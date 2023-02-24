package gosu.data;

public class gosuVo {
	// 회원리스트           //대분류
    String u_id;         String bi_num;
  	String u_pw;         String bi_name;
	String u_name;       //중분류
	String u_email;      String mid_num; 
	String u_gender;     String mid_name;
	String u_phone;      //FAQ
	String u_sido;      String faq_code;
	String u_gugun;     String f_date;
	/* 고소회원*/         String f_head;           
	String g_num;       String f_body;
	/*고수업무리스트 */     String reply;
	String w_num;       String f_check;            
	String sdate;         
	String edate;          
	String price;       
	String wsido;
	String wgugun;
	String prmess;
	//메세지리스트
	String mread;
	//거래리스트
	String m_message;
	String g_message;
	String g_check;
	String g_date;
	public gosuVo() {}
	public gosuVo(String u_id, String bi_num, String u_pw, String bi_name, String u_name, String u_email,
			String mid_num, String u_gender, String mid_name, String u_phone, String u_sido, String faq_code,
			String u_gugun, String f_date, String f_head, String g_num, String f_body, String reply, String w_num,
			String f_check, String sdate, String edate, String price, String wsido, String prmess, String mread,
			String m_message, String g_message, String g_check, String g_date,String wgugun) {
		super();
		this.u_id = u_id;
		this.bi_num = bi_num;
		this.u_pw = u_pw;
		this.bi_name = bi_name;
		this.u_name = u_name;
		this.u_email = u_email;
		this.mid_num = mid_num;
		this.u_gender = u_gender;
		this.mid_name = mid_name;
		this.u_phone = u_phone;
		this.u_sido = u_sido;
		this.faq_code = faq_code;
		this.u_gugun = u_gugun;
		this.f_date = f_date;
		this.f_head = f_head;
		this.g_num = g_num;
		this.f_body = f_body;
		this.reply = reply;
		this.w_num = w_num;
		this.f_check = f_check;
		this.sdate = sdate;
		this.edate = edate;
		this.price = price;
		this.wsido = wsido;
		this.prmess = prmess;
		this.mread = mread;
		this.m_message = m_message;
		this.g_message = g_message;
		this.g_check = g_check;
		this.g_date = g_date;
		this.wgugun = wgugun;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getBi_num() {
		return bi_num;
	}
	public void setBi_num(String bi_num) {
		this.bi_num = bi_num;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getBi_name() {
		return bi_name;
	}
	public void setBi_name(String bi_name) {
		this.bi_name = bi_name;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getMid_num() {
		return mid_num;
	}
	public void setMid_num(String mid_num) {
		this.mid_num = mid_num;
	}
	public String getU_gender() {
		return u_gender;
	}
	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}
	public String getMid_name() {
		return mid_name;
	}
	public void setMid_name(String mid_name) {
		this.mid_name = mid_name;
	}
	public String getU_phone() {
		return u_phone;
	}
	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}
	public String getU_sido() {
		return u_sido;
	}
	public void setU_sido(String u_sido) {
		this.u_sido = u_sido;
	}
	public String getFaq_code() {
		return faq_code;
	}
	public void setFaq_code(String faq_code) {
		this.faq_code = faq_code;
	}
	public String getU_gugun() {
		return u_gugun;
	}
	public void setU_gugun(String u_gugun) {
		this.u_gugun = u_gugun;
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
	public String getG_num() {
		return g_num;
	}
	public void setG_num(String g_num) {
		this.g_num = g_num;
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
	public String getW_num() {
		return w_num;
	}
	public void setW_num(String w_num) {
		this.w_num = w_num;
	}
	public String getF_check() {
		return f_check;
	}
	public void setF_check(String f_check) {
		this.f_check = f_check;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWsido() {
		return wsido;
	}
	public void setWsido(String wsido) {
		this.wsido = wsido;
	}
	public String getPrmess() {
		return prmess;
	}
	public void setPrmess(String prmess) {
		this.prmess = prmess;
	}
	public String getMread() {
		return mread;
	}
	public void setMread(String mread) {
		this.mread = mread;
	}
	public String getM_message() {
		return m_message;
	}
	public void setM_message(String m_message) {
		this.m_message = m_message;
	}
	public String getG_message() {
		return g_message;
	}
	public void setG_message(String g_message) {
		this.g_message = g_message;
	}
	public String getG_check() {
		return g_check;
	}
	public void setG_check(String g_check) {
		this.g_check = g_check;
	}
	public String getG_date() {
		return g_date;
	}
	public void setG_date(String g_date) {
		this.g_date = g_date;
	}
	public String getWgugun() {
		return wgugun;
	}
	public void setWgugun(String wgugun) {
		this.wgugun = wgugun;
	}
	
}
