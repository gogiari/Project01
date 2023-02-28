package gosu.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gosu.data.georaeVo;
import gosu.data.gosuDao;



public class Gearae extends JFrame {
	JPanel Pane;
	JLabel lblusername, lblgosuname, lblwork, lbldate, lblstarttime, lblendtime, lblprice, lbllocation, lblmessage;
	
	JButton btnsend, btncancel, btnget;
	JTextField  txtm_message, txtuname, txtwo, txtda, txtlsido, txtlgugun, txtme, txtgname;
	JComboBox  startcb, endcb;
	
	BorderLayout gb;
	JLabel lbltitle, lbluserid;
	
	public Gearae() {
		init();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("거래요청서");
		setVisible(true);
		setSize(800,500);
		setLocation(600, 200);		
	}
	
	
	private void init () {
		
		getContentPane().setLayout(new BorderLayout());
	    Pane  = new JPanel();
		setContentPane(Pane);		
		Pane.setLayout(null);		

		// 제목
		lbltitle = new JLabel("거래요청서");
		lbltitle.setFont(new Font("D2Coding", Font.PLAIN, 30));
		lbltitle.setBounds(330, 10, 200, 34);
		Pane.add(lbltitle);
		
		// 거래요청자 이름
		lblusername = new JLabel("거래요청자 이름");
		lblusername.setFont(new Font("D2Coding", Font.PLAIN, 20));
		lblusername.setBounds(30, 90, 200, 20);
		Pane.add(lblusername);
		txtuname = new JTextField("이름불러오기");
		txtuname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		txtuname.setBounds(200, 85, 200, 30);
		Pane.add(txtuname);
		
		// 업무내용(중분류)
		lblwork = new JLabel("업무 내용");
		lblwork.setBounds(30, 150, 200, 20);
		lblwork.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblwork);
		txtwo = new JTextField("업무내용불러오기");
		txtwo.setFont(new Font("D2Coding", Font.PLAIN, 20));
		txtwo.setBounds(200, 145, 200, 30);
		Pane.add(txtwo);
				
		// 날짜
		lbldate = new JLabel("날짜");
		lbldate.setBounds(30, 210, 200, 20);
		lbldate.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lbldate);
		txtda = new JTextField("업무날짜불러오기");
		txtda.setBounds(200, 205, 200, 30);
		txtda.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(txtda);
		
		
		// 업무가능 시작시간 
		lblstarttime = new JLabel("시작시간");
		lblstarttime.setBounds(30, 270, 200, 20);
		lblstarttime.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblstarttime);
		String [] starttime = { "6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		startcb = new JComboBox(starttime);
		startcb.setBounds(120, 265, 60, 30);
		Pane.add(startcb);

		// 업무가능 종료시간
		lblendtime = new JLabel("종료시간");
		lblendtime.setBounds(200, 270, 200, 20);
		lblendtime.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblendtime);
		String [] endtime = { "7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
		endcb = new JComboBox(endtime);
		endcb.setBounds(290, 265, 60, 30);
		Pane.add(endcb);
		
		// 업무 가능 위치
		lbllocation = new JLabel("위치");
		lbllocation.setBounds(30, 330, 200, 20);
		lbllocation.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lbllocation);
		txtlsido = new JTextField("시도");
		txtlsido.setBounds(200, 325, 90, 30);
		txtlsido.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(txtlsido);
		txtlgugun = new JTextField("구군");
		txtlgugun.setBounds(310, 325, 90, 30);
		txtlgugun.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(txtlgugun);
		
		
		// 고수이름
		lblgosuname = new JLabel("고수 이름");
		lblgosuname.setBounds(450, 90, 200, 20);
		lblgosuname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblgosuname);
		txtgname = new JTextField("이름불러오기");
		txtgname.setBounds(560, 85, 200, 30);
		txtgname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(txtgname);
				
		// 추가 메시지
		lblmessage = new JLabel("거래요청 메시지");
		lblmessage.setBounds(450, 150, 200, 20);
		lblmessage.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblmessage);
		txtm_message = new JTextField();
		txtm_message.setBounds(450, 180, 310, 175);
		Pane.add(txtm_message);

		
		// 버튼
		btnsend              = new JButton("거래요청");
		btnsend.setBounds(250, 380, 100, 50);
		btncancel            = new JButton("취소");
		btncancel.setBounds(450, 380, 100, 50);

		
		// btnsend(거래요청) 버튼에 기능 추가

		btnsend.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("거래요청 클릭");				
				addgeorae();

			}
	
		
     	});
		
		btncancel.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("취소 클릭");				
				dispose();
				
			}
	
		
     	});		
		
		Pane.add( btnsend );
		Pane.add( btncancel );

	   }

		protected void addgeorae() {
			gosuDao   gDao    =  new gosuDao();
			georaeVo    vo    =  getViewData();
			int       aftcnt  =  gDao.addgeorae( vo );
			
			addmessage();

			JOptionPane.showMessageDialog(null, 
					aftcnt + "거래요청서가 전송되었습니다",
					"확인",
					JOptionPane.OK_OPTION);
			 // 현재 창닫기
			this.dispose();	
		}

		protected void addmessage() {
			gosuDao   gDao    =  new gosuDao();
			georaeVo  vo      =  getViewData();
			int       aftcnt  =  gDao.addmessage( vo );
		}

		private void setViewData(georaeVo vo) {
			String   u_name    =  vo.getU_name(); 
			String   mid_name  =  vo.getMid_name(); 
			String   gdate     =  vo.getGdate(); 
			String   g_start   =  vo.getG_start();
			String   g_end     =  vo.getG_end();
			String   wsido     =  vo.getWsido(); 
			String   wgugun    =  vo.getWgugun(); 
			String   g_name    =  vo.getG_name(); 
			String   m_message =  vo.getM_message();
			
			this.txtuname.setText(u_name); 
			this.txtwo.setText(mid_name); 
			this.txtda.setText(gdate); 
			this.startcb.setSelectedItem(g_start);
			this.endcb.setSelectedItem(g_end);
			this.txtlsido.setText(wsido); 
			this.txtlgugun.setText(wgugun); 
			this.txtgname.setText(g_name); 
			this.txtm_message.setText(m_message);

		}

		private georaeVo getViewData() {
			String   u_name     =  this.txtuname.getText(); 
			String   mid_name   =  this.txtwo.getText(); 
			String   gdate      =  this.txtda.getText(); 
			String   g_start    =  (String) this.startcb.getSelectedItem();
			String   g_end      =  (String) this.endcb.getSelectedItem();
			String   wsido      =  this.txtlsido.getText(); 
			String   wgugun     =  this.txtlgugun.getText(); 
			String   g_num      =  this.txtgname.getText(); 
			String   m_message  =  this.txtm_message.getText();

			georaeVo   vo       = new georaeVo(
					u_name, mid_name, gdate, g_start, g_end, wsido, wgugun, g_num, m_message);

			return vo;
		}
		
	
	public static void main(String[] args) {
		new Gearae();

	}
}