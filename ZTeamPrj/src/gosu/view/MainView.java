package gosu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class MainView extends JFrame{
	JPanel pCenterBack, pCenterList, pCenterMsg, pCenterMypage, pSouth;
	JLabel lblCenterMsg, lblCenterList, lblCenterMypage, lblList, lblMsg, lblMypage;
	JButton  btnList, btnMsg, btnMypage;
	
	public MainView() {
		inite();
	}

	private void inite() {
		setTitle("리스트");
		getContentPane().setLayout(new BorderLayout());
		
		pCenterBack = new JPanel();
		pCenterList = new JPanel();
		pCenterMsg = new JPanel();
		pCenterMypage = new JPanel();
		pSouth     = new JPanel();
		
		lblCenterList   = new JLabel("리스트화면");
		lblCenterMsg    = new JLabel("메세지화면");
		lblCenterMypage = new JLabel("마이페이지화면");
		
		btnList   = new JButton();
		btnMsg    = new JButton();
		btnMypage = new JButton();
		
		btnList.setBackground(Color.WHITE);
		btnMsg.setBackground(Color.WHITE);
		btnMypage.setBackground(Color.WHITE);
		
		//파라미터: 색상, 선 두께, border의 모서리를 둥글게 할 것인지
	      btnList.setBorderPainted(false);
	      btnMsg.setBorderPainted(false);
	      btnMypage.setBorderPainted(false);
	      
	      //고정패널 아이콘 부분 시작
	      ImageIcon icon = new ImageIcon("img/home.png");
	      
	      Image img = icon.getImage();
	      
	      Image ch = img.getScaledInstance(50,50,Image.SCALE_SMOOTH);
	      ImageIcon changeIcon = new ImageIcon(ch);
	      
	      btnList.setIcon(changeIcon);
	      
	      btnList.setHorizontalAlignment(JLabel.CENTER);
	      
	      //btnMsg------------------------------------------------
	      ImageIcon icon2 = new ImageIcon("img/comment.png");
	      
	      Image img2 = icon2.getImage();
	      
	      Image ch2 = img2.getScaledInstance(50,50,Image.SCALE_SMOOTH);
	      ImageIcon changeIcon2 = new ImageIcon(ch2);
	      
	      btnMsg.setIcon(changeIcon2);
	      
	      btnMsg.setHorizontalAlignment(JLabel.CENTER);
	      
	      //btnMypage------------------------------------------------
	      ImageIcon icon3 = new ImageIcon("img/user.png");
	      
	      Image img3 = icon3.getImage();
	      
	      Image ch3 = img3.getScaledInstance(50,50,Image.SCALE_SMOOTH);
	      ImageIcon changeIcon3 = new ImageIcon(ch3);
	      
	      btnMypage.setIcon(changeIcon3);
	      
	      btnMypage.setHorizontalAlignment(JLabel.CENTER);
	    //고정패널 아이콘 부분 끝
		
		
		btnList.setPreferredSize(new Dimension(150, 100));
		btnMsg.setPreferredSize(new Dimension(150, 100));
		btnMypage.setPreferredSize(new Dimension(150, 100));
		
		
		getContentPane().add(pCenterBack, BorderLayout.CENTER);
		pCenterBack.add(pCenterList);
		pCenterBack.add(pCenterMsg);
		pCenterBack.add(pCenterMypage);
		
		pCenterList.add(lblCenterList);
		pCenterMsg.add(lblCenterMsg);
		pCenterMypage.add(lblCenterMypage);
		
		// 패널 추가 후 setVisible로 꺼줌
		pCenterMsg.setVisible(false);
		pCenterMypage.setVisible(false);

		
		getContentPane().add(pSouth, BorderLayout.SOUTH);
		pSouth.add(btnList);
		pSouth.add(btnMsg);
		pSouth.add(btnMypage);
		pSouth.setBackground(Color.WHITE);
		
		btnList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					pCenterMsg.setVisible(false);
					pCenterMypage.setVisible(false);
					pCenterList.setVisible(true);
			}
		});
		
		btnMsg.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					pCenterList.setVisible(false);
					pCenterMypage.setVisible(false);
					pCenterMsg.setVisible(true);
			}
		});
		
		btnMypage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pCenterList.setVisible(false);
				pCenterMsg.setVisible(false);
				pCenterMypage.setVisible(true);
				
			}
		});
		
		
		
		


		
		
		
		setVisible(true);
		setSize(1200, 900);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
		

		// 화면 중앙 뜨게하기
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈

		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙

	}

	public static void main(String[] args) {
		new MainView();
	}

}


