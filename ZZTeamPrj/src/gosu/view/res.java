package gosu.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
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

public class res extends JFrame implements ActionListener {

	Edit edit = null;

	private JPanel panel_1, panel_2, panel_3, panel_4, panel_5;
	private JLabel logo, title, lab1, lab2, lab3, lab3_1, lab3_2, lab4, lab4_1, lab4_2, lab5, lab6, lab7, line_1,
			line_2, line_3, line_4, line_5, line_6, lblNewLabel;
	private JComboBox comboBox1, comboBox2;
	private JTextField textField1;
	private JTextArea textArea1;
	private JButton btn1, btn2;
	private JComboBox<String> comboBox5, comboBox6;
	private ArrayList<String> comboTime ,comboTime2 ;
	JComboBox<String> sidoR, gugunR;

	// RoundedButton btn2 = new RoundedButton();
	Design comDe = new Design();

	LineBorder bb = new LineBorder(new Color(190, 190, 190), 1, true);

	UtilDateModel model1, model2;
	JDatePanelImpl datePanel1, datePanel2;
	JDatePickerImpl datePicker1, datePicker2;

	String dateStr, dateEnd;
	static String uid;

	/**
	 * @wbp.parser.constructor
	 */
	public res(Edit edit, String getDateStr) {
		this(uid);
		JButton btn4 = new JButton("수정");
		btn4.setFont(new Font("굴림", Font.PLAIN, 14));
		btn4.setBackground(new Color(0, 175, 212));
		btn4.setForeground(new Color(255, 255, 255));
		btn4.setBounds(485, 10, 100, 30);
		panel_5.add(btn4);

		btn1.setVisible(false);

		getDataDetail(getDateStr);

		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfo();
				System.out.println("수정클릭");
			}
		});

	}

	public res(String uid) {
		this.uid = uid;
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		// comDesign(JFrame frame, JLabel label, JComboBox combobox, JTextField textf,
		// JButton button){};
		// new LineBorder(Color.black, 1, true);

		// panel_1 로고---------------------------------------------------------
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 21, 1184, 35);
		getContentPane().add(panel_1);

		logo = new JLabel();

		ImageIcon icon = new ImageIcon("img/logo.png");

		Image img = icon.getImage();
		Image ch = img.getScaledInstance(28, 23, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(ch);
		logo.setIcon(changeIcon);
		logo.setHorizontalAlignment(JLabel.CENTER);
		panel_1.add(logo);

		// panel_2 제목-------------------------------------------------------
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 56, 1184, 35);
		getContentPane().add(panel_2);

		title = new JLabel("고수 업무 등록");
		comDe.getTitleFont(title);
		panel_2.add(title);

		// panel_3 -------------------------------------------------------
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 126, 550, 490);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		// 대분류
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

		// 중분류
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

		// 날짜
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
		datePicker1.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		datePicker1.getJFormattedTextField().setForeground(new Color(0, 0, 0));
		datePicker1.setBounds(310, 229, 190, 26);
		panel_3.add(datePicker1);

		lab3_2 = new JLabel("마감일");
		lab3_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lab3_2.setBounds(225, 272, 78, 25);
		panel_3.add(lab3_2);

		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2);
		datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		datePicker2.getJFormattedTextField().setForeground(new Color(0, 0, 0));
		datePicker2.setBounds(310, 271, 190, 26);
		panel_3.add(datePicker2);

		// 시간대
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

		comboTime  = new ArrayList<String>();
		comboTime2 = new ArrayList<String>();
		int hour = 0;
		int min = 0;
		String ampm = null;

		for (int i = 1; i < 25; i++) {
			hour = i + 7;
			min = 0;
			String min2 = "00";
			if (hour > 24) {
				hour = i - 17;
			}
			ampm = hour > 12 ? "오후" : "오전";
			for (int j = 1; j <= 6; j++) {
				if (j >= 2) {
					min += 10;
					min2 = min + "분";
				} else {
					min = 0;
				}
				String time = ampm + hour + "시" + min2;
				comboTime.add(time);
				comboTime2.add(time);
			}
		}
		
		//System.out.println(comboTime.contains("오전8시50분"));
		comboBox5 = new JComboBox<String>(comboTime.toArray(new String[comboTime.size()]));
		comboBox5.setForeground(new Color(128, 128, 128));
		comboBox5.setBounds(310, 366, 190, 26);
		panel_3.add(comboBox5);
		comboBox5.setSelectedIndex(0);
		// comboBox5.setSelectedItem("오전8시50분");

		lab4_2 = new JLabel("마감시간");
		lab4_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		lab4_2.setBounds(225, 407, 78, 25);
		panel_3.add(lab4_2);

		comboBox6 = new JComboBox<String>(comboTime2.toArray(new String[comboTime2.size()]));
		comboBox6.setForeground(new Color(128, 128, 128));
		comboBox6.setBounds(310, 407, 190, 26);
		panel_3.add(comboBox6);
		comboBox6.setSelectedIndex(0);

		// panel_4
		// -----------------------------------------------------------------------
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(634, 126, 550, 490);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);

		// 가능한 위치
		lab6 = new JLabel("\uAC00\uB2A5\uD55C \uC704\uCE58");
		lab6.setBounds(37, 101, 78, 25);
		lab6.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_4.add(lab6);

		line_6 = new JLabel();
		imgLine(line_6);
		line_6.setBounds(37, 121, 300, 15);
		panel_4.add(line_6);
		line_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		sidoR = new JComboBox(new DefaultComboBoxModel(getDataSi()));
		sidoR.setForeground(new Color(128, 128, 128));
		sidoR.setBounds(37, 141, 125, 26);
		panel_4.add(sidoR);
		sidoR.setToolTipText("\uC2DC");
		sidoR.setBackground(new Color(255, 255, 255));


		gugunR = new JComboBox<String>();
		gugunR.setForeground(new Color(128, 128, 128));
		gugunR.setBounds(187, 141, 125, 26);
		panel_4.add(gugunR);
		gugunR.setToolTipText("");
		gugunR.setBackground(new Color(255, 255, 255));

		// 자기 PR
		lab7 = new JLabel("\uC790\uAE30 PR");
		lab7.setBounds(37, 195, 78, 25);
		panel_4.add(lab7);
		lab7.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		textArea1 = new JTextArea();
		textArea1.setBounds(37, 230, 347, 204);
		panel_4.add(textArea1);

		textArea1.setBorder(bb);

		// 금액
		lab5 = new JLabel("\uAE08\uC561");
		lab5.setBounds(37, 10, 78, 25);
		panel_4.add(lab5);
		lab5.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		line_5 = new JLabel();
		line_5.setBounds(37, 31, 300, 15);
		panel_4.add(line_5);
		imgLine(line_5);
		line_5.setHorizontalAlignment(SwingConstants.CENTER);

		textField1 = new JTextField("");
		textField1.setBounds(37, 51, 251, 26);
		panel_4.add(textField1);
		textField1.setForeground(new Color(128, 128, 128));
		textField1.setColumns(10);

		JLabel lab8 = new JLabel("원");
		lab8.setBounds(294, 53, 18, 21);
		panel_4.add(lab8);

		// panel_5
		// -------------------------------------------------------------------------
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
		btn1.setBounds(485, 10, 100, 30);
		panel_5.add(btn1);

		btn2 = new JButton("취소");
		btn2.setForeground(new Color(130, 130, 130));
		btn2.setBackground(new Color(212, 212, 212));
		btn2.setBounds(608, 10, 100, 30);
		panel_5.add(btn2);

		JButton btn3 = new JButton("수정 조회");
		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("굴림", Font.PLAIN, 14));
		btn3.setBackground(new Color(0, 175, 212));
		btn3.setBounds(921, 10, 100, 30);
		panel_5.add(btn3);
		btn3.addActionListener(this);
		
		lblNewLabel = new JLabel("* 필수 항목입니다");
		lblNewLabel.setForeground(new Color(255, 0, 128));
		lblNewLabel.setBounds(540, 679, 169, 35);
		getContentPane().add(lblNewLabel);
		
		
//이벤트-----------------------------------------------------------
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cb = comboBox1.getSelectedIndex() + 1;
				Vector<String> list = getDataMidList(cb);
				comboBox2.setModel(new DefaultComboBoxModel(list));
			}
		});

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("추가버튼 클릭....");
				addMember(uid, lblNewLabel);
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("취소버튼 클릭....");
				cancelMember();
			}
		});
		
		sidoR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cb = (String) sidoR.getSelectedItem();
				
				Vector<String> list = getDataGu(cb);
				gugunR.setModel(new DefaultComboBoxModel(list));
			}
		});

		// -----------------------------------------------------------------
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200, 800);
		setVisible(true);
		
		this.setLocation(700,240);

	}

	// ---------------------------------------------------------------------
	private Vector<String> getDataBigList() {
		Dao dao = new Dao();
		Vector<String> exlist = dao.getExList();
		return exlist;
	}


	private Vector<String> getDataMidList(int index) {
		//String bigCom = String.valueOf(index + 1);
		Dao dao = new Dao();
		Vector<String> exlist = dao.getExList2(String.valueOf(index));
		return exlist;
	}
	
	private Vector<String> getDataSi() {
		Dao dao = new Dao();
		Vector<String> exlist = dao.getExSi();
		return exlist;
	}

	private Vector<String> getDataGu(String si) {
		Dao dao = new Dao();
		Vector<String> exlist = dao.getExGu(String.valueOf(si));
		return exlist;
	}
	
	// --------------------------------------------------------------------------
	private void addMember(String uid ,JLabel lblNewLabel) {
		Dao dao = new Dao();
		Vo vo = getViewData();
		
//		if(vo.getGugun() !=  null) {lblNewLabel.setText("입력해주세요");}
		
		
		
		int aftcnt = 0 ;
		aftcnt = dao.insertGWORK(vo, uid );
		
		if( aftcnt == 1) {
			lblNewLabel.setText("등록되었습니다");
		} else {
			lblNewLabel.setText("등록 되지 않았습니다");	
		}

	}
	
	
	//수정
	private void updateInfo() {
			Dao Dao = new Dao();
			Vo vo = getViewData();
			System.out.println(vo);
			Dao.updateInfo(vo, uid);
	}

	private void setViewData(Vo vo) {
		String combo1 = vo.getBigList();
		String combo2 = vo.getMidList();
		String mod1 = vo.getStaDate();
		String mod2 = vo.getEndDate();
		String combo5 = vo.getStaTime();
		String combo6 = vo.getEndTime();
		String textf = vo.getPrice();
		String combo3 = vo.getSido();
		String combo4 = vo.getGugun();
		String texta = vo.getPrMes();

		this.comboBox1.setSelectedItem(combo1);
		this.comboBox2.setSelectedItem(combo2);
//		this.model1.setValue(mod1);
//		this.model1.setValue(mod2);
		this.comboBox5.setSelectedItem(combo5);
		this.comboBox6.setSelectedItem(combo6);
		this.textField1.setText(textf);
		this.sidoR.setSelectedItem(combo3);
		this.gugunR.setSelectedItem(combo4);
		this.textArea1.setText(texta);
	}

	private Vo getViewData() {
		// String wNum = 
		Vo vo;
		String combo1 = (String) this.comboBox1.getSelectedItem();
		String combo2 = (String) this.comboBox2.getSelectedItem();
		String mod1 = model1.getYear() + "-" + (model1.getMonth() + 1) + "-" + model1.getDay();
		String mod2 = model2.getYear() + "-" + (model2.getMonth() + 1) + "-" + model2.getDay();
		String combo5 = (String) this.comboBox5.getSelectedItem();
		String combo6 = (String) this.comboBox6.getSelectedItem();
		String combo3 = (String) this.sidoR.getSelectedItem();
		String combo4 = (String) this.gugunR.getSelectedItem();
		String textf = this.textField1.getText();
		String texta = this.textArea1.getText();
		String uid = this.uid;
		System.out.println(uid + "dddddddddfd");

		dateStr = combo5;
		dateStr = mod1 + " " + dateStr.replace("오전", " ").replace("오후", " ").replace("시", ":").replace("분", " ").trim();

		dateEnd = combo6;
		dateEnd = mod2 + " " + dateEnd.replace("오전", " ").replace("오후", " ").replace("시", ":").replace("분", " ").trim();
		System.out.println(dateEnd + "dfd");
		vo = new Vo(uid, combo1, combo2, mod1, mod2, combo5, combo6, textf, combo3, combo4, texta, dateStr, dateEnd );
		return vo;
	}

	// 수정조회 및 상세보기-------------------------------------------
	private void getDataDetail(String getDateStr) {
		System.out.println(getDateStr);
		Dao dao = new Dao();
		Vector<String> list = dao.getDataDetail(uid, getDateStr);
		
		String stDateAll = list.get(2);
		String edDateAll = list.get(3);
		
		String stDate = stDateAll.substring(0, 10);   // 시작날짜 model 값 - 완전체 
		String stTime = stDateAll.substring(11, 19);  // stTime 값 - 미완전체
		
		String edDate = edDateAll.substring(0, 10);   // 마감날짜 model 값 - 완전체
		String edTime = edDateAll.substring(11, 19);  // edTime 값 - 미완전체
		
		stTime = getDateDetailFunction(stTime, comboBox5 );
		edTime = getDateDetailFunction(edTime, comboBox6 );
		
		getDate(stDate, model1 );
		getDate(edDate, model2 );
		
		//------------
		String combo1 = list.get(0);
		System.out.println("함수 확인"+ combo1);
		String combo2 = list.get(1);
		System.out.println("함수 확인"+ combo2);

		String textf = list.get(4);
		String sido = list.get(5);
		String gugum = list.get(6);
		String texta = list.get(7);

		this.comboBox1.setSelectedItem(combo1);
		this.comboBox2.setSelectedItem(combo2);
		this.sidoR.setSelectedItem(sido);
		this.gugunR.setSelectedItem(gugum);
		this.textField1.setText(textf);
		this.textArea1.setText(texta);
	}

	private void getDate(String inputDate, UtilDateModel inputModel ) {
		String[] date = inputDate.split("-");
		int dateY = Integer.parseInt(date[0]);
		int dateM = Integer.parseInt(date[1]) - 1;
		int dateD = Integer.parseInt(date[2]);
		inputModel.setDate(dateY, dateM, dateD);
		inputModel.setSelected(true);
	}

	// 수정 및 상세보기 날짜 출력 기능
	private String getDateDetailFunction(String DateInput, JComboBox<String> combobox) {
		DateInput = DateInput.substring(0, 2) + "시" + DateInput.substring(3, 5) + "분";
		String text1 = DateInput.substring(0, 2);
		String text2 = DateInput.substring(3, 5);
		int dateindex = Integer.parseInt(DateInput.substring(0, 2));

		if (dateindex < 13) {
			String conString = "오전";
			if(text1.indexOf("0") == 0) {text1 = text1.replace("0", "");}
			DateInput = conString + text1 + "시" + text2 + "분";
			if(text2.indexOf("00") == 00) {DateInput = conString + text1 + "시" + text2;}
		} else {
			String conString = "오후";
			
			if(text1.indexOf("0") == 0) {text1.replace("0", "");}
			DateInput = conString + text1 + "시" + text2 + "분";
			if(text2.indexOf("00") == 00) {DateInput = conString + text1 + "시" + text2;}
		}
		
		if (comboTime.contains(DateInput)) {
			combobox.setSelectedItem(DateInput.trim());		
		}
		
		String DateAll = DateInput;
		return DateAll;
	}
	
	// ------------------------------------------------------------
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
		// this.sidoR.setSelectedIndex(0);
		// this.gugunR.setSelectedIndex(0);

		this.textField1.setText("");
		this.textArea1.setText("");

		this.textField1.grabFocus();
	}

	private void imgLine(JLabel line) {
		ImageIcon icon = new ImageIcon("img/line.png");

		Image img = icon.getImage();

		Image ch = img.getScaledInstance(300, 1, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(ch);

		line.setIcon(changeIcon);

		line.setHorizontalAlignment(JLabel.CENTER);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "수정 조회":
			System.out.println("수정 조회");
			if (edit != null)
				edit.dispose();
			edit = new Edit(this, uid);
			break;
		}
	}
}
