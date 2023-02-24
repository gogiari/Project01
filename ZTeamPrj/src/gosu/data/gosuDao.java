package gosu.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class gosuDao {
	
		Connection conn = null;
	public gosuDao() {
		 conn = dbConn.getInstace();
	}
	public void close() {
		try {
			conn.close();
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
	public Vector<Vector> getClientList() {
		Vector<Vector>list = new Vector<Vector>();
		
		String sql = "SELECT "	; 
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
		    rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	String id = rs.getString("");
		    	String pw = rs.getString("");
		    	String name = rs.getString("");
		    	String email = rs.getString("");
		    	String gender = rs.getString("");
		    	String phone = rs.getString("");
		    	String sido = rs.getString("");
		    	String gugun = rs.getString("");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(pstmt != null)pstmt.close();
			if(rs    != null )rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
