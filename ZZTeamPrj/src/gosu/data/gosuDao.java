package gosu.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import gosu.view.MainView;


public class gosuDao {

	private Connection conn = null;
	MainView mainview = null;



	public gosuDao() {
		conn = dbConn.getInstace();
	}

	public void close() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	// 회원가입
	public int insertMember(String u_id, String u_pw, String u_name, String u_phone, String u_email, String u_gender,
			String u_sido, String u_gugun) {
		String sql1 = "INSERT INTO USERLIST (U_ID,USERPW,USERNAME,PHONE,EMAIL,GENDER,U_SIDO,U_GUGUN)"
				+ "    VALUES (?,?,?,?,?,?,?,?) ";
		String sql2 = "   INSERT INTO GOSU (G_NUM,U_ID) VALUES ('G'||GOSU_SEQ.NEXTVAL,?) ";

		int aftcnt = 0;

		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2= null;
		try {
			pstmt1 = conn.prepareStatement(sql1);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt1.setString(1, u_id);
			pstmt1.setString(2, u_pw);
			pstmt1.setString(3, u_name);
			pstmt1.setString(4, u_phone);
			pstmt1.setString(5, u_email);
			pstmt1.setString(6, u_gender);
			pstmt1.setString(7, u_sido);
			pstmt1.setString(8, u_gugun);
			pstmt2.setString(1, u_id);

			aftcnt = pstmt1.executeUpdate();
			aftcnt = pstmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt1 != null)
				if (pstmt2 != null)
				pstmt1.close();
			pstmt2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aftcnt;
	}

	public int insertMember(userVo vo) {

		String id = vo.getId();
		String pw = vo.getPw();
		String name = vo.getName();
		String phone = vo.getPhone();
		String email = vo.getEmail();
		String gender = vo.getGender();
		String sido = vo.getSido();
		String gugun = vo.getGugun();

		int aftcnt = insertMember(id, pw, name, phone, email, gender, sido, gugun);
		return aftcnt;
	}

	public Vector<Vector> getUserList() {
		Vector<Vector> list = new Vector<Vector>();

		String sql = "SELECT U_ID,USERPW,USERNAME,EMAIL," + " GENDER,PHONE,U_SIDO,U_GUGUN " + "     FROM USERLIST ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("U_ID");
				String pw = rs.getString("USERPW");
				String name = rs.getString("USERNAME");
				String email = rs.getString("EMAIL");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String sido = rs.getString("U_SIDO");
				String gugun = rs.getString("U_GUGUN");

				Vector v = new Vector();
				v.add(id);
				v.add(pw);
				v.add(name);
				v.add(email);
				v.add(gender);
				v.add(phone);
				v.add(sido);
				v.add(gugun);

				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 고수리스트 테이블 데이터
	public Vector<Vector> getGosuList() {
		Vector<Vector> list = new Vector<Vector>();
		userVo vo = new userVo();

		String sql = "";
		sql += "SELECT W_NUM                             W_NUM , ";
		sql += "       ML.MID_NAME                       MID_NAME, ";
		sql += "       USERNAME                          USERNAME, ";
		sql += "       PRICE                             PRICE, ";
		sql += "       U.U_SIDO || ' ' ||  U. U_GUGUN    ADDR  ";
		sql += "  FROM GWORK GW LEFT JOIN GOSU G ";
		sql += "  ON   GW.G_NUM = G.G_NUM LEFT JOIN USERLIST U ";
		sql += "  ON   U.U_ID = G.U_ID LEFT JOIN MIDLIST ML ";
		sql += "  ON GW.MID_NUM = ML.MID_NUM LEFT JOIN BIGLIST BL ";
		sql += "  ON ML.BI_NUM = BL.BI_NUM ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String w_num = rs.getString("W_NUM");
				String mid_name = rs.getString("MID_NAME");
				String username = rs.getString("USERNAME");
				String price = rs.getString("PRICE");
				String addr = rs.getString("ADDR");

				Vector v = new Vector();
				v.add(w_num);
				v.add(mid_name);
				v.add(username);
				v.add(price);
				v.add(addr);
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}

		}
		return list;

	}



	public Vector<Vector> getSelGosuList(String bigSelect) {
		Vector<Vector> list = new Vector<Vector>();
		System.out.println(bigSelect);
		String sql = "";
		sql += "SELECT W_NUM                             W_NUM , ";
		sql += "       ML.MID_NAME                       MID_NAME, ";
		sql += "       U.USERNAME                          USERNAME, ";
		sql += "       PRICE                             PRICE, ";
		sql += "       U.U_SIDO || ' ' ||  U. U_GUGUN    ADDR  ";
		sql += "  FROM GWORK GW LEFT JOIN GOSU G ";
		sql += "  ON   GW.G_NUM = G.G_NUM LEFT JOIN USERLIST U ";
		sql += "  ON   U.U_ID = G.U_ID LEFT JOIN MIDLIST ML ";
		sql += "  ON GW.MID_NUM = ML.MID_NUM LEFT JOIN BIGLIST BL ";
		sql += "  ON ML.BI_NUM = BL.BI_NUM ";
		if(!bigSelect.equals("전체")) 
			sql += "  WHERE BL.BI_NAME = ? ";


		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			if(!bigSelect.equals("전체"))
			pstmt.setString(1,  bigSelect); 

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String w_num = rs.getString("W_NUM");
				String mid_name = rs.getString("MID_NAME");
				String username = rs.getString("USERNAME");
				String price = rs.getString("PRICE");
				String addr = rs.getString("ADDR");

				Vector v = new Vector();
				v.add(w_num);
				v.add(mid_name);
				v.add(username);
				v.add(price);
				v.add(addr);
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}

		}
		return list;

	}


	public Vector<Vector> getFAQList() {
		Vector<Vector> list = new Vector<Vector>();

		String sql = "SELECT FAQ_CODE, U_ID, F_DATE, F_HEAD, F_BODY, REPLY, F_CHECK " + "     FROM FAQ ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				String faqcode = rs.getString("FAQ_CODE");
				String u_id = rs.getString("U_ID");
				String f_date = rs.getString("F_DATE");
				String f_head = rs.getString("F_HEAD");
				String f_body = rs.getString("F_BODY");
				String reply = rs.getString("REPLY");
				String check = rs.getString("F_CHECK");

				Vector v = new Vector();
				v.add(faqcode);
				v.add(u_id);
				v.add(f_date);
				v.add(f_head);
				v.add(f_body);
				v.add(reply);
				v.add(check);

				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}

		}
		return list;
	}

	public userVo getUser(String id) {

		userVo vo = null;
		String sql = "SELECT U_ID,USERPW,USERNAME,EMAIL," + " GENDER,PHONE,U_SIDO,U_GUGUN " + "     FROM USERLIST "
				+ "   WHERE U_ID = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				String uid = rs.getString("U_ID");
				String pw = rs.getString("USERPW");
				String pw2= rs.getString("USERPW");
				String name = rs.getString("USERNAME");
				String email = rs.getString("EMAIL");
				String gender = rs.getString("GENDER");
				String phone = rs.getString("PHONE");
				String sido = rs.getString("U_SIDO");
				String gugun = rs.getString("U_GUGUN");

				vo = new userVo(uid, pw, pw2 ,name, phone, email, gender,sido, gugun);
//				System.out.println(email);
//				System.out.println(phone);
//				System.out.println(gender);
//				vo = new userVo();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}

		}
		return vo;
	}

	// 대분류 목록 가져오기
	public Vector<String> getBigList() {
		Vector<String> list = new Vector<String>();
		list.add("전체");

		String sql = "";
		sql += "SELECT BI_NAME FROM BIGLIST";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String bigList = rs.getString("BI_NAME");
				list.add(bigList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}

		}
		return list;
	}

	public boolean loginCheck(String Uid, String Upw) {
		boolean flag = false;


		String sql = "SELECT USERPW "
				+ "    FROM USERLIST "
				+ "    WHERE U_ID   = ?  ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Uid);
			rs = pstmt.executeQuery();
			System.out.println("아이디를 확인하세요");
			while (rs.next()) {
				if (Upw.equals(rs.getString("USERPW"))) {
					flag = true;
					System.out.println("비밀번호 일치");
				} else {
					flag = false;
					System.out.println("비밀번호 불일치");
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}

		}
		return flag;
	}
	public  ArrayList<String> allSido(){
		ArrayList<String> sidoData = new ArrayList<String>();

		String sql = "SELECT DISTINCT SIDO  FROM POST";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();

			while(rs.next()) {
				sidoData.add(rs.getString("SIDO"));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null)conn.close();
			if(rs != null)rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return sidoData;
	}
	public ArrayList<String> allGugun(String sido){
		ArrayList<String> gugunData = new ArrayList<String>();

		String sql = "SELECT DISTINCT GUGUN  FROM POST WHERE SIDO = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt =	conn.prepareStatement(sql);
			pstmt.setString(1, sido);
			rs= pstmt.executeQuery();

			while(rs.next()) {
				gugunData.add(rs.getString("GUGUN"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null)conn.close();
			if(rs != null)rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return gugunData;
	}

	public class GugunComboBoxModel extends DefaultComboBoxModel<String> {
		ArrayList<String> datas = new ArrayList<String>();


		public GugunComboBoxModel(String sido) {
			gosuDao dao = new gosuDao();
			datas = dao.allGugun(sido);
		}

		@Override
		public int getSize() {

			return datas.size();
		}

		@Override
		public String getElementAt(int index) {
			return datas.get(index);
		}
		public class sidoComboBoxModel extends DefaultComboBoxModel<String> {
			ArrayList<String> datas1= new ArrayList<String>();

			public sidoComboBoxModel() {
				gosuDao dao = new gosuDao();
				datas1 = dao.allSido();
			}

			@Override
			public int getSize() {

				return datas1.size() ;
			}

			@Override
			public String getElementAt(int index) {
				return datas1.get(index);
			}

		}
	}

	// 회원 거래요청서에서 거래리스트에 저장
				public int addgeorae(String g_code, String g_num, String g_start, String g_end,  String m_message, String g_message, String g_check)
				
				{				String sql = "INSERT INTO GEORAE "
						+ "   ( GEORAE_CODE, W_NUM, G_START, G_END, M_MESSAGE, G_MESSAGE, G_CHECK, U_ID ) "
						+ "     VALUES( 'GR'|| LPAD(G_SEQ.nextval,4,0),"
						+ "      (SELECT GW.W_NUM FROM GOSU GS JOIN GWORK GW ON GS.G_NUM = GW.G_NUM"		
						+ "       WHERE GS.U_ID = ? ),"
						+ "               ?, ?, ?, '-', '요청중', ?) ";
				
			    
				int aftcnt = 0;

				
				PreparedStatement pstmt1 = null;


				try {

					pstmt1 = conn.prepareStatement(sql);
								
					pstmt1.setString(1, g_num);
					pstmt1.setString(2, g_start);
					pstmt1.setString(3, g_end);
					pstmt1.setString(4, m_message);
					pstmt1.setString(5, g_code);
					
					aftcnt = pstmt1.executeUpdate();	

				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						
						if(pstmt1 != null) pstmt1.close();

					} catch (SQLException e) {

					}
				}
				return  aftcnt;


				}
				public int addgeorae(georaeVo2 vo) {		
					
					String   g_code     = vo.getG_code();
					String   g_num      = vo.getG_num();
					String   g_start    = vo.getG_start();
					String   g_end      = vo.getG_end();
					String   m_message  = vo.getM_message();
					String   g_message  = vo.getG_message();
					String   g_check    = vo.getG_check();
				

					int aftcnt = addgeorae(g_code, g_num, g_start, g_end, m_message, g_message, g_check);				
					return aftcnt;				
				}
	// 회원 거래요청서에서 메시지 리스트에 저장
	public int select(String g_code, String messnum, String mread, String m_date, String title) {

		String sql = " INSERT INTO MESSAGE " 
				+ " (GEORAE_CODE, MESSNUM, MREAD, M_DATE, TITLE) "
				+ "  VALUES ( (SELECT NVL(MAX(GEORAE_CODE), 0) FROM GEORAE), M_SEQ.nextval, '읽지않음', SYSDATE, '거래요청서') ";

		int afcnt = 0;
		PreparedStatement pstmt = null;


		try {
			pstmt = conn.prepareStatement(sql);			
			afcnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();

			} catch (SQLException e) {

			}
		}
		return afcnt;

	}
	 
	public int select(georaeVo vo) {				

		String   g_code     = vo.getG_code();
		String   messnum    = vo.getMessnum();
		String   mread      = vo.getMread();
		String   m_date     = vo.getM_date();
		String   title      = vo.getTitle();

		int aftcnt = select(g_code, messnum, mread, m_date, title);
		return aftcnt;				
	}	

	// 회원 거래요청 취소
	public int delete(georaeVo vo) {
		String sql =  " DELETE FROM GEORAE "
				+ " WHERE GEORAE_CODE = (SELECT NVL(MAX(GEORAE_CODE), 0) FROM GEORAE) ";

		int afcnt = 0;
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);			
			afcnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();

			} catch (SQLException e) {

			}
		}
		return afcnt;

	}

	// 고수 거래요청서에 뜨는 내용
		public georaeVo getGeorae(String g_code) {

			georaeVo  vo = null;
			String sql = ""; 
			sql += " SELECT G.GEORAE_CODE, M.MID_NAME, ";
			sql += "        GR.G_START || '~' || GR.G_END,   G.G_START,   G.G_END,    GW.WSIDO, ";
			sql += "        GW.WGUGUN,  G.U_ID, G.M_MESSAGE";
			sql += " FROM   GEORAE G ";
			sql += " JOIN   GWORK GW ON G.W_NUM = GW.W_NUM ";
			sql += " JOIN   GOSU GS ON GS.G_NUM = GW.G_NUM ";
			sql += " JOIN   MIDLIST M ON GW.MID_NUM = M.MID_NUM ";
			sql += " WHERE  G.GEORAE_CODE = '"+ g_code +"'";

			PreparedStatement pstmt  =  null;
			ResultSet         rs     =  null;

			try {
				pstmt =  conn.prepareStatement(sql);
				rs    =  pstmt.executeQuery();

				if( rs.next() ) {	
					String  g_code2   = rs.getString(1);
					String  mid_name  = rs.getString(2);
					String  gdate     = rs.getString(3);
					String  g_start   = rs.getString(4);
					String  g_end     = rs.getString(5);
					String  wsido     = rs.getString(6);
					String  wgugun    = rs.getString(7);
					String  g_name    = rs.getString(8);
					String  m_message = rs.getString(9);
					
					

					vo = new georaeVo(g_code2, mid_name, gdate, g_start, g_end, wsido, wgugun, g_name, m_message);				
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs    != null)   rs.close();
					if(pstmt != null)   pstmt.close();
				} catch (SQLException e) {		
				}
			}		

			return    vo;


		}

	// 고수 거래요청서 답장에서 거래리스트에 저장(수정)
	public int surakgeorae(updateVo vo) {
		System.out.println("수정전:" + vo);	

		String   sql    = "UPDATE GEORAE SET "
				+ " G_MESSAGE          = ?, "
				+ " G_CHECK            = '거래중' "
				+  " WHERE GEORAE_CODE = ? " ;

		int aftcnt = 0;
		PreparedStatement pstmt  = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getG_message());
			pstmt.setString(2, vo.getG_code());

			aftcnt = pstmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
			}
		}
		return  aftcnt;
	}


	// 고수 거래요청서 답장에서 반송
	public int bansong(updateVo vo) {
		System.out.println("반송:" + vo);	

		String   sql    = "UPDATE GEORAE SET "
				+ " G_MESSAGE          = ?, "
				+ " G_CHECK            = '반송' "
				+  " WHERE GEORAE_CODE = ? " ;

		int aftcnt = 0;
		PreparedStatement pstmt  = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getG_message());
			pstmt.setString(2, vo.getG_code());

			aftcnt = pstmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
			}
		}
		return  aftcnt;
	}

	// 메시지 테이블 데이터
	public Vector<Vector> getMsgList(String uid) {
		Vector<Vector> list = new Vector<Vector>();
		String sql = "SELECT ME.GEORAE_CODE GEORAE_CODE,  "
				   + "		UL.USERNAME    USERNAME,  "
				   + "		GR.G_CHECK     G_CHECK,  "
				   + "		ME.M_DATE      M_DATE  "
				   + "FROM  MESSAGE ME LEFT JOIN GEORAE GR  "
				   + "ON    ME.GEORAE_CODE = GR.GEORAE_CODE LEFT JOIN GOSU GS "
				   + "ON    ME.G_NUM = GS.G_NUM LEFT JOIN USERLIST UL "
				   + "ON    GS.U_ID = UL.U_ID  "
				   + "WHERE ME.U_ID = ? "
				   + "UNION "
				   + "SELECT ME.GEORAE_CODE GEORAE_CODE,  "
				   + "		UL2.USERNAME    USERNAME,  "
				   + "		GR.G_CHECK     G_CHECK,  "
				   + "		ME.M_DATE      M_DATE  "
				   + "FROM  MESSAGE ME LEFT JOIN GEORAE GR  "
				   + "ON    ME.GEORAE_CODE = GR.GEORAE_CODE LEFT JOIN GOSU GS "
				   + "ON    ME.G_NUM = GS.G_NUM LEFT JOIN USERLIST UL "
				   + "ON    GS.U_ID = UL.U_ID LEFT JOIN USERLIST UL2 "
				   + "ON    ME.U_ID = UL2.U_ID "
				   + "WHERE UL.U_ID = ? ";
	

		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);
			psmt.setString(2, uid);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String georae_code = rs.getString("GEORAE_CODE");
				String username = rs.getString("USERNAME");
				String g_check = rs.getString("G_CHECK");
				String m_date = rs.getString("M_DATE");

				Vector v = new Vector();
				v.add(georae_code);
				v.add(username);
				v.add(g_check);
				v.add(m_date);

				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(psmt!=null)psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	public static void main(String[] args) {
		System.out.println();
	}

	// 마이페이지 테이블 데이터
	public Vector<Vector> getmylist(String select, String uid) {
		Vector<Vector> list = new Vector<Vector>( );
		System.out.println(select+"임당");
		String sql = " SELECT GR.GEORAE_CODE                GEORAE_CODE, "
				   + "        BL.BI_NAME                    BI_NAME, "
				   + "        ML.MID_NAME                   MID_NAME, ";
				   if(select.equals("고수")) {
	  	      sql += "        UL.USERNAME                   USERNAME, "; } // 본인이 고수일때
				   else {
			  sql += "        UL2.USERNAME                   USERNAME, "; }
			  sql += "        GR.G_START || '~' || GR.G_END                     GDATE, "
				   + "        GW.PRICE                      PRICE, "
				   + "        NVL(GR.G_CHECK, '업무대기중') G_CHECK, "
				   + "        EV.G_SCORE                    G_SCORE "
				   + "  FROM  GEORAE GR FULL JOIN GWORK GW "
				   + "  ON    GR.W_NUM = GW.W_NUM FULL JOIN GOSU GS "
				   + "  ON    GW.G_NUM = GS.G_NUM LEFT JOIN MIDLIST ML "
				   + "  ON    GW.MID_NUM = ML.MID_NUM LEFT JOIN BIGLIST BL "
				   + "  ON    ML.BI_NUM = BL.BI_NUM LEFT JOIN USERLIST UL "
				   + "  ON    GR.U_ID = UL.U_ID LEFT JOIN EVALUATION EV "
				   + "  ON    GS.U_ID = EV.U_ID LEFT JOIN USERLIST UL2 "
				   + "  ON    GS.U_ID = UL2.U_ID";
				   if(select.equals("고수")) {
      		  sql += "  WHERE UL2.U_ID = ?"; }       //본인이 고수일때
				   else { 
			  sql += "  WHERE UL.U_ID = ?";  // 본인이 회원일때
				   }
		

		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String georae_code = rs.getString("GEORAE_CODE");
				String bi_name = rs.getString("BI_NAME");
				String mid_name = rs.getString("MID_NAME");
				String username = rs.getString("USERNAME");
				String gdate = rs.getString("GDATE");
				String price = rs.getString("PRICE");
				String g_check = rs.getString("G_CHECK");
				String g_score = rs.getString("G_SCORE");

				Vector v = new Vector();
				v.add(georae_code);
				v.add(bi_name);
				v.add(mid_name);
				v.add(username);
				v.add(gdate);
				v.add(price);
				v.add(g_check);
				v.add(g_score);

				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(psmt!=null)psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	// 수락페이지조회
	public gosuVo2 getMember(String georae_code) {

		gosuVo2 vo2 = null;

		String sql = " SELECT GE.GEORAE_CODE, U.USERNAME, M.MID_NAME, GE.G_DATE, GW.SDATE, GE.G_CHECK, GW.PRICE, GO.U_ID \r\n"
				+ "FROM   GEORAE GE , GOSU GO, MIDLIST M, GWORK GW, USERLIST U\r\n" + "WHERE  U.U_ID = GO.U_ID\r\n"
				+ "AND    GO.G_NUM = GW.G_NUM\r\n" + "AND    GW.MID_NUM = M.MID_NUM\r\n"
				+ "AND    GW.W_NUM  = GE.W_NUM\r\n" + "AND    GE.GEORAE_CODE = ? ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, georae_code);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String ogeorae_code = rs.getString("GEORAE_CODE");
				String username = rs.getString("USERNAME");
				String mid_name = rs.getString("MID_NAME");
				String g_date = rs.getString("G_DATE");
				String sdate = rs.getString("SDATE");
				String g_check = rs.getString("G_CHECK");
				String price = rs.getString("PRICE");
				String u_id = rs.getString("U_ID");
				

				vo2 = new gosuVo2(ogeorae_code, username, mid_name, g_date, sdate, g_check, price,u_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}

		return vo2;
	}
	// 거래 리뷰,스코어
	public int insertGereo(String gereo_code,String review, String score,String u_id) {

		String sql = "INSERT INTO EVALUATION(REVIEW_CODE,GEORAE_CODE, REVIEW,G_SCORE,U_ID) VALUES (\r\n"
				+ "REVIEW_CODE.NEXTVAL,?   ,?,TO_NUMBER(?),? )" ;
				

		PreparedStatement pstmt = null;
		int aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gereo_code);
			pstmt.setString(2, review);
			pstmt.setString(3, score);
			pstmt.setString(4, u_id);
			
		

			aftcnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}
		return aftcnt;
	}

	public int insertGereo(gosuVo2 vo2) {
		String review = vo2.getReview();
		String score  = vo2.getScore();
		String u_id  =  vo2.getU_id();
		String gereo_code = vo2.getGeorae_code();
		
		int aftcnt = insertGereo(gereo_code,review, score,u_id);
		return aftcnt;
	}

	
	

	// FAQ등록
	public int insertFAQ(String u_id, String f_head, String f_body, String reply) {

		String sql = " INSERT INTO FAQ(FAQ_CODE,U_ID, F_DATE, F_HEAD, F_BODY, REPLY, F_CHECK) VALUES(\r\n"
				+ " FAQ_CODE.NEXTVAL , (SELECT U.U_ID FROM USERLIST U WHERE U.U_ID = ? ) , SYSDATE , ?, ?, ?, 'N'                   \r\n"
				+ ") ";

		PreparedStatement pstmt = null;
		int aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_id);
			pstmt.setString(2, f_head);
			pstmt.setString(3, f_body);
			pstmt.setString(4, reply);

			aftcnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}
		return aftcnt;
	}

	public int insertFAQ(gosuVo3 vo) {
		String u_id = vo.getU_id();
		String f_head = vo.getF_head();
		String f_body = vo.getF_body();
		String reply = vo.getReply();

		int aftcnt = insertFAQ(u_id, f_head, f_body, reply);
		return aftcnt;
	}
	// FAQ 리스트 회원용
	public Vector<Vector> getHList(String uid) {
		Vector<Vector> list = new Vector<Vector>(); // 조회된 결과전체 대응 : rs

		String sql = "SELECT F.U_ID, F.FAQ_CODE, F.F_HEAD , F.F_BODY, F.F_CHECK\r\n" + "FROM   FAQ F, USERLIST U\r\n"
				+ " WHERE  F.U_ID = U.U_ID\r\n"
				+ "AND  U.U_ID = ?\r\n";
		// userid 같을때

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String u_id = rs.getString("U_ID");
				String faq_code = rs.getString("FAQ_CODE");
				String f_head = rs.getString("F_HEAD");
				// 1: 칼럼번호(1~)
				String f_body = rs.getString("F_BODY"); // 2
				String f_check = rs.getString("F_CHECK"); // 3
				// 4

				// 5

				Vector v = new Vector(); // 안쪽 Vector : 한 줄 Row 를 의미
				v.add(u_id);
				v.add(faq_code);
				v.add(f_head);
				v.add(f_body);
				v.add(f_check);

				list.add(v); // 전체 목록에 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}

		return list;

	}
	// FAQ 클릭시 불러오기
	public gosuVo3 getFaq(String u_id) {

		gosuVo3 vo3 = null;

		String sql = " SELECT U_ID,FAQ_CODE, F_HEAD , F_BODY, REPLY\r\n" + " FROM   FAQ\r\n" + " WHERE  U_ID = ? ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				String ofaq_code = rs.getString("U_ID");
				String f_head = rs.getString("F_HEAD");
				String f_body = rs.getString("F_BODY");
				String reply = rs.getString("REPLY");
				String faq_code = rs.getString("FAQ_CODE");

				vo3 = new gosuVo3(ofaq_code, f_head, f_body, reply, faq_code);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}

		return vo3;
	}

	public userVo getId(String name, String phone, String email) {

		userVo id = null;
		String sql = "SELECT U_ID FROM USERLIST " + "   WHERE USERNAME = ? " + "     AND    PHONE = ? "
				+ "     AND    EMAIL = ? ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			pstmt.setString(3, email);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				String uid = rs.getString("U_ID");
			
				id = new userVo(uid);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if 
					(rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}

		
		}
		if(id == null)
		JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.", "아이디 확인", JOptionPane.WARNING_MESSAGE);
		return id;
	}

	public userVo getPw(String id, String name, String phone, String email) {
		userVo pw = null;
		String sql = "SELECT USERPW FROM USERLIST " + "   WHERE     U_ID = ? " + "     and USERNAME = ? "
				+ "     AND    PHONE = ? " + "     AND    EMAIL = ? ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			pstmt.setString(4, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				String upw = rs.getString("USERPW");

				pw = new userVo(upw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}

		}
		if(pw == null)
			JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.", "아이디 확인", JOptionPane.WARNING_MESSAGE);
		return pw;
	}

	public int deleteUser(String id) {
		String sql1 = "DELETE FROM USERLIST "
				+ "    WHERE U_ID =  ? ";
		
		PreparedStatement pstmt1 = null;
		int aftcnt = 0;
		try {
			pstmt1 = conn.prepareStatement(sql1);
			
			pstmt1.setString(1, id);
		
			aftcnt = pstmt1.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt1 != null)
					pstmt1.close();
				
			} catch (SQLException e) {
			}
		}
		return aftcnt;
	}

	public int deleteGosu(String wnum) {
		String sql = "";
		sql += "DELETE FROM  GWORK";
		sql += " WHERE W_NUM = ? ";

		PreparedStatement pstmt = null;
		int aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, wnum);
			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}
		return aftcnt;
	}

	public int updateMember(faqVo vo) {
		String  sql = "UPDATE FAQ "
				+ "       SET REPLY = ?, "
				+ "           F_CHECK = 'O'"
				+ "     WHERE U_ID  = ? ";
	
		int  aftcnt  = 0;
		PreparedStatement  pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getRep() );
			pstmt.setString(2, vo.getId() );
			
			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null ) pstmt.close();
			} catch (SQLException e) {			
			}
		}		
		return aftcnt;


	}

	public int editUser() {
		return 0;
	}
	// 회원 수정
	public int editUser(userVo vo) {
		int aftcnt = 0;
		String  sql = "";
		sql     +=" UPDATE USERLIST "
				+ "  SET   USERPW   = ?, "
				+ "        USERNAME = ?, "
				+ "        PHONE    = ?, "
				+ "        GENDER   = ?, "
				+ "        U_SIDO   = ?, "
				+ "        U_GUGUN  = ? "
				+ "  WHERE U_ID     = ? ";
		PreparedStatement  pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw() );
			pstmt.setString(2, vo.getName() );
			pstmt.setString(3, vo.getPhone() );
			pstmt.setString(4, vo.getGender() );
			pstmt.setString(5, vo.getSido() );
			pstmt.setString(6, vo.getGugun() );
			
			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null ) pstmt.close();
			} catch (SQLException e) {			
			}
		}		
		return aftcnt;
	}
	// 회원수정
	public int updateMember(userVo vo) {
		String sql = "UPDATE USERLIST  "
				+ "SET    USERPW = ?, "
				+ "       USERNAME = ?, "
				+ "       EMAIL = ?, "
				+ "       GENDER = ?, "
				+ "       PHONE = ?, "
				+ "       U_SIDO = ?, "
				+ "       U_GUGUN = ? "
				+ "WHERE  U_ID = ?";

		int aftcnt = 0;

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getGender());
			pstmt.setString(5, vo.getPhone());
			pstmt.setString(6, vo.getSido());
			pstmt.setString(7, vo.getGugun());
			pstmt.setString(8, vo.getId());
			System.out.println("안녕??"+vo.getId());
			System.out.println("안녕??"+vo.getGugun());

			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
			}
		}return aftcnt;
	}

	public int ddeleteUser(String uid) {
		String  sql = "DELETE FROM USERLIST "
				    + "WHERE U_ID = ? ";
	
		
		PreparedStatement  pstmt  = null ;
		int                aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			
			aftcnt = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)  pstmt.close();
			} catch (SQLException e) {
			}
		}
		return aftcnt;
	}

	public String getUserAddress(String uid) {
		String addr = null;
		String  sql = " SELECT U_SIDO||U_GUGUN "
				    + "  FROM  USERLIST "
				    + "  WHERE U_ID = ? ";

	
	PreparedStatement  pstmt  = null ;
	ResultSet rs = null;
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, uid);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		addr = rs.getString(1);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		} catch (SQLException e) {
		}
	}
	return addr;
	}

//	public int updateMember(userVo vo) {
//
//		String id = vo.getId();
//		String pw = vo.getPw();
//		String name = vo.getName();
//		String phone = vo.getPhone();
//		String email = vo.getEmail();
//		String gender = vo.getGender();
//		String sido = vo.getSido();
//		String gugun = vo.getGugun();
//
//		int aftcnt = updateMember(id, pw, name, phone, email, gender, sido, gugun);
//		return aftcnt;
//	}
}			 





