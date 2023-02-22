package project.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import project.oracle.newMember;

public class client extends JFrame implements ActionListener, MouseListener {
	Font titleFnt = new Font("굴림체",Font.BOLD,32);
	Font fnt = new Font("굴림체",Font.BOLD,14);
	JButton bs, br, ac , sc ;
	JPanel sPane;
	JPanel nPane;
	JLabel lbl, title;
	JTable list;
	JScrollPane Scrollpane;
	private JScrollPane Scrollpane_1;
	JTextField jtf;
	public client() {
	Scrollpane  = new JScrollPane(list);
	sPane = new JPanel();
	nPane = new JPanel();
		jtf = new JTextField(5);
		bs = new JButton("번호조회");
		br = new JButton("새로고침");
		ac = new JButton("예약등록");
		sc = new JButton("스케줄러");
		bs.setBackground(Color.white);
		br.setBackground(Color.white);
		ac.setBackground(Color.white);
		sc.setBackground(Color.white);
		sPane.add(jtf);
		sPane.add(bs);
		sPane.add(br);
		sPane.add(ac);
		sPane.add(sc);
		sPane.setLayout(new FlowLayout());
		sPane.setFont(fnt);
		sPane.setBackground(new Color(0,120,255));
		sPane.setForeground(Color.white);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, nPane, 36, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, nPane, 32, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, sPane, 27, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, sPane, -30, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, nPane, 9, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, nPane, 3, SpringLayout.WEST, getContentPane());
		getContentPane().setLayout(springLayout);
		getContentPane().add(nPane);
		getContentPane().add(sPane);
		list  = new JTable();
		list.setBackground(new Color(0,200,255));
		list.setModel(new DefaultTableModel(getDataList(), getColumnList()));
		
		list.addMouseListener(this);
		
		Scrollpane_1 = new JScrollPane(list);
		springLayout.putConstraint(SpringLayout.NORTH, Scrollpane_1, -364, SpringLayout.NORTH, sPane);
		springLayout.putConstraint(SpringLayout.SOUTH, Scrollpane_1, -19, SpringLayout.NORTH, sPane);
		springLayout.putConstraint(SpringLayout.EAST, Scrollpane_1, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(Scrollpane_1);
		lbl = new JLabel("예약 관리");
		springLayout.putConstraint(SpringLayout.NORTH, lbl, -6, SpringLayout.NORTH, nPane);
		springLayout.putConstraint(SpringLayout.WEST, lbl, 123, SpringLayout.EAST, nPane);
		springLayout.putConstraint(SpringLayout.SOUTH, lbl, 0, SpringLayout.SOUTH, nPane);
		springLayout.putConstraint(SpringLayout.EAST, lbl, -107, SpringLayout.EAST, getContentPane());
		lbl.setFont(titleFnt);
		getContentPane().add(lbl);
		ac.addActionListener(this);
		
		
		
		setSize(500,600);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(400,60);
	}
	private Vector<Vector> getDataList() {
		newMember nM = new newMember();
		
		Vector<Vector>list = nM.getList();
		
		return list;
	}
	private Vector<String> getColumnList() {
		Vector<String>cols = new Vector<>();
		cols.add("전화번호");
		cols.add("날짜");
		cols.add("시간");
		cols.add("메모");
		cols.add("픽업여부");
		cols.add("지역");
		return cols;
	}
public static void main(String[] args) {
	new client();
}
@Override
public void actionPerformed(ActionEvent e) {
	new addClient(this);
}
@Override
public void mouseClicked(MouseEvent e) {
	

}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	list.setSelectionBackground(Color.GREEN);
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}	
}
