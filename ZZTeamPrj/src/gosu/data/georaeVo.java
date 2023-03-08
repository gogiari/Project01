package gosu.data;

public class georaeVo  {
	String g_code;
	String u_name;
	String mid_name;
	String gdate;
	String g_start;
	String g_end;
	String wsido;
	String wgugun;
	String g_name;
	String m_message;
	String g_num;
	String w_num;

	String g_message;
	String g_check;
	
	String messnum;
	String uid;
	String mread;
	String m_date;
	String title;

	public georaeVo() {
		super();

	}
		
	public georaeVo(String g_code, String mid_name, String g_start, String g_end, String wsido,
			String wgugun, String g_num, String m_message) {
		super();
		this.g_code = g_code;
		this.mid_name = mid_name;
		this.g_start = g_start;
		this.g_end = g_end;
		this.wsido = wsido;
		this.wgugun = wgugun;
		this.g_num = g_num;
		this.m_message = m_message;
	


	}


	public georaeVo(String g_code4, String messnum4, String mread4, String m_date4) {
		
	}
	
	public georaeVo(String g_code5, String g_message5, String g_check5) {
		
	}

	public georaeVo(String g_code2) {
		// TODO Auto-generated constructor stub
	}

	public georaeVo(String g_code2, String m_message2) {
		// TODO Auto-generated constructor stub
	}

	public georaeVo(String u_name2, String mid_name2, String gdate2, String g_start2, String g_end2, String wsido2,
			String wgugun2, String g_num, String m_message2, String title) {
		// TODO Auto-generated constructor stub
	}


	public georaeVo(georaeVo vo2) {
		super();
		this.uid    = uid;
		this.u_name = uid;	
		
	}

	public georaeVo(String g_code2, String mid_name2, String gdate2, String g_start2, String g_end2, String wsido2,
			String wgugun2, String g_name2, String m_message2) {
		this.g_code = g_code2;
		this.mid_name = mid_name2;
		this.gdate   = gdate2;
		this.g_start = g_start2;
		this.g_end = g_end2;
		this.wsido = wsido2;
		this.wgugun = wgugun2;
		this.g_name = g_name2;
		this.m_message = m_message2;
		


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

	public String getGdate() {
		return gdate;
	}

	public void setGdate(String gdate) {
		this.gdate = gdate;
	}

	public String getG_start() {
		return g_start;
	}

	public void setG_start(String g_start) {
		this.g_start = g_start;
	}

	public String getG_end() {
		return g_end;
	}

	public void setG_end(String g_end) {
		this.g_end = g_end;
	}

	public String getWsido() {
		return wsido;
	}

	public void setWsido(String wsido) {
		this.wsido = wsido;
	}

	public String getWgugun() {
		return wgugun;
	}

	public void setWgugun(String wgugun) {
		this.wgugun = wgugun;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getM_message() {
		return m_message;
	}

	public void setM_message(String m_message) {
		this.m_message = m_message;
	}
	
	public String getG_code() {
		return g_code;
	}
	
	public void setG_code(String g_code) {
		this.g_code = g_code;
	}
	
	public String getG_check() {
		return g_check;
	}
	public void setG_check(String g_check) {
		this.g_check = g_check;
	}
	
	public String getG_message() {
		return g_message;
	}

	public void setG_message(String g_message) {
		this.g_message = g_message;
	}
	public String getMessnum() {
		return messnum;
	}
	public void setMessnum(String messnum) {
		this.messnum = messnum;
	}

	public String getUid() {
		return uid;
	}
	public void setU_id(String u_id) {
		this.uid = uid;
	}

	public String getMread() {
		return mread;
	}
	public void setMread(String mread) {
		this.mread = mread;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getG_num() {
		return g_num;
	}
	public void setG_num(String g_num) {
		this.g_num = g_num;
	}
	
	public String getW_num() {
		return w_num;
	}
	public void setW_num(String w_num) {
		this.w_num = w_num;
	}

	@Override
	public String toString() {
		return "georaeVo [g_code=" + g_code + ", u_name=" + u_name + ", mid_name=" + mid_name + ", gdate=" + gdate
				+ ", g_start=" + g_start + ", g_end=" + g_end + ", wsido=" + wsido + ", wgugun=" + wgugun + ", g_name="
				+ g_name + ", m_message=" + m_message + ", g_num=" + g_num + ", w_num=" + w_num + ", g_message="
				+ g_message + ", g_check=" + g_check + ", messnum=" + messnum + ", uid=" + uid + ", mread=" + mread
				+ ", m_date=" + m_date + ", title=" + title + "]";
	}
	

	
			
}