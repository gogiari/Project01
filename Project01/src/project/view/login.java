package project.view;
//zzz

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class login extends JFrame {

	private JPanel loginPanel = new JPanel(new GridLayout(3, 2));
	private JLabel idLabel = new JLabel("아이디 ");
	private JLabel pwLabel = new JLabel("비밀번호 ");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("로그인");
	private JButton idpwSearchBtn = new JButton("직원 등록");

	public login() {
		super("로그인 창");
		this.setContentPane(loginPanel);
		loginPanel.add(idLabel);
		loginPanel.add(pwLabel);
		loginPanel.add(idText);
		loginPanel.add(pwText);
		loginPanel.add(idpwSearchBtn);
		loginPanel.add(loginBtn);

		idLabel.setHorizontalAlignment(NORMAL);

		pwLabel.setHorizontalAlignment(NORMAL);

		setSize(350, 150);

		this.setLocationRelativeTo(null);

		this.setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 로그인 버튼을 눌렀을때
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idText.getText().trim();
				String pw = pwText.getText().trim();
				if (id.length() == 0 || pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!",
							JOptionPane.DEFAULT_OPTION);
					return;
				}
				if (id.equals("test") && pw.equals("1234")) {
					JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
					new client();
					return;
				}
				JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
			}
		});
		idpwSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// 직원등록 Emp
			
			}
		});
	}

	public static void main(String[] args) {
		new login();
	}
}