package gosu.data;

public class gosuVo2 {
	String georae_code; 
	String gereo_code2;
	String u_name;
	String mid_name;
	String g_date;
	String sdate; 
	String g_check;
	String price;
	String review;
	String score;
	String u_id;
	String g_num;
	
	String faq_code;
	String f_date;
	String f_head;
	String f_body;
	String reply;
	String f_check;
	    
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
	
	public gosuVo2(String ofaq_code, String f_head, String f_body, String reply) {
		
	}
	
	public gosuVo2(String review, String score,String g_num) {
		this.review = review;
		this.score  = score;
		this.g_num = g_num;
	}

	public String getG_num() {
		return g_num;
	}
	public void setG_num(String g_num) {
		this.g_num = g_num;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getFaq_code() {
		return faq_code;
	}
	public void setFaq_code(String faq_code) {
		this.faq_code = faq_code;
	}
	public String getF_date() {
		return f_date;
	}
	public void setF_date(String f_date) {
		this.f_date = f_date;
	}
	public String getF_head() {
		return f_head;
	}
	public void setF_head(String f_head) {
		this.f_head = f_head;
	}
	public String getF_body() {
		return f_body;
	}
	public void setF_body(String f_body) {
		this.f_body = f_body;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getF_check() {
		return f_check;
	}
	public void setF_check(String f_check) {
		this.f_check = f_check;
	}
	public String getGereo_code2() {
		return gereo_code2;
	}
	public void setGereo_code2(String gereo_code2) {
		this.gereo_code2 = gereo_code2;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
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
		return "gosuVo2 [georae_code=" + georae_code + ", gereo_code2=" + gereo_code2 + ", u_name=" + u_name
				+ ", mid_name=" + mid_name + ", g_date=" + g_date + ", sdate=" + sdate + ", g_check=" + g_check
				+ ", price=" + price + ", review=" + review + ", score=" + score + ", u_id=" + u_id + ", faq_code="
				+ faq_code + ", f_date=" + f_date + ", f_head=" + f_head + ", f_body=" + f_body + ", reply=" + reply
				+ ", f_check=" + f_check + "]";
	}
	
	

	
	
	
	
}
