package gosu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gosu.data.Vo;
import gosu.data.georaeVo;
import gosu.data.georaeVo2;
import gosu.data.gosuDao;


public class Gearae extends JFrame {	
	
	ResDetail rd;
	loginPage lg;
	MainView mainview;
	String uid;
	String sel;
	
	JPanel Pane;
	JLabel lblusername, lblgosuname, lblwork, lbldate, lblstarttime, lblendtime, lblprice, lbllocation, lblmessage;
	
	JButton btnsend, btncancel, btnmess;
	JTextField  txtm_message, txtuid, txtwo, txtda, txtlsido, txtlgugun, txtme, txtgname, txtstart, txtend;
	JComboBox  startcb, endcb;
	
	BorderLayout gb;
	JLabel lbltitle, lbluserid;
	Gearae georae;
	
	public Gearae() {	
		init();
			
	}


	public Gearae(String sel, String uid, ResDetail rd) {
		init();
		
		this.rd  =  rd;
		this.sel = sel;
		this.uid = uid;
		System.out.println("거래:"+ uid);
		
		txtuid.setText(rd.uid);
		
		txtwo.setText(rd.comboBoxG2.getSelectedItem().toString());
		txtda.setText(rd.model1.getYear()+ "-" + (rd.model1.getMonth() + 1) + "-" + rd.model1.getDay() +
		             " ~ " + rd.model2.getYear()+ "-" + (rd.model2.getMonth() + 1) + "-" + rd.model2.getDay());
		txtgname.setText(rd.labG5_3.getText().toString());
		txtstart.setText(rd.comboBoxG5.getSelectedItem().toString());
		txtend.setText(rd.comboBoxG6.getSelectedItem().toString());
		txtlsido.setText(rd.sidoCB.getSelectedItem().toString());
		txtlgugun.setText(rd.gugunCB.getSelectedItem().toString());
	}




	private void init () {
		
		setBackground(Color.WHITE);
		
		getContentPane().setLayout(new BorderLayout());
	    Pane  = new JPanel();
	    Pane.setBackground(new Color(135, 206, 250));
	    //Pane.setBackground(SystemColor.inactiveCaptionBorder);
	    
		setContentPane(Pane);
		Pane.setLayout(null);

		// 제목
		lbltitle = new JLabel("거래요청서");
		lbltitle.setBounds(325, 10, 200, 34);
		//lbltitle.setForeground(SystemColor.textHighlight);
		lbltitle.setForeground(Color.WHITE);
		lbltitle.setFont(new Font("D2Coding", Font.PLAIN, 35));
		Pane.add(lbltitle);
		
	    // 거래요청자 이름
	      lblusername = new JLabel("거래요청자 ID");
	      lblusername.setBounds(30, 90, 200, 20);
	      lblusername.setForeground(SystemColor.textHighlight);
	      lblusername.setBackground(SystemColor.text);
	      lblusername.setFont(new Font("D2Coding", Font.PLAIN, 20));
	      Pane.add(lblusername);
	      txtuid = new JTextField("회원 ID 불러오기");
	      txtuid.setBounds(200, 85, 200, 30);
	      txtuid.setColumns(10);
	      txtuid.setEditable(false);
	      txtuid.setFont(new Font("D2Coding", Font.PLAIN, 17));
	      Pane.add(txtuid);
	      
		
		// 업무내용(중분류)
		lblwork = new JLabel("업무 내용");
		lblwork.setBounds(30, 150, 200, 20);
		lblwork.setForeground(SystemColor.textHighlight);
		lblwork.setBackground(SystemColor.text);
		lblwork.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblwork);
		txtwo = new JTextField("업무 내용 불러오기");
		txtwo.setBounds(200, 145, 200, 30);
		txtwo.setEditable(false);
		txtwo.setFont(new Font("D2Coding", Font.PLAIN, 17));
		Pane.add(txtwo);
		txtda = new JTextField("업무날짜불러오기");
		txtda.setBounds(200, 205, 200, 30);
		txtda.setEditable(false);
		txtda.setFont(new Font("D2Coding", Font.PLAIN, 17));
		Pane.add(txtda);
		
		
		
		
		/*String [] starttime = { "선택","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
		startcb = new JComboBox();
		startcb.setFont(new Font("D2Coding", Font.PLAIN, 15));
	    startcb.setBackground(SystemColor.text);
		startcb.setBounds(120, 265, 80, 30);
		Pane.add(startcb);*/
		/*String [] endtime = { "선택", "7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
		endcb = new JComboBox(endtime);		
		
		endcb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {					
				if (Integer.parseInt((String) endcb.getSelectedItem())
				    <= Integer.parseInt((String) startcb.getSelectedItem())) {
					JOptionPane.showMessageDialog(null, 
							"올바른 시간을 선택해주세요", 
							"시간 선택하기", JOptionPane.WARNING_MESSAGE);
					return;
				
				}
			}
		});			
		endcb.setFont(new Font("D2Coding", Font.PLAIN, 15));	
		endcb.setBackground(SystemColor.text);
		endcb.setBounds(320, 265, 80, 30);
		Pane.add(endcb);*/
			
		// 고수이름
		lblgosuname = new JLabel("고수 ID");
		lblgosuname.setBounds(450, 90, 200, 20);
		lblgosuname.setForeground(SystemColor.textHighlight);
		lblgosuname.setBackground(SystemColor.text);
		lblgosuname.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblgosuname);
		txtgname = new JTextField("고수 ID 불러오기");
		txtgname.setBounds(560, 85, 200, 30);
		txtgname.setEditable(false);
		txtgname.setFont(new Font("D2Coding", Font.PLAIN, 17));
		Pane.add(txtgname);
				
		// 추가 메시지
		lblmessage = new JLabel("거래요청 메시지");
		lblmessage.setBounds(450, 150, 200, 20);
		lblmessage.setForeground(SystemColor.textHighlight);
		lblmessage.setBackground(SystemColor.text);
		lblmessage.setFont(new Font("D2Coding", Font.PLAIN, 20));
		Pane.add(lblmessage);
		txtm_message = new JTextField();
		txtm_message.setBounds(450, 180, 310, 175);
		txtm_message.setFont(new Font("D2Coding", Font.PLAIN, 17));
		Pane.add(txtm_message);

		
		// 버튼
		btnsend              = new JButton("거래요청");
		btnsend.setBounds(249, 446, 100, 40);
		btnsend.setForeground(new Color(30, 144, 255));
		btnsend.setBackground(new Color(240, 248, 255));
		btnsend.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btnsend.setBackground(new Color(255, 255, 255));
		
		btncancel            = new JButton("취소");
		btncancel.setBounds(450, 446, 100, 40);
		btncancel.setForeground(SystemColor.textHighlight);
		btncancel.setBackground(SystemColor.text);
		btncancel.setFont(new Font("D2Coding", Font.PLAIN, 15));
		btncancel.setBackground(new Color(255, 255, 255));

		
		// btnsend(거래요청) 버튼에 기능 추가
		btnsend.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("거래요청 클릭");
				
				/*if (startcb.getSelectedItem() == "선택" || endcb.getSelectedItem() == "선택") {
					JOptionPane.showMessageDialog(null, "시간을 선택해주세요", "시간 선택하기", JOptionPane.WARNING_MESSAGE);
					return;
				}*/
		
				addgeorae(sel);
			    new message();
			}
	
		
     	});
		
		// btncancel(취소) 버튼에 기능 추가
		btncancel.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("취소 클릭");				
				dispose();
				
			}	
     	});						
		
		Pane.add( btnsend );
		Pane.add( btncancel );
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 55, 760, 381);
	    panel.setBackground(SystemColor.inactiveCaptionBorder);
		Pane.add(panel);
		
			panel.setLayout(null);
			txtlsido = new JTextField("시도");
			txtlsido.setBounds(188, 316, 90, 27);
			panel.add(txtlsido);
			txtlsido.setEditable(false);
			txtlsido.setFont(new Font("D2Coding", Font.PLAIN, 17));
			
			
	
			// 업무가능 종료시간
			lblendtime = new JLabel("종료시간");
			lblendtime.setBounds(22, 264, 80, 24);
			panel.add(lblendtime);
			lblendtime.setForeground(SystemColor.textHighlight);
			lblendtime.setBackground(SystemColor.text);
			lblendtime.setFont(new Font("D2Coding", Font.PLAIN, 20));
		
			
			// 업무 가능 위치
			lbllocation = new JLabel("위치");
			lbllocation.setBounds(25, 317, 40, 24);
			panel.add(lbllocation);
			lbllocation.setForeground(SystemColor.textHighlight);
			lbllocation.setBackground(SystemColor.text);
			lbllocation.setFont(new Font("D2Coding", Font.PLAIN, 20));
			txtlgugun = new JTextField("구군");
			txtlgugun.setBounds(299, 315, 90, 30);
			panel.add(txtlgugun);
			txtlgugun.setEditable(false);
			txtlgugun.setFont(new Font("D2Coding", Font.PLAIN, 17));
			txtstart = new JTextField();
			txtstart.setBounds(189, 208, 200, 30);
			panel.add(txtstart);
			txtstart.setFont(new Font("D2Coding", Font.PLAIN, 15));
			txtstart.setBackground(SystemColor.text);
			txtstart.setEditable(false);
			txtend = new JTextField();
			txtend.setBounds(189, 262, 200, 30);
			panel.add(txtend);
			txtend.setFont(new Font("D2Coding", Font.PLAIN, 15));
			txtend.setBackground(SystemColor.text);
			txtend.setEditable(false);
			
			
			// 업무가능 시작시간 
			lblstarttime = new JLabel("시작시간");
			lblstarttime.setBounds(22, 212, 80, 20);
			panel.add(lblstarttime);
			lblstarttime.setForeground(SystemColor.textHighlight);
			lblstarttime.setBackground(SystemColor.text);
			lblstarttime.setFont(new Font("D2Coding", Font.PLAIN, 20));
			

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("거래요청서");
		//setUndecorated(true);
		setVisible(true);
		setSize(800,546);
		setLocation(600, 200);			

	   }

   
	


		protected void addgeorae(String sel) {
			gosuDao  gDao      =  new gosuDao();
			georaeVo2    vo    =  getViewData();	
		   
			int       aftcnt   =  gDao.addgeorae( vo );					
		}
			

		private void setViewData(georaeVo2 vo) {
			String   uid       =  vo.getUid(); 
			
			String   mid_name  =  vo.getMid_name(); 
			String   gdate     =  vo.getGdate(); 
			String   g_start   =  vo.getG_start();
			String   g_end     =  vo.getG_end();
			String   wsido     =  vo.getWsido(); 
			String   wgugun    =  vo.getWgugun();
			
			String   g_num     =  vo.getG_num(); 
			
			String   m_message =  vo.getM_message();
			
			this.txtuid.setText(uid); 
			this.txtwo.setText(mid_name); 
			this.txtda.setText(gdate); 
			this.txtstart.setText(g_start);
			this.txtend.setText(g_end);
			this.txtlsido.setText(wsido); 
			this.txtlgugun.setText(wgugun); 
			this.txtgname.setText(g_num); 
			this.txtm_message.setText(m_message);

		}

		private georaeVo2 getViewData() {
			String   uid        =  this.txtuid.getText(); 
			
			String   mid_name   =  this.txtwo.getText(); 
			String   gdate      =  this.txtda.getText(); 
			String   g_start    =  this.txtstart.getText();;
			String   g_end      =  this.txtend.getText();
			String   wsido      =  this.txtlsido.getText(); 
			String   wgugun     =  this.txtlgugun.getText();
			
			String   g_num      =  this.txtgname.getText(); 
			String   m_message  =  this.txtm_message.getText();
			String   w_num      =  this.sel;
			
			georaeVo2   vo       = new georaeVo2(
					uid, mid_name, gdate, g_start, g_end, wsido, wgugun, g_num, m_message, w_num);

			return vo;
		}

		
	public static void main(String[] args) {
		new Gearae();
		
	}



}