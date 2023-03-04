package gosu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gosu.data.gosuDao;
import gosu.data.gosuVo2;
import gosu.data.messageDao;



public class PaymentPage extends JFrame{

	private JFrame frame;
	private JTextField txtGr;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnFind;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private JRadioButton rb4;
	private JRadioButton rb5;
	private JTextArea textArea;
	
	PaymentCompletePage   pay        = null;
	AcceptPage            acceptpage = null;
	static PaymentPage    acc        = null;
	private JTextField txtHong;
	
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
	
	public PaymentPage( String id, AcceptPage acceptpage ) {
		this();
		this.acceptpage = acceptpage;
		
		// 넘어온 아이디를 txtGr 에 넣고 find 버튼 클릭하면
		txtGr.setText( id );
		btnFind.doClick();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 706, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
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
		
		JLabel lblNewLabel_1_3 = new JLabel("\uACE0\uC218ID");
		lblNewLabel_1_3.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_3.setBounds(12, 300, 109, 30);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\uC810\uC218");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_1.setBounds(392, 74, 109, 30);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("\uB9AC\uBDF0\uB0B4\uC6A9");
		lblNewLabel_1_4.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_4.setBounds(392, 151, 109, 30);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 204));
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
		
		txtGr = new JTextField();
		txtGr.setText("GR0059");
		txtGr.setEditable(false);
		txtGr.setBounds(133, 89, 167, 28);
		frame.getContentPane().add(txtGr);
		txtGr.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(133, 141, 167, 28);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(133, 196, 167, 28);
		frame.getContentPane().add(textField_2);
// 그룹화
		ButtonGroup  group = new ButtonGroup();
		
// 점수 위에서부터 1~5까지		
		rb1 = new JRadioButton("1");
		rb1.setBackground(new Color(255, 255, 255));
		rb1.setBounds(395, 121, 51, 23);
		frame.getContentPane().add(rb1);
				
		rb2 = new JRadioButton("2");
		rb2.setBackground(new Color(255, 255, 255));
		rb2.setBounds(450, 122, 51, 23);
		frame.getContentPane().add(rb2);
		
		rb3 = new JRadioButton("3");
		rb3.setBackground(new Color(255, 255, 255));
		rb3.setBounds(505, 121, 51, 23);
		frame.getContentPane().add(rb3);
		
		rb4 = new JRadioButton("4");
		rb4.setBackground(new Color(255, 255, 255));
		rb4.setBounds(560, 121, 51, 23);
		frame.getContentPane().add(rb4);
		
		rb5 = new JRadioButton("5");
		rb5.setBackground(new Color(255, 255, 255));
		rb5.setBounds(615, 121, 51, 23);
		frame.getContentPane().add(rb5);
// 점수버튼 그룹화		
		ButtonGroup  group1 = new ButtonGroup();
		group1.add(rb1);  
		group1.add( rb2);  
		group1.add(rb3);
		group1.add(rb4);
		group1.add(rb5);
		
		btnFind = new JButton("\uC870\uD68C");
		btnFind.setBounds(569, 20, 97, 36);
		frame.getContentPane().add(btnFind);
		
		txtHong = new JTextField();
		txtHong.setEditable(false);
		txtHong.setColumns(10);
		txtHong.setBounds(133, 300, 167, 28);
		frame.getContentPane().add(txtHong);
		
		//조회기능
		btnFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				findGereo();
				
			}
		});
		
		// 결제완료 버튼
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				String  id  = (String)textField.getText(); 
				System.out.println( e );	
				if ( pay != null)
					pay.dispose();
				PaymentPage ppp = PaymentPage.this;
				pay = new PaymentCompletePage( id, ppp );
				*/
				
				addGereo();
				payment();
				// 메인화면으로 돌아가게하면될듯?
				 
			}
		});
		// 취소버튼
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AcceptPage();
				frame.setVisible(false);
			}
		});
	}


	protected void addGereo() {
		gosuDao   gDao      =  new gosuDao();
		gosuVo2    vo        =  getViewData();
		int       aftcnt  =  gDao.insertGereo( vo );
		
		JOptionPane.showMessageDialog(null, 
			aftcnt + "건 결제되었습니다",
			"결제",
			JOptionPane.OK_OPTION);
		
		// MemberList 에 있는 jTableRefresh() 함수를 호출한다
		// memberList.jTableRefresh();
		
	    // 현재 창닫기
		
		
	}

	private gosuVo2 getViewData() {
		
		
		
		String   review       =  this.textArea.getText();
		String   u_id         =  this.txtHong.getText();
		String   gereo_code   =  this.txtGr.getText();
		
		
		String   score       =  "";
		if( this.rb1.isSelected() )    score = "1";
		if( this.rb2.isSelected() )    score = "2";
		if( this.rb3.isSelected() )    score = "3";
		if( this.rb4.isSelected() )    score = "4";
		if( this.rb5.isSelected() )    score = "5";
		
		gosuVo2  vo2        =  new gosuVo2( gereo_code ,u_id, score,review );
		return   vo2;
	}

	protected void findGereo() {
	
	    	
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
	private void payment() {
		String      g_code32    =  this.txtGr.getText();		
    	messageDao  gDao        =  new messageDao();
    	
    	int choice  =   JOptionPane.showConfirmDialog(null, 
				"결제하시겠습니까?",
				"확인",
				JOptionPane.OK_CANCEL_OPTION);
		int     aftcnt = 0 ;
		String  msg    = "";
		if( choice == 0) {
			gosuVo2 vo2 =  getViewData1();
			aftcnt      =  gDao.payment( vo2 );
			if( aftcnt > 0 )
				msg     =   "결제되었습니다";
			else
				msg     =  "결제되지 않았습니다";
		} else {
			msg = "결제를 선택하였습니다";
		}
		JOptionPane.showMessageDialog(null, 
				msg,
				"결제",
				JOptionPane.OK_OPTION);		
		
		// 마이페이지 새로고침		
		this.dispose();
	}
	
	public gosuVo2 getViewData1() {
		String     georae_code    =  this.txtGr.getText(); 	
		gosuVo2    vo2             =  new gosuVo2(georae_code);	
		
		return     vo2;
	}



	private void setViewData(gosuVo2 vo2) {
		String   georae_code    =  vo2.getGeorae_code();		
		String   midname        =  vo2.getMid_name();		
		String   price          =  vo2.getPrice();
		String   u_id           =  vo2.getU_id();
		
		this.txtGr.setText( georae_code );		
		this.textField_1.setText( midname );	
		this.textField_2.setText( price );
		this.txtHong.setText(u_id);
			
		
	}
}
