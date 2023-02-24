package gosu.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import gosu.data.gosuDao;

import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class GosuListView extends JFrame{
	JPanel pList;
	JLabel lblListname;
	JButton btnOk;
	JTable tabGosuList;
	
	static GosuListView gosuList = null;
	
	public GosuListView(){
		init();
	}

	private void init() {
		setTitle("리스트");
		
		//파라미터: 색상, 선 두께, border의 모서리를 둥글게 할 것인지
		LineBorder lb = new LineBorder(Color.black, 1, true);

		
		pList = new JPanel();
		pList.setBackground(Color.WHITE);
		
		getContentPane().add(pList);
		pList.setLayout(null);
		
		JComboBox cbxJobtype1 = new JComboBox();
		cbxJobtype1.setForeground(new Color(255, 255, 255));
		cbxJobtype1.setToolTipText("\uB300\uBD84\uB958");
		cbxJobtype1.setBounds(148, 52, 32, 23);
		pList.add(cbxJobtype1);
		
		lblListname = new JLabel("\uACE0\uC218 \uC5C5\uBB34 \uB9AC\uC2A4\uD2B8");
		lblListname.setForeground(new Color(0, 128, 192));
		lblListname.setFont(new Font("휴먼엑스포", Font.PLAIN, 60));
		lblListname.setBounds(338, 21, 574, 113);
		pList.add(lblListname);
		
		 btnOk = new JButton("\uD655\uC778\uD558\uAE30");
		 btnOk.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnOk.setBorder(lb);
		 btnOk.setBackground(new Color(255, 255, 255));
		 btnOk.setForeground(new Color(0, 128, 192));
		 btnOk.setBounds(974, 640, 117, 47);
		 pList.add(btnOk);

		 tabGosuList = new JTable();
		 tabGosuList.setModel(
				 new DefaultTableModel(getGosuDataList(), getGosuCoulumnList()  ) {

					 @Override
					 public boolean isCellEditable(int row, int column) {
						 return false;
					 }

				 });
		 tabGosuList.setBounds(185, 168, 804, 387);
		 pList.add(tabGosuList);
		
		setSize(1200, 800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// --------------------------------------------------------------------
	}
	// 테이블 데이터
	private Vector<Vector> getGosuDataList() {
		gosuDao dao = new gosuDao();
		Vector<Vector> list = dao.getGosuList();
		return list;
	}

	// 테이블 제목줄
	private Vector<String> getGosuCoulumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("NO");
		cols.add("중분류");
		cols.add("고수이름");
		cols.add("금액");
		cols.add("위치");
		return cols;
	}

	public static void main(String[] args) {
		gosuList = new GosuListView();
	}
}