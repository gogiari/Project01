package gosu.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class loginPage extends JFrame implements ActionListener {

	private JPanel contentPane;
	gosuDao dao;
	TextField idU;
	JPasswordField pwU;

	public loginPage() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 480);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 139));
		contentPane.setBackground(new Color(102, 204, 255));
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
		label.setForeground(new Color(0, 153, 204));
		label.setFont(new Font("Comic Sans MS", Font.ITALIC, 32));
		label.setAlignment(Label.CENTER);
		label.setBounds(50, 358, 200, 36);
		panel.add(label);

		Button SignUp = new Button("SignUp");
		SignUp.setForeground(SystemColor.textHighlight);
		SignUp.setBackground(SystemColor.text);
		SignUp.setFont(new Font("Sitka Text", Font.ITALIC, 18));
		SignUp.setBounds(427, 291, 194, 32);
		contentPane.add(SignUp);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(400, 172, 248, 2);
		contentPane.add(separator);

		JLabel lblNewLabel = new JLabel("User ID ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblNewLabel.setBounds(401, 120, 80, 23);
		contentPane.add(lblNewLabel);

		JLabel lblPw = new JLabel("Password");
		lblPw.setForeground(Color.WHITE);
		lblPw.setFont(new Font("Sitka Text", Font.ITALIC, 15));
		lblPw.setBounds(400, 189, 92, 23);
		contentPane.add(lblPw);

		idU = new TextField();
		idU.setForeground(Color.BLACK);
		idU.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		idU.setColumns(10);
		idU.setBackground(new Color(176, 224, 230));
		idU.setBounds(400, 149, 248, 23);
		contentPane.add(idU);

		pwU = new JPasswordField();
		pwU.setForeground(Color.BLACK);
		pwU.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		pwU.setColumns(10);
		pwU.setBackground(new Color(176, 224, 230));
		pwU.setBounds(400, 215, 248, 23);
		contentPane.add(pwU);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(400, 238, 248, 2);
		contentPane.add(separator_1);

		JLabel lbl_Close = new JLabel("X");
		lbl_Close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lbl_Close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Close.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 17));
		lbl_Close.setBounds(679, 0, 26, 23);
		contentPane.add(lbl_Close);
		Button create = new Button("Create");

		// 회원가입
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new createPage();

			}
		});
		create.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 12));
		create.setBackground(SystemColor.textHighlightText);
		create.setForeground(SystemColor.textHighlight);
		create.setBounds(488, 341, 76, 23);
		contentPane.add(create);

		setUndecorated(true);
		setVisible(true);
		setLocation(600, 300);
		SignUp.addActionListener(this);

	}

	// 로그인 버튼
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dao = new gosuDao();
		this.setVisible(false);
		String id = this.idU.getText();
		String pw = "";
		for (int i = 0; i < pwU.getPassword().length; i++) {
			pw = pw + pwU.getPassword()[i];

		}

		if (id.length() == 0 || pw.length() == 0) {
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!", JOptionPane.DEFAULT_OPTION);
			this.setVisible(true);
			return;
		} else if (id.equals("admin") && pw.equals("1234")) {
			JOptionPane.showMessageDialog(null, "관리자 로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
			new ConstructorPage();
			this.setVisible(false);
			return;
		} else if (id != null && pw != null) {
			if (dao.loginCheck(id, pw)) {
				new MainView();
				JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
			} else {
				JOptionPane.showMessageDialog(null, "아이디/비밀번호를 확인하세요", "로그인 실패", JOptionPane.DEFAULT_OPTION);
				this.setVisible(true);
			}
		}
	}

	public static void main(String[] args) {
		new loginPage();
	}
}