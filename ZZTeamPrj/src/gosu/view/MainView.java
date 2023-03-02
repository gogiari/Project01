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
import gosu.data.userVo;

import javax.swing.DefaultComboBoxModel;

public class MainView extends JFrame implements ActionListener{
	JPanel pCenterBack, pCenterList, pCenterMsg, pCenterMypage, pSouth;
	JLabel lblCenterMsg, lblCenterList, lblCenterMypage, lblList, lblMsg, lblMypage;
	JButton  btnList, btnMsg, btnMypage;
	
	MainView mianview = null;
	
	// 고수리스트 변수
	JLabel lblListname;
	JComboBox cbxlist;
	JScrollPane scrGosu;
	JButton btnOk, btnRefresh;
	JTable tabGosuList;
	
	// 메시지 리스트 변수
	JLabel lblMsgname;
	JTable tabMsg;
	JScrollPane scrMsg;
	
	// 마이 페이지 변수
	JLabel lblMyname;
	JComboBox cbxMypage;
	JButton btnGosuCreate, bntUserSet;
	JTable tabMypage;
	JScrollPane scrMypage;
	
	//파라미터: 색상, 선 두께, border의 모서리를 둥글게 할 것인지
	LineBorder lb = new LineBorder(Color.black, 1, true);
	
	String bigSelect;
	
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
	
	// 마이페이지 화면
	private Component mypage() {
		
		// 마이페이지 패널생성
		pCenterMypage = new JPanel();
		pCenterMypage.setBounds(0, 5, 1184, 746);
		pCenterMypage.setLayout(null);
		
		// 마이페이지 타이틀
		lblMyname = new JLabel("마이 페이지");
		lblMyname.setBounds(340, 0, 486, 70);
		lblMyname.setForeground(new Color(0, 128, 192));
		lblMyname.setFont(new Font("휴먼엑스포", Font.PLAIN, 60));
		pCenterMypage.add(lblMyname);
		
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
				pCenterMypage.repaint();
			}
		});

		return pCenterMypage;
	}



	// 메시지리스트 화면
	private Component msglist() {
		
		// 메시지리스트 패널 생성
		pCenterMsg = new JPanel();
		pCenterMsg.setBounds(0, 5, 1184, 746);
		pCenterMsg.setLayout(null);
		
		// 메시지 타이틀
		lblMsgname = new JLabel("메시지 리스트");
		lblMsgname.setBounds(340, 0, 486, 70);
		lblMsgname.setForeground(new Color(0, 128, 192));
		lblMsgname.setFont(new Font("휴먼엑스포", Font.PLAIN, 60));
		pCenterMsg.add(lblMsgname);
		
		// 메시지 테이블 생성
		tabMsg = new JTable();
		tabMsg.setModel(
				new DefaultTableModel(getMsgDataList(), getMsgCoulumnList()  ) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}

				});
		
		
		// 메시지 테이블 스크롤 생성
		scrMsg = new JScrollPane(tabMsg);
		scrMsg.setBounds(135, 70, 865, 614);
		tabMsg.setBackground(Color.WHITE);
		scrMsg.setBackground(Color.WHITE);
		pCenterMsg.add(scrMsg);
		
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
		btnOk = new JButton("\uD655\uC778\uD558\uAE30");
		btnOk.setBounds(1049, 703, 102, 17);
		
		btnOk.setBorder(lb);
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setForeground(new Color(0, 128, 192));
		pCenterList.add(btnOk);
		btnOk.addActionListener(this);
		
		// 고수 테이블
		tabGosuList = new JTable();
		
		userVo vo = new userVo();
		vo.setBigSelect("전체");
		
		System.out.println(vo.getBigSelect());
		tabGosuList.setModel(
				new DefaultTableModel(getGosuDataList(), getGosuCoulumnList()  ) {

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
				vo.setBigSelect(bigSelect);
				if(vo.getBigSelect() != "전체") { // 전체 선택 돌아갈때 필요
					System.out.println(bigSelect);
					
					tabGosuList.setModel(
							new DefaultTableModel(getSelGosuDataList(), getGosuCoulumnList()  ) {

								@Override
								public boolean isCellEditable(int row, int column) {
									return false;
								}

							});
				} else { // 그외 선택
					tabGosuList.setModel(
							new DefaultTableModel(getGosuDataList(), getGosuCoulumnList()  ) {

								@Override
								public boolean isCellEditable(int row, int column) {
									return false;
								}

							});
				}
				pCenterList.repaint();
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
		Vector<Vector> list = dao.getSelGosuList(bigSelect);
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

	private Vector<Vector> getMsgDataList() {
		gosuDao dao = new gosuDao();
		Vector<Vector> list = dao.getMsgList();
		return list;
	}
	
	// 마이페이지 테이블
	private Vector<String> getMyCoulumnList() {
		Vector<String> cols = new Vector<String>();
		cols.add("거래번호");
		cols.add("대분류");
		cols.add("중분류");
		if(cbxMypage.getSelectedItem().toString() == "회원") {
			cols.add("고수이름");
			} else {
		cols.add("회원이름");
			}
		cols.add("날짜");
		cols.add("금액");
		cols.add("거래현황");
		cols.add("평점");
		return cols;
	}

	private Vector<Vector> getMyDataList() {
		gosuDao dao = new gosuDao();
		Vector<Vector> list = dao.getmylist(cbxMypage.getSelectedItem().toString());
		return list;
	}

	public static void main(String[] args) {
		new MainView();
	}

	
	
	// 버튼 액션
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) { // 눌러진 버튼의 글자
		case "새로고침" :
			System.out.println("새로고침클릭");
			gosuRefresh();
			break;
		case "고수 업무 등록" :
			System.out.println("고수 업무 등록");
			new res();
			break;
		case "회원 정보 수정 / 삭제" :
			System.out.println("회원 정보 수정 / 삭제");
			break;

		}
	}

	public void gosuRefresh() {
		tabGosuList.setModel(
				new DefaultTableModel(getGosuDataList(), getGosuCoulumnList()  ) {

					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}

				});
		tabGosuList.repaint();
	}

}
