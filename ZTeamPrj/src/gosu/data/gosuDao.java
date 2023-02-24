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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
