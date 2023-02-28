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
				   wsido1,
				   wsido2,
				   prMes;
	String endDate;
	String staDate;
	
	public Vo() {}

	public Vo(String bigList, String midList, String staDate, String endDate, String staTime, String endTime,
			String price, String wsido1,String wsido2, String prMes) {
		super();
		this.bigList = bigList;
		this.midList = midList;
		this.staDate = staDate;
		this.endDate = endDate;
		this.staTime = staTime;
		this.endTime = endTime;
		this.price = price;
		this.wsido1 = wsido1;
		this.wsido2 = wsido2;
		this.prMes = prMes;
	}

	//getter setter
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

	public String getStaDate() {
		return staDate;
	}

	public void setStaDate(String staDate) {
		this.staDate = staDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getWsido1() {
		return wsido1;
	}

	public void setWsido1(String wsido1) {
		this.wsido1 = wsido1;
	}

	public String getWsido2() {
		return wsido2;
	}

	public void setWsido2(String wsido2) {
		this.wsido2 = wsido2;
	}

	public String getPrMes() {
		return prMes;
	}

	public void setPrMes(String prMes) {
		this.prMes = prMes;
	}
	
	//toString
	@Override
	public String toString() {
		return "Vo [bigList=" + bigList + ", midList=" + midList + ", staDate=" + staDate + ", endDate=" + endDate
				+ ", staTime=" + staTime + ", endTime=" + endTime + ", price=" + price + ", wsido1=" + wsido1
				+ ", wsido2=" + wsido2 + ", prMes=" + prMes + "]";
	}
	
}
