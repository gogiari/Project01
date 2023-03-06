package gosu.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.Dao;
import model.Vo;
import java.awt.Color;

public class Edit extends JFrame implements ActionListener{

	res res = null;
	
	JPanel        topPane, bodyPane, footerPane;
	JTable        jTable;
	JScrollPane   pane;
	String uid;

	private JTable table;
	
	public Edit(String uid) {
		initEdit(uid);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Edit(res res, String uid) {
		initEdit(uid);
		this.res = res;
		//Refresh();
	}
	
	public void initEdit(String uid) {
		table = new JTable();
		table.setBounds(100, 146, 1000, 450);
		getContentPane().add(table);
		
		table.setModel(new DefaultTableModel( getDataList(uid), getColumnList() ) {				
			@Override
			public boolean isCellEditable(int row, int column) {		
				return false;   
			}				
		});

		JButton btnUpdate  = new JButton("\uC218\uC815 \uBC0F \uC870\uD68C");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(0, 128, 192));
		btnUpdate.setBounds(494, 647, 123, 23);
		getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		JButton btnDelete = new JButton("삭제");
		btnDelete.setForeground(new Color(0, 0, 0));
		btnDelete.setBackground(new Color(128, 128, 128));
		btnDelete.setBounds(658, 647, 97, 23);
		getContentPane().add(btnDelete);
		
		btnDelete.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removePrvGoList(uid);
			}
		});
		
		//-----------------------------------------------------------------
		
		
		
		//-----------------------------------------------------------------
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		getContentPane().setLayout(null);
		
		JButton btnDelete_1 = new JButton("새로고침");
		btnDelete_1.setBounds(1003, 647, 97, 23);
		getContentPane().add(btnDelete_1);
		setVisible(true);
		
		 btnDelete_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("새로고침버튼 클릭....");
				Refresh();
				
				table.setModel(new DefaultTableModel( getDataList(uid), getColumnList() ) {				
					@Override
					public boolean isCellEditable(int row, int column) {		
						return false;   
					}				
				});
			}
		});
		
		 
		 
		 
		Dimension frameSize = this.getSize();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 

		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
		
	}

	protected void removePrvGoList(String uid) {
		Dao dao = new Dao();
		int row = table.getSelectedRow();
		
		TableModel data = table.getModel();
		String tableTime = (String)data.getValueAt(row,2);
		
		
		int choice = JOptionPane.showConfirmDialog(
				null,
				"업무리스트 삭제하시겠습니까?",
				"삭제확인",
				JOptionPane.OK_CANCEL_OPTION
		);
		
		String msg = "";

		if(choice == 0) { //ok 클릭
			String tableTime1 = tableTime;
			
			int text1 = Integer.parseInt(tableTime.substring(5,6));
			System.out.println("테스트1" + text1);
			int text2 = Integer.parseInt(tableTime.substring(8,9));
			System.out.println("테스트2" + text2);
			
			tableTime1 = tableTime1.substring(0,16);		
			
			String[] date = tableTime1.split("-");
			String dateY = date[0];
			String dateM = date[1];
			String dateD = date[2];
			String time = tableTime1.substring(11,16);
			
			if( (text1 == 0) || (text2 == 0) ) {
				if(text1 == 0) {
					dateM = dateM.substring(0,2).replace("0", "");
				}
				if(text2 == 0) {
					 dateD =  dateD.substring(0,2).replace("0", "");
				}
				tableTime1 = dateY + "-" + dateM + "-" + dateD + " " + time;
			}else {
				tableTime1 = dateY + "-" + dateM + "-" + dateD + " " + time;				
			}
			
			int aftcnt = dao.removePrvGoList(uid, tableTime1);
			if(aftcnt > 0) { 
				msg = "삭제 되었습니다";
				this.dispose();
				//새로고침 넣기
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
		
//		jTableRefresh();
	}

	

	//-----------------------------------------------------------------
	private Vector<? extends Vector> getDataList(String uid) {
		Dao dao = new Dao();
		Vector<Vector> list = dao.getEditList(uid);
		return list;
	}

	private Vector<String> getColumnList() {
		Vector<String>  cols = new Vector<>(); 
		cols.add("아이디");
		cols.add("이름");
		cols.add("직업");
		cols.add("성별");
		return  cols;
	}
	
//	public void jTableRefresh() {
//		
//		jTable.setModel(
//			new DefaultTableModel(  getDataList(uid),  getColumnList()  ) {
//
//				@Override
//				public boolean isCellEditable(int row, int column) {					
//					return false;
//				}
//				
//			}
//		);  
//		
//		jTable.repaint(); 
//	}
	
	
	public void Refresh() {
		table.setModel(
		new DefaultTableModel(getDataList(uid),getColumnList()  ) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		});
		table.repaint();
		
		table.setModel(
		new DefaultTableModel(getDataList(uid),getColumnList()  ) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		});
	}
	
	//--------------------------------------------------------------------
  
    //action
	@Override
	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		TableModel data = table.getModel();
		String tableTime = (String)data.getValueAt(row,2);
		
		res = new res( this, tableTime );
	}
}
