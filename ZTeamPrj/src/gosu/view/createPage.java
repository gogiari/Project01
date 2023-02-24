package gosu.view;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gosu.data.gosuDao;
import gosu.data.gosuVo;

public class createPage extends JFrame {
	
	
	public createPage() {
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setForeground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 562, 579);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		

		JLabel lblId = new JLabel("ID ");
		lblId.setBackground(new Color(255, 255, 255));
		lblId.setForeground(SystemColor.textHighlight);
		lblId.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		lblId.setBounds(24, 115, 81, 15);
		panel.add(lblId);

		JLabel lblUserPassword = new JLabel("PassWord");
		lblUserPassword.setForeground(SystemColor.textHighlight);
		lblUserPassword.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblUserPassword.setBounds(24, 175, 115, 15);
		panel.add(lblUserPassword);

		JLabel lblUserName = new JLabel("Name");
		lblUserName.setForeground(SystemColor.textHighlight);
		lblUserName.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblUserName.setBounds(24, 235, 81, 15);
		panel.add(lblUserName);

		JLabel lblUserName_1 = new JLabel("Phone");
		lblUserName_1.setForeground(SystemColor.textHighlight);
		lblUserName_1.setFont(new Font("D2Coding", Font.ITALIC, 15));
		lblUserName_1.setBounds(24, 295, 81, 15);
		panel.add(lblUserName_1);

		JLabel lblUserName_1_1 = new JLabel("Gender");
		lblUserName_1_1.setForeground(SystemColor.textHighlight);
		lblUserName_1_1.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		lblUserName_1_1.setBounds(24, 402, 81, 15);
		panel.add(lblUserName_1_1);

		TextField idtxt = new TextField();
		idtxt.setForeground(Color.BLACK);
		idtxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		idtxt.setColumns(10);
		idtxt.setBackground(new Color(255, 255, 255));
		idtxt.setBounds(24, 135, 169, 23);
		panel.add(idtxt);

		TextField pwtxt = new TextField();
		pwtxt.setForeground(Color.BLACK);
		pwtxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		pwtxt.setColumns(10);
		pwtxt.setBackground(new Color(255, 255, 255));
		pwtxt.setBounds(24, 195, 172, 23);
		panel.add(pwtxt);

		TextField nametxt = new TextField();
		nametxt.setForeground(Color.BLACK);
		nametxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		nametxt.setColumns(10);
		nametxt.setBackground(new Color(255, 255, 255));
		nametxt.setBounds(24, 255, 172, 23);
		panel.add(nametxt);

		TextField phonetxt = new TextField();
		phonetxt.setForeground(Color.BLACK);
		phonetxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		phonetxt.setColumns(10);
		phonetxt.setBackground(new Color(255, 255, 255));
		phonetxt.setBounds(24, 316, 172, 23);
		panel.add(phonetxt);

		Checkbox man = new Checkbox("Man");
		man.setBackground(new Color(248, 248, 255));
		man.setForeground(SystemColor.textHighlight);
		man.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		man.setBounds(24, 423, 56, 23);
		panel.add(man);

		Checkbox man_1 = new Checkbox("Woman");
		man_1.setBackground(new Color(248, 248, 255));
		man_1.setForeground(SystemColor.textHighlight);
		man_1.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		man_1.setBounds(100, 423, 73, 23);
		panel.add(man_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(24, 485, 93, 23);
		panel.add(comboBox);

		JLabel sido = new JLabel("Addr");
		sido.setForeground(SystemColor.textHighlight);
		sido.setFont(new Font("D2Coding", Font.ITALIC, 15));
		sido.setBounds(24, 460, 81, 15);
		panel.add(sido);

		JComboBox gugun = new JComboBox();
		gugun.setForeground(new Color(255, 255, 255));
		gugun.setBackground(new Color(255, 255, 255));
		gugun.setBounds(152, 485, 93, 23);
		panel.add(gugun);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 204, 255));
		panel_1.setBounds(314, 0, 248, 579);
		panel.add(panel_1);
		panel_1.setLayout(null);

		Label label = new Label("Share Ability");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Comic Sans MS", Font.ITALIC, 32));
		label.setAlignment(Label.CENTER);
		label.setBounds(10, 218, 200, 36);
		panel_1.add(label);

		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(224, 0, 24, 28);
		panel_1.add(lblNewLabel_1);
		
		Button Cancel = new Button("Cancel");
		Cancel.setBounds(88, 497, 61, 23);
		panel_1.add(Cancel);
		Cancel.setForeground(new Color(30, 144, 255));
		Cancel.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
		Cancel.setBackground(new Color(240, 248, 255));
		
		Button findBtn = new Button("find");
		findBtn.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
		findBtn.setForeground(new Color(30, 144, 255));
		findBtn.setBackground(new Color(240, 248, 255));
		findBtn.setBounds(199, 135, 46, 23);
		panel.add(findBtn);
		
		findBtn.addActionListener(new ActionListener() {
		
			// 찾기 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(133, -27, 187, 182);
				panel.add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon("img/deal.png"));
				
				Button addBtn = new Button("Add");
				addBtn.setForeground(new Color(30, 144, 255));
				addBtn.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
				addBtn.setBackground(new Color(240, 248, 255));
				addBtn.setBounds(24, 546, 46, 23);
				panel.add(addBtn);
				addBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					addMember();
						
					}
				});
				
				
				
				Button AlterBtn = new Button("Alter");
				AlterBtn.setForeground(new Color(30, 144, 255));
				AlterBtn.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
				AlterBtn.setBackground(new Color(240, 248, 255));
				AlterBtn.setBounds(121, 546, 56, 23);
				panel.add(AlterBtn);
				
				Button deleteBtn = new Button("Delete");
				deleteBtn.setForeground(new Color(30, 144, 255));
				deleteBtn.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
				deleteBtn.setBackground(new Color(240, 248, 255));
				deleteBtn.setBounds(228, 546, 56, 23);
				panel.add(deleteBtn);
				
				JLabel lblEail = new JLabel("Email");
				lblEail.setForeground(SystemColor.textHighlight);
				lblEail.setFont(new Font("D2Coding", Font.ITALIC, 15));
				lblEail.setBounds(24, 345, 81, 15);
				panel.add(lblEail);
				
				TextField emailtxt = new TextField();
				emailtxt.setForeground(Color.BLACK);
				emailtxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
				emailtxt.setColumns(10);
				emailtxt.setBackground(Color.WHITE);
				emailtxt.setBounds(24, 366, 172, 23);
				panel.add(emailtxt);
		setLayeredPane(getLayeredPane());
		setUndecorated(true);
		setVisible(true);
		setSize(562, 579);
		
	}

	protected void addMember() {
		gosuDao gDao = new gosuDao();
		gosuVo  vo   = getViewData();
	}

	private gosuVo getViewData() {
		gosuVo vo = new gosuVo(); 
		return vo;
	}
}
