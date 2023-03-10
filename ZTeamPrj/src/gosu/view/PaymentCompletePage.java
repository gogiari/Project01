package gosu.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class PaymentCompletePage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentCompletePage window = new PaymentCompletePage();
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
	public PaymentCompletePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 562, 539);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC774 \uACB0\uC81C\uB97C \uC644\uB8CC\uD588\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setFont(new Font("궁서", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(47, 10, 470, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC70\uB798\uBC88\uD638");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(85, 70, 88, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uD68C\uC6D0\uC774\uB984");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(85, 120, 88, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uB0B4\uC6A9");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_2.setBounds(85, 170, 88, 36);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\uB0A0\uC9DC");
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_3.setBounds(85, 220, 88, 36);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("\uC2DC\uAC04\uB300");
		lblNewLabel_1_4.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_4.setBounds(85, 270, 88, 36);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("\uC704\uCE58");
		lblNewLabel_1_5.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_5.setBounds(85, 320, 88, 36);
		frame.getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("\uAE08\uC561");
		lblNewLabel_1_6.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_6.setBounds(85, 370, 88, 36);
		frame.getContentPane().add(lblNewLabel_1_6);
		
		textField = new JTextField();
		textField.setBounds(190, 70, 280, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 120, 280, 32);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(190, 170, 280, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(190, 220, 280, 32);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(190, 270, 280, 32);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(190, 320, 280, 32);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(190, 370, 280, 32);
		frame.getContentPane().add(textField_6);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(217, 431, 97, 46);
		frame.getContentPane().add(btnNewButton);
	}

}
