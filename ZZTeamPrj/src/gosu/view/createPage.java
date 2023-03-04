package gosu.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

import gosu.data.gosuDao;
import gosu.data.gosuDao.GugunComboBoxModel.sidoComboBoxModel;
import gosu.data.userVo;
import javax.swing.JSeparator;

public class createPage extends JFrame {
	TextField idtxt, nametxt, phonetxt, emailtxt;
	JRadioButton man, woman;
	JComboBox<String> sidoCB,gugunCB;
	ButtonGroup group;
	JPasswordField pwtxt, pwcheck;
	Button cancelBtn, findBtn, addBtn;
	gosuDao dao;
	
	public createPage() {
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setForeground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 562, 579);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblId = new JLabel("ID ");
		lblId.setBackground(new Color(255, 255, 255));
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		lblId.setBounds(24, 66, 81, 15);
		panel.add(lblId);

		JLabel lblUserPassword = new JLabel("PassWord");
		lblUserPassword.setForeground(new Color(0, 0, 0));
		lblUserPassword.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblUserPassword.setBounds(24, 116, 115, 15);
		panel.add(lblUserPassword);

		JLabel lblUserName = new JLabel("Name");
		lblUserName.setForeground(new Color(0, 0, 0));
		lblUserName.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblUserName.setBounds(24, 235, 81, 15);
		panel.add(lblUserName);

		JLabel lblUserName_1 = new JLabel("Phone");
		lblUserName_1.setForeground(new Color(0, 0, 0));
		lblUserName_1.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblUserName_1.setBounds(24, 284, 81, 15);
		panel.add(lblUserName_1);

		JLabel lblUserName_1_1 = new JLabel("Gender");
		lblUserName_1_1.setForeground(new Color(0, 0, 0));
		lblUserName_1_1.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		lblUserName_1_1.setBounds(24, 402, 81, 15);
		panel.add(lblUserName_1_1);

		idtxt = new TextField("아이디");
		idtxt.setForeground(Color.BLACK);
		idtxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		idtxt.setColumns(10);
		idtxt.setBackground(new Color(255, 255, 255));
		idtxt.setBounds(24, 87, 147, 23);
		panel.add(idtxt);

		pwtxt = new JPasswordField("비밀번호");
		pwtxt.setForeground(Color.BLACK);
		pwtxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		pwtxt.setColumns(10);
		pwtxt.setBackground(new Color(255, 255, 255));
		pwtxt.setBounds(24, 141, 147, 23);
		panel.add(pwtxt);

		pwcheck = new JPasswordField("비밀번호");
		pwcheck.setForeground(Color.BLACK);
		pwcheck.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		pwcheck.setColumns(10);
		pwcheck.setBackground(Color.WHITE);
		pwcheck.setBounds(24, 200, 147, 23);
		panel.add(pwcheck);

		nametxt = new TextField("이름");
		nametxt.setForeground(Color.BLACK);
		nametxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		nametxt.setColumns(10);
		nametxt.setBackground(new Color(255, 255, 255));
		nametxt.setBounds(24, 255, 147, 23);
		panel.add(nametxt);

		phonetxt = new TextField("ex:  010-0000-0000");
		phonetxt.setForeground(Color.BLACK);
		phonetxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		phonetxt.setColumns(10);
		phonetxt.setBackground(new Color(255, 255, 255));
		phonetxt.setBounds(24, 305, 147, 23);
		panel.add(phonetxt);

		man = new JRadioButton("Man");
		man.setBackground(new Color(248, 248, 255));
		man.setForeground(new Color(0, 0, 0));
		man.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		man.setBounds(24, 423, 56, 23);

		woman = new JRadioButton("Woman");
		woman.setBackground(new Color(248, 248, 255));
		woman.setForeground(new Color(0, 0, 0));
		woman.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		woman.setBounds(100, 423, 73, 23);
		group = new ButtonGroup();
		group.add(man);
		group.add(woman);
		panel.add(man);
		panel.add(woman);
		
		sidoCB = new JComboBox<String>();
		sidoCB.setBackground(Color.WHITE);
		sidoCB.setModel(new SidoComboBoxModel());
		sidoCB.setBounds(24, 485, 93, 23);
		panel.add(sidoCB);
		
		sidoCB.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String sido = (String)sidoCB.getSelectedItem();
					gugunCB.setModel(new GugunComboBoxModel(sido));
				}
				
			}
		});
		
		gugunCB = new JComboBox<String>();
		gugunCB.setForeground(Color.BLACK);
		gugunCB.setBackground(Color.WHITE);
		gugunCB.setBounds(152, 485, 93, 23);
		panel.add(gugunCB);
		
		
		JLabel sido = new JLabel("Addr");
		sido.setForeground(new Color(0, 0, 0));
		sido.setFont(new Font("D2Coding", Font.ITALIC, 15));
		sido.setBounds(24, 460, 81, 15);
		panel.add(sido);


		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(204, 204, 255));
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(314, 0, 248, 579);
		panel.add(panel_1);
		panel_1.setLayout(null);

		Label label = new Label("Share Ability");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		label.setAlignment(Label.CENTER);
		label.setBounds(0, 218, 238, 43);
		panel_1.add(label);

		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(224, 0, 24, 28);
		panel_1.add(lblNewLabel_1);

		cancelBtn = new Button("Cancel");
		cancelBtn.setBounds(80, 497, 83, 23);
		panel_1.add(cancelBtn);
		cancelBtn.setForeground(new Color(0, 0, 0));
		cancelBtn.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
		cancelBtn.setBackground(new Color(204, 204, 255));
		
		JLabel lblNewLabel_2_1 = new JLabel("come !");
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.ITALIC, 40));
		lblNewLabel_2_1.setBounds(0, 0, 176, 68);
		panel_1.add(lblNewLabel_2_1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(25, 266, 197, 2);
		panel_1.add(separator);

		cancelBtn.addActionListener(new ActionListener() {
			// 취소 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "로그인창으로 이동합니다.", "Cancel", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					setVisible(false);
				} else {
					return;
				}

			}
		});
		
	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(139, 164, 187, 182);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("img/deal.png"));

		addBtn = new Button("Add");
		addBtn.setForeground(new Color(0, 0, 0));
		addBtn.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
		addBtn.setBackground(new Color(204, 204, 255));
		addBtn.setBounds(85, 533, 96, 23);
		panel.add(addBtn);
		addBtn.addActionListener(new ActionListener() {

			gosuDao dao = new gosuDao();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (idtxt.getText().length() == 0 || idtxt.getText().trim().equals("아이디")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.", "아이디 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (pwtxt.getText().trim().length() == 0 || pwtxt.getText().trim().equals("비밀번호")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요.", "비밀번호 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (pwcheck.getText().trim().length() == 0 || pwcheck.getText().trim().equals("비밀번호 확인")) {
					JOptionPane.showMessageDialog(null, "비밀번호 확인을 입력해 주세요.", "비밀번호 확인 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (!(pwtxt.getText().trim().equals(pwcheck.getText().trim()))) {
					JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다.!!", "비밀번호 확인", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (nametxt.getText().trim().length() == 0 || nametxt.getText().trim().equals("이름")) {
					JOptionPane.showMessageDialog(null, "이름을 입력해 주세요.", "이름 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (phonetxt.getText().trim().length() == 0 || phonetxt.getText().trim().equals("ex:  010-0000-0000")) {
					JOptionPane.showMessageDialog(null, "전화번호를 입력해 주세요.", "전화번호 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (emailtxt.getText().trim().length() == 0 || emailtxt.getText().trim().equals("이메일")) {
					JOptionPane.showMessageDialog(null, "이메일을 입력해 주세요.", "이메일 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if (sidoCB.getSelectedItem() == null || gugunCB.getSelectedItem() == null ) {
					JOptionPane.showMessageDialog(null, "지역을 선택해주세요", "지역 선택", JOptionPane.WARNING_MESSAGE);
					return;
				}
				String id = idtxt.getText();
				if (dao.getUser(id) != null) {
					JOptionPane.showMessageDialog(null, "중복된 아이디입니다.", "중복된 아이디", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				addMember();
				clearViewData();

			}
		});

		JLabel lblEail = new JLabel("Email");
		lblEail.setForeground(new Color(0, 0, 0));
		lblEail.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblEail.setBounds(24, 334, 81, 15);
		panel.add(lblEail);

		emailtxt = new TextField("이메일");
		emailtxt.setForeground(Color.BLACK);
		emailtxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		emailtxt.setColumns(10);
		emailtxt.setBackground(Color.WHITE);
		emailtxt.setBounds(24, 359, 147, 23);
		panel.add(emailtxt);
		//
		JLabel lblPasswordcheck = new JLabel("PassWord Check");
		lblPasswordcheck.setForeground(new Color(0, 0, 0));
		lblPasswordcheck.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblPasswordcheck.setBounds(24, 174, 115, 15);
		panel.add(lblPasswordcheck);
		
		JLabel lblNewLabel_2 = new JLabel("Wel");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(222, 0, 93, 68);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.ITALIC, 40));
		//

		setLayeredPane(getLayeredPane());
		setUndecorated(true);
		setVisible(true);
		setSize(562, 579);

		FocusEvent();

	}


	private void FocusEvent() {
		idtxt.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (idtxt.getText().trim().length() == 0) {
					idtxt.setText("아이디");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (idtxt.getText().trim().equals("아이디")) {
					idtxt.setText("");
				}
			}
		});
		pwtxt.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (pwtxt.getText().trim().length() == 0) {
					pwtxt.setText("비밀번호");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (pwtxt.getText().trim().equals("비밀번호")) {
					pwtxt.setText("");
				}
			}
		});
		pwcheck.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (pwcheck.getText().trim().length() == 0) {
					pwcheck.setText("비밀번호");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (pwcheck.getText().trim().equals("비밀번호")) {
					pwcheck.setText("");
				}
			}
		});
		nametxt.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (nametxt.getText().trim().length() == 0) {
					nametxt.setText("이름");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (nametxt.getText().trim().equals("이름")) {
					nametxt.setText("");
				}
			}
		});
		phonetxt.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (phonetxt.getText().trim().length() == 0) {
					phonetxt.setText("");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (phonetxt.getText().trim().equals("ex:  010-0000-0000")) {
					phonetxt.setText("");
				}
			}
		});
		emailtxt.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(java.awt.event.FocusEvent e) {
				if (emailtxt.getText().trim().length() == 0) {
					emailtxt.setText("이메일");
				}
			}

			@Override
			public void focusGained(java.awt.event.FocusEvent e) {
				if (emailtxt.getText().trim().equals("이메일")) {
					emailtxt.setText("");
				}
			}
		});

	}

	protected void clearViewData() {
		this.idtxt.setText("아이디");
		this.pwtxt.setText("비밀번호");
		this.pwcheck.setText("비밀번호");
		this.nametxt.setText("이름");
		this.phonetxt.setText("ex 010-0000-0000");
		this.emailtxt.setText("이메일");
		this.man.setSelected(false);
		this.woman.setSelected(false);
		this.sidoCB.getSelectedIndex();
		this.gugunCB.getSelectedIndex();
	}

	protected void addMember() {
		gosuDao gDao = new gosuDao();
		userVo vo = getViewData();
		int aftcnt = gDao.insertMember(vo);
		if(aftcnt == 0)
			JOptionPane.showMessageDialog(null, "회원가입 실패 \n입력사항이 올바르지않습니다.", "입력사항 확인", JOptionPane.WARNING_MESSAGE);
		else
		JOptionPane.showMessageDialog(null, "회원 가입이 완료 되었습니다.", "회원 가입 완료.", JOptionPane.WARNING_MESSAGE);
		setVisible(false);
	}

	protected void findUser() {
		String id = this.idtxt.getText();
		
		if (id.trim().equals("")) 
			return;
		gosuDao dao = new gosuDao(); 
		userVo vo = dao.getUser(id);
		setViewData(vo);
		
	}

	private void setViewData(userVo vo) {
		String id = vo.getId();
		String pw = vo.getPw();
		String name = vo.getName();
		String phone = vo.getPhone();
		String email = vo.getEmail();
		String gender = vo.getGender();
		String sido = vo.getSido();
		String gugun = vo.getGugun();

		this.idtxt.setText(id);
		this.pwtxt.setText(pw);
		this.nametxt.setText(name);
		this.phonetxt.setText(phone);
		this.emailtxt.setText(email);
		switch (gender) {
		case "남":
			this.man.setSelected(true);
			break;
		case "여":
			this.woman.setSelected(true);
			break;
		}
		this.sidoCB.setSelectedItem(sido);
		this.gugunCB.setSelectedItem(gugun);

	}

	// 회원가입
	private userVo getViewData() {
		String id = this.idtxt.getText();
		String pw = this.pwtxt.getText();
		String pw2 = this.pwtxt.getText();
		String name = this.nametxt.getText();
		String phone = this.phonetxt.getText();
		String email = this.emailtxt.getText();
		String gender = "";
		if (this.man.isSelected())
			gender = "남";
		if (this.woman.isSelected())
			gender = "여";
		String sido = (String) this.sidoCB.getSelectedItem();
		String gugun = (String) this.gugunCB.getSelectedItem();

		userVo vo = new userVo(id, pw, pw2 , name, phone, email, gender, sido, gugun);

		return vo;
	}
}
