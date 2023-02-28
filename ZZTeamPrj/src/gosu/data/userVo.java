package gosu.data;

public class userVo {

	String id,pw,pw2,name,phone,email,gender,sido,gugun;

	public userVo(String id, String pw, String pw2, String name, String phone, String email, String gender, String sido,
			String gugun) {
		super();
		this.id = id;
		this.pw = pw;
		this.pw2 = pw2;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.sido = sido;
		this.gugun = gugun;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPw2() {
		return pw2;
	}

	public void setPw2(String pw) {
		this.pw2 = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getGugun() {
		return gugun;
	}

	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	@Override
	public String toString() {
		return "userVo [id=" + id + ", pw=" + pw + ", pw2=" + pw2 + ", name=" + name + ", phone=" + phone + ", email="
				+ email + ", gender=" + gender + ", sido=" + sido + ", gugun=" + gugun + "]";
	}
	
}
	

