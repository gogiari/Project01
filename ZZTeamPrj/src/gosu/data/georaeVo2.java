package gosu.data;

public class georaeVo2  {
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

	public georaeVo2() {
		super();

	}
		
	public georaeVo2(String g_code, String mid_name, String gdate, String g_start, String g_end, String wsido,
			String wgugun, String uid, String m_message, String w_num) {
		super();
		this.g_code = g_code;
		this.mid_name = mid_name;
		this.gdate = gdate;
		this.g_start = g_start;
		this.g_end = g_end;
		this.wsido = wsido;
		this.wgugun = wgugun;
		this.uid = uid;
		this.m_message = m_message;
		this.w_num = w_num;

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
		this.uid = u_id;
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
		return "georaeVo2 [g_code=" + g_code + ", u_name=" + u_name + ", mid_name=" + mid_name + ", gdate=" + gdate
				+ ", g_start=" + g_start + ", g_end=" + g_end + ", wsido=" + wsido + ", wgugun=" + wgugun + ", g_name="
				+ g_name + ", m_message=" + m_message + ", g_num=" + g_num + ", w_num=" + w_num + ", g_message="
				+ g_message + ", g_check=" + g_check + ", messnum=" + messnum + ", uid=" + uid + ", mread=" + mread
				+ ", m_date=" + m_date + ", title=" + title + "]";
	}
	

	
			
}