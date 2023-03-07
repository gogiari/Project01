package gosu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gosu.data.georaeVo;
import gosu.data.gosuDao;
import gosu.data.messageDao;
import gosu.data.updateVo;


public class GearaeGosu extends JFrame {
	JPanel Pane;
	JLabel lblusername, lblgosuname, lblwork, lbldate, lblstarttime, lblendtime,
	lblprice, lbllocation, lblmessage, lblreply, lblgnum;
	
	JButton btn1, btn2, btn3;
	JTextField txtgcode;
	JTextField txtm_message;
	JTextField txtuname;
	JTextField txtwo;
	JTextField txtda;
	JTextField txtstart;
	JTextField txtend;
	JTextField txtpri;
	JTextField txtlsido;
	JTextField txtlgugun;
	JTextField txtme;
	JTextField txtgname;
	JTextField txtg_message;
	String sel;
	String uid;
	
	BorderLayout gb;
	JLabel lbltitle, lbluserid;
	
	
	
	public GearaeGosu(String sel, String uid, MainView mainview) {
		
		this.sel = sel;
		System.out.println(sel);
		init();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("거래요청서가 도착했습니다");
		setVisible(true);
		setSize(800, 580);
		setLocation(600, 200);	
		txtgcode.setText(sel);

		if(sel!=null)
		btn3.doClick();
		
		
		
	}
	
	private void init () {
		
		setBackground(Color.WHITE);
		
		getContentPane().setLayout(new BorderLayout());
	    Pane  = new JPanel();
	    Pane.setBackground(new Color(135, 206, 250));
	    
		setContentPane(Pane);		
		Pane.setLayout(null);		

		// 제목
		lbltitle = new JLabel("거래요청서가 도착했습니다");
		lbltitle.setForeground(Color.WHITE);
		lbltitle.setFont(new Font("D2Coding", Font.PLAIN, 30));
		lbltitle.setBounds(210, 25, 500, 34);
		Pane.add(lbltitle);
		
		// 거래번호
		lblgnum = new JLabel("거래번호");
		lblgnum.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblgnum.setForeground(SystemColor.textHighlight);
		lblgnum.setBackground(SystemColor.text);
		lblgnum.setBounds(30, 100, 200, 20);
		Pane.add(lblgnum);
		txtgcode = new JTextField("거래번호불러오기");
		txtgcode.setFont(new Font("D2Coding", Font.PLAIN, 17));
		txtgcode.setBounds(200, 95, 560, 30);
		Pane.add(txtgcode);
		
		
		// 거래요청자 
		lblusername = new JLabel("거래요청자 ID");
		lblusername.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblusername.setForeground(SystemColor.textHighlight);
		lblusername.setBackground(SystemColor.text);
		lblusername.setBounds(30, 145, 200, 20);
		Pane.add(lblusername);
		txtuname = new JTextField("이름불러오기");
		txtuname.setFont(new Font("D2Coding", Font.PLAIN, 17));
		txtuname.setBounds(200, 140, 200, 30);
		Pane.add(txtuname);
		
		// 업무내용(중분류)
		lblwork = new JLabel("업무 내용");
		lblwork.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblwork.setForeground(SystemColor.textHighlight);
		lblwork.setBounds(30, 195, 200, 20);
		lblwork.setBackground(SystemColor.text);
		Pane.add(lblwork);
		txtwo = new JTextField("업무내용불러오기");
		txtwo.setFont(new Font("D2Coding", Font.PLAIN, 17));
		txtwo.setBounds(200, 190, 200, 30);
		Pane.add(txtwo);
				
		// 날짜
		lbldate = new JLabel("날짜");
		lbldate.setForeground(SystemColor.textHighlight);
		lbldate.setBackground(SystemColor.text);
		lbldate.setBounds(30, 255, 200, 20);
		lbldate.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lbldate);
		txtda = new JTextField("업무날짜불러오기");
		txtda.setBounds(200, 250, 200, 30);
		txtda.setFont(new Font("D2Coding", Font.PLAIN, 17));
		Pane.add(txtda);
		
		
		// 업무가능 시작시간 
		lblstarttime = new JLabel("시작시간");
		lblstarttime.setForeground(SystemColor.textHighlight);
		lblstarttime.setBackground(SystemColor.text);
		lblstarttime.setBounds(30, 315, 200, 20);
		lblstarttime.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblstarttime);		
		txtstart = new JTextField("시작 불러오기");
		txtstart.setFont(new Font("D2Coding", Font.PLAIN, 15));
		txtstart.setBounds(120, 310, 80, 30);
		Pane.add(txtstart);

		// 업무가능 종료시간
		lblendtime = new JLabel("종료시간");
		lblendtime.setForeground(SystemColor.textHighlight);
		lblendtime.setBackground(SystemColor.text);
		lblendtime.setBounds(230, 315, 200, 20);
		lblendtime.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblendtime);		
		txtend = new JTextField("종료 불러오기");
		txtend.setFont(new Font("D2Coding", Font.PLAIN, 15));
		txtend.setBounds(320, 310, 80, 30);
		Pane.add(txtend);
		
		// 업무 가능 위치
		lbllocation = new JLabel("위치");
		lbllocation.setForeground(SystemColor.textHighlight);
		lbllocation.setBackground(SystemColor.text);
		lbllocation.setBounds(30, 375, 200, 20);
		lbllocation.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lbllocation);
		txtlsido = new JTextField("시도");
		txtlsido.setBounds(200, 370, 90, 30);
		txtlsido.setFont(new Font("D2Coding", Font.PLAIN, 17));
		Pane.add(txtlsido);
		txtlgugun = new JTextField("구군");
		txtlgugun.setBounds(310, 370, 90, 30);
		txtlgugun.setFont(new Font("D2Coding", Font.PLAIN, 17));
		Pane.add(txtlgugun);
		
		/*
		// 고수이름
		lblgosuname = new JLabel("고수 ID");
		lblgosuname.setForeground(SystemColor.textHighlight);
		lblgosuname.setBackground(SystemColor.text);
		lblgosuname.setBounds(450, 145, 200, 20);
		lblgosuname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblgosuname);
		txtgname = new JTextField("ID불러오기");
		txtgname.setBounds(560, 140, 200, 30);
		txtgname.setFont(new Font("D2Coding", Font.PLAIN, 17));
		Pane.add(txtgname);
		*/
				
		// 추가 메시지
		lblmessage = new JLabel("거래요청 메시지");
		lblmessage.setForeground(SystemColor.textHighlight);
		lblmessage.setBackground(SystemColor.text);
		lblmessage.setBounds(450, 195, 200, 20);
		lblmessage.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblmessage);
		txtm_message = new JTextField("거래요청 메시지 불러오기");
		txtm_message.setBounds(450, 225, 310, 65);
		txtm_message.setFont(new Font("D2Coding", Font.PLAIN, 17));
		Pane.add(txtm_message);
		
        // 답장
        lblreply = new JLabel("답장");
        lblreply.setForeground(SystemColor.textHighlight);
        lblreply.setBackground(SystemColor.text);
        lblreply.setBounds(450, 315, 200, 20);
        lblreply.setFont(new Font("D2Coding", Font.PLAIN, 20));
        Pane.add(lblreply);
        txtg_message = new JTextField();
        txtg_message.setBounds(450, 345, 310, 65);
        txtg_message.setFont(new Font("D2Coding", Font.PLAIN, 17));
        Pane.add(txtg_message);
		
		// 버튼
		btn1             = new JButton("수락하기");
		btn1.setForeground(new Color(30, 144, 255));
		btn1.setBackground(new Color(240, 248, 255));
		btn1.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btn1.setBounds(250, 469, 100, 50);
		
		btn2             = new JButton("반송하기");
		btn2.setForeground(new Color(30, 144, 255));
		btn2.setBackground(new Color(240, 248, 255));
		btn2.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btn2.setBounds(450, 469, 100, 50);
		
		btn3             = new JButton("조회");
		btn3.setForeground(new Color(30, 144, 255));
		btn3.setBackground(new Color(240, 248, 255));
		btn3.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btn3.setBounds(10, 10, 100, 30);
		
		
		this.txtgcode.addKeyListener( new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			
			}

			@Override
			public void keyReleased(KeyEvent e) {

				if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
					btn3.doClick(); 
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {


				
			}
		});
		
		
		// btn1(수락하기) 버튼에 기능 추가
		btn1.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("수락하기 클릭");				    				
				surakgeorae();				
				mess();							

			}

		});
		
		// btn2(반송하기) 버튼에 기능 추가
		btn2.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("반송하기 클릭");				    				
				bansong();				
				mess2();
			}

		});
		
		
		btn3.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("조회 클릭");				
				getGeorae();
			}


		});
		Pane.add( btn1);		
		Pane.add( btn2 );
		Pane.add( btn3 );
		
		
		JPanel panel = new JPanel();
	    panel.setBackground(SystemColor.inactiveCaptionBorder);
		//panel.setBackground(new Color(102, 204, 255));
		panel.setBounds(10, 74, 760, 371);
		Pane.add(panel);


	}

	protected void getGeorae() {
		String      g_code  =  this.txtgcode.getText();
		gosuDao     gDao    =  new gosuDao();
		
		if( g_code.trim().equals("") )
			return;

		georaeVo    vo      =  gDao.getGeorae( g_code );
		System.out.println( vo );

		setViewData( vo );
		
	}
	

	protected void surakgeorae() {
		
		System.out.println("1:" + getViewData1());		
		String      g_code3    =  this.txtgcode.getText();		
    	gosuDao     gDao       =  new gosuDao();
    	
    	int choice  =   JOptionPane.showConfirmDialog(null, 
				"수정하시겠습니까?",
				"수정확인",
				JOptionPane.OK_CANCEL_OPTION);
		int     aftcnt = 0 ;
		String  msg    = "";
		if( choice == 0) {
			updateVo vo =  getViewData1();
			aftcnt      =  gDao.surakgeorae( vo );
			if( aftcnt > 0 )
				msg     =   "수정되었습니다";
			else
				msg     =  "수정되지 않았습니다";
		} else {
			msg = "취소를 선택하였습니다";
		}
		JOptionPane.showMessageDialog(null, 
				msg,
				"수정",
				JOptionPane.OK_OPTION);		
		
		// 마이페이지 새로고침		
		this.dispose();
		
	}	
	
	private void bansong() {

		String      g_code3    =  this.txtgcode.getText();		
    	gosuDao     gDao       =  new gosuDao();
    	
    	int choice  =   JOptionPane.showConfirmDialog(null, 
				"반송하시겠습니까?",
				"반송확인",
				JOptionPane.OK_CANCEL_OPTION);
		int     aftcnt = 0 ;
		String  msg    = "";
		if( choice == 0) {
			updateVo vo =  getViewData1();
			aftcnt      =  gDao.bansong( vo );
			if( aftcnt > 0 )
				msg     =   "반송되었습니다";
			else
				msg     =  "반송되지 않았습니다";
		} else {
			msg = "취소를 선택하였습니다";
		}
		JOptionPane.showMessageDialog(null, 
				msg,
				"반송",
				JOptionPane.OK_OPTION);		
		
		// 마이페이지 새로고침		
		this.dispose();
	}
	
	private void mess() {
		messageDao   mDao    =  new messageDao();
		updateVo     vo      =  getViewData1();
		int       aftcnt     =  mDao.mess( vo );
		
	}
	
	private void mess2() {
		messageDao   mDao    =  new messageDao();
		updateVo     vo      =  getViewData1();
		int       aftcnt     =  mDao.mess2( vo );
		
	}

	

	private void setViewData(georaeVo vo) {
		String   g_code2   =  vo.getG_code();
		String   mid_name  =  vo.getMid_name(); 
		String   gdate     =  vo.getGdate(); 
		String   g_start   =  vo.getG_start();
		String   g_end     =  vo.getG_end();
		String   wsido     =  vo.getWsido(); 
		String   wgugun    =  vo.getWgugun(); 
		String   g_name    =  vo.getG_name();
		String   m_message =  vo.getM_message();
		String   g_message =  vo.getG_message();
		
		this.txtgcode.setText(g_code2); 
		this.txtwo.setText(mid_name); 
		this.txtda.setText(gdate); 
		this.txtstart.setText(g_start);
		this.txtend.setText(g_end);
		this.txtlsido.setText(wsido); 
		this.txtlgugun.setText(wgugun); 
		this.txtuname.setText(g_name);
		this.txtm_message.setText(m_message);	
		this.txtg_message.setText(g_message);	
	}
	

	public georaeVo getViewData() {
		String   g_code2   =  this.txtgcode.getText(); 
		String   mid_name  =  this.txtwo.getText(); 
		String   gdate     =  this.txtda.getText(); 
		String   g_start   =  this.txtstart.getText();
		String   g_end     =  this.txtend.getText();
		String   wsido     =  this.txtlsido.getText(); 
		String   wgugun    =  this.txtlgugun.getText(); 
		String   g_name    =  this.txtuname.getText();
		String   m_message =  this.txtm_message.getText();
		String   g_message =  this.txtg_message.getText();

		georaeVo   vo       = new georaeVo(
				g_code2, mid_name, gdate, g_start, g_end, wsido, wgugun, g_name, m_message, g_message);
		
		return vo;
	}
	

	private void setViewData1(updateVo vo) {
		String g_code3  = vo.getG_code();
		String g_message3 = vo.getG_message();
		
		this.txtgcode.setText(g_code3);
		this.txtg_message.setText(g_message3);
	}
	
	public updateVo getViewData1() {
		String   g_code3    =  this.txtgcode.getText(); 
		String   g_message3 =  this.txtg_message.getText();
		
		updateVo   vo       = new updateVo(g_code3, g_message3);
		
		return vo;
	}

	public static void main(String[] args) {
		new GearaeGosu(null,null,null);

	}
}