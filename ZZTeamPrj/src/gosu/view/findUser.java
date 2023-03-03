package gosu.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gosu.data.gosuDao;
import gosu.data.userVo;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class findUser extends JFrame {

	TextField pwtxt, idtxt, emailtxt2, phonetxt2, nametxt2;
	Button searchId, searchPw;
	private JLabel lblEmail2;
	private JLabel lblPhone_1;
	private JLabel lblUserName2;
	private JLabel lblId_1;
	private JLabel lblEmail;
	private JLabel lblPhone;
	private JLabel lblUserName;
	private TextField emailtxt;
	private TextField phonetxt;
	private TextField nametxt;
	private JPanel panel;
	private JLabel lblNewLabel;
	private Button cancelBtn;
	private JLabel lblId;
	private TextField idArea;
	private TextField pwArea;
	private JLabel lblPw;
	private JPanel panel_1;
	private JLabel lblFindId;
	private JLabel lblFindPw;

	public findUser() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(findUser.class.getResource("/img/user.png")));
		getContentPane().setBackground(Color.WHITE);
		setTitle("Find User");

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		searchId = new Button("Search  ID");
		searchId.setForeground(new Color(255, 255, 0));
		searchId.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
		searchId.setBackground(new Color(135, 206, 250));
		searchId.setBounds(73, 209, 101, 23);
		getContentPane().add(searchId);

		searchId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (nametxt.getText().trim().length() == 0 || nametxt.getText().trim().equals("이름")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해 주세요.", "이름 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (phonetxt.getText().trim().length() == 0 || phonetxt.getText().trim().equals("전화번호")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력해 주세요.", "전화번호 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (emailtxt.getText().trim().length() == 0 || emailtxt.getText().trim().equals("이메일")) {
					JOptionPane.showMessageDialog(null, "이메일을 입력해 주세요.", "이메일 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				findId();

			}
		});

		searchPw = new Button("Search  PW");
		searchPw.setForeground(new Color(255, 255, 0));
		searchPw.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
		searchPw.setBackground(new Color(135, 206, 250));
		searchPw.setBounds(71, 531, 101, 23);
		getContentPane().add(searchPw);

		idtxt = new TextField("\uC544\uC774\uB514");
		idtxt.setForeground(Color.BLACK);
		idtxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		idtxt.setColumns(10);
		idtxt.setBackground(Color.WHITE);
		idtxt.setBounds(40, 333, 132, 23);
		getContentPane().add(idtxt);

		emailtxt2 = new TextField("\uC774\uBA54\uC77C");
		emailtxt2.setForeground(Color.BLACK);
		emailtxt2.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		emailtxt2.setColumns(10);
		emailtxt2.setBackground(Color.WHITE);
		emailtxt2.setBounds(40, 484, 132, 23);
		getContentPane().add(emailtxt2);

		phonetxt2 = new TextField("\uC804\uD654\uBC88\uD638");
		phonetxt2.setForeground(Color.BLACK);
		phonetxt2.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		phonetxt2.setColumns(10);
		phonetxt2.setBackground(Color.WHITE);
		phonetxt2.setBounds(40, 433, 132, 23);
		getContentPane().add(phonetxt2);

		nametxt2 = new TextField("\uC774\uB984");
		nametxt2.setForeground(Color.BLACK);
		nametxt2.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		nametxt2.setColumns(10);
		nametxt2.setBackground(Color.WHITE);
		nametxt2.setBounds(40, 383, 132, 23);
		getContentPane().add(nametxt2);
		
		lblEmail2 = new JLabel("Email");
		lblEmail2.setForeground(SystemColor.textHighlight);
		lblEmail2.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblEmail2.setBounds(12, 462, 81, 15);
		getContentPane().add(lblEmail2);
		
		lblPhone_1 = new JLabel("Phone");
		lblPhone_1.setForeground(SystemColor.textHighlight);
		lblPhone_1.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblPhone_1.setBounds(12, 412, 81, 15);
		getContentPane().add(lblPhone_1);
		
		lblUserName2 = new JLabel("Name");
		lblUserName2.setForeground(SystemColor.textHighlight);
		lblUserName2.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblUserName2.setBounds(12, 362, 81, 15);
		getContentPane().add(lblUserName2);
		
		lblId_1 = new JLabel("ID ");
		lblId_1.setForeground(SystemColor.textHighlight);
		lblId_1.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		lblId_1.setBackground(Color.WHITE);
		lblId_1.setBounds(12, 314, 81, 15);
		getContentPane().add(lblId_1);
		
		lblEmail = new JLabel("Email");
		lblEmail.setForeground(SystemColor.textHighlight);
		lblEmail.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblEmail.setBounds(12, 152, 81, 15);
		getContentPane().add(lblEmail);
		
		lblPhone = new JLabel("Phone");
		lblPhone.setForeground(SystemColor.textHighlight);
		lblPhone.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblPhone.setBounds(12, 101, 81, 15);
		getContentPane().add(lblPhone);
		
		lblUserName = new JLabel("Name");
		lblUserName.setForeground(SystemColor.textHighlight);
		lblUserName.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblUserName.setBounds(12, 51, 81, 15);
		getContentPane().add(lblUserName);
		
		emailtxt = new TextField("\uC774\uBA54\uC77C");
		emailtxt.setForeground(Color.BLACK);
		emailtxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		emailtxt.setColumns(10);
		emailtxt.setBackground(Color.WHITE);
		emailtxt.setBounds(40, 173, 132, 23);
		getContentPane().add(emailtxt);
		
		phonetxt = new TextField("\uC804\uD654\uBC88\uD638");
		phonetxt.setForeground(Color.BLACK);
		phonetxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		phonetxt.setColumns(10);
		phonetxt.setBackground(Color.WHITE);
		phonetxt.setBounds(40, 123, 132, 23);
		getContentPane().add(phonetxt);
		
		nametxt = new TextField("\uC774\uB984");
		nametxt.setForeground(Color.BLACK);
		nametxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		nametxt.setColumns(10);
		nametxt.setBackground(Color.WHITE);
		nametxt.setBounds(40, 72, 132, 23);
		getContentPane().add(nametxt);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(250, 0, 199, 574);
		getContentPane().add(panel);
		
		lblNewLabel = new JLabel("X");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(224, 0, 24, 28);
		panel.add(lblNewLabel);
		
		cancelBtn = new Button("Cancel");
		cancelBtn.setForeground(new Color(255, 255, 0));
		cancelBtn.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
		cancelBtn.setBackground(new Color(135, 206, 250));
		cancelBtn.setBounds(48, 529, 83, 23);
		panel.add(cancelBtn);
		
		lblId = new JLabel("ID ");
		lblId.setForeground(SystemColor.textHighlight);
		lblId.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblId.setBounds(23, 81, 81, 15);
		panel.add(lblId);
		
		idArea = new TextField();
		idArea.setForeground(new Color(0, 0, 255));
		idArea.setBackground(new Color(255, 255, 255));
		idArea.setEditable(false);
		idArea.setBounds(23, 102, 110, 21);
		panel.add(idArea);
		
		pwArea = new TextField();
		pwArea.setForeground(new Color(0, 0, 255));
		pwArea.setBackground(new Color(255, 255, 255));
		pwArea.setEditable(false);
		pwArea.setBounds(23, 400, 110, 21);
		panel.add(pwArea);
		
		lblPw = new JLabel("PassWord");
		lblPw.setForeground(SystemColor.textHighlight);
		lblPw.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblPw.setBounds(23, 379, 115, 15);
		panel.add(lblPw);
		
		Label label = new Label("Share Ability");
		label.setBackground(new Color(135, 206, 250));
		label.setBounds(0, 241, 199, 33);
		panel.add(label);
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Comic Sans MS", Font.ITALIC, 32));
		label.setAlignment(Label.CENTER);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 204, 255));
		panel_1.setBounds(-11, 241, 460, 33);
		getContentPane().add(panel_1);
		
		lblFindId = new JLabel("< Find ID >");
		lblFindId.setForeground(SystemColor.textHighlight);
		lblFindId.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 18));
		lblFindId.setBounds(75, 10, 113, 31);
		getContentPane().add(lblFindId);
		
		lblFindPw = new JLabel("< Find PW >");
		lblFindPw.setForeground(SystemColor.textHighlight);
		lblFindPw.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 18));
		lblFindPw.setBounds(59, 284, 113, 31);
		getContentPane().add(lblFindPw);
		setSize(466, 613);
		FocusEvent();

		searchPw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (idtxt.getText().trim().length() == 0 || idtxt.getText().trim().equals("아이디")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.", "아이디 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (nametxt2.getText().trim().length() == 0 || nametxt2.getText().trim().equals("이름")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해 주세요.", "이름 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (phonetxt2.getText().trim().length() == 0 || phonetxt2.getText().trim().equals("전화번호")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력해 주세요.", "전화번호 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (emailtxt2.getText().trim().length() == 0 || emailtxt2.getText().trim().equals("이메일")) {
					JOptionPane.showMessageDialog(null, "이메일을 입력해 주세요.", "이메일 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				findPw();
				

			}
		});
	}

	protected void findPw() {
		String id = this.idtxt.getText();
		String name = this.nametxt2.getText();
		String phone = this.phonetxt2.getText();
		String email = this.emailtxt2.getText();

		if (name.trim().equals(""))
			if (name.trim().equals(""))
				if (email.trim().equals(""))
					if (phone.trim().equals(""))
						return;
		gosuDao dao = new gosuDao();
		userVo pw = dao.getPw(id, name, phone, email);
		setpwView(pw);

	}

	private void setpwView(userVo vo) {
		String pw = vo.getPw();
		this.pwArea.setText(pw);

	}

	protected void findId() {
		String name = this.nametxt.getText();
		String phone = this.phonetxt.getText();
		String email = this.emailtxt.getText();

		if (name.trim().equals(""))
			if (email.trim().equals(""))
				if (phone.trim().equals(""))
					return;
		gosuDao dao = new gosuDao();
		userVo id = dao.getId(name, phone, email);
		setidView(id);
	}

	private void setidView(userVo vo) {
		String id = vo.getId();
		this.idArea.setText(id);
	}

	private void FocusEvent() {
		idtxt.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (idtxt.getText().trim().length() == 0) {
					idtxt.setText("아이디");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (idtxt.getText().trim().equals("아이디")) {
					idtxt.setText("");
				}
			}
		});
		nametxt2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (nametxt2.getText().trim().length() == 0) {
					nametxt2.setText("이름");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (nametxt2.getText().trim().equals("이름")) {
					nametxt2.setText("");
				}
			}
		});
		phonetxt2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (phonetxt2.getText().trim().length() == 0) {
					phonetxt2.setText("전화번호");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (phonetxt2.getText().trim().equals("전화번호")) {
					phonetxt2.setText("");
				}
			}
		});
		emailtxt2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (emailtxt2.getText().trim().length() == 0) {
					emailtxt2.setText("이메일");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (emailtxt2.getText().trim().equals("이메일")) {
					emailtxt2.setText("");
				}
			}
		});
		nametxt.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (nametxt.getText().trim().length() == 0) {
					nametxt.setText("이름");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (nametxt.getText().trim().equals("이름")) {
					nametxt.setText("");
				}
			}
		});
		phonetxt.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (phonetxt.getText().trim().length() == 0) {
					phonetxt.setText("전화번호");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (phonetxt.getText().trim().equals("전화번호")) {
					phonetxt.setText("");
				}
			}
		});
		emailtxt.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (emailtxt.getText().trim().length() == 0) {
					emailtxt.setText("이메일");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (emailtxt.getText().trim().equals("이메일")) {
					emailtxt.setText("");
				}
			}
		});
	}
}
