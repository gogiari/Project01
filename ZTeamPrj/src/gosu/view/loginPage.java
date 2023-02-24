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
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class loginPage extends JFrame implements ActionListener {

	private JPanel contentPane;

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

		TextField idE = new TextField();
		idE.setForeground(Color.BLACK);
		idE.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		idE.setColumns(10);
		idE.setBackground(new Color(176, 224, 230));
		idE.setBounds(400, 149, 248, 23);
		contentPane.add(idE);

		TextField pwE = new TextField();
		pwE.setForeground(Color.BLACK);
		pwE.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		pwE.setColumns(10);
		pwE.setBackground(new Color(176, 224, 230));
		pwE.setBounds(400, 215, 248, 23);
		contentPane.add(pwE);

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
		new MainView();
		this.setVisible(false);
	}

	public static void main(String[] args) {
		new loginPage();
	}
}