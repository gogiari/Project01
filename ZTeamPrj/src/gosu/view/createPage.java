package gosu.view;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Button;

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
		lblUserName_1_1.setBounds(24, 355, 81, 15);
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
		phonetxt.setBounds(24, 315, 172, 23);
		panel.add(phonetxt);

		Checkbox man = new Checkbox("Man");
		man.setBackground(new Color(248, 248, 255));
		man.setForeground(SystemColor.textHighlight);
		man.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		man.setBounds(31, 376, 56, 23);
		panel.add(man);

		Checkbox man_1 = new Checkbox("Woman");
		man_1.setBackground(new Color(248, 248, 255));
		man_1.setForeground(SystemColor.textHighlight);
		man_1.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		man_1.setBounds(96, 376, 73, 23);
		panel.add(man_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(24, 443, 93, 23);
		panel.add(comboBox);

		JLabel addr = new JLabel("Addr");
		addr.setForeground(SystemColor.textHighlight);
		addr.setFont(new Font("D2Coding", Font.ITALIC, 15));
		addr.setBounds(24, 418, 81, 15);
		panel.add(addr);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(new Color(255, 255, 255));
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setBounds(133, 443, 93, 23);
		panel.add(comboBox_1);

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
		
		Button findBtn = new Button("찾기");
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
		Button alterBtn = new Button("수정");
		findBtn.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
		findBtn.setForeground(new Color(30, 144, 255));
		
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(133, -27, 187, 182);
				panel.add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon("img/deal.png"));
		setLayeredPane(getLayeredPane());
		setUndecorated(true);
		setVisible(true);
		setSize(562, 579);
	}
}
