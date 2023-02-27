package gosu.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class PaymentPage {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentPage window = new PaymentPage();
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
	public PaymentPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 706, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uACB0\uC81C \uBC0F \uC810\uC218\uB4F1\uB85D");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(204, 0, 297, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uAC70\uB798\uBC88\uD638");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(12, 89, 109, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uB0B4\uC6A9");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(12, 141, 109, 30);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uAE08\uC561");
		lblNewLabel_1_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_2.setBounds(12, 192, 109, 30);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\uACB0\uC81C\uBC29\uBC95");
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_3.setBounds(12, 250, 109, 30);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uC810\uC218");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_1.setBounds(392, 74, 109, 30);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("\uB9AC\uBDF0\uB0B4\uC6A9");
		lblNewLabel_1_4.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_4.setBounds(392, 151, 109, 30);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("20\uC790 \uC774\uB0B4\uB85C \uC785\uB825\uD558\uC2DC\uC624.");
		textArea.setBounds(392, 197, 233, 130);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("\uACB0\uC81C \uC644\uB8CC");
		btnNewButton.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(191, 385, 109, 44);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\uCDE8\uC18C");
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(358, 385, 109, 44);
		frame.getContentPane().add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(133, 89, 167, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 148, 167, 28);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 199, 167, 28);
		frame.getContentPane().add(textField_2);
		
// 결제방법 		
		JRadioButton  rdbtnNewRadioButton= new JRadioButton("\uBB34\uD1B5\uC7A5 \uC785\uAE08");
		rdbtnNewRadioButton.setBounds(148, 250, 121, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uB9CC\uB098\uC11C \uACB0\uC81C");
		rdbtnNewRadioButton_1.setBounds(148, 285, 121, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\uCE74\uCE74\uC624 \uD398\uC774");
		rdbtnNewRadioButton_2.setBounds(148, 320, 121, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_2);
// 그룹화
		ButtonGroup  group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);  
		group.add( rdbtnNewRadioButton_1);  
		group.add(rdbtnNewRadioButton_2);
		
// 점수 위에서부터 1~5까지		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("1\uC810");
		rdbtnNewRadioButton_3.setBounds(395, 121, 51, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3);
				
		JRadioButton rdbtnNewRadioButton_3_1 = new JRadioButton("2\uC810");
		rdbtnNewRadioButton_3_1.setBounds(450, 122, 51, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3_1);
		
		JRadioButton rdbtnNewRadioButton_3_2 = new JRadioButton("3\uC810");
		rdbtnNewRadioButton_3_2.setBounds(505, 121, 51, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3_2);
		
		JRadioButton rdbtnNewRadioButton_3_3 = new JRadioButton("4\uC810");
		rdbtnNewRadioButton_3_3.setBounds(560, 121, 51, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3_3);
		
		JRadioButton rdbtnNewRadioButton_3_4 = new JRadioButton("5\uC810");
		rdbtnNewRadioButton_3_4.setBounds(615, 121, 51, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_3_4);
// 점수버튼 그룹화		
		ButtonGroup  group1 = new ButtonGroup();
		group1.add(rdbtnNewRadioButton_3);  
		group1.add( rdbtnNewRadioButton_3_1);  
		group1.add(rdbtnNewRadioButton_3_2);
		group1.add(rdbtnNewRadioButton_3_3);
		group1.add(rdbtnNewRadioButton_3_4);
		
	}
}
