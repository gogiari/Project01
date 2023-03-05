package gosu.data;

public class updateVo {
	String g_code3;
	String g_message3;
	String g_check3;
	
	String messnum;
	String mread;
	String m_date;
	String title;

	public updateVo() {
		super();
	}
	
	public updateVo(String g_code, String g_message, String g_check3) {
		super();
		this.g_code3 = g_code;
		this.g_message3 = g_message;
		this.g_check3 = g_check3;
	}

	public updateVo(String g_code3, String g_message3) {
		super();
		this.g_code3 = g_code3;
		this.g_message3 = g_message3;

	}
	
	public updateVo(String g_code4, String messnum, String mread, String m_date, String title) {
		super();
		this.g_code3   = g_code4;
		this.messnum   = messnum;
		this.mread     = mread;
		this.m_date    = m_date;
		this.title     = title;
		
	}

	public updateVo(String g_code32) {
		this.g_code3 = g_code32;
	}

	public String getG_code() {
		return g_code3;
	}

	public void setG_code(String g_code3) {
		this.g_code3 = g_code3;
	}

	public String getG_message() {
		return g_message3;
	}

	public void setG_message(String g_message) {
		this.g_message3 = g_message;
	}

	public String getG_check() {
		return g_check3;
	}

	public void setG_check(String g_check) {
		this.g_check3 = g_check;
	}
	
	public String getMessnum() {
		return messnum;
	}

	public void setMessnum(String messnum) {
		this.messnum = messnum;
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

	@Override
	public String toString() {
		return "updateVo [g_code3=" + g_code3 + ", g_message3=" + g_message3 + ", g_check3=" + g_check3 + ", messnum="
				+ messnum + ", mread=" + mread + ", m_date=" + m_date + ", title=" + title + "]";
	}


}

