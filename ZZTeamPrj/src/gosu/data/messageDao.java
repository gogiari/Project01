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
	
	// 메시지 수락시 추가
	public int mess(String g_code4, String messnum, String mread, String m_date, String title) {
		
		System.out.println(g_code4);
		
		String sql = " INSERT INTO MESSAGE " 
				+ " (GEORAE_CODE, MESSNUM, MREAD, M_DATE, TITLE) "
				+ "  VALUES ( (SELECT GEORAE_CODE FROM GEORAE WHERE GEORAE_CODE= '" + g_code4+ "' ),"
		        +              " M_SEQ.nextval, '읽지않음', SYSDATE, '거래 수락') ";
		
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
		String   title      = vo.getTitle();
		
		int aftcnt = mess(g_code4, messnum, mread, m_date, title);
		return aftcnt;
	}
	
	// 메시지 반송시
	public int mess2(String g_code4, String messnum, String mread, String m_date, String title) {
		
		System.out.println(g_code4);
		
		String sql = " INSERT INTO MESSAGE " 
				+ " (GEORAE_CODE, MESSNUM, MREAD, M_DATE, TITLE) "
				+ "  VALUES ( (SELECT GEORAE_CODE FROM GEORAE WHERE GEORAE_CODE= '" + g_code4 + "' ),"
		        +              " M_SEQ.nextval, '읽지않음', SYSDATE, '반송') ";
		
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
	
	public int mess2(updateVo vo) {
		
		String   g_code4    = vo.getG_code();
		String   messnum    = vo.getMessnum();
		String   mread      = vo.getMread();
		String   m_date     = vo.getM_date();
		String   title      = vo.getTitle();
		
		int aftcnt = mess2(g_code4, messnum, mread, m_date, title);
		return aftcnt;
	}
	
	// 결제페이지에서 결제 완료
	public int payment(gosuVo2 vo2) {
		System.out.println("결제:" + vo2);	

		String   sql    = "UPDATE GEORAE SET "
				+  " G_CHECK            = '결제' "
				+  " WHERE GEORAE_CODE = ? " ;

		int aftcnt = 0;
		PreparedStatement pstmt  = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo2.getGeorae_code());

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
	// 결제페이지에서 결제 완료시 메시지
		public int mess3(String g_code4, String messnum, String mread, String m_date, String title) {
			
			System.out.println(g_code4);
			
			String sql = " INSERT INTO MESSAGE " 
					+ " (GEORAE_CODE, MESSNUM, MREAD, M_DATE, TITLE) "
					+ "  VALUES ( (SELECT GEORAE_CODE FROM GEORAE WHERE GEORAE_CODE= '" + g_code4 + "' ),"
			        +              " M_SEQ.nextval, '읽지않음', SYSDATE, '결제완료') ";
			
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
		
		public int mess3(updateVo vo) {
			
			String   g_code4    = vo.getG_code();
			String   messnum    = vo.getMessnum();
			String   mread      = vo.getMread();
			String   m_date     = vo.getM_date();
			String   title      = vo.getTitle();
			
			int aftcnt = mess3(g_code4, messnum, mread, m_date, title);
			return aftcnt;
		}
		





}