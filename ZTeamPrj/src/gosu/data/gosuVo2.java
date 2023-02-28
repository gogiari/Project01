package gosu.data;

public class gosuVo2 {
	String georae_code; 
	String u_name;
	String mid_name;
	String g_date;
	String sdate; 
	String g_check;
	String price;
	
	public gosuVo2() {}
	public gosuVo2(String georae_code, String u_name, String mid_name, String g_date, String sdate, String g_check,
			String price) {
		
		this.georae_code = georae_code;
		this.u_name = u_name;
		this.mid_name = mid_name;
		this.g_date = g_date;
		this.sdate = sdate;
		this.g_check = g_check;
		this.price = price;
	}
	public String getGeorae_code() {
		return georae_code;
	}
	public void setGeorae_code(String georae_code) {
		this.georae_code = georae_code;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getMid_name() {
		return mid_name;
	}
	public void setMid_name(String mid_name) {
		this.mid_name = mid_name;
	}
	public String getG_date() {
		return g_date;
	}
	public void setG_date(String g_date) {
		this.g_date = g_date;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getG_check() {
		return g_check;
	}
	public void setG_check(String g_check) {
		this.g_check = g_check;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "gosuVo2 [georae_code=" + georae_code + ", u_name=" + u_name + ", mid_name=" + mid_name + ", g_date="
				+ g_date + ", sdate=" + sdate + ", g_check=" + g_check + ", price=" + price + "]";
	}
	
}
