package gosu.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class gosuDao {

	private Connection conn = null;

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
		String sql = "INSERT INTO USERLIST " + " (U_ID,USERPW,USERNAME,PHONE,EMAIL,GENDER,U_SIDO,U_GUGUN)" + " VALUES "
				+ "  (?,?,?,?,?,?,?,?)   ";

		int aftcnt = 0;

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_id);
			pstmt.setString(2, u_pw);
			pstmt.setString(3, u_name);
			pstmt.setString(4, u_phone);
			pstmt.setString(5, u_email);
			pstmt.setString(6, u_gender);
			pstmt.setString(7, u_sido);
			pstmt.setString(8, u_gugun);

			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null)
				pstmt.close();
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

	// Gosu Jtable에 보여줄 data목록
	public Vector<Vector> getGosuList() {
		Vector<Vector> list = new Vector<Vector>();

		String sql = "";
		sql += "SELECT W_NUM                             W_NUM , ";
		sql += "       ML.MID_NAME                       MID_NAME, ";
		sql += "       USERNAME                          USERNAME, ";
		sql += "       PRICE                             PRICE, ";
		sql += "       U.U_SIDO || ' ' ||  U. U_GUGUN    ADDR  ";
		sql += "  FROM GWORK GW LEFT JOIN GOSU G ";
		sql += "  ON   GW.G_NUM = G.G_NUM LEFT JOIN USERLIST U ";
		sql += "  ON   U.U_ID = G.U_ID LEFT JOIN MIDLIST ML ";
		sql += "  ON GW.MID_NUM = ML.MID_NUM";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

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

				vo = new userVo(uid, pw, pw2 ,name, email, gender, phone, sido, gugun);
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
		public int addgeorae(String g_code, String g_start, String g_end, String m_message, String g_message, String g_check)

		{	String sql = "INSERT INTO GEORAE "
				+ "   ( GEORAE_CODE, G_START, G_END, M_MESSAGE, G_MESSAGE, G_CHECK) "
				+ "     VALUES( 'GR'|| LPAD(G_SEQ.nextval,4,0), ?, ?, ?, '-', '요청중') ";


		int aftcnt = 0;

		PreparedStatement pstmt1 = null;


		try {
			pstmt1 = conn.prepareStatement(sql);

			pstmt1.setString(1, g_start);
			pstmt1.setString(2, g_end);
			pstmt1.setString(3, m_message);

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
		public int addgeorae(georaeVo vo) {				

			String   g_code     = vo.getG_code();
			String   g_start    = vo.getG_start();
			String   g_end      = vo.getG_end();
			String   m_message  = vo.getM_message();
			String   g_message  = vo.getG_message();
			String   g_check    = vo.getG_check();

			int aftcnt = addgeorae(g_code, g_start, g_end, m_message, g_message, g_check);
			return aftcnt;				
		}	
		
		// 회원 거래요청서에서 메시지 리스트에 저장
		public int select(String g_code, String messnum, String mread, String m_date) {

			String sql = " INSERT INTO MESSAGE " 
					+ " (GEORAE_CODE, MESSNUM, MREAD, M_DATE) "
					+ "  VALUES ( (SELECT NVL(MAX(GEORAE_CODE), 0) FROM GEORAE), M_SEQ.nextval, '읽지않음', SYSDATE) ";

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

			int aftcnt = select(g_code, messnum, mread, m_date);
			return aftcnt;				
		}	
		
		// 회원 거래요청 취소
			public int delete(georaeVo vo) {
				String sql =  " DELETE FROM GEORAE "
				            + " WHERE GEORAE_CODE= (SELECT NVL(MAX(GEORAE_CODE), 0) FROM GEORAE) ";
			
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

			String  sql = "";
			sql += " SELECT G.GEORAE_CODE, M.MID_NAME, ";
			sql += "        GW.GDATE,   G.G_START,   G.G_END,    GW.WSIDO, ";
			sql += "        GW.WGUGUN,  GU.USERNAME, G.M_MESSAGE ";
			sql += " FROM   GEORAE G ";
			sql += " JOIN   GWORK GW ON G.W_NUM = GW.W_NUM ";
			sql += " JOIN   GOSU GS ON GS.G_NUM = GW.G_NUM ";
			sql += " JOIN   USERLIST GU ON GU.U_ID = GS.U_ID ";
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
		public int surakgeorae(georaeVo vo) {
				
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

}
