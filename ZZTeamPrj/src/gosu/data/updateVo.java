package gosu.data;

public class updateVo {
	String g_code;
	String g_message;
	String g_check;

	public updateVo() {
		super();
	}
 
	public updateVo(String g_code, String g_message, String g_check) {
		super();
		this.g_code = g_code;
		this.g_message = g_message;
		this.g_check = g_check;
	}

	public updateVo(String g_code3, String g_message3) {
		// TODO Auto-generated constructor stub
	}

	public String getG_code() {
		return g_code;
	}

	public void setG_code(String g_code) {
		this.g_code = g_code;
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

	@Override
	public String toString() {
		return "updateVo [g_code=" + g_code + ", g_message=" + g_message + ", g_check=" + g_check + "]";
	}
	
}

