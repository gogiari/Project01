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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import api.webview.Web;
import gosu.data.gosuDao;
import gosu.data.userVo;

public class MainView extends JFrame implements ActionListener{
	JPanel pCenterBack, pCenterList, pCenterMsg, pCenterMypage, pSouth;
	JLabel lblCenterMsg, lblCenterList, lblCenterMypage, lblList, lblMsg, lblMypage;
	JButton  btnList, btnMsg, btnMypage;
	
	MainView mainview = null;
	GearaeGosu tradeGosu;
	AcceptPage acPage = null;
	loginPage loginpage;
	ResDetail resdet;
	PaymentCompletePage pmcPage = null;
	Edit edit = null;
	res res = null;

	
	String sel;
	String val;
	
	// 고수리스트 변수
	JLabel lblListname;
	JComboBox cbxlist;
	JScrollPane scrGosu;
	JButton btnOk, btnRefresh, btnAdrSuch;
	JTable tabGosuList;
	JTextField txtAdrSuch1, txtAdrSuch2;
	
	// 메시지 리스트 변수
	JLabel lblMsgname;
	JTable tabMsg;
	JScrollPane scrMsg;
	JButton btnMsgDetail;
	
	// 마이 페이지 변수
	JLabel lblMyname;
	JComboBox cbxMypage;
	JButton btnGosuCreate, bntUserSet, btnFAQ;
	JTable tabMypage;
	JScrollPane scrMypage;
	String uid;
	
	//파라미터: 색상, 선 두께, border의 모서리를 둥글게 할 것인지
	LineBorder lb = new LineBorder(Color.black, 1, true);
	
	String bigSelect;
	String titleMsg;
	String sel2;
	
	public MainView(String uid, loginPage loginPage) {
		this.loginpage = loginPage;
		this.uid = uid;
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		inite();
		System.out.println(uid+" : 메인뷰 아이디확인");
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
		
		focusEvent();

		
		

		// 화면 중앙 뜨게하기
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈

		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙

	}
	
	// 마이페이지 화면
	private Component mypage() {
		
		// 마이페이지 패널생성
		pCenterMypage = new JPanel();
		pCenterMypage.setBackground(new Color(255, 255, 255));
		pCenterMypage.setBounds(0, 5, 1184, 746);
		pCenterMypage.setLayout(null);
		
		// 마이페이지 타이틀
		lblMyname = new JLabel("마이 페이지");
		lblMyname.setBounds(340, 0, 486, 70);
		lblMyname.setForeground(new Color(0, 128, 192));
		lblMyname.setFont(new Font("휴먼엑스포", Font.PLAIN, 60));
		pCenterMypage.add(lblMyname);
		
		// 확인 버튼
		btnOk = new JButton("확인하기");
		btnOk.setBounds(1049, 703, 102, 17);
		
		btnOk.setBorder(lb);
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setForeground(new Color(0, 128, 192));
		pCenterMypage.add(btnOk);
		btnOk.addActionListener(this);
		
		// 새로고침 버튼
		btnRefresh = new JButton("새로고침");
		btnRefresh.setBounds(935, 703, 102, 17);
		
		btnRefresh.setBorder(lb);
		btnRefresh.setBackground(new Color(255, 255, 255));
		btnRefresh.setForeground(new Color(0, 128, 192));
		pCenterMypage.add(btnRefresh);
		// 새로고침 액션
		btnRefresh.addActionListener(this);
		
		// 마이페이지 대분류
		cbxMypage = new JComboBox();
		cbxMypage.setModel(new DefaultComboBoxModel(new String[] {"고수", "회원"}));
		cbxMypage.setBounds(59, 22, 82, 23);
		cbxMypage.setForeground(new Color(0, 0, 0));
		cbxMypage.setToolTipText("\uB300\uBD84\uB958");
		pCenterMypage.add(cbxMypage);
		
		// 마이페이지 테이블
		tabMypage = new JTable();
		tabMypage.setModel(
				new DefaultTableModel(getMyDataList(), getMyCoulumnList()  ) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}

				});
		
		
		// 마에페이지 테이블 스크롤 생성
		scrMypage = new JScrollPane(tabMypage);
		scrMypage.setBounds(135, 70, 865, 614);
		tabMypage.setBackground(Color.WHITE);
		scrMypage.setBackground(Color.WHITE);
		pCenterMypage.add(scrMypage);

		
		// 마이페이지 버튼
		btnGosuCreate = new JButton("고수 업무 등록");
		btnGosuCreate.setBounds(1030, 40, 142, 17);
		btnGosuCreate.setBorder(lb);
		btnGosuCreate.setBackground(new Color(255, 255, 255));
		btnGosuCreate.setForeground(new Color(0, 128, 192));
		pCenterMypage.add(btnGosuCreate);
		
		bntUserSet = new JButton("회원 정보 수정 / 삭제");
		bntUserSet.setBounds(1030, 40, 142, 17);
		bntUserSet.setBorder(lb);
		bntUserSet.setBackground(new Color(255, 255, 255));
		bntUserSet.setForeground(new Color(0, 128, 192));
		pCenterMypage.add(bntUserSet);
		
		btnFAQ = new JButton("FAQ");
		btnFAQ.setBounds(30, 703, 142, 17);
		btnFAQ.setBorder(lb);
		btnFAQ.setBackground(new Color(255, 255, 255));
		btnFAQ.setForeground(new Color(0, 128, 192));
		pCenterMypage.add(btnFAQ);
		btnFAQ.addActionListener(this);
		
		bntUserSet.setVisible(false);

		
		btnGosuCreate.addActionListener(this);
		bntUserSet.addActionListener(this); 
		

		cbxMypage.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼 이벤트
				switch ((cbxMypage.getSelectedItem().toString())) {
				case "회원": 
					btnGosuCreate.setVisible(false);
					bntUserSet.setVisible(true);
					
					break;
				default: 
					btnGosuCreate.setVisible(true);
					bntUserSet.setVisible(false);
					break;
				}
				tabMypage.setModel(
						new DefaultTableModel(getMyDataList(), getMyCoulumnList()  ) {

							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}

						});
				tabMypage.repaint();
			}
		});
		
		tabMypage.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스를 클릭하면
				int row = tabMypage.getSelectedRow();
				int col = tabMypage.getSelectedColumn();
				sel = (String) tabMypage.getValueAt(row, 0);
				val = (String) tabMypage.getValueAt(row, 6);
				System.out.println(val +" 상황클릭값");
				System.out.println(e);
				if(tradeGosu != null)
					tradeGosu.dispose();
				if(e.getClickCount() == 2 ) {
					if(val.equals("거래요청서"))
						tradeGosu = new GearaeGosu(sel,uid, mainview);
					if(val.equals("거래수락"))
						acPage = new AcceptPage(sel, mainview);
					if(val.equals("업무대기중"))
						new Edit(res, uid);

				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		
		return pCenterMypage;
	}



	// 메시지리스트 화면
	private Component msglist() {
		
		// 메시지리스트 패널 생성
		pCenterMsg = new JPanel();
		pCenterMsg.setBackground(new Color(255, 255, 255));
		pCenterMsg.setBounds(0, 5, 1184, 746);
		pCenterMsg.setLayout(null);
		
		// 메시지 타이틀
		lblMsgname = new JLabel("메시지 리스트");
		lblMsgname.setBounds(340, 0, 486, 70);
		lblMsgname.setForeground(new Color(0, 128, 192));
		lblMsgname.setFont(new Font("휴먼엑스포", Font.PLAIN, 60));
		pCenterMsg.add(lblMsgname);
		
		// 새로고침 버튼
		btnRefresh = new JButton("새로고침");
		btnRefresh.setBounds(935, 703, 102, 17);
		
		btnRefresh.setBorder(lb);
		btnRefresh.setBackground(new Color(255, 255, 255));
		btnRefresh.setForeground(new Color(0, 128, 192));
		pCenterMsg.add(btnRefresh);
		// 새로고침 액션
		btnRefresh.addActionListener(this);
		
		
		// 메시지 테이블 생성
		tabMsg = new JTable();
		tabMsg.setModel(
				new DefaultTableModel(getMsgDataList(), getMsgCoulumnList()  ) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
					

				});
		// 상세보기 버튼
		btnMsgDetail = new JButton("상세보기");
		btnMsgDetail.setBounds(1049, 703, 102, 17);

		btnMsgDetail.setBorder(lb);
		btnMsgDetail.setBackground(new Color(255, 255, 255));
		btnMsgDetail.setForeground(new Color(0, 128, 192));
		pCenterMsg.add(btnMsgDetail);
		btnMsgDetail.addActionListener(this);

		
		// 메시지 테이블 스크롤 생성
		scrMsg = new JScrollPane(tabMsg);
		scrMsg.setBounds(135, 70, 865, 614);
		tabMsg.setBackground(Color.WHITE);
		scrMsg.setBackground(Color.WHITE);
		pCenterMsg.add(scrMsg);
		
		
		System.out.println(titleMsg);
		tabMsg.addMouseListener(new MouseListener() {
			//뷁
			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스를 클릭하면
				int row = tabMsg.getSelectedRow();
				int col = tabMsg.getSelectedColumn();
				sel = (String) tabMsg.getValueAt(row, 0);
				val = (String) tabMsg.getValueAt(row, 2);
				System.out.println(val +" 상황클릭값");
				System.out.println(e);
				if(tradeGosu != null)
					tradeGosu.dispose();
				if(e.getClickCount() == 2 ) {
					if(val.equals("거래요청서"))
						tradeGosu = new GearaeGosu(sel, uid, mainview);
					if(val.equals("거래수락"))
						acPage = new AcceptPage(sel, mainview);

					
					if(val.equals("결제완료"))
						pmcPage = new PaymentCompletePage(sel, mainview);
					

					if(val.equals("결제완료"))
						pmcPage = new PaymentCompletePage(sel, mainview);


				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});
		
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
		btnOk = new JButton("확인하기");
		btnOk.setBounds(1049, 703, 102, 17);
		
		btnOk.setBorder(lb);
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setForeground(new Color(0, 128, 192));
		pCenterList.add(btnOk);
		btnOk.addActionListener(this);
		
		btnAdrSuch = new JButton("주소찾기");
		btnAdrSuch.setBounds(698, 700, 97, 23);
		btnAdrSuch.addActionListener(this);
		
		btnAdrSuch.setBorder(lb);
		btnAdrSuch.setBackground(new Color(255, 255, 255));
		btnAdrSuch.setForeground(new Color(0, 128, 192));
		pCenterList.add(btnAdrSuch);
		gosuDao dao = new gosuDao();
		System.out.println("뷁"+dao.getUserAddress(uid));
		txtAdrSuch1 = new JTextField(dao.getUserAddress(uid));
		txtAdrSuch1.setBounds(440, 701, 116, 21);
		pCenterList.add(txtAdrSuch1);
		txtAdrSuch1.setColumns(10);
		
		txtAdrSuch2 = new JTextField("고수업무 클릭시 자동 입력");
		txtAdrSuch2.setColumns(10);
		txtAdrSuch2.setBounds(568, 701, 116, 21);
		pCenterList.add(txtAdrSuch2);
		
		
		// 고수 테이블
		tabGosuList = new JTable();
		
		userVo vo = new userVo();
		
		tabGosuList.setModel(
				new DefaultTableModel(getSelGosuDataList(), getGosuCoulumnList()  ) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}

				});
		
		// 새로고침 버튼
		btnRefresh = new JButton("새로고침");
		btnRefresh.setBounds(935, 703, 102, 17);
		
		btnRefresh.setBorder(lb);
		btnRefresh.setBackground(new Color(255, 255, 255));
		btnRefresh.setForeground(new Color(0, 128, 192));
		pCenterList.add(btnRefresh);

		
		
		// 고수 테이블 스크롤 생성
		scrGosu = new JScrollPane(tabGosuList);
		scrGosu.setBounds(135, 70, 865, 614);
		tabGosuList.setBackground(Color.WHITE);
		scrGosu.setBackground(Color.WHITE);
		pCenterList.add(scrGosu);
		
		// 새로고침 액션
		btnRefresh.addActionListener(this);
		
		// 대분류 선택 액션
		cbxlist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				bigSelect = (String) cbxlist.getSelectedItem();
//				System.out.println(bigSelect+"zzz");
				tabGosuList.setModel(
						new DefaultTableModel(getSelGosuDataList(), getGosuCoulumnList()  ) {

							@Override
							public boolean isCellEditable(int row, int column) {
								return false;
							}

						});

				pCenterList.repaint();
			}
			

			
		});
		tabGosuList.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// 마우스를 클릭하면
				int row = tabGosuList.getSelectedRow();
				int col = tabGosuList.getSelectedColumn();
				String sel = (String) tabGosuList.getValueAt(row, 0);
				sel2 = (String) tabGosuList.getValueAt(row, 4);
				txtAdrSuch2.setText(sel2);
				System.out.println(sel2 +" 상황클릭값 + ㅇ");
				System.out.println(e);
				if(tradeGosu != null)
					tradeGosu.dispose();
				if(e.getClickCount() == 2 ) {
					resdet = new ResDetail(sel, uid, mainview);
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
		});

		
		
		
		
		return pCenterList;
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
	
	// 고수 리스트 테이블 데이터
	private Vector<Vector> getGosuDataList() {
		gosuDao dao = new gosuDao();
		Vector<Vector> list = dao.getGosuList();
		return list;
	}
	// 고수 리스트 선택 테이블 데이터 (이벤트)
	private Vector<Vector> getSelGosuDataList() {
		gosuDao dao = new gosuDao();
		Vector<Vector> list = dao.getSelGosuList(cbxlist.getSelectedItem().toString());
		return list;
	}

	private Vector<String> getBigList() {
		gosuDao dao = new gosuDao();
		Vector<String> blist = dao.getBigList();
		return blist;
	}
	
	// 메시지 테이블 제목줄
	private Vector<String> getMsgCoulumnList() {
		Vector<String> cols = new Vector<>();
		cols.add("거래번호");
		cols.add("보낸사람");
		cols.add("제목");
		cols.add("보낸날짜");
		return cols;
	}
	// 메시지 테이블 데이터
	private Vector<Vector> getMsgDataList() {
		gosuDao dao = new gosuDao();
//		System.out.println(dao.getMsgList().get(1).get(1)+"");
		Vector<Vector> list = dao.getMsgList(uid);
		return list;
	}
	
	// 마이페이지 테이블
	private Vector<String> getMyCoulumnList() {
		Vector<String> cols = new Vector<String>();
		cols.add("거래번호");
		cols.add("대분류");
		cols.add("중분류");
		if(cbxMypage.getSelectedItem().toString() == "회원") {
			cols.add("고수이름(상대방)");
			} else {
		cols.add("회원이름(상대방)");
			}
		cols.add("날짜");
		cols.add("금액");
		cols.add("거래현황");
		cols.add("평점");
		return cols;
	}

	private Vector<Vector> getMyDataList() {
		gosuDao dao = new gosuDao();
		Vector<Vector> list = dao.getmylist(cbxMypage.getSelectedItem().toString(), uid);
		return list;
	}

	
	
	// 버튼 액션
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) { // 눌러진 버튼의 글자
		case "주소찾기" :
			if(txtAdrSuch1.getText() == null)
				JOptionPane.showMessageDialog(null, "주소를 입력해주세요", "주소찾기", JOptionPane.INFORMATION_MESSAGE);
			new Web(txtAdrSuch1.getText().trim(),txtAdrSuch2.getText().trim());
			
			System.out.println(sel2);
			break;
		case "확인하기" :
			if(pCenterList.isVisible()==true) {
				int row = tabGosuList.getSelectedRow();
				int col = tabGosuList.getSelectedColumn();
				String sel = (String) tabGosuList.getValueAt(row, 0);
				resdet = new ResDetail(sel, uid, mainview);
			} else if(pCenterMypage.isVisible()==true) {
				System.out.println("야호");
				int row = tabMypage.getSelectedRow();
				int col = tabMypage.getSelectedColumn();
				sel = (String) tabMypage.getValueAt(row, 0);
				val = (String) tabMypage.getValueAt(row, 6);
				if(val.equals("거래요청서"))
					tradeGosu = new GearaeGosu(sel, uid, mainview);
				if(val.equals("거래수락"))
					acPage = new AcceptPage(sel, mainview);
				if(val.equals("업무대기중"))
					new Edit(res, uid);
			}
			
			break;
		case "상세보기" :
			System.out.println("상세보기클릭");
			int row = tabMsg.getSelectedRow();
			int col = tabMsg.getSelectedColumn();
			sel = (String) tabMsg.getValueAt(row, 0);
			val = (String) tabMsg.getValueAt(row, 2);
			if(val.equals("거래요청서"))
				tradeGosu = new GearaeGosu(sel, uid, mainview);
			if(val.equals("거래수락"))
				acPage = new AcceptPage(sel, mainview);
			break;
		case "새로고침" :
			System.out.println("새로고침클릭");
			gosuRefresh();
			break;
		case "고수 업무 등록" :
			System.out.println("고수 업무 등록");
			System.out.println(uid + ": 로그인페이지 아이디 가져옴");
			new res(uid);
			break;
		case "회원 정보 수정 / 삭제" :
			System.out.println("회원 정보 수정 / 삭제");
			System.out.println("ㅈㅂ"+loginpage.pwU.getText());
//			String input = JOptionPane.showInputDialog("기존 비밀번호 입력");
			
			// 제이옵션 패스워드필드추가
			JPanel panel = new JPanel();
			JLabel label = new JLabel("기존 비밀번호 입력 :");
			JPasswordField pass = new JPasswordField(10);
			panel.add(label);
			panel.add(pass);
			String[] options = new String[]{"확인", "취소"};
			int option = JOptionPane.showOptionDialog(null, panel, "비밀번호 확인", 
			                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
			                         null, options, options[1]);

			if(option == 0) // pressing OK button
			{
			    char[] password = pass.getPassword();
			    System.out.println("Your password is: " + new String(password));
			    if(new String(password).equals(loginpage.pwU.getText())) {
			    	new UserEdit(uid, loginpage.pwU.getText());
			    } else {
			    	JOptionPane.showMessageDialog(null, "비밀번호를 다시 확인해주세요", "비밀번호 불일치", JOptionPane.ERROR_MESSAGE);
			    }
			}
			
			break;
		case "FAQ" :
			System.out.println("FAQ버튼");
			new FAQList(uid);
			break;

		}
	}
	private void focusEvent() {
		txtAdrSuch1.addFocusListener(new FocusListener() {
			gosuDao dao = new gosuDao();
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAdrSuch1.getText().trim().length() == 0) {
					txtAdrSuch1.setText(dao.getUserAddress(uid));
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (txtAdrSuch1.getText().equals(dao.getUserAddress(uid))) {
					txtAdrSuch1.setText("");
				}
				
			}
		});
		txtAdrSuch2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAdrSuch2.getText().length() == 0) {
					txtAdrSuch2.setText(sel2);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (txtAdrSuch2.getText().equals(sel2) || txtAdrSuch2.getText().equals("고수업무 클릭시 자동 입력")) {
					System.out.println(txtAdrSuch2.getText());
					System.out.println(sel2);
					txtAdrSuch2.setText("");
				}
				
			}
		});
	}



	public static void main(String[] args) {
		new MainView(null, null);
	}

	public void gosuRefresh() {
		if(pCenterList.isVisible() == true) {
		tabGosuList.setModel(
				new DefaultTableModel(getSelGosuDataList(), getGosuCoulumnList()  ) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}

				});
		tabGosuList .repaint();
		} else if(pCenterMsg.isVisible() == true) {
		tabMsg.setModel(
				new DefaultTableModel(getMsgDataList(), getMsgCoulumnList()  ) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
					

				});
		tabMsg.repaint();
		} else if(pCenterMypage.isVisible() == true) {
		tabMypage.setModel(
				new DefaultTableModel(getMyDataList(), getMyCoulumnList()  ) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}

				});
		tabMypage.repaint();
		}
		
		
	}
	

}
