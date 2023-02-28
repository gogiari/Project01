package gosu.view;

import java.awt.BorderLayout;
import java.awt.Font;
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

	
	BorderLayout gb;
	JLabel lbltitle, lbluserid;

	
	public GearaeGosu() {
		init();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("거래요청서가 도착했습니다");
		setVisible(true);
		setSize(800, 600);
		
	}
	
	private void init () {
		
		getContentPane().setLayout(new BorderLayout());
	    Pane  = new JPanel();
		setContentPane(Pane);		
		Pane.setLayout(null);		

		// 제목
		lbltitle = new JLabel("거래요청서가 도착했습니다");
		lbltitle.setFont(new Font("D2Coding", Font.PLAIN, 30));
		lbltitle.setBounds(200, 15, 500, 34);
		Pane.add(lbltitle);
		
		// 거래번호
		lblgnum = new JLabel("거래번호");
		lblgnum.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblgnum.setBounds(30, 80, 200, 20);
		Pane.add(lblgnum);
		txtgcode = new JTextField("거래번호불러오기");
		txtgcode.setFont(new Font("D2Coding", Font.PLAIN, 20));
		txtgcode.setBounds(200, 75, 560, 30);
		Pane.add(txtgcode);
		
		
		// 거래요청자 이름
		lblusername = new JLabel("거래요청자 이름");
		lblusername.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblusername.setBounds(30, 130, 200, 20);
		Pane.add(lblusername);
		txtuname = new JTextField("이름불러오기");
		txtuname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		txtuname.setBounds(200, 125, 200, 30);
		Pane.add(txtuname);
		
		// 업무내용(중분류)
		lblwork = new JLabel("업무 내용");
		lblwork.setBounds(30, 180, 200, 20);
		lblwork.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblwork);
		txtwo = new JTextField("업무내용불러오기");
		txtwo.setFont(new Font("D2Coding", Font.PLAIN, 20));
		txtwo.setBounds(200, 175, 200, 30);
		Pane.add(txtwo);
				
		// 날짜
		lbldate = new JLabel("날짜");
		lbldate.setBounds(30, 240, 200, 20);
		lbldate.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lbldate);
		txtda = new JTextField("업무날짜불러오기");
		txtda.setBounds(200, 235, 200, 30);
		txtda.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(txtda);
		
		
		// 업무가능 시작시간 
		lblstarttime = new JLabel("시작시간");
		lblstarttime.setBounds(30, 300, 200, 20);
		lblstarttime.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblstarttime);		
		txtstart = new JTextField("시작");
		txtstart.setBounds(120, 295, 60, 30);
		Pane.add(txtstart);

		// 업무가능 종료시간
		lblendtime = new JLabel("종료시간");
		lblendtime.setBounds(200, 300, 200, 20);
		lblendtime.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblendtime);		
		txtend = new JTextField("종료");
		txtend.setBounds(290, 295, 60, 30);
		Pane.add(txtend);
		
		// 업무 가능 위치
		lbllocation = new JLabel("위치");
		lbllocation.setBounds(30, 360, 200, 20);
		lbllocation.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lbllocation);
		txtlsido = new JTextField("시도");
		txtlsido.setBounds(200, 355, 90, 30);
		txtlsido.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(txtlsido);
		txtlgugun = new JTextField("구군");
		txtlgugun.setBounds(310, 355, 90, 30);
		txtlgugun.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(txtlgugun);
		
		// 고수이름
		lblgosuname = new JLabel("고수 이름");
		lblgosuname.setBounds(450, 130, 200, 20);
		lblgosuname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblgosuname);
		txtgname = new JTextField("이름불러오기");
		txtgname.setBounds(560, 125, 200, 30);
		txtgname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(txtgname);
				
		// 추가 메시지
		lblmessage = new JLabel("거래요청 메시지");
		lblmessage.setBounds(450, 180, 200, 20);
		lblmessage.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblmessage);
		txtm_message = new JTextField();
		txtm_message.setBounds(450, 210, 310, 65);
		Pane.add(txtm_message);
		
        // 답장
        lblreply = new JLabel("답장");
        lblreply.setBounds(450, 300, 200, 20);
        lblreply.setFont(new Font("D2Coding", Font.PLAIN, 20));
        Pane.add(lblreply);
        txtg_message = new JTextField();
        txtg_message.setBounds(450, 330, 310, 65);
        Pane.add(txtg_message);
		
		// 버튼
		btn1             = new JButton("수락하기");
		btn1.setBounds(250, 440, 100, 50);
		btn2             = new JButton("반송하기");
		btn2.setBounds(450, 440, 100, 50);
		btn3             = new JButton("조회");
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
				regeorae();

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

	}

	protected void getGeorae() {
		String      g_code  =  this.txtgcode.getText();
		if( g_code.trim().equals("") )
			return;
		
		gosuDao   mDao    =  new gosuDao();

		georaeVo    vo      =  mDao.getGeorae( g_code );
		System.out.println( vo );

		setViewData( vo );
		
	}
	
	protected void regeorae() {
		String      g_code     =  this.txtgcode.getText();
		String      g_message  =  this.txtg_message.getText();
		
		if( g_code.trim().equals("") )
			return;
		
		gosuDao   gDao    =  new gosuDao();
		int choice  =   JOptionPane.showConfirmDialog(null, 
				"거래요청서를 수락하셨습니다",
				"확인",
				JOptionPane.OK_CANCEL_OPTION);
		int       aftcnt  =  0;
		String    msg     = "";
		if( choice == 0) {
			georaeVo vo =  getViewData();
			aftcnt      =  gDao.regeorae( vo );
			if( aftcnt > 0 )
				msg     =  "거래가 수락되었습니다";
			else
				msg     =  "거래가 수락되지 않았습니다";
		} else {
			msg = "취소를 선택하였습니다";
		}
		JOptionPane.showMessageDialog(null, 
				msg,
				"수정",
				JOptionPane.OK_OPTION);		
		
		this.dispose();
		
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
		this.txtgname.setText(g_name);
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
		String   g_name    =  this.txtgname.getText();
		String   m_message =  this.txtm_message.getText();
		String   g_message =  this.txtg_message.getText();

		georaeVo   vo       = new georaeVo(
				g_code2, mid_name, gdate, g_start, g_end, wsido, wgugun, g_name, m_message, g_message);

		return vo;
	}


	public static void main(String[] args) {
		new GearaeGosu();

	}
}