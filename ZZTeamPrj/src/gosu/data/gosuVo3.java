package gosu.data;

public class gosuVo3 {
	String faq_code;
	String f_date;
	String f_head;
	String f_body;
	String reply;
	String f_check;
	String u_id;
	
	public gosuVo3(String u_id, String f_head, String f_body, String reply,String faq_code) {
		this.u_id = u_id;
		this.f_head = f_head;
		this.f_body = f_body;
		this.reply = reply;
		this.faq_code = faq_code;
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
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "gosuVo3 [faq_code=" + faq_code + ", f_date=" + f_date + ", f_head=" + f_head + ", f_body=" + f_body
				+ ", reply=" + reply + ", f_check=" + f_check + ", u_id=" + u_id + "]";
	}
	

}
