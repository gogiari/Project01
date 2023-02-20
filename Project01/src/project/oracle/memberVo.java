package project.oracle;

public class memberVo {
	String Uphone;
	String Rdate;
	String Rtime;
	String Rmemo;
	String pick;
	String location;
	public memberVo() {}
	public memberVo(String uphone, String rdate, String rtime, String rmemo, String pick, String location) {
		super();
		Uphone = uphone;
		Rdate = rdate;
		Rtime = rtime;
		Rmemo = rmemo;
		this.pick = pick;
		this.location = location;
	}
	public String getUphone() {
		return Uphone;
	}
	public void setUphone(String uphone) {
		Uphone = uphone;
	}
	public String getRdate() {
		return Rdate;
	}
	public void setRdate(String rdate) {
		Rdate = rdate;
	}
	public String getRtime() {
		return Rtime;
	}
	public void setRtime(String rtime) {
		Rtime = rtime;
	}
	public String getRmemo() {
		return Rmemo;
	}
	public void setRmemo(String rmemo) {
		Rmemo = rmemo;
	}
	public String getPick() {
		return pick;
	}
	public void setPick(String pick) {
		this.pick = pick;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "memberVo [Uphone=" + Uphone + ", Rdate=" + Rdate + ", Rtime=" + Rtime + ", Rmemo=" + Rmemo + ", pick="
				+ pick + ", location=" + location + "]";
	}
}
