package model;

import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Vo {
	//user 입력 Fields
	private String bigList, 
				   midList,
				   staTime,
				   endTime,
				   price,
				   sido,
				   gugun,
				   prMes;
	String endDate;
	String staDate;
	String dateStr, dateEnd; // 데이터 날짜 값으로 변환 변수
	String uid;

	
	public Vo() {}

	public Vo(String uid, String bigList, String midList, String staDate, String endDate, String staTime, String endTime,
			String price, String sido, String gugun, String prMes, String dateStr, String dateEnd) {
		super();
		this.bigList = bigList;
		this.midList = midList;
		this.staDate = staDate;
		this.endDate = endDate;
		this.staTime = staTime;
		this.endTime = endTime;
		this.price = price;
		this.sido = sido;
		this.gugun = gugun;
		this.prMes = prMes;
		this.dateStr = dateStr;	
		this.dateEnd = dateEnd;
		this.uid = uid;
	}

	public String getBigList() {
		return bigList;
	}

	public void setBigList(String bigList) {
		this.bigList = bigList;
	}

	public String getMidList() {
		return midList;
	}

	public void setMidList(String midList) {
		this.midList = midList;
	}

	public String getStaTime() {
		return staTime;
	}

	public void setStaTime(String staTime) {
		this.staTime = staTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	public String getPrMes() {
		return prMes;
	}

	public void setPrMes(String prMes) {
		this.prMes = prMes;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStaDate() {
		return staDate;
	}

	public void setStaDate(String staDate) {
		this.staDate = staDate;
	}

	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Vo [bigList=" + bigList + ", midList=" + midList + ", staTime=" + staTime + ", endTime=" + endTime
				+ ", price=" + price + ", sido=" + sido + ", gugun=" + gugun + ", prMes=" + prMes + ", endDate="
				+ endDate + ", staDate=" + staDate + ", dateStr=" + dateStr + ", dateEnd=" + dateEnd + ", uid=" + uid
				+ "]";
	}

	
}
