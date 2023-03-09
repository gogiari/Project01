package gosu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import gosu.data.Dao;
import com.Design;

import java.awt.Window.Type;

public class Edit extends JFrame implements ActionListener{

	res res = null;
	
	JPanel topPane, bodyPane, footerPane, panel;
	JTable jTable;
	JLabel title;
	JScrollPane   pane;
	String uid;
	Design comDe = new Design();
	private JTable table;
	
	public Edit() {}
//	public Edit(String uid) {
//		getContentPane().setForeground(new Color(255, 255, 255));
//		getContentPane().setBackground(new Color(255, 255, 255));
//		dispose();
//		initEdit(uid);
//	}
	public Edit(res res, String uid) {
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		initEdit(uid);
		this.res = res;
	}
		
	public void initEdit(String uid) {
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		getContentPane().add(panel);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		panel.setBounds(0, 21, 1184, 35);
		getContentPane().add(panel);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 56, 1184, 35);
		getContentPane().add(panel);

		title = new JLabel("고수 업무 수정페이지");
		comDe.getTitleFont(title);
		panel.add(title);
		
		//-----------------------------------------------------------------
		table = new JTable();
		table.setModel(new DefaultTableModel( getDataList(uid), getColumnList() ) {				
			@Override
			public boolean isCellEditable(int row, int column) {		
				return false;   
			}				
		});
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(100, 146, 1000, 450);
		getContentPane().add(scrollpane);
		//-----------------------------------------------------------------
		
		JButton btnUpdate  = new JButton("수정");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(0, 128, 192));
		btnUpdate.setBounds(493, 647, 97, 23);
		getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(128, 128, 128));
		btnDelete.setBounds(631, 647, 97, 23);
		getContentPane().add(btnDelete);
		
		btnDelete.addActionListener(this);
//		btnDelete.addActionListener( new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				removePrvGoList(uid);
//			}
//		});
		
		//-----------------------------------------------------------------
		getContentPane().setLayout(null);
		Refresh(uid);
		
		JButton btnNew = new JButton("새로고침");
		btnNew.setForeground(new Color(255, 255, 255));
		btnNew.setBackground(new Color(0, 128, 192));
		btnNew.setBounds(1003, 647, 97, 23);
		getContentPane().add(btnNew);
		
//		btnNew.addActionListener(this);
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("새로고침버튼 클릭....");
				Refresh(uid);
			}
		});
		 
		JLabel lblNewLabel = new JLabel("먼저 행을 선택해주세요");
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setBounds(553, 690, 175, 15);
		getContentPane().add(lblNewLabel);
		 
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200, 800);
		setVisible(true);
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 

		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); 
	}

	protected void removePrvGoList(String uid) {
		Dao dao = new Dao();
		int row = table.getSelectedRow();
		
		TableModel data = table.getModel();
		String Wnum = (String)data.getValueAt(row,0);
		
		
		int choice = JOptionPane.showConfirmDialog(
				null,
				"업무리스트 삭제하시겠습니까?",
				"삭제확인",
				JOptionPane.OK_CANCEL_OPTION
		);
		
		String msg = "";

		if(choice == 0) { //ok 클릭
			int aftcnt = dao.removePrvGoList(Wnum);
			if(aftcnt > 0) { 
				msg = "삭제 되었습니다";
				dispose();
			}else {
				msg = "삭제 되지 않았습니다";
			}
			}else {
				msg = "취소를 클릭하였습니다";
			}
		
		JOptionPane.showMessageDialog(
				null,
				msg,
				"삭제",
				JOptionPane.OK_OPTION
		);

	}

	//-----------------------------------------------------------------
	private Vector<Vector> getDataList(String uid) {
		Dao dao = new Dao();
		Vector<Vector> list = dao.getEditList(uid);
		return list;
	}

	private Vector<String> getColumnList() {
		Vector<String> cols = new Vector<>(); 
		cols.add("업무번호");
		cols.add("종류");
		cols.add("금액");
		cols.add("시작일");
		cols.add("마감일");
		cols.add("위치");
		return  cols;
	}
	
	public void Refresh(String uid) {
		table.setModel(new DefaultTableModel(getDataList(uid),getColumnList()  ) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		repaint();
	}
	
	//--------------------------------------------------------------------
  
    //action
	@Override
	public void actionPerformed(ActionEvent e) {
		switch( e.getActionCommand() ) {  // 눌러진 버튼의 글자
		case "수정":
			System.out.println("수정");
			if(  this != null )
				dispose();
				int row = table.getSelectedRow();
				TableModel data = table.getModel();
				String Wnum = (String)data.getValueAt(row,0);
				
				res = new res( this, Wnum );
			break;
		case "삭제":
			System.out.println("삭제 클릭");
			removePrvGoList(uid);	
			break;
		
		}
	}
	
}
