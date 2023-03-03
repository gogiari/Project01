package gosu.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import gosu.data.gosuDao;
import javax.swing.UIManager;

public class ConstructorPage extends JFrame implements MouseListener, ActionListener {

	private JPanel mainPage;
	private JScrollPane userpane, gosupane, faqpane;
	private JTable userTable, gosuTable, FAQTable;
	private JTextField idtxt;
	private JTextField gosutxt;
	private Button REP;
	public ConstructorPage() {
		setBackground(Color.WHITE);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 495);
		mainPage = new JPanel();
		mainPage.setBackground(new Color(0, 0, 0));
		mainPage.setBorder(new EmptyBorder(5, 5, 5, 5));

		setUndecorated(true);
		setVisible(true);
		setContentPane(mainPage);
		mainPage.setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.textText);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 795, 495);
		mainPage.add(panel);
		panel.setLayout(null);

		setVisible(true);
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setBounds(775, 0, 22, 24);
		panel.add(lblNewLabel_1);

		JPanel ClientPane = new JPanel();
		ClientPane.setBackground(new Color(255, 255, 255));
		ClientPane.setBounds(0, 0, 794, 414);
		panel.add(ClientPane);
		ClientPane.setLayout(null);

		Button GosuBtn = new Button("GosuList");
		JPanel GosuPane = new JPanel();
		GosuPane.setBackground(new Color(255, 255, 255));
		GosuPane.setBounds(0, 0, 794, 414);
		panel.add(GosuPane);
		GosuPane.setLayout(null);

		JLabel lblGosu = new JLabel("Gosu List");
		lblGosu.setForeground(SystemColor.textHighlight);
		lblGosu.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 27));
		lblGosu.setBounds(317, 10, 154, 32);
		GosuPane.add(lblGosu);

		JSeparator gosu2 = new JSeparator();
		gosu2.setForeground(Color.BLACK);
		gosu2.setBounds(78, 25, 203, 2);
		GosuPane.add(gosu2);

		JSeparator gosu1 = new JSeparator();
		gosu1.setForeground(Color.BLACK);
		gosu1.setBounds(515, 25, 203, 2);
		GosuPane.add(gosu1);

		JPanel FAQPane;
		FAQPane = new JPanel();
		FAQPane.setBackground(new Color(255, 255, 255));
		FAQPane.setBounds(0, 0, 794, 414);
		panel.add(FAQPane);
		FAQPane.setLayout(null);

		JLabel lblFAQ;
		lblFAQ = new JLabel("FAQ List");
		lblFAQ.setForeground(SystemColor.textHighlight);
		lblFAQ.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 27));
		lblFAQ.setBounds(317, 10, 154, 32);
		FAQPane.add(lblFAQ);

		JSeparator FAQ2;
		FAQ2 = new JSeparator();
		FAQ2.setForeground(Color.BLACK);
		FAQ2.setBounds(78, 25, 203, 2);
		FAQPane.add(FAQ2);

		JSeparator FAQ1;
		FAQ1 = new JSeparator();
		FAQ1.setForeground(Color.BLACK);
		FAQ1.setBounds(515, 25, 203, 2);
		FAQPane.add(FAQ1);

		JPanel mainBtnPane = new JPanel();
		mainBtnPane.setBackground(new Color(135, 206, 250));
		mainBtnPane.setBounds(0, 411, 807, 95);
		panel.add(mainBtnPane);
		mainBtnPane.setLayout(null);

		Button FAQBtn = new Button("FAQ List");
		FAQBtn.setBounds(561, 0, 144, 83);
		mainBtnPane.add(FAQBtn);
		FAQBtn.setForeground(new Color(255, 255, 255));
		FAQBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		FAQBtn.setBackground(new Color(135, 206, 250));

		JSeparator client1 = new JSeparator();
		client1.setForeground(Color.BLACK);
		client1.setBounds(78, 25, 203, 2);
		ClientPane.add(client1);

		JSeparator client2 = new JSeparator();
		client2.setForeground(Color.BLACK);
		client2.setBounds(515, 25, 203, 2);
		ClientPane.add(client2);

		Button ClientLBtn = new Button("ClientList");
		JLabel lblClient = new JLabel("Client List");
		lblClient.setForeground(SystemColor.textHighlight);
		lblClient.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 27));
		lblClient.setBounds(317, 10, 154, 32);
		ClientPane.add(lblClient);

		ClientLBtn.setBounds(64, 0, 133, 83);
		mainBtnPane.add(ClientLBtn);
		ClientLBtn.setForeground(new Color(255, 255, 255));
		ClientLBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		ClientLBtn.setBackground(new Color(135, 206, 250));

		GosuBtn.setForeground(Color.WHITE);
		GosuBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
		GosuBtn.setBackground(new Color(135, 206, 250));
		GosuBtn.setBounds(321, 0, 133, 83);
		mainBtnPane.add(GosuBtn);
		// 회원 리스트
		userTable = new JTable();
		userTable.setModel(new DefaultTableModel(getUserList(), getUserColumnList()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
		});
		userTable.repaint();
		userpane = new JScrollPane(userTable);
		userpane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		userpane.setBounds(0, 94, 794, 276);
		ClientPane.add(userpane);

		userTable.addMouseListener(this);
		Button deleteUser = new Button("Delete User");
		deleteUser.setForeground(new Color(255, 0, 0));
		deleteUser.setFont(new Font("D2Coding", Font.PLAIN, 15));
		deleteUser.setBackground(new Color(135, 206, 250));
		deleteUser.setBounds(320, 376, 132, 28);
		ClientPane.add(deleteUser);

		idtxt = new JTextField();
		idtxt.setBounds(186, 380, 116, 21);
		ClientPane.add(idtxt);
		idtxt.setColumns(10);
		idtxt.setEditable(false);

		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setBounds(162, 380, 43, 24);
		ClientPane.add(lblNewLabel);
		deleteUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				removeUser();

			}
		});

		// 고수 리스트
		gosuTable = new JTable();
		gosuTable.setModel(new DefaultTableModel(getGosuList(), getGosuColumnList()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}
		});
		gosuTable.repaint();
		gosupane = new JScrollPane(gosuTable);
		gosupane.setBounds(0, 94, 794, 276);
		GosuPane.add(gosupane);
		
		gosuTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = gosuTable.getSelectedRow();
				String id = (String) gosuTable.getValueAt(row, 0);
				gosutxt.setText(id);
				
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("ID :");
		lblNewLabel_2.setBounds(162, 380, 43, 24);
		GosuPane.add(lblNewLabel_2);
		
		Button deleteGosu = new Button("Delete Gosu");
		deleteGosu.setActionCommand("Delete Gosu");
		deleteGosu.setForeground(Color.RED);
		deleteGosu.setFont(new Font("D2Coding", Font.PLAIN, 15));
		deleteGosu.setBackground(new Color(135, 206, 250));
		deleteGosu.setBounds(320, 376, 132, 28);
		GosuPane.add(deleteGosu);
		deleteGosu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeGosu();
				
			}
		});
		
		gosutxt = new JTextField();
		gosutxt.setEditable(false);
		gosutxt.setColumns(10);
		gosutxt.setBounds(186, 380, 116, 21);
		GosuPane.add(gosutxt);

		// FAQ 테이블리스트
		FAQTable = new JTable();
		FAQTable.setModel(new DefaultTableModel(getFAQList(), getFAQColumnList()) {
			;
			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
			}

		});
		FAQTable.repaint();
		faqpane = new JScrollPane(FAQTable);
		faqpane.setBounds(0, 94, 794, 276);
		FAQPane.add(faqpane);
		
		REP = new Button("Rep / Alt");
		REP.setForeground(Color.BLACK);
		REP.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		REP.setBackground(new Color(135, 206, 250));
		REP.setActionCommand("REPLY");
		REP.setBounds(320, 376, 132, 28);
		FAQPane.add(REP);
		
		REP.addActionListener(this);
			

		ClientLBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClientPane.setVisible(true);
				GosuPane.setVisible(false);
				FAQPane.setVisible(false);

			}
		});

		GosuBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClientPane.setVisible(false);
				GosuPane.setVisible(true);
				FAQPane.setVisible(false);

			}
		});

		FAQBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ClientPane.setVisible(false);
				GosuPane.setVisible(false);
				FAQPane.setVisible(true);
			}
		});

	}

protected void removeGosu() {
	int row = gosuTable.getSelectedRow();
	String id = (String) gosuTable.getValueAt(row, 2);
	String wnum = this.gosutxt.getText();
	gosuDao dao = new gosuDao();
	// 삭제 확인
	
	int choice = JOptionPane.showConfirmDialog(null, "업무번호: "+ wnum +"ID:  " + id +"\n삭제하시겠습니까?", "삭제확인", JOptionPane.OK_CANCEL_OPTION);;
	String msg = "";
	if (choice == 0) { // Ok 클릭
		int aftcnt = dao.deleteGosu(wnum);
		if (aftcnt > 0) {
			msg = aftcnt + "건 삭제되었습니다";
		} else {
			msg = "삭제 되지 않았습니다, 삭제될 아이디를 확인해주세요";
		}
	} else {
		msg = "취소를 클릭하였습니다";
	}
	JOptionPane.showMessageDialog(null, msg, "삭제", JOptionPane.OK_OPTION);

	this.gosuTable.repaint();
	this.dispose();
	new ConstructorPage();
		
	}

	// 삭제
	protected void removeUser() {
		int row = userTable.getSelectedRow();
		String name = (String) userTable.getValueAt(row, 2);
		String g_num = "";		
		String id = this.idtxt.getText();
		if( row > 0) {	
			g_num = (String) gosuTable.getValueAt(row, 3);
			return;
		}
		gosuDao dao = new gosuDao();
		
		// 삭제 확인
		int choice = JOptionPane.showConfirmDialog(null, "ID: "+id+" \n이름:"+name+"\n삭제하시겠습니까?", "삭제확인", JOptionPane.OK_CANCEL_OPTION);
		String msg = "";
		if (choice == 0) { // Ok 클릭
			int aftcnt = dao.deleteUser(id, g_num);
			if (aftcnt > 0) {
				msg = aftcnt + "건 삭제되었습니다";
			} else {
				msg = "삭제 되지 않았습니다, 삭제될 아이디를 확인해주세요";
			}
		} else {
			msg = "취소를 클릭하였습니다";
		}
		JOptionPane.showMessageDialog(null, msg, "삭제", JOptionPane.OK_OPTION);

		this.userTable.repaint();
		this.dispose();
		new ConstructorPage();

	}

	private Vector<Vector> getFAQList() {
		gosuDao dao = new gosuDao();
		Vector<Vector> list = dao.getFAQList();
		return list;
	}

	private Vector<String> getFAQColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("FAQ_CODE");
		cols.add("ID");
		cols.add("DATE");
		cols.add("제목");
		cols.add("내용");
		cols.add("답글");
		cols.add("읽음");
		return cols;
	}

// 고수리스트
	private Vector<Vector> getGosuList() {
		gosuDao dao = new gosuDao();
		Vector<Vector> list = dao.getGosuList();
		return list;
	}

	private Vector<String> getGosuColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("업무번호");
		cols.add("중분류번호");
		cols.add("ID");
		cols.add("고수번호");
		cols.add("Price");
		cols.add("구군");
		return cols;
	}

// 사용자 list
	private Vector<Vector> getUserList() {
		gosuDao dao = new gosuDao();
		Vector<Vector> list = dao.getUserList();
		return list;
	}// 사용자 lsit

	private Vector<String> getUserColumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("ID");
		cols.add("PW");
		cols.add("NAME");
		cols.add("EMAIL");
		cols.add("GENDER");
		cols.add("PHONE");
		cols.add("SIDO");
		cols.add("GUGUN");
		return cols;
	}

	public static void main(String[] args) {
		new ConstructorPage();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = userTable.getSelectedRow();
		String id = (String) userTable.getValueAt(row, 0);
		idtxt.setText(id);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = FAQTable.getSelectedRow();
		if(row == -1) {
		JOptionPane.showMessageDialog(null, "답변/수정할 줄을 선택해주세요.", "줄 선택", JOptionPane.WARNING_MESSAGE);
		}
		String fcode = (String) FAQTable.getValueAt(row, 0); 
		String uid = (String) FAQTable.getValueAt(row, 1);
		String fdate = (String) FAQTable.getValueAt(row, 2);
		String fhead = (String) FAQTable.getValueAt(row, 3);
		String fbody = (String) FAQTable.getValueAt(row, 4);
		new rep(fcode,uid,fdate,fhead,fbody,this);
		
		
	}
}
