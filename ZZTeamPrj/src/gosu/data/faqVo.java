package gosu.data;

public class faqVo {
	String fcode;
	String id;
	String date;
	String head;
	String body;
	String rep;
	String check;
	public faqVo() {}
	public faqVo(String id,String rep) {

		this.rep = rep;
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRep() {
		return rep;
	}
	public void setRep(String rep) {
		this.rep = rep;
	}

}
