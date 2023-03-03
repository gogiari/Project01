package gosu.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gosu.view.MainView;

public class messageDao {
	
	private Connection conn = null;
	MainView mainview = null;

	public messageDao() {
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
	
	public int mess(String g_code4, String messnum, String mread, String m_date) {
		
		System.out.println(g_code4);
		
		String sql = " INSERT INTO MESSAGE " 
				+ " (GEORAE_CODE, MESSNUM, MREAD, M_DATE) "
				+ "  VALUES ( (SELECT GEORAE_CODE FROM GEORAE WHERE GEORAE_CODE= '" + g_code4+ "' ),"
		        +              " M_SEQ.nextval, '읽지않음', SYSDATE) ";
		
		int aftcnt = 0;
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);			
			aftcnt = pstmt.executeUpdate();		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();

			} catch (SQLException e) {

			}
		}
		return aftcnt;

	}
	
	public int mess(updateVo vo) {
		
		String   g_code4    = vo.getG_code();
		String   messnum    = vo.getMessnum();
		String   mread      = vo.getMread();
		String   m_date     = vo.getM_date();
		
		int aftcnt = mess(g_code4, messnum, mread, m_date);
		return aftcnt;
	}





}
