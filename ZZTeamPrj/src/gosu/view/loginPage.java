package gosu.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import gosu.data.gosuDao;

public class loginPage extends JFrame implements ActionListener, KeyListener {

	private JPanel contentPane;
	gosuDao dao;
	TextField idU;
	JPasswordField pwU;
	Button findBtn;
	MainView mainview;
	Button SignUp;

	public loginPage() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 480);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 139));
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(0, -40, 301, 536);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img/deal.png"));
		lblNewLabel_1.setBounds(40, 84, 216, 264);
		panel.add(lblNewLabel_1);

		Label label = new Label("Share Ability");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 32));
		label.setAlignment(Label.CENTER);
		label.setBounds(19, 342, 241, 65);
		panel.add(label);

		SignUp = new Button("SignUp");
		SignUp.setForeground(new Color(0, 0, 0));
		SignUp.setBackground(Color.WHITE);
		SignUp.setFont(new Font("Arial", Font.ITALIC, 15));
		SignUp.setBounds(443, 326, 137, 23);
		contentPane.add(SignUp);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(368, 166, 248, 2);
		contentPane.add(separator);

		JLabel lblNewLabel = new JLabel("User ID ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel.setBounds(365, 138, 114, 23);
		contentPane.add(lblNewLabel);

		JLabel lblPw = new JLabel("Password");
		lblPw.setForeground(new Color(0, 0, 0));
		lblPw.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblPw.setBounds(369, 222, 132, 23);
		contentPane.add(lblPw);

		idU = new TextField();
		idU.setForeground(Color.BLACK);
		idU.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		idU.setColumns(10);
		idU.setBackground(new Color(255, 255, 255));
		idU.setBounds(370, 176, 245, 23);
		contentPane.add(idU);

		pwU = new JPasswordField();
		pwU.setForeground(Color.BLACK);
		pwU.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		pwU.setColumns(10);
		pwU.setBackground(new Color(255, 255, 255));
		pwU.setBounds(373, 259, 245, 23);
		contentPane.add(pwU);
		pwU.addKeyListener(this);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(372, 251, 248, 2);
		contentPane.add(separator_1);

		JLabel lbl_Close = new JLabel("X");
		lbl_Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.exit(0);
				dispose();
			}
		});
		lbl_Close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Close.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 17));
		lbl_Close.setBounds(679, 0, 42, 23);
		contentPane.add(lbl_Close);
		Button create = new Button("Create");

		// 회원가입
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new createPage();

			}
		});
		create.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 12));
		create.setBackground(Color.WHITE);
		create.setForeground(new Color(0, 0, 0));
		create.setBounds(395, 382, 76, 23);
		contentPane.add(create);

		findBtn = new Button("Find User");
		findBtn.setForeground(new Color(0, 0, 0));
		findBtn.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 12));
		findBtn.setBackground(Color.WHITE);
		findBtn.setBounds(545, 381, 76, 23);
		contentPane.add(findBtn);

		findBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new findUser();
			}
		});

		setUndecorated(true);
		setVisible(true);
		setLocation(600, 300);
		SignUp.setActionCommand("login");
		SignUp.addActionListener(this);

	}

	// 로그인 버튼
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "login") { // 눌러진 버튼 액션
			this.dao = new gosuDao();
			this.setVisible(false);
			String id = this.idU.getText();
			String pw = "";
			for (int i = 0; i < pwU.getPassword().length; i++) {
				pw = pw + pwU.getPassword()[i];
			}

			if (id.length() == 0 || pw.length() == 0) {
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!",
						JOptionPane.DEFAULT_OPTION);
				this.setVisible(true);
				return;
			} else if (id.equals("admin") && pw.equals("1234")) {
				JOptionPane.showMessageDialog(null, "관리자 로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
				new ConstructorPage();
				this.setVisible(false);
				return;
			} else if (id != null && pw != null) {
				if (dao.loginCheck(id, pw)) {
					new MainView(idU.getText(), this);
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
				} else {
					JOptionPane.showMessageDialog(null, "아이디/비밀번호를 확인하세요", "로그인 실패", JOptionPane.DEFAULT_OPTION);
					this.setVisible(true);
				}

			}

		} // 로그인 버튼 끝
	}

	public static void main(String[] args) {
		new loginPage();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.dao = new gosuDao();
			this.setVisible(false);
			String id = this.idU.getText();
			String pw = "";
			for (int i = 0; i < pwU.getPassword().length; i++) {
				pw = pw + pwU.getPassword()[i];
			}

			if (id.length() == 0 || pw.length() == 0) {
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!",
						JOptionPane.DEFAULT_OPTION);
				this.setVisible(true);
				return;
			} else if (id.equals("admin") && pw.equals("1234")) {
				JOptionPane.showMessageDialog(null, "관리자 로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
				new ConstructorPage();
				this.setVisible(false);
				return;
			} else if (id != null && pw != null) {
				if (dao.loginCheck(id, pw)) {
					new MainView(idU.getText(), this);
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
					
				} else {
					JOptionPane.showMessageDialog(null, "아이디/비밀번호를 확인하세요", "로그인 실패", JOptionPane.DEFAULT_OPTION);
				    this.setVisible(false);
					new loginPage();
				}
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}

}
