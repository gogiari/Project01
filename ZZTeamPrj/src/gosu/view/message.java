package gosu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gosu.data.georaeVo;
import gosu.data.gosuDao;

public class message extends JFrame {
	
	public message( ) {
		
	setBackground(Color.WHITE);

	getContentPane().setLayout(new BorderLayout());
	JPanel Pane  = new JPanel();
	Pane.setBackground(SystemColor.inactiveCaptionBorder);
	

	setContentPane(Pane);		
	Pane.setLayout(null);	

	setTitle("새창");
	Pane.setLayout(null);
	
	JButton btnmess = new JButton("네");
	btnmess.setBounds(700, 380, 100, 50);
	btnmess.setBackground(new Color(102, 204, 255));
	btnmess.setBounds(70, 70, 60, 23);
	getContentPane().add(btnmess);

	JButton btn2 = new JButton("요청 취소");
	btn2.setBackground(new Color(255, 255, 255));
	btn2.setBounds(140, 70, 100, 23);
	getContentPane().add(btn2);
	
	
	btnmess.addActionListener( new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("네 클릭");				
			select();
			dispose();

		}

		private void select() {
			gosuDao   gDao    =  new gosuDao();
			georaeVo  vo      =  getViewData();
			int       aftcnt  =  gDao.select( vo );
			
		}

		private georaeVo getViewData() {
			georaeVo   vo       = new georaeVo();

			return vo;
		}

	
 	});		
	
	JLabel lbltitle = new JLabel("거래요청서를 전송하시겠습니까?");
	lbltitle.setFont(new Font("D2Coding", Font.PLAIN, 15));
	lbltitle.setBounds(29, 33, 226, 18);
	getContentPane().add(lbltitle);
	
	btn2.addActionListener( new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("요청취소");	
			delete();
			dispose();

		}

		private void delete() {
			gosuDao   gDao    =  new gosuDao();
			georaeVo  vo      =  getViewData();
			int       aftcnt  =  gDao.delete( vo );
			
		}
			private georaeVo getViewData() {
				georaeVo   vo       = new georaeVo();

				return vo;
			}

		
	});	
	
	setSize(300, 150);
	setVisible(true);
	setLocation(800, 300);		
	
	}

}
