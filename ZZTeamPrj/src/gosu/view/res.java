package Team;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.Design;

import model.Dao;
import model.Vo;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class res extends JFrame {
	
	
	private JPanel panel_1, panel_2, panel_3, panel_4, panel_5;
	private JLabel logo,title, lab1, lab2, lab3, lab3_1, lab3_2, lab4, lab4_1, lab4_2, lab5, lab6, lab7, line_1, line_2, line_3, line_4, line_5,line_6, line_7;
	private JComboBox comboBox1, comboBox2, comboBox3, comboBox4;
	private JTextField textField1, textField1_1, textField2, textField3, textField4;
	private JTextArea textArea1;
	private JButton btn1, btn2;
	private JComboBox<String> comboBox5,comboBox6;
	
	//RoundedButton btn2 = new RoundedButton();
	Design comDe = new Design();
	
	LineBorder bb = new LineBorder(new Color(190, 190, 190), 1, true);
	
	UtilDateModel model1, model2;
	JDatePanelImpl datePanel1, datePanel2;
	JDatePickerImpl datePicker1, datePicker2;
	
	public res() {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		//comDesign(JFrame frame, JLabel label, JComboBox combobox, JTextField textf, JButton button){};
		//new LineBorder(Color.black, 1, true); 
		
		//panel_1 로고---------------------------------------------------------
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 21, 1184, 35);
		getContentPane().add(panel_1);
		
		logo = new JLabel();
		
		ImageIcon icon = new ImageIcon("img/logo.png");
		
		Image img = icon.getImage();
		Image ch = img.getScaledInstance(28,23,Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(ch);
		logo.setIcon(changeIcon);
		logo.setHorizontalAlignment(JLabel.CENTER);
		panel_1.add(logo);
		
		//panel_2 제목-------------------------------------------------------
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 56, 1184, 35);
		getContentPane().add(panel_2);
		
		title = new JLabel("고수 업무 등록");
		comDe.getTitleFont(title);
		panel_2.add(title);
		
		//panel_3 -------------------------------------------------------
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 126, 550, 490);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		//대분류
		lab1 = new JLabel("대분류");
		lab1.setBounds(225, 10, 78, 25);
		lab1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_3.add(lab1);
		
		line_1 = new JLabel();
		imgLine(line_1);
		line_1.setBounds(225, 30, 300, 15);
		panel_3.add(line_1);
		
		comboBox1 = new JComboBox(new DefaultComboBoxModel(getDataBigList()));
		comboBox1.setForeground(new Color(128, 128, 128));
		comboBox1.setBackground(new Color(255, 255, 255));
		comboBox1.setBounds(225, 50, 275, 26);
		comboBox1.setToolTipText("");
		panel_3.add(comboBox1);
		
		//중분류
		lab2 = new JLabel("\uC911\uBD84\uB958");
		lab2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lab2.setBounds(225, 99, 78, 25);
		panel_3.add(lab2);
		
		line_2 = new JLabel();
		imgLine(line_2);
		line_2.setHorizontalAlignment(SwingConstants.CENTER);
		line_2.setBounds(225, 119, 300, 15);
		panel_3.add(line_2);
		
		comboBox2 = new JComboBox();
		comboBox2.setForeground(new Color(128, 128, 128));
		comboBox2.setBackground(new Color(255, 255, 255));
		comboBox2.setToolTipText("");
		comboBox2.setBounds(225, 139, 275, 26);
		panel_3.add(comboBox2);
		
		//날짜
		lab3 = new JLabel("\uB0A0\uC9DC");
		lab3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lab3.setBounds(225, 188, 78, 25);
		panel_3.add(lab3);

		line_3 = new JLabel();
		imgLine(line_3);
		line_3.setHorizontalAlignment(SwingConstants.CENTER);
		line_3.setBounds(225, 208, 300, 15);
		panel_3.add(line_3);
		
		lab3_1 = new JLabel("시작일");
		lab3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lab3_1.setBounds(225, 227, 78, 25);
		panel_3.add(lab3_1);
		
		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1);
		datePicker1 = new JDatePickerImpl(datePanel1);
		datePicker1.getJFormattedTextField().setForeground(new Color(255, 255, 255));
		datePicker1.setBounds(310, 229, 190, 26);
		panel_3.add(datePicker1);
		
		lab3_2 = new JLabel("마감일");
		lab3_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lab3_2.setBounds(225, 272, 78, 25);
		panel_3.add(lab3_2);
		
		model2 = new UtilDateModel();
        datePanel2 = new JDatePanelImpl(model2);
        datePicker2 = new JDatePickerImpl(datePanel2);
        datePicker2.getJFormattedTextField().setForeground(new Color(255, 255, 255));
		datePicker2.setBounds(310, 271, 190, 26);
		panel_3.add(datePicker2);
		
		//시간대
		lab4 = new JLabel("\uC2DC\uAC04\uB300");
		lab4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		lab4.setBounds(225, 321, 78, 25);
		panel_3.add(lab4);
		
		line_4 = new JLabel();
		imgLine(line_4);
		line_4.setHorizontalAlignment(SwingConstants.CENTER);
		line_4.setBounds(225, 341, 300, 15);
		panel_3.add(line_4);
		
		lab4_1 = new JLabel("시작시간");
		lab4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lab4_1.setBounds(225, 364, 78, 25);
		panel_3.add(lab4_1);
		
		ArrayList<String> comboTime = new ArrayList<String>();
		Calendar cal = Calendar.getInstance( );
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int ampm = cal.get(Calendar.AM_PM);
		System.out.println(min);
		for (int p = 1; p <= 2; p++) {
			String strAmpm = (1 == p)? "오전" : "오후";
			for (int i = 1; i < 13; i++) {
				hour = i;
				min = 0;
				for (int j = 1; j <= 6; j++) {
					min += 10;
					if(min == 60) {min = 0;}
					String time = strAmpm + hour + "시" + min + "분";
					comboTime.add(time);
				}
			}
		}
		
		comboBox5 = new JComboBox<String>(comboTime.toArray(new String[comboTime.size()]));
		comboBox5.setForeground(new Color(128, 128, 128));
		comboBox5.setBounds(310, 366, 190, 26);
		panel_3.add(comboBox5);
		
		lab4_2 = new JLabel("마감시간");
		lab4_2 .setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lab4_2 .setBounds(225, 407, 78, 25);
		panel_3.add(lab4_2 );
		
		comboBox6 = new JComboBox<>(comboTime.toArray(new String[comboTime.size()]));
		comboBox6.setForeground(new Color(128, 128, 128));
		comboBox6.setBounds(310, 407, 190, 26);
		panel_3.add(comboBox6);
		
		//panel_4 -----------------------------------------------------------------------
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(634, 126, 550, 490);
		getContentPane().add(panel_4);
		panel_4.setLayout(null); 
		
		//가능한 위치
		lab6 = new JLabel("\uAC00\uB2A5\uD55C \uC704\uCE58");
		lab6.setBounds(37, 101, 78, 25);
		lab6.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_4.add(lab6);
		
		line_6 = new JLabel();
		imgLine(line_6);
		line_6.setBounds(37, 121, 300, 15);
		panel_4.add(line_6);
		line_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		comboBox3 = new JComboBox();
		comboBox3.setForeground(new Color(128, 128, 128));
		comboBox3.setBounds(37, 141, 125, 26);
		panel_4.add(comboBox3);
		comboBox3.setToolTipText("\uC2DC");
		comboBox3.setBackground(new Color(255, 255, 255));
		
		comboBox4 = new JComboBox();
		comboBox4.setForeground(new Color(128, 128, 128));
		comboBox4.setBounds(187, 141, 125, 26);
		panel_4.add(comboBox4);
		comboBox4.setToolTipText("");
		comboBox4.setBackground(new Color(255, 255, 255));
		
		//자기 PR
		lab7 = new JLabel("\uC790\uAE30 PR");
		lab7.setBounds(37, 195, 78, 25);
		panel_4.add(lab7);
		lab7.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		
		textArea1 = new JTextArea();
		textArea1.setBounds(37, 230, 347, 204);
		panel_4.add(textArea1);
		//JScrollPane scroll = new JScrollPane(textArea_1);
		//scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textArea1.setBorder(bb);
		
		//금액
		lab5 = new JLabel("\uAE08\uC561");
		lab5.setBounds(37, 10, 78, 25);
		panel_4.add(lab5);
		lab5.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		
		line_5 = new JLabel();
		line_5.setBounds(37, 31, 300, 15);
		panel_4.add(line_5);
		imgLine(line_5);
		line_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField1 = new JTextField("\uC6D0");
		textField1.setBounds(37, 51, 275, 26);
		panel_4.add(textField1);
		textField1.setForeground(new Color(128, 128, 128));
		textField1.setColumns(10);
		
		//panel_5 -------------------------------------------------------------------------
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(0, 615, 1184, 54);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		btn1 = new JButton("등록");
		btn1.setFont(new Font("굴림", Font.PLAIN, 14));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn1.setBackground(new Color(0, 175, 212));
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setBounds(472, 14, 100, 30);
		panel_5.add(btn1);
		
		btn2 = new JButton("취소");
		btn2.setForeground(new Color(130, 130, 130));
		btn2.setBackground(new Color(212, 212, 212));
		btn2.setBounds(615, 14, 100, 30);
		panel_5.add(btn2);
		
//		btn2 = new RoundedButton("취소");
//		btn2.setForeground(new Color(130, 130, 130));
//		btn2.setBackground(new Color(212, 212, 212));
//		btn2.setBounds(615, 14, 100, 30);
//		panel_5.add(btn2);
		
		comboBox1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		           int cb = comboBox1.getSelectedIndex()+1; 
		           Vector<String> list = getDataMidList(cb);
		           comboBox2.setModel(new DefaultComboBoxModel(list));
		      }
		 });
		
		btn1.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("추가버튼 클릭....");				
				addMember();
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("취소버튼 클릭....");	
				cancelMember();
			}
		});
		
		//-----------------------------------------------------------------
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200,800);
		setVisible(true);
	}
	
	//---------------------------------------------------------------------
	private Vector<String> getDataBigList() {
		Dao       dao   =  new Dao();
		Vector<String>  exlist  =  dao.getExList();
		return  exlist;
	}
   
	private Vector<String> getDataMidList() {
	String bigCom =  String.valueOf(comboBox1.getSelectedIndex()+1); 
	Dao       dao   =  new Dao();
	Vector<String>  exlist  =  dao.getExList2( String.valueOf(bigCom));
    return  exlist;
	}
	
	private Vector<String> getDataMidList(int index) {
		String bigCom =  String.valueOf(index+1); 
		System.out.println(bigCom);
		Dao       dao   =  new Dao();
		Vector<String>  exlist  =  dao.getExList2( String.valueOf(index));
	    return  exlist;
	}
	
	//--------------------------------------------------------------------------
	//고수 업무 리스트 primary key 
//	private String getsetGworkPK() {
//		Dao dao = new Dao();
//		String newNum = dao.getGworkPK();
//		String num =  
//		return ;
//	}
	
	//--------------------------------------------------------------------------
	private void addMember() {
		if (textField1 != null) {
			Dao   Dao    =  new Dao();
			Vo    vo      =  getViewData();
			int aftcnt = Dao.insertGWORK( vo );
		}else {
			System.out.println(textField1 + "입력하지 않았습니다");
		}
	}
	
	private void setViewData(Vo vo) {
		String   combo1    =  vo.getBigList();
		String   combo2    =  vo.getMidList();
		String   mod1  	   =  vo.getStaDate();
		String   mod2      =  vo.getEndDate();    
		String   combo5    =  vo.getStaTime();  
		String   combo6    =  vo.getEndTime();
		String 	 textf     =  vo.getPrice();
		String   combo3    =  vo.getWsido1();  
		String   combo4    =  vo.getWsido2();
		String   texta     =  vo.getPrMes();
		
		this.comboBox1.setSelectedItem(combo1);
		this.comboBox2.setSelectedItem(combo2);
//		this.model1.setValue(mod1);
//		this.model1.setValue(mod2);
		this.comboBox5.setSelectedItem(combo5);
		this.comboBox6.setSelectedItem(combo6);
		this.textField1.setText(textf);
		this.comboBox3.setSelectedItem(combo3);
		this.comboBox4.setSelectedItem(combo4);
		this.textArea1.setText(texta);
				
	}
	
	private Vo getViewData() {
		//String wNum = 
		Vo vo;
		String combo1 = (String) this.comboBox1.getSelectedItem();
		String combo2 = (String) this.comboBox2.getSelectedItem();
		String mod1 = model1.getYear() + "-" + (model1.getMonth() + 1) + "-" + model1.getDay();
		String mod2 = model2.getYear() + "-" + (model2.getMonth() + 1) + "-" + model2.getDay();
		String combo5 = (String) this.comboBox5.getSelectedItem();
		String combo6 = (String) this.comboBox6.getSelectedItem();
		String combo3 = (String) this.comboBox3.getSelectedItem();
		String combo4 = (String) this.comboBox4.getSelectedItem();
		String textf    =  this.textField1.getText();
		String texta    =  this.textArea1.getText(); 
		//if (textf != null) { vo = false;}
		vo        =  new Vo(
				combo1, combo2, mod1, mod2, combo5, combo6, textf, combo3, combo4, texta );
		return   vo;
	}

	//------------------------------------------------------------
	private void cancelMember() {
		clearViewData();
	}
	
	private void clearViewData() {
		this.comboBox1.setSelectedIndex(0);
		this.comboBox2.setSelectedIndex(0);
		model1.setSelected(false);
		model2.setSelected(false);
		this.comboBox5.setSelectedIndex(0);
		this.comboBox6.setSelectedIndex(0);
		//this.comboBox3.setSelectedIndex(0);
		//this.comboBox4.setSelectedIndex(0);
		
		this.textField1.setText( "" );
		this.textArea1.setText( "" );
		
		this.textField1.grabFocus(); 
	}

	private void imgLine(JLabel line) {
		ImageIcon icon = new ImageIcon("img/line.png");
        
        Image img = icon.getImage();
        
        Image ch = img.getScaledInstance(300,1,Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(ch);
        
        line.setIcon(changeIcon);
        
        line.setHorizontalAlignment(JLabel.CENTER);
	}

	public static void main(String[] args) {
		new res();
	}
}
