package gosu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gosu.data.gosuDao;
import gosu.data.gosuVo3;

public class FAQ extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private ImageIcon imgTest;
    private JTextArea textArea;
    private JTextArea txtrbyte;
    private JButton btnFind;
    
    FAQ      faq = null;
    FAQList  faqList = null;
    private JTextField textField_1;
    private JTextField textField_2;
    String uid;
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAQ window = new FAQ();
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
	public FAQ() {
		this.uid = uid;
		initialize();
		
	}

	public FAQ(String id, String id2, FAQList faqList) {
		this();
		this.faqList = faqList;
		
		// 넘어온 아이디를 txtId 에 넣고 find 버튼 클릭하면
		textField_2.setText( id );
		btnFind.doClick();
		textField_1.setText(id2);
	}

	
	public FAQ(String id2,FAQList faqList ) {
		this();
		this.faqList = faqList;
		
		textField_1.setText(id2);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 850, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 834, 507);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
				
		
		/* JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\\uC0AC\uC9C4\\faq.png"));
		lblNewLabel.setBounds(165, 10, 573, 487);
		panel.add(lblNewLabel);
		*/
		
	
		
		JLabel lblNewLabel_1 = new JLabel("\uC81C\uBAA9");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(58, 145, 91, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBB38\uC758\uB0B4\uC6A9");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(42, 230, 107, 42);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RE");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(58, 359, 57, 37);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 204));
		textField.setText("\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		textField.setBounds(180, 140, 542, 42);
		panel.add(textField);
		textField.setColumns(10);
		
		txtrbyte = new JTextArea();
		txtrbyte.setBackground(new Color(255, 255, 204));
		txtrbyte.setText("4000byte \uC774\uB0B4\uB85C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		txtrbyte.setBounds(180, 201, 542, 102);
		panel.add(txtrbyte);
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 255, 204));
		textArea.setText("\uB2F5\uBCC0");
		textArea.setEnabled(false);
		textArea.setBounds(180, 337, 542, 90);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(307, 445, 97, 37);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBackground(new Color(0, 255, 255));
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(429, 445, 97, 37);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("FAQ");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_4.setBounds(367, 10, 97, 60);
		panel.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setText(uid);
		textField_1.setBackground(new Color(255, 255, 204));
		textField_1.setBounds(180, 82, 146, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel USER_ID = new JLabel("\uBB38\uC758\uC790(ID)");
		USER_ID.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		USER_ID.setBounds(51, 81, 82, 26);
		panel.add(USER_ID);
		
		btnFind = new JButton("\uC870\uD68C");
		btnFind.setBounds(142, 452, 70, 23);
		panel.add(btnFind);
		
		JLabel lblNewLabel = new JLabel("\uB2F5\uBCC0 \uBC88\uD638");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(32, 417, 70, 26);
		panel.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 204));
		textField_2.setBounds(12, 445, 116, 34);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u203B\uC544\uC774\uB514\uAC00 \uD2C0\uB9AC\uBA74 \uC785\uB825\uB418\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_5.setForeground(new Color(204, 0, 0));
		lblNewLabel_5.setBounds(335, 87, 219, 15);
		panel.add(lblNewLabel_5);

		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addFAQ();
				
			}
		});
		
		btnFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FindFAQ();
				
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new FAQList();
				frame.setVisible(false);
			}
		});
				
		FocusEvent();
		
	}
		


	
	private void FocusEvent() {
		textField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().trim().length() == 0) {
					textField.setText("제목을 입력해주세요");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().trim().equals(""
						+ "제목을 입력해주세요")) {
					textField.setText("");
				}
			}
		});
		txtrbyte.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (txtrbyte.getText().trim().length() == 0) {
					txtrbyte.setText("4000byte 이내로 입력해주세요");
				}
			}	@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (txtrbyte.getText().trim().equals("4000byte 이내로 입력해주세요")) {
					txtrbyte.setText("");
				}
			}
		});
		
	}

	protected void FindFAQ() {
		String      faq_code  =  this.textField_2.getText();
	 
		if( faq_code.trim().equals("") )
			return;
		
		gosuDao   gDao     =  new gosuDao();
		// 조회한 결과를 vo로 돌려받는다
		gosuVo3    vo2      =  gDao.getFaq( faq_code );
		System.out.println( vo2 );
		// vo를 화면을 구성하는 component 에 출력
		setViewData( vo2 );
		
	}

	private void setViewData(gosuVo3 vo2) {
		String   u_id        =  vo2.getU_id();
		String   f_head      =  vo2.getF_head();
		String   f_body      =  vo2.getF_body();
		String   reply       =  vo2.getReply();  
		String   faq_code    =  vo2.getFaq_code();

		this.textField_1.setText( uid );
		this.textField.setText( f_head );
		this.txtrbyte.setText( f_body );
		this.textArea.setText( reply );
		this.textField_2.setText( faq_code );
		
		
	}

	protected void addFAQ() {
		gosuDao   gDao      =  new gosuDao();
		gosuVo3   vo       =    getViewFAQ();
		int       aftcnt  =  gDao.insertFAQ( vo );
		
		JOptionPane.showMessageDialog(null, 
			aftcnt + "건 저장되었습니다",
			"추가",
			JOptionPane.OK_OPTION);
		
		
		
	    // 현재 창닫기
		this.dispose();
		
	}
	

	
	private gosuVo3 getViewFAQ() {
		
		String   u_id      =  this.textField_1.getText();
        String   f_head    =  this.textField.getText(); 	
		String   f_body    =  this.txtrbyte.getText();  // 줄표시 : 옛날 명령		
		String   reply     =  this.textArea.getText();
		String   faq_code  =  this.textField_2.getText();
		
		
		
		gosuVo3  vo        =  new gosuVo3(u_id,f_head, f_body, reply,faq_code);
		return   vo;
				
	}
	
	
}
