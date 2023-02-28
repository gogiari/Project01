package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Dao {
	
	private Connection  conn = null;
	
	public Dao() {
		conn  =  DBConn.getInstance(); 
	}
	public  void close() {
		try {
			if(conn != null)  conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//고수 업무 등록 대분류값 출력
	public Vector<String> getExList() {
		
		//ExVo  exvo = null;
		Vector<String>  comlist = new Vector<String>();
		
		String  sql = "";
		sql += "SELECT  BI_NAME";
		sql += " FROM  BIGLIST";
		
		PreparedStatement pstmt  =  null;
		ResultSet         rs     =  null;
		
		try {
			pstmt =  conn.prepareStatement(sql);
			
			rs    =  pstmt.executeQuery();
			
			while( rs.next() ) { 
				String  exBig   = rs.getString("BI_NAME");        
				
				//exBig.substring(0, exBig.length() -1);
				System.out.print(exBig);
				
				Vector  v         = new Vector();  
				v.add( exBig );
				comlist.addAll( v ); 
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
		
		return comlist;
	}
	
	//고수업무등록 중분류 값 출력
	public Vector<String> getExList2(String bigCom) {
		
		//ExVo  exvo = null;
		Vector<String>  comlist = new Vector<String>();
		
		String  sql = "";
		sql += "SELECT  M.MID_NAME ";
		sql += "FROM MIDLIST M INNER JOIN BIGLIST B ON M.BI_NUM = B.BI_NUM ";
		sql += " WHERE  M.BI_NUM like ?";
		//sql += " WHERE  M.BI_NUM like '%'+ ? +'%' ";
		
		PreparedStatement pstmt  =  null;
		ResultSet         rs     =  null;
		
		try {
			pstmt =  conn.prepareStatement(sql);
			String names = "%"+bigCom+"%";
			pstmt.setString(1, names);
			rs    =  pstmt.executeQuery();
			
			while( rs.next() ) { 
				String  exMid   = rs.getString("MID_NAME");        
				
				Vector  v         = new Vector();  
				v.add( exMid );
				comlist.addAll( v ); 
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
		
		return comlist;
	}
	
	//고수 업무 리스트 primary key 
//	public String getGworkPK() {
//		String  gworPk = null;
//		String  sql = "";
//		sql += "SELECT  W_NUM ";
//		sql += "FROM GWORK ";
//		
//		PreparedStatement pstmt  =  null;
//		ResultSet         rs     =  null;
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rs    =  pstmt.executeQuery();
//			boolean rsLast = rs.last();
//			if( rsLast = true ) {				
//				gworPk = rs.getString("W_NUM");
//			}else {
//				gworPk = "W01";
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs    != null)   rs.close();
//				if(pstmt != null)   pstmt.close();
//			} catch (SQLException e) {		
//			}
//		}
//		return gworPk;
//	}
	
	//고수 업무 리스트 데이터 추가 
	public int insertGWORK(String midList, String price, String wsido, String prMes, String staDate, String endDate, String staTime, String endTime) {
		String sql = "";
		sql += "INSERT INTO GWORK (" ;
		sql += "    W_NUM, G_NUM, MID_NUM, PRICE, PRMESSAGE , SDATE, EDATE,  WSIDO) ";
		sql +=" VALUES ";
		sql +=" ( 'W-' || gwork_Num.NEXTVAL, ?, ?, ?, ?, ?, ? , ? )";
		
		String  sql2 = "";
		sql2 += "SELECT  MID_NUM ";
		sql2 += "FROM MIDLIST ";
		sql2 += " WHERE MID_NAME like ? ";
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet 	rs = null;
		int		aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt2 = conn.prepareStatement(sql2);
			
			String names = "%"+midList+"%";
			pstmt2.setString(1, names);
			rs = pstmt2.executeQuery();
			
			String midnum = null;
			if(rs.next()) {				
				midnum = rs.getString("MID_NUM");
			}
			
			pstmt.setString(1, "G01");
			pstmt.setString(2, midnum);
			pstmt.setString(3, price);
			pstmt.setString(4, prMes);
			
			pstmt.setString(5, prMes);
			pstmt.setString(6, prMes);0
			pstmt.setString(7, prMes);
			
			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return aftcnt;
	}

	public int insertGWORK(Vo vo) {
		String midList = vo.getMidList();
		String price = vo.getPrice();
		String wsido = vo.getWsido1();
		String prMes = vo.getPrMes();
		String staDate = vo.getStaDate();
		String endDate = vo.getEndDate();
		String staTime = vo.getStaTime();
		String endTime = vo.getEndTime();
		String wsido1 = vo.getWsido1();
		String wsido2 = vo.getWsido2();
	
		int aftcnt = insertGWORK(midList ,price, wsido, prMes, staDate, endDate, staTime, endTime);
		return aftcnt;
	}
	
	
}
