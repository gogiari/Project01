package gosu.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
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

public class ResDetail extends JFrame {
	private JPanel panel_G1, panel_G2, panel_G3, panel_G4, panel_G5;
	private JLabel logo, title, labG5_0,labG5_1, labG5_2, labG5_3, labG5_4, labG5_5, labG1, labG2, labG3, labG3_1, labG3_2, labG4, labG4_1, labG4_2, labG5, labG6, labG7, line_1,
			line_2, line_3, line_4, line_5, line_6, line_7;
	private JComboBox comboBoxG1, comboBoxG2;
	private JTextField textFieldG1;
	private JTextArea textArea1;
	private JButton btnG1, btnG2;
	private JComboBox<String> comboBoxG5, comboBoxG6;
	private ArrayList<String> comboTime ,comboTimeG2 ;
	JComboBox<String> sidoCB, gugunCB;

	// RoundedButton btnG2 = new RoundedButton();
	Design comDe = new Design();

	LineBorder bb = new LineBorder(new Color(190, 190, 190), 1, true);

	UtilDateModel model1, model2;
	JDatePanelImpl datePanel1, datePanel2;
	JDatePickerImpl datePicker1, datePicker2;

	String dateStr, dateEnd;

	public ResDetail() {
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		// comDesign(JFrame frame, JLabel label, JComboBox combobox, JTextField textf,
		// JButton button){};
		// new LineBorder(Color.black, 1, true);

		// panel_G1 로고---------------------------------------------------------
		panel_G1 = new JPanel();
		panel_G1.setBackground(Color.WHITE);
		panel_G1.setBounds(0, 21, 1184, 35);
		getContentPane().add(panel_G1);

		logo = new JLabel();

		ImageIcon icon = new ImageIcon("img/logo.png");

		Image img = icon.getImage();
		Image ch = img.getScaledInstance(28, 23, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(ch);
		logo.setIcon(changeIcon);
		logo.setHorizontalAlignment(JLabel.CENTER);
		panel_G1.add(logo);
		
		//---------------------------------------------------------------------
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 101, 1184, 48);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		labG5_0 = new JLabel("이름");
		labG5_0.setBounds(220, 10, 28, 20);
		labG5_0.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel.add(labG5_0);
		
		labG5_1 = new JLabel("이름 값");
		labG5_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		labG5_1.setBounds(260, 10, 63, 20);
		panel.add(labG5_1);
		
		labG5_2 = new JLabel("ID");
		labG5_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		labG5_2.setBounds(335, 10, 28, 20);
		panel.add(labG5_2);
		
		labG5_3 = new JLabel("id값");
		labG5_3.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		labG5_3.setBounds(361, 10, 37, 20);
		panel.add(labG5_3);
		
		labG5_4 = new JLabel("평점");
		labG5_4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		labG5_4.setBounds(878, 10, 37, 20);
		panel.add(labG5_4);
		
		labG5_5 = new JLabel("평균값");
		labG5_5.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		labG5_5.setBounds(920, 10, 37, 20);
		panel.add(labG5_5);
		
		JLabel line_1_1 = new JLabel();
		line_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		line_1_1.setBounds(193, 33, 780, 15);
		panel.add(line_1_1);

		// panel_G2 제목-------------------------------------------------------
		panel_G2 = new JPanel();
		panel_G2.setBackground(new Color(255, 255, 255));
		panel_G2.setBounds(0, 56, 1184, 35);
		getContentPane().add(panel_G2);

		title = new JLabel("\uACE0\uC218 \uC5C5\uBB34 \uC0C1\uC138\uBCF4\uAE30");
		comDe.getTitleFont(title);
		panel_G2.add(title);

		// panel_G3 -------------------------------------------------------
		panel_G3 = new JPanel();
		panel_G3.setBackground(new Color(255, 255, 255));
		panel_G3.setBounds(0, 159, 550, 447);
		getContentPane().add(panel_G3);
		panel_G3.setLayout(null);

		// 대분류
		labG1 = new JLabel("대분류");
		labG1.setBounds(225, 10, 78, 25);
		labG1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_G3.add(labG1);

		line_1 = new JLabel();
		imgLine(line_1);
		line_1.setBounds(225, 30, 300, 15);
		panel_G3.add(line_1);

		comboBoxG1 = new JComboBox(new DefaultComboBoxModel(getDataBigList()));
		comboBoxG1.setForeground(new Color(128, 128, 128));
		comboBoxG1.setBackground(new Color(255, 255, 255));
		comboBoxG1.setBounds(225, 50, 275, 26);
		comboBoxG1.setToolTipText("");
		panel_G3.add(comboBoxG1);

		// 중분류
		labG2 = new JLabel("\uC911\uBD84\uB958");
		labG2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		labG2.setBounds(225, 99, 78, 25);
		panel_G3.add(labG2);

		line_2 = new JLabel();
		imgLine(line_2);
		line_2.setHorizontalAlignment(SwingConstants.CENTER);
		line_2.setBounds(225, 119, 300, 15);
		panel_G3.add(line_2);

		comboBoxG2 = new JComboBox();
		comboBoxG2.setForeground(new Color(128, 128, 128));
		comboBoxG2.setBackground(new Color(255, 255, 255));
		comboBoxG2.setToolTipText("");
		comboBoxG2.setBounds(225, 139, 275, 26);
		panel_G3.add(comboBoxG2);

		// 날짜
		labG3 = new JLabel("\uB0A0\uC9DC");
		labG3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		labG3.setBounds(225, 188, 78, 25);
		panel_G3.add(labG3);

		line_3 = new JLabel();
		imgLine(line_3);
		line_3.setHorizontalAlignment(SwingConstants.CENTER);
		line_3.setBounds(225, 208, 300, 15);
		panel_G3.add(line_3);

		labG3_1 = new JLabel("시작일");
		labG3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		labG3_1.setBounds(225, 227, 78, 25);
		panel_G3.add(labG3_1);

		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1);
		datePicker1 = new JDatePickerImpl(datePanel1);
		datePicker1.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		datePicker1.getJFormattedTextField().setForeground(new Color(0, 0, 0));
		datePicker1.setBounds(310, 229, 190, 26);
		panel_G3.add(datePicker1);

		labG3_2 = new JLabel("마감일");
		labG3_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		labG3_2.setBounds(225, 272, 78, 25);
		panel_G3.add(labG3_2);

		model2 = new UtilDateModel();
		datePanel2 = new JDatePanelImpl(model2);
		datePicker2 = new JDatePickerImpl(datePanel2);
		datePicker2.getJFormattedTextField().setBackground(new Color(255, 255, 255));
		datePicker2.getJFormattedTextField().setForeground(new Color(0, 0, 0));
		datePicker2.setBounds(310, 271, 190, 26);
		panel_G3.add(datePicker2);

		// 시간대
		labG4 = new JLabel("\uC2DC\uAC04\uB300");
		labG4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		labG4.setBounds(225, 321, 78, 25);
		panel_G3.add(labG4);

		line_4 = new JLabel();
		imgLine(line_4);
		line_4.setHorizontalAlignment(SwingConstants.CENTER);
		line_4.setBounds(225, 341, 300, 15);
		panel_G3.add(line_4);

		labG4_1 = new JLabel("시작시간");
		labG4_1.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		labG4_1.setBounds(225, 364, 78, 25);
		panel_G3.add(labG4_1);

		comboTime  = new ArrayList<String>();
		comboTimeG2 = new ArrayList<String>();
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
				comboTimeG2.add(time);
			}
		}
		
		//System.out.println(comboTime.contains("오전8시50분"));
		comboBoxG5 = new JComboBox<String>(comboTime.toArray(new String[comboTime.size()]));
		comboBoxG5.setForeground(new Color(128, 128, 128));
		comboBoxG5.setBounds(310, 366, 190, 26);
		panel_G3.add(comboBoxG5);
		comboBoxG5.setSelectedIndex(0);
		// comboBoxG5.setSelectedItem("오전8시50분");

		labG4_2 = new JLabel("마감시간");
		labG4_2.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		labG4_2.setBounds(225, 407, 78, 25);
		panel_G3.add(labG4_2);

		comboBoxG6 = new JComboBox<>(comboTimeG2.toArray(new String[comboTimeG2.size()]));
		comboBoxG6.setForeground(new Color(128, 128, 128));
		comboBoxG6.setBounds(310, 407, 190, 26);
		panel_G3.add(comboBoxG6);
		comboBoxG6.setSelectedIndex(0);

		// panel_G4
		// -----------------------------------------------------------------------
		panel_G4 = new JPanel();
		panel_G4.setBackground(new Color(255, 255, 255));
		panel_G4.setBounds(634, 159, 550, 447);
		getContentPane().add(panel_G4);
		panel_G4.setLayout(null);

		// 가능한 위치
		labG6 = new JLabel("\uAC00\uB2A5\uD55C \uC704\uCE58");
		labG6.setBounds(37, 101, 78, 25);
		labG6.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel_G4.add(labG6);

		line_6 = new JLabel();
		imgLine(line_6);
		line_6.setBounds(37, 121, 300, 15);
		panel_G4.add(line_6);
		line_6.setHorizontalAlignment(SwingConstants.CENTER);

		sidoCB = new JComboBox<String>();
		sidoCB.setForeground(new Color(128, 128, 128));
		sidoCB.setBounds(37, 141, 125, 26);
		panel_G4.add(sidoCB);
		sidoCB.setToolTipText("\uC2DC");
		sidoCB.setBackground(new Color(255, 255, 255));
		sidoCB.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String sido = (String) sidoCB.getSelectedItem();
					gugunCB.setModel(new GugunComboBoxModel(sido));
				}
			}
		});

		gugunCB = new JComboBox<String>();
		gugunCB.setForeground(new Color(128, 128, 128));
		gugunCB.setBounds(187, 141, 125, 26);
		panel_G4.add(gugunCB);
		gugunCB.setToolTipText("");
		gugunCB.setBackground(new Color(255, 255, 255));

		// 자기 PR
		labG7 = new JLabel("\uC790\uAE30 PR");
		labG7.setBounds(37, 195, 78, 25);
		panel_G4.add(labG7);
		labG7.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		textArea1 = new JTextArea();
		textArea1.setBounds(37, 230, 347, 204);
		panel_G4.add(textArea1);
		// JScrollPane scroll = new JScrollPane(textArea_1);
		// scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		textArea1.setBorder(bb);

		// 금액
		labG5 = new JLabel("\uAE08\uC561");
		labG5.setBounds(37, 10, 78, 25);
		panel_G4.add(labG5);
		labG5.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		line_5 = new JLabel();
		line_5.setBounds(37, 31, 300, 15);
		panel_G4.add(line_5);
		imgLine(line_5);
		line_5.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldG1 = new JTextField("");
		textFieldG1.setBounds(37, 51, 251, 26);
		panel_G4.add(textFieldG1);
		textFieldG1.setForeground(new Color(128, 128, 128));
		textFieldG1.setColumns(10);

		JLabel lab8 = new JLabel("원");
		lab8.setBounds(294, 53, 18, 21);
		panel_G4.add(lab8);

		// panel_G5
		// -------------------------------------------------------------------------
		panel_G5 = new JPanel();
		panel_G5.setBackground(new Color(255, 255, 255));
		panel_G5.setBounds(0, 648, 1184, 54);
		getContentPane().add(panel_G5);
		panel_G5.setLayout(null);

		btnG1 = new JButton("\uAC70\uB798\uC694\uCCAD \uBC0F Message");
		btnG1.setFont(new Font("굴림", Font.PLAIN, 14));
		btnG1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnG1.setBackground(new Color(0, 175, 212));
		btnG1.setForeground(new Color(255, 255, 255));
		btnG1.setBounds(424, 10, 187, 30);
		panel_G5.add(btnG1);

		btnG2 = new JButton("취소");
		btnG2.setForeground(new Color(130, 130, 130));
		btnG2.setBackground(new Color(212, 212, 212));
		btnG2.setBounds(634, 10, 100, 30);
		panel_G5.add(btnG2);

//삭제
//		JButton btn3 = new JButton("수정 조회");
//		btn3.setForeground(Color.WHITE);
//		btn3.setFont(new Font("굴림", Font.PLAIN, 14));
//		btn3.setBackground(new Color(0, 175, 212));
//		btn3.setBounds(1061, 10, 100, 30);
//		panel_G5.add(btn3);
		

		comboBoxG1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cb = comboBoxG1.getSelectedIndex() + 1;
				Vector<String> list = getDataMidList(cb);
				comboBoxG2.setModel(new DefaultComboBoxModel(list));
			}
		});

		btnG1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("거래메세지");
				//addMember();
			}
		});

		btnG2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("취소버튼 클릭....");
				cancelMember();
			}
		});

		// -----------------------------------------------------------------
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1200, 800);
		setVisible(true);
	}

	// ---------------------------------------------------------------------
	private Vector<String> getDataBigList() {
		Dao dao = new Dao();
		Vector<String> exlist = dao.getExList();
		return exlist;
	}

	private Vector<String> getDataMidList() {
		String bigCom = String.valueOf(comboBoxG1.getSelectedIndex() + 1);
		Dao dao = new Dao();
		Vector<String> exlist = dao.getExList2(String.valueOf(bigCom));
		return exlist;
	}

	private Vector<String> getDataMidList(int index) {
		String bigCom = String.valueOf(index + 1);
		System.out.println(bigCom);
		Dao dao = new Dao();
		Vector<String> exlist = dao.getExList2(String.valueOf(index));
		return exlist;
	}
	// --------------------------------------------------------------------------
	private void addMember() {
		if (textFieldG1 != null) {
			Dao Dao = new Dao();
			Vo vo = getViewData();
			int aftcnt = Dao.insertGWORK(vo);
		} else {
			System.out.println(textFieldG1 + "입력하지 않았습니다");
		}
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

		this.comboBoxG1.setSelectedItem(combo1);
		this.comboBoxG2.setSelectedItem(combo2);
//		this.model1.setValue(mod1);
//		this.model1.setValue(mod2);
		this.comboBoxG5.setSelectedItem(combo5);
		this.comboBoxG6.setSelectedItem(combo6);
		this.textFieldG1.setText(textf);
		this.sidoCB.setSelectedItem(combo3);
		this.gugunCB.setSelectedItem(combo4);
		this.textArea1.setText(texta);
	}

	private Vo getViewData() {
		// String wNum = 
		Vo vo;
		String combo1 = (String) this.comboBoxG1.getSelectedItem();
		String combo2 = (String) this.comboBoxG2.getSelectedItem();
		String mod1 = model1.getYear() + "-" + (model1.getMonth() + 1) + "-" + model1.getDay();
		String mod2 = model2.getYear() + "-" + (model2.getMonth() + 1) + "-" + model2.getDay();
		String combo5 = (String) this.comboBoxG5.getSelectedItem();
		String combo6 = (String) this.comboBoxG6.getSelectedItem();
		String combo3 = (String) this.sidoCB.getSelectedItem();
		String combo4 = (String) this.gugunCB.getSelectedItem();
		String textf = this.textFieldG1.getText();
		String texta = this.textArea1.getText();

		dateStr = combo5;
		dateStr = mod1 + " " + dateStr.replace("오전", " ").replace("오후", " ").replace("시", ":").replace("분", " ").trim();

		dateEnd = combo6;
		dateEnd = mod2 + " " + dateEnd.replace("오전", " ").replace("오후", " ").replace("시", ":").replace("분", " ").trim();
		System.out.println(dateEnd + "dfd");
		vo = new Vo(combo1, combo2, mod1, mod2, combo5, combo6, textf, combo3, combo4, texta, dateStr, dateEnd);
		return vo;
	}
	
	// ------------------------------------------------------------
	private void cancelMember() {
		clearViewData();
	}

	private void clearViewData() {
		this.comboBoxG1.setSelectedIndex(0);
		this.comboBoxG2.setSelectedIndex(0);
		model1.setSelected(false);
		model2.setSelected(false);
		this.comboBoxG5.setSelectedIndex(0);
		this.comboBoxG6.setSelectedIndex(0);
		// this.sidoCB.setSelectedIndex(0);
		// this.gugunCB.setSelectedIndex(0);

		this.textFieldG1.setText("");
		this.textArea1.setText("");

		this.textFieldG1.grabFocus();
	}

	private void imgLine(JLabel line) {
		ImageIcon icon = new ImageIcon("img/line.png");

		Image img = icon.getImage();

		Image ch = img.getScaledInstance(300, 1, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(ch);

		line.setIcon(changeIcon);

		line.setHorizontalAlignment(JLabel.CENTER);
	}
	
	public static void main(String[] args) {
		new ResDetail();
	}
}
