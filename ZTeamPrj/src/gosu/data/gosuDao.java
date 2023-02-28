package gosu.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import gosu.data.gosuVo;



public class gosuDao {

	Connection conn = null;
	public gosuDao() {
		conn = dbConn.getInstace();
	}
	public void close() {
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 회원가입
	public int insertMember(String u_id, String u_pw, String u_name, String u_email,
			String u_gender, String u_phone, String u_sido, String u_gugun) {
		String sql = "INSERT INTO MEMBER "
				+ "   (?,?,?,?,?,?,?,?)   ";

		int aftcnt = 0;

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u_id);
			pstmt.setString(2, u_pw);
			pstmt.setString(3, u_name);
			pstmt.setString(4, u_email);
			pstmt.setString(5, u_gender);
			pstmt.setString(6, u_phone);
			pstmt.setString(7, u_sido);
			pstmt.setString(8, u_gugun);

			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pstmt != null)pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aftcnt;
	}

	public int insertMember(gosuVo vo) {

		String id = vo.getU_id();
		String pw = vo.getU_pw();
		String name = vo.getU_name();
		String email = vo.getU_email();
		String gender = vo.getU_gender();
		String phone = vo.getU_phone();
		String sido = vo.getU_sido();
		String gugun = vo.getU_gugun();

		int aftcnt = insertMember(id,pw,name,email,gender,phone,sido,gugun);
		return aftcnt;
	}
	
	//수락페이지조회
   public gosuVo2 getMember(String georae_code) {
		
		gosuVo2  vo2 = null;
			
		String  sql = " SELECT GE.GEORAE_CODE, U.USERNAME, M.MID_NAME, GE.G_DATE, GW.SDATE, GE.G_CHECK, GW.PRICE \r\n"
				+ "FROM   GEORAE GE , GOSU GO, MIDLIST M, GWORK GW, USERLIST U\r\n"
				+ "WHERE  U.U_ID = GO.U_ID\r\n"
				+ "AND    GO.G_NUM = GW.G_NUM\r\n"
				+ "AND    GW.MID_NUM = M.MID_NUM\r\n"
				+ "AND    GW.W_NUM  = GE.W_NUM\r\n"
				+ "AND    GE.GEORAE_CODE = ? ";
		
		PreparedStatement pstmt  =  null;
		ResultSet         rs     =  null;
		
		try {
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1, georae_code);
			
			rs    =  pstmt.executeQuery();
			
			if( rs.next() ) {
				String  ogeorae_code = rs.getString("GEORAE_CODE");
				String  username     = rs.getString("USERNAME");
				String  mid_name     = rs.getString("MID_NAME");
				String  g_date       = rs.getString("G_DATE");				
				String  sdate        = rs.getString("SDATE");
				String  g_check      = rs.getString("G_CHECK");
				String  price        = rs.getString("PRICE");				
				
				vo2   = new gosuVo2( ogeorae_code, username, mid_name, g_date , sdate, g_check, price);				
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
				
		return    vo2;
	}
	
	/*
    // 점수추가
	public int insertScore( String gscore) {
		
		String sql = "INSERT INTO GOSU (G_SCORE) VALUES ( ? ) ";

		PreparedStatement pstmt = null;
		int aftcnt = 0;
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gscore);
	
			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		try {
			if(pstmt != null)pstmt.close();
		} catch (SQLException e) {
		}
	}
		return aftcnt;
	}
	public int insertScore(gosuVo vo) {

		String gscore = vo.getG_score();
		

		int aftcnt = insertScore(gscore);
		return aftcnt;
	}
	*/
   
	// Gosu Jtable에 보여줄 data목록
	public Vector<Vector> getGosuList() {
		Vector<Vector> list = new Vector<Vector>();

		String sql = "";
		sql		  += "SELECT W_NUM        W_NUM , ";
		sql		  += "       MID_NUM      MID_NUM, ";
		sql		  +="        U.U_ID       U_ID, ";
		sql		  +="        PRICE        PRICE, ";
		sql		  += "       WGUGUN       WGUGUN ";
		sql		  += "  FROM GWORK GW LEFT JOIN GOSU G ";
		sql		  += "  ON   GW.G_NUM = G.G_NUM LEFT JOIN USERLIST U ";
		sql		  += "  ON   U.U_ID = G.U_ID ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				String w_num = rs.getString("W_NUM");
				String mid_num = rs.getString("MID_NUM");
				String u_id = rs.getString("U_ID");
				String price = rs.getString("PRICE");
				String wgugun = rs.getString("WGUGUN");

				Vector v = new Vector();
				v.add(w_num);
				v.add(mid_num);
				v.add(u_id);
				v.add(price);
				v.add(wgugun);
				list.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			} catch (SQLException e) {
			}

		}
		return list;

	}

	// 대분류 목록 가져오기
	public Vector<String> getBigList(){
		Vector<String> list = new Vector<String>();
		list.add("전체");

		String sql = "";
		sql       += "SELECT BI_NAME FROM BIGLIST";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String bigList = rs.getString("BI_NAME");
				list.add(bigList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			} catch (SQLException e) {
			}

		}
		return list;


	}

	
	
}
