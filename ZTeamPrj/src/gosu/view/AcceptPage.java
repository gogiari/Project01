package gosu.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import gosu.data.gosuDao;
import gosu.data.gosuVo;
import gosu.data.gosuVo2;

import java.awt.Color;

public class AcceptPage extends JFrame {

	private JFrame frame;
	private JTextField txtDd;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	// 조회한 결과를 vo로 돌려받는다

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new AcceptPage();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcceptPage window = new AcceptPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public AcceptPage() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 544);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		JLabel lblNewLabel = new JLabel("\uAC70\uB798\uB97C \uC218\uB77D\uD569\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("궁서", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(58, 10, 337, 68);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uAC70\uB798\uBC88\uD638");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(12, 100, 94, 31);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\uB0B4\uC6A9");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(12, 200, 94, 31);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\uACE0\uC218\uC774\uB984");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_2.setBounds(12, 150, 94, 31);
		frame.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("\uB0A0\uC9DC");
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_3.setBounds(12, 250, 94, 31);
		frame.getContentPane().add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("\uC2DC\uAC04\uB300");
		lblNewLabel_1_4.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_4.setBounds(12, 300, 94, 31);
		frame.getContentPane().add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("\uC704\uCE58");
		lblNewLabel_1_5.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_5.setBounds(12, 350, 94, 31);
		frame.getContentPane().add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_5_1 = new JLabel("\uAE08\uC561");
		lblNewLabel_1_5_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_5_1.setBounds(12, 400, 94, 31);
		frame.getContentPane().add(lblNewLabel_1_5_1);

		JButton btnAccept = new JButton("\uACB0\uC81C\uD558\uAE30");
		btnAccept.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		btnAccept.setForeground(Color.BLACK);
		btnAccept.setBackground(new Color(0, 255, 255));
		btnAccept.setBounds(170, 450, 108, 45);
		frame.getContentPane().add(btnAccept);

		JButton btnReturn = new JButton("\uC694\uCCAD \uCDE8\uC18C");
		btnReturn.setBackground(new Color(0, 255, 255));
		btnReturn.setForeground(new Color(0, 0, 0));
		btnReturn.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		btnReturn.setBounds(320, 450, 108, 45);
		frame.getContentPane().add(btnReturn);

		txtDd = new JTextField();
		txtDd.setText("");
		txtDd.setBounds(131, 100, 268, 31);
		frame.getContentPane().add(txtDd);
		txtDd.setColumns(10);

		textField_1 = new JTextField();

		textField_1.setColumns(10);
		textField_1.setBounds(131, 150, 268, 31);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();

		textField_2.setColumns(10);
		textField_2.setBounds(131, 200, 268, 31);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField();

		textField_3.setColumns(10);
		textField_3.setBounds(131, 250, 268, 31);
		frame.getContentPane().add(textField_3);

		textField_4 = new JTextField();

		textField_4.setColumns(10);
		textField_4.setBounds(131, 300, 268, 31);
		frame.getContentPane().add(textField_4);

		textField_5 = new JTextField();

		textField_5.setColumns(10);
		textField_5.setBounds(131, 350, 268, 31);
		frame.getContentPane().add(textField_5);

		textField_6 = new JTextField();

		textField_6.setColumns(10);
		textField_6.setBounds(131, 400, 268, 31);
		frame.getContentPane().add(textField_6);

		JButton btnFind = new JButton("\uC870\uD68C");
		btnFind.setForeground(Color.BLACK);
		btnFind.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		btnFind.setBackground(Color.CYAN);
		btnFind.setBounds(20, 450, 108, 45);
		frame.getContentPane().add(btnFind);

		// 결제하기버튼 기능
		btnAccept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new PaymentPage();
				frame.setVisible(false);

			}

		});

		btnFind.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				findGereo();

			}
		});

		// 취소버튼 기능
		btnReturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);

			}
		});

	}

	protected void findGereo() {
		String georae_code = this.txtDd.getText();
		if (georae_code.trim().equals(""))
			return;

		gosuDao mDao = new gosuDao();
		// 조회한 결과를 vo로 돌려받는다
		gosuVo2 vo2 = mDao.getMember(georae_code);
		System.out.println(vo2);
		// vo를 화면을 구성하는 component 에 출력
		setViewData(vo2);

	}

	private gosuVo2 getViewData() {
		String georae_code = this.txtDd.getText();

		// String passwd = this.txtPwd.getPassword().toString(); // char [] -> String
		String uname = this.textField_1.getText();
		String midname = this.textField_2.getText();
		String gdate = this.textField_3.getText();
		String sdate = this.textField_4.getText();
		String gcheck = this.textField_5.getText();
		String price = this.textField_6.getText();

		gosuVo2 vo = new gosuVo2(georae_code, uname, midname, gdate, sdate, gcheck, price);
		return vo;
	}

	private void setViewData(gosuVo2 vo2) {
		String georae_code = vo2.getGeorae_code();
		String uname = vo2.getU_name();
		String midname = vo2.getMid_name();
		String gdate = vo2.getG_date(); // "회사원", ...
		String sdate = vo2.getSdate(); // "남", "여", ""
		String gcheck = vo2.getG_check();
		String price = vo2.getPrice();

		this.txtDd.setText(georae_code);
		this.textField_1.setText(uname);
		this.textField_2.setText(midname);
		this.textField_3.setText(gdate);
		this.textField_4.setText(sdate);
		this.textField_5.setText(gcheck);
		this.textField_6.setText(price);

	}

}