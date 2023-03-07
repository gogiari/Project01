package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Dao {

	private Connection conn = null;

	public Dao() {
		conn = DBConn.getInstance();
	}

	public void close() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 고수 업무 등록 대분류값 출력
	public Vector<String> getExList() {

		// ExVo exvo = null;
		Vector<String> comlist = new Vector<String>();

		String sql = "";
		sql += "SELECT  BI_NAME";
		sql += " FROM  BIGLIST";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String exBig = rs.getString("BI_NAME");

				// exBig.substring(0, exBig.length() -1);
				Vector v = new Vector();
				v.add(exBig);
				comlist.addAll(v);
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

		return comlist;
	}

	// 고수업무등록 중분류 값 출력
	public Vector<String> getExList2(String bigCom) {

		// ExVo exvo = null;
		Vector<String> comlist = new Vector<String>();

		String sql = "";
		sql += "SELECT  M.MID_NAME ";
		sql += "FROM MIDLIST M INNER JOIN BIGLIST B ON M.BI_NUM = B.BI_NUM ";
		sql += " WHERE  M.BI_NUM like ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			String names = "%" + bigCom + "%";
			pstmt.setString(1, names);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String exMid = rs.getString("MID_NAME");

				Vector v = new Vector();
				v.add(exMid);
				comlist.addAll(v);
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

		return comlist;
	}
	
	//시 데이터 출력
//	public Vector<String> getExSi() {
//
//		Vector<String> comlist = new Vector<String>();
//
//		String sql = "";
//		sql += " SELECT SIDO";
//		sql += " FROM POST";
//
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				String exSi = rs.getString("SIDO");
//
//				Vector v = new Vector();
//				v.add(exSi);
//				comlist.addAll(v);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//			} catch (SQLException e) {
//			}
//		}
//
//		return comlist;
//	}
	
	//시 데이터 출력
//	public Vector<String> getExSi() {
//
//		Vector<String> comlist = new Vector<String>();
//
//		String sql = "";
//		sql += " SELECT SIDO_NAME";
//		sql += " FROM SIDO";
//
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				String exSi = rs.getString("SIDO_NAME");
//
//				System.out.print(exSi);
//
//				Vector v = new Vector();
//				v.add(exSi);
//				comlist.addAll(v);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//			} catch (SQLException e) {
//			}
//		}
//
//		return comlist;
//	}
	
	// 구군 데이터 출력
//	public Vector<String> getExGu(String si) {
//
//		Vector<String> comlist = new Vector<String>();
//
//		String sql = "";
//		sql += "SELECT G.GUGUN ";
//		sql += "FROM GUGUN G INNER JOIN SIDO S ON G.SIDO_NUM = S.SIDO_NUM ";
//		sql += " WHERE  S.SIDO_NAME like ?";
//
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			pstmt = conn.prepareStatement(sql);
//			String names = "%" + si + "%";
//			pstmt.setString(1, names);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				String exgu = rs.getString("GUGUN");
//
//				Vector v = new Vector();
//				v.add(exgu);
//				comlist.addAll(v);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//			} catch (SQLException e) {
//			}
//		}
//
//		return comlist;
//	}
	
	//고수등록 시 고수 번호 생성
	public int gosuNum(String uid) {
		String sql ="";
		sql += "SELECT U_ID ";
		sql += "FROM GOSU WHERE U_ID = ?" ;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			rs = pstmt.executeQuery();
											
			if(!rs.next()) {
				sql = "INSERT INTO GOSU(G_NUM, U_ID) VALUES('G-' || GOSU_Num.NEXTVAL, ?) ";
				pstmt.close();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, uid);
				aftcnt = pstmt.executeUpdate();
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
				e.printStackTrace();
			}
		}
		return aftcnt;
	}
	
	//고수 첫 등록 및 GWORK 고수번호 업데이트
	public void addGosuUp(String uid) {
		String sql ="";
		sql += "UPDATE GWORK ";
		sql += "SET G_NUM = (select G_NUM from GOSU where U_ID = ?) " ;
		sql += "WHERE U_ID = ? ";
		
		PreparedStatement pstmt = null;
		int aftcnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, uid);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	// 고수 업무 리스트 데이터 추가
	public int insertGWORK(String uid, String midList, String price, String wsido, String prMes, String staDate, String endDate,
							String staTime, String endTime, String dateStr, String dateEnd, String wsido2, String idCheck) {
		String sql = "";
		sql += "INSERT INTO GWORK (";
		sql += "  W_NUM, G_NUM , MID_NUM, PRICE, PRMESSAGE , SDATE, EDATE, WSIDO, WGUGUN, U_ID ) ";
		sql += " VALUES ";
		sql += " ( 'W-' || gwork_Num.NEXTVAL, ?, ?, ?, ?, TO_DATE(? , 'YYYY-MM-DD HH24:MI') , TO_DATE(? , 'YYYY-MM-DD HH24:MI'), ?, ?, ? ) ";

		String sql2 = "";
		sql2 += "SELECT  MID_NUM ";
		sql2 += "FROM MIDLIST ";
		sql2 += " WHERE MID_NAME like ? ";
		
		String sql3 = "";
		sql3 += "SELECT G_NUM ";
		sql3 += "FROM GOSU";
		sql3 += " WHERE U_ID = ? ";

		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;
		ResultSet rs3 = null;
		int aftcnt = 0;
		try {		
			//gosuNum(uid);
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);
			
			//중분류
			String names = "%" + midList + "%";
			pstmt2.setString(1, names);
			rs = pstmt2.executeQuery();

			String midnum = null;
			if (rs.next()) {
				midnum = rs.getString("MID_NUM");
			}
			//G_NUM
			pstmt3.setString(1, uid);
			rs3 = pstmt3.executeQuery();
			String gNum = null;
			if (rs3.next()) {
				gNum = rs3.getString("G_NUM");
			}
			
			pstmt.setString(1, gNum);
			pstmt.setString(2, midnum);
			pstmt.setString(3, price);
			pstmt.setString(4, prMes);

			pstmt.setString(5, dateStr);
			pstmt.setString(6, dateEnd);
			pstmt.setString(7, wsido);
			
			pstmt.setString(8, wsido2);
			pstmt.setString(9, uid);

			aftcnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return aftcnt;
	}

	// Jtable 에 보여줄 data 목록
	public Vector<Vector> getEditList(String userID) {
		Vector<Vector> list = new Vector<Vector>();
		String sql = "";
		sql += " SELECT W_NUM, M.MID_NAME, W.PRICE, W.SDATE, W.EDATE, W.WSIDO, W.WGUGUN ";
		sql += " FROM GWORK W INNER JOIN MIDLIST M ON W.MID_NUM = M.MID_NUM ";
		sql += " WHERE G_NUM IN ( SELECT G_NUM ";
		sql += "		  FROM GOSU ";
		sql += "	      WHERE U_ID = ? ) ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String wNum = rs.getString(1);
				String mName = rs.getString(2);
				String price = rs.getString(3);
				String sdate = rs.getString(4);
				String edate = rs.getString(5);
				String wsido = rs.getString(6);
				String wsido2 = rs.getString(7);
				
				String wsido3 = wsido + wsido2;
				Vector v = new Vector();
				v.add(wNum);
				v.add(mName);
				v.add(price);
				v.add(sdate);
				v.add(edate);
				v.add( wsido3);

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

	// 상세보기
	public Vector<String> getDataDetail(String getWnum) {

		Vector<String> comlist = new Vector<String>();

		String sql = "";
		sql += " SELECT B.BI_NAME, M.MID_NAME, W.SDATE, W.EDATE, W.PRICE, W.WSIDO, W.WGUGUN, W.PRMESSAGE ";
		sql += " FROM GWORK W INNER JOIN MIDLIST M ON W.MID_NUM = M.MID_NUM INNER JOIN BIGLIST B ON B.BI_NUM = M.BI_NUM ";
		sql += " WHERE W_NUM = ? ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, getWnum);
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String biName = rs.getString("BI_NAME");
				String midName = rs.getString("MID_NAME");
				String sDate = rs.getString("SDATE");
				String eDate = rs.getString("EDATE");
				String price = rs.getString("PRICE");
				String wSido = rs.getString("WSIDO");
				String gugun = rs.getString("WGUGUN");
				String prMess = rs.getString("PRMESSAGE");

				Vector v = new Vector();

				v.add(biName);
				v.add(midName);
				v.add(sDate);
				v.add(eDate);
				v.add(price);
				v.add(wSido);
				v.add(gugun);
				v.add(prMess);

				comlist.addAll(v);
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
		return comlist;
	}
	
	// 메인 상세보기
	public Vector<String> getMainDataDetail(String sel) {

		Vector<String> comlist = new Vector<String>();

		String sql = "";
		sql += "SELECT B.BI_NAME, M.MID_NAME, W.SDATE, W.EDATE, W.PRICE, W.WSIDO, W.PRMESSAGE, G.U_ID, U.USERNAME ,W.WGUGUN ";
		sql += " FROM USERLIST U INNER JOIN GOSU G ON U.U_ID = G.U_ID INNER JOIN GWORK W ON G.G_NUM = W.G_NUM INNER JOIN MIDLIST M ON W.MID_NUM = M.MID_NUM INNER JOIN BIGLIST B ON B.BI_NUM = M.BI_NUM ";
		sql += " WHERE W_NUM = ? ";
		
		String sql2 = "";
		sql2 += " SELECT E.G_SCORE ";
		sql2 += " FROM GWORK W INNER JOIN GOSU G ON W.G_NUM = G.G_NUM INNER JOIN EVALUATION E ON G.U_ID = E.U_ID ";
		sql2 += " WHERE W_NUM = ? ";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);

			pstmt.setString(1, sel);
			rs = pstmt.executeQuery();
			
			pstmt2.setString(1, sel);
			rs2 = pstmt2.executeQuery();
			
			if (rs.next()) {
				String biName = rs.getString("BI_NAME");
				String midName = rs.getString("MID_NAME");
				String sDate = rs.getString("SDATE");
				String eDate = rs.getString("EDATE");
				String price = rs.getString("PRICE");
				String wSido = rs.getString("WSIDO");
				String prMess = rs.getString("PRMESSAGE");
				String userid = rs.getString("U_ID");
				String username = rs.getString("USERNAME");
				String wgugun = rs.getString("WGUGUN");

				Vector v = new Vector();

				v.add(0,biName);
				v.add(1,midName);
				v.add(2,sDate);
				v.add(3,eDate);
				v.add(4,price);
				v.add(5,wSido);
				v.add(6,wgugun);
				v.add(7,prMess);
				v.add(8,userid);
				v.add(9,username);
				//평균값 v.add(username);
				
				comlist.addAll(v);
			}
			
//			if (rs2.next()) {
//				System.out.println("gs1 " + rs2.getString("G_SCORE"));
//				String GScore = rs2.getString("G_SCORE");
//				
//				System.out.println("gs " + GScore);
//				
//				comlist.add(10, GScore);
//				System.out.print(comlist);
//			}
			
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
		return comlist;
	}
	
	// 메인 상세보기2
	public Vector<String> getMainDataDetail2(String sel) {

		Vector<String> comlist = new Vector<String>();
		
		String sql2 = "";
		sql2 += " SELECT E.G_SCORE ";
		sql2 += " FROM GWORK W INNER JOIN GOSU G ON W.G_NUM = G.G_NUM INNER JOIN EVALUATION E ON G.U_ID = E.U_ID ";
		sql2 += " WHERE W_NUM = ? ";

		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		
		
		try {
			pstmt2 = conn.prepareStatement(sql2);
			
			pstmt2.setString(1, sel);
			rs2 = pstmt2.executeQuery();
			
			
			if (rs2.next()) {
				String GScore = rs2.getString("G_SCORE");
				Vector v = new Vector();

				v.add(GScore);
				
				comlist.addAll(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs2 != null)
					rs2.close();
				if (pstmt2 != null)
					pstmt2.close();
			} catch (SQLException e) {
			}
		}
		return comlist;
	}

	// 수정
	public int updateInfo(Vo vo, String Wnum) {
		String sql = "";
		sql += " UPDATE GWORK ";
		sql += " SET MID_NUM = (SELECT MID_NUM FROM MIDLIST WHERE MID_NAME like ?), "; //1 
		sql += " SDATE = TO_DATE(? , 'YYYY-MM-DD HH24:MI'), ";  //2
		sql += " EDATE = TO_DATE(? , 'YYYY-MM-DD HH24:MI'), ";  //3
		sql += " PRICE = ?, ";  //4
		sql += " WSIDO = ?, ";  //5
		sql += " WGUGUN = ?, ";  //6
		sql += " PRMESSAGE = ? ";  //7 
		sql += " WHERE W_NUM = ? ";  //7 8

		PreparedStatement pstmt = null;
		int  aftcnt  = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			String minNum = "%"+ vo.getMidList() +"%";
			pstmt.setString(1, minNum);
			pstmt.setString(2, vo.getDateStr());
			pstmt.setString(3, vo.getDateEnd());
			pstmt.setString(4, vo.getPrice());
			pstmt.setString(5, vo.getSido());
			pstmt.setString(6, vo.getGugun());
			pstmt.setString(7, vo.getPrMes());

			pstmt.setString(8, Wnum);
			
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
	
	//삭제
	public int removePrvGoList(String WNum ) {
		String sql = "";
		sql += "DELETE FROM GWORK ";
		sql += " WHERE W_NUM = ? ";
		
		PreparedStatement pstmt = null;
		int aftcnt = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, WNum);
			
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
	

	public int insertGWORK(Vo vo, String idCheck) {
		String midList = vo.getMidList();
		String price = vo.getPrice();
		String prMes = vo.getPrMes();
		String staDate = vo.getStaDate();
		String endDate = vo.getEndDate();
		String staTime = vo.getStaTime();
		String endTime = vo.getEndTime();
		String wsido1 = vo.getSido();
		String wsido2 = vo.getGugun();
		String dateStr = vo.getDateStr();
		String dateEnd = vo.getDateEnd();
		String uid = vo.getUid();
		
		int aftcnt = insertGWORK(uid, midList, price, wsido1, prMes, staDate, endDate, staTime, endTime, dateStr, dateEnd, wsido2 , idCheck);
		
		return aftcnt;
	}
	

}
