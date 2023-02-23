package gosu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class ListView extends JFrame{
	JPanel pCenterBack, pCenterList, pCenterMsg, pCenterMypage, pSouth;
	JLabel lblCenterMsg, lblCenterList, lblCenterMypage, lblList, lblMsg, lblMypage;
	JButton  btnList, btnMsg, btnMypage;
	
	public ListView() {
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
		
		btnList   = new JButton("리스트");
		btnMsg    = new JButton("메시지");
		btnMypage = new JButton("마이페이지");
		
		btnList.setBackground(Color.WHITE);
		btnMsg.setBackground(Color.WHITE);
		btnMypage.setBackground(Color.WHITE);
		
		//파라미터: 색상, 선 두께, border의 모서리를 둥글게 할 것인지
		LineBorder lb = new LineBorder(Color.black, 1, true);
		btnList.setBorder(lb);
		btnMsg.setBorder(lb);
		btnMypage.setBorder(lb);
		
		
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
		setSize(600, 900);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
		

		// 화면 중앙 뜨게하기
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈

		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙

	}

	public static void main(String[] args) {
		new ListView();
	}

}


