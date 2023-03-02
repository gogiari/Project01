package gosu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import gosu.data.gosuDao;

public class MainView extends JFrame implements ActionListener{
	JPanel pCenterBack, pCenterList, pCenterMsg, pCenterMypage, pSouth;
	JLabel lblCenterMsg, lblCenterList, lblCenterMypage, lblList, lblMsg, lblMypage;
	JButton  btnList, btnMsg, btnMypage;
	
	// 고수리스트 변수
	JLabel lblListname;
	JComboBox cbxlist;
	JScrollPane scroll;
	JButton btnOk, btnRefresh;
	JTable tabGosuList;
	
	// 메시지 리스트 변수
	JLabel lblMsgname;
//	JComboBox cbxlist2;
//	JScrollPane scroll;
//	JButton btnOk;
//	JTable tabGosuList;
	
	// 마이 페이지 변수
	JLabel lblMyname;
	
	public MainView() {
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		inite();
	}

	private void inite() {
		setTitle("리스트");
		getContentPane().setLayout(new BorderLayout());
		
		pCenterBack = new JPanel();
		pCenterBack.setBackground(new Color(255, 255, 255));
//		pCenterList = new JPanel();
//		pCenterMsg = new JPanel();
//		pCenterMsg.setBounds(744, 237, 70, 25);
//		pCenterMypage = new JPanel();
//		pCenterMypage.setBounds(819, 237, 94, 25);
		pSouth     = new JPanel();
		
//		lblCenterList   = new JLabel("리스트화면");
//		lblCenterMsg    = new JLabel("메세지화면");
//		lblCenterMypage = new JLabel("마이페이지화면");
		
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
		pCenterBack.setLayout(null);
		
		// 패널안에 고수리스트 넣기
		pCenterBack.add(gosulist());
		// 패널안에 메시지리스트 넣기
		pCenterBack.add(msglist());
		// 패널안에 마이페이 넣기
		pCenterBack.add(mypage());
		
//		pCenterMypage.add(lblCenterMypage);
		
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
	private Component mypage() {
		
		// 마이페이지 패널생성
		pCenterMypage = new JPanel();
		pCenterMypage.setBounds(0, 5, 1184, 746);
		pCenterMypage.setLayout(null);
		
		lblMyname = new JLabel("마이 페이지");
		lblMyname.setBounds(340, 0, 486, 70);
		lblMyname.setForeground(new Color(0, 128, 192));
		lblMyname.setFont(new Font("휴먼엑스포", Font.PLAIN, 60));
		pCenterMypage.add(lblMyname);
		
		return pCenterMypage;
	}

	// 메시지리스트 화면
	private Component msglist() {
		
		// 메시지리스트 패널 생성
		pCenterMsg = new JPanel();
		pCenterMsg.setBounds(0, 5, 1184, 746);
		pCenterMsg.setLayout(null);
		
		lblMsgname = new JLabel("메시지 리스트");
		lblMsgname.setBounds(340, 0, 486, 70);
		lblMsgname.setForeground(new Color(0, 128, 192));
		lblMsgname.setFont(new Font("휴먼엑스포", Font.PLAIN, 60));
		pCenterMsg.add(lblMsgname);
		

		
		return pCenterMsg;
	}

	// 고수리스트 화면
	private Component gosulist() {
		
		// 고수리스트 패널 생성
		pCenterList = new JPanel();
		pCenterList.setBackground(new Color(255, 255, 255));
		pCenterList.setBounds(0, 5, 1184, 746);
		pCenterList.setLayout(null);
		
		// 고수리스트 타이틀
		lblListname = new JLabel("\uACE0\uC218 \uC5C5\uBB34 \uB9AC\uC2A4\uD2B8");
		lblListname.setBounds(340, 0, 486, 70);
		lblListname.setForeground(new Color(0, 128, 192));
		lblListname.setFont(new Font("휴먼엑스포", Font.PLAIN, 60));
		pCenterList.add(lblListname);
		
		// 고수리스트 대분류
		cbxlist = new JComboBox(getBigList());
		cbxlist.setBounds(59, 22, 82, 23);
		cbxlist.setForeground(new Color(0, 0, 0));
		cbxlist.setToolTipText("\uB300\uBD84\uB958");
		pCenterList.add(cbxlist);
		
		
		// 확인 버튼
		//파라미터: 색상, 선 두께, border의 모서리를 둥글게 할 것인지
		LineBorder lb = new LineBorder(Color.black, 1, true);
		btnOk = new JButton("\uD655\uC778\uD558\uAE30");
		btnOk.setBounds(1082, 729, 102, 17);
		
		btnOk.setBorder(lb);
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setForeground(new Color(0, 128, 192));
		pCenterList.add(btnOk);
		btnOk.addActionListener(this);
		
		tabGosuList = new JTable();
		tabGosuList.setModel(
				new DefaultTableModel(getGosuDataList(), getGosuCoulumnList()  ) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}

				});

		scroll = new JScrollPane(tabGosuList);
		scroll.setBounds(135, 70, 865, 614);
		tabGosuList.setBackground(Color.WHITE);
		scroll.setBackground(Color.WHITE);
		pCenterList.add(scroll);

//		setSize(1200, 800);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		
		return pCenterList;
	}

	// 고수 리스트 테이블 데이터
	private Vector<Vector> getGosuDataList() {
		gosuDao dao = new gosuDao();
		Vector<Vector> list = dao.getGosuList();
		return list;
	}

	// 고수 리스트 테이블 제목줄
	private Vector<String> getGosuCoulumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("NO");
		cols.add("중분류");
		cols.add("고수이름");
		cols.add("금액");
		cols.add("위치");
		return cols;
	}
	private Vector<String> getBigList() {
		gosuDao dao = new gosuDao();
		Vector<String> blist = dao.getBigList();
		return blist;
	}

	public static void main(String[] args) {
		new MainView();
	}
	
	
	// 버튼 이벤트
	// 고수리스트 확인 버튼 액션
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
