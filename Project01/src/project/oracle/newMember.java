package project.oracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class newMember {
	private Connection conn;
public newMember() {
	conn = SQLconn.getInstace();
}
public void close() {
	try {
		if(conn != null)conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public int insertMember(String uphone, String rdate, String rtime, String rmemo, String pick, String location) {
	
	String sql = "INSERT INTO RESERVATE VALUES "
			+ " ( ? , ? , ? , ? , ? , ? ) ";
	
	PreparedStatement pstmt = null;
	int cnt = 0;
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, uphone);
		pstmt.setString(2, rdate);
		pstmt.setString(3, rtime);
		pstmt.setString(4, rmemo);
		pstmt.setString(5, pick);
		pstmt.setString(6, location);
		
		cnt = pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}try {
	if(pstmt != null)	pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return cnt;
}
public int insertMember(memberVo vo) {
	String phone    = vo.getUphone();
	String rdate    = vo.getRdate();
	String rtime    = vo.getRtime();
	String rmemo    = vo.getRmemo();
	String pick     = vo.getPick();
	String location = vo.getLocation();
	
	int cnt = insertMember(phone,rdate,rtime,rmemo,pick,location);
	return cnt;
}
public Vector<Vector> getList(){
	Vector<Vector> list = new Vector<Vector>();
	
	String sql ="SELECT U_PHONE, R_DATE , R_TIME, R_MEMO, PICKUP, LOCATION "
			+ " FROM RESERVATE ";
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		pstmt = conn.prepareStatement(sql);
		rs    = pstmt.executeQuery();
		
		while(rs.next()) {
			String uphone = rs.getString("U_PHONE");
			String rdate = rs.getString("R_DATE");
			String rtime = rs.getString("R_TIME");
			String rmemo = rs.getString("R_MEMO");
			String pickup = rs.getString("PICKUP");
			String location = rs.getString("LOCATION");
			
			
			Vector<Object> v = new Vector<>();
			v.add(uphone);
			v.add(rdate);
			v.add(rtime);
			v.add(rmemo);
			v.add(pickup);
			v.add(location);
			list.add(v);		
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		pstmt.close();
		rs.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return list;
}





}
