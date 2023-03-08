package gosu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gosu.data.gosuDao;
import gosu.data.gosuVo2;



public class PaymentCompletePage extends JFrame{

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JButton    btnFind;
	
	MainView mainview = null;
	PaymentPage    paymentPage        = null;
	private JTextField txtGr;
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

	public PaymentCompletePage( String sel, MainView mainview  ) {
		this();
		this.mainview = mainview;
		
		// 넘어온 아이디를 txtId 에 넣고 find 버튼 클릭하면
		txtGr.setText( sel );
		btnFind.doClick();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 562, 539);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
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
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(190, 120, 280, 32);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(190, 170, 280, 32);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(190, 220, 280, 32);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(190, 270, 280, 32);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(190, 320, 280, 32);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(190, 370, 280, 32);
		frame.getContentPane().add(textField_6);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setBounds(217, 431, 97, 46);
		frame.getContentPane().add(btnNewButton);
		
		btnFind = new JButton("\uC870\uD68C");
		btnFind.setBounds(437, 454, 97, 36);
		frame.getContentPane().add(btnFind);
		
		txtGr = new JTextField();
		txtGr.setText("GR0030");
		txtGr.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		txtGr.setEditable(false);
		txtGr.setColumns(10);
		txtGr.setBounds(190, 74, 280, 32);
		frame.getContentPane().add(txtGr);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				
			}
		});
		
		btnFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				findgereo();
				
			}
		});
	}

	protected void findgereo() {
		String      georae_code  =  this.txtGr.getText();
		if( georae_code.trim().equals("") )
			return;
		
		gosuDao   mDao     =  new gosuDao();
		// 조회한 결과를 vo로 돌려받는다
		gosuVo2    vo2      =  mDao.getMember( georae_code );
		System.out.println( vo2 );
		// vo를 화면을 구성하는 component 에 출력
		setViewData( vo2 );
		
	}

	private void setViewData(gosuVo2 vo2) {
		String   georae_code    =  vo2.getGeorae_code();
		String   uname     =  vo2.getU_name();
		String   midname   =  vo2.getMid_name();
		String   gdate     =  vo2.getG_date();     // "회사원", ...
		String   sdate     =  vo2.getSdate();  // "남", "여", ""  
		String   location  =  vo2.getLoction();
		String   price     =  vo2.getPrice();
		  
		this.txtGr.setText( georae_code );
		this.textField_1.setText( uname );
		this.textField_2.setText( midname );
		this.textField_3.setText( gdate );
		this.textField_4.setText( sdate );
		this.textField_5.setText( location );
		this.textField_6.setText( price );
		
	}
}
