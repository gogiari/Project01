package project.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import project.oracle.newMember;


public class addClient extends JFrame implements ActionListener{
	Font fnt = new Font("굴림체",Font.BOLD,14);
	Font titleFnt = new Font("굴림체",Font.BOLD,32);
	JLabel titleLbl = new JLabel("예 약 등 록");
	JLabel idLbl = new JLabel("전화번호");
	JTextField idField = new JTextField(30);
	JButton search = new JButton("조회");
	
	JLabel phoneLbl = new JLabel("이름");
	JTextField phoneField = new JTextField(30);
	
	JLabel petLbl = new JLabel("PET");
	JTextField petField = new JTextField(30);
	
	JLabel memoLbl = new JLabel("메모");
	JTextField memoField = new JTextField(30);
	
	JLabel emailLbl = new JLabel("이메일");
	JTextField emailField = new JTextField(30);
	
	JLabel date = new JLabel("예약일자");
	JButton datebtn = new JButton("일자 확인");
	
	
	JLabel timeLbl = new JLabel("예약시간");
	String time[] = {"09:00","10:00","11:00","12:00","13:00","14:00","15:00",
			 "16:00","17:00","18:00","19:00","20:00","21:00","22:00"};
	DefaultComboBoxModel<String> time1 = new DefaultComboBoxModel<String>(time);
	JComboBox<String> timeCombo = new JComboBox<String>(time1);
	
	JLabel optionLbl = new JLabel("예약내용");
	String option[] = {"미용","발톱정리","귀청소","목욕","각질케어"};
	DefaultComboBoxModel<String> option1 = new DefaultComboBoxModel<String>(option);
	JComboBox<String> optionCombo = new JComboBox<String>(option1);	
	
	JLabel rbtLbl = new JLabel("픽업여부");
	JRadioButton rbtY = new JRadioButton("Y");
	JRadioButton rbtN = new JRadioButton("N");
	ButtonGroup group = new ButtonGroup();
	JPanel rbyYN = new JPanel();
	
	JButton signUpBtn = new JButton("예약등록");
	JButton cancelBtn = new JButton("취소");
	
	
	
	public addClient() {
		setLayout(null);
		int x=300;
		int x1=410;
		add(titleLbl).setBounds(450,100,200,30);
		titleLbl.setFont(titleFnt);
		
		add(idLbl).setBounds(x,200,100,30); add(idField).setBounds(x1,200,250,30);
		idLbl.setFont(fnt);
		idField.setFont(fnt);
		add(search).setBounds(700, 200, 70, 30);
		search.setFont(fnt);
		search.setBackground(new Color(0,130,255));
		search.setForeground(Color.white);
	
		add(phoneLbl).setBounds(x,250,100,30); add(phoneField).setBounds(x1,250,250,30);
		phoneLbl.setFont(fnt);
		phoneField.setFont(fnt);
		
		add(petLbl).setBounds(x,300,100,30); add(petField).setBounds(x1,300,250,30);
		petLbl.setFont(fnt);
		petField.setFont(fnt);
		
		add(memoLbl).setBounds(x,350,100,30); add(memoField).setBounds(x1,350,250,30);
		memoLbl.setFont(fnt);
		memoField.setFont(fnt);
		
		add(emailLbl).setBounds(x,400,100,30); add(emailField).setBounds(x1,400,250,30);
		emailLbl.setFont(fnt);
		emailField.setFont(fnt);
		
		add(timeLbl).setBounds(x,450,100,30); add(timeCombo).setBounds(x1,450,250,30);
		timeLbl.setFont(fnt);
		timeCombo.setFont(fnt);
		timeCombo.setBackground(Color.white);
		
		add(optionLbl).setBounds(x,500,100,30); add(optionCombo).setBounds(x1,500,250,30);
		optionLbl.setFont(fnt);
		optionCombo.setFont(fnt);
		optionCombo.setBackground(Color.white);
		
		add(rbtLbl).setBounds(x,550,100,30);
		group.add(rbtN);group.add(rbtY);rbyYN.add(rbtY);rbyYN.add(rbtN);
		rbtN.setFont(fnt);
		rbtY.setFont(fnt);
		add(rbyYN).setBounds(x1,550,250,30);
		
		
		
		add(signUpBtn).setBounds(400,600,100,30); add(cancelBtn).setBounds(530,600,100,30);
		signUpBtn.setFont(fnt);
		signUpBtn.setBackground(new Color(0,130,255));
		signUpBtn.setForeground(Color.white);
		signUpBtn.setEnabled(false);
		cancelBtn.setFont(fnt);
		cancelBtn.setBackground(new Color(0,130,255));
		cancelBtn.setForeground(Color.white);
		
		getContentPane().setBackground(Color.white);
		setSize(1000,800);
		setVisible(true);
		
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new newMember();
				
			}
		});
		signUpBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}



	public addClient(client client) {
		this();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		//예약등록
		
		
	}
	





}
