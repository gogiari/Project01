package project.oracle;

public class memberVo {
	
	String kindP;
	String nameC;
	String phoneC;
	String addrC;
	
	String etcR;
	String pickup;
	
	String idE;
	String pwE;
	String nameE;
	String phoneE;
	
	String nameB;
	
	String headFAQ;
	String bodyFAQ;
	
	String nameO;
	
	String hireP, dateR, timeR, dateO, timeO;
	
	int    numP,numR, numE, numB, numO, numFAQ;

	public memberVo(String kindP, String nameC, String phoneC, String addrC, String etcR, String pickup, String idE,
			String pwE, String nameE, String phoneE, String nameB, String headFAQ, String bodyFAQ, String nameO,
			String hireP, String dateR, String timeR, String dateO, String timeO, int numP, int numR, int numE,
			int numB, int numO, int numFAQ) {
		super();
		this.kindP = kindP;
		this.nameC = nameC;
		this.phoneC = phoneC;
		this.addrC = addrC;
		this.etcR = etcR;
		this.pickup = pickup;
		this.idE = idE;
		this.pwE = pwE;
		this.nameE = nameE;
		this.phoneE = phoneE;
		this.nameB = nameB;
		this.headFAQ = headFAQ;
		this.bodyFAQ = bodyFAQ;
		this.nameO = nameO;
		this.hireP = hireP;
		this.dateR = dateR;
		this.timeR = timeR;
		this.dateO = dateO;
		this.timeO = timeO;
		this.numP = numP;
		this.numR = numR;
		this.numE = numE;
		this.numB = numB;
		this.numO = numO;
		this.numFAQ = numFAQ;
	}

	public String getKindP() {
		return kindP;
	}

	public void setKindP(String kindP) {
		this.kindP = kindP;
	}

	public String getNameC() {
		return nameC;
	}

	public void setNameC(String nameC) {
		this.nameC = nameC;
	}

	public String getPhoneC() {
		return phoneC;
	}

	public void setPhoneC(String phoneC) {
		this.phoneC = phoneC;
	}

	public String getAddrC() {
		return addrC;
	}

	public void setAddrC(String addrC) {
		this.addrC = addrC;
	}

	public String getEtcR() {
		return etcR;
	}

	public void setEtcR(String etcR) {
		this.etcR = etcR;
	}

	public String getPickup() {
		return pickup;
	}

	public void setPickup(String pickup) {
		this.pickup = pickup;
	}

	public String getIdE() {
		return idE;
	}

	public void setIdE(String idE) {
		this.idE = idE;
	}

	public String getPwE() {
		return pwE;
	}

	public void setPwE(String pwE) {
		this.pwE = pwE;
	}

	public String getNameE() {
		return nameE;
	}

	public void setNameE(String nameE) {
		this.nameE = nameE;
	}

	public String getPhoneE() {
		return phoneE;
	}

	public void setPhoneE(String phoneE) {
		this.phoneE = phoneE;
	}

	public String getNameB() {
		return nameB;
	}

	public void setNameB(String nameB) {
		this.nameB = nameB;
	}

	public String getHeadFAQ() {
		return headFAQ;
	}

	public void setHeadFAQ(String headFAQ) {
		this.headFAQ = headFAQ;
	}

	public String getBodyFAQ() {
		return bodyFAQ;
	}

	public void setBodyFAQ(String bodyFAQ) {
		this.bodyFAQ = bodyFAQ;
	}

	public String getNameO() {
		return nameO;
	}

	public void setNameO(String nameO) {
		this.nameO = nameO;
	}

	public String getHireP() {
		return hireP;
	}

	public void setHireP(String hireP) {
		this.hireP = hireP;
	}

	public String getDateR() {
		return dateR;
	}

	public void setDateR(String dateR) {
		this.dateR = dateR;
	}

	public String getTimeR() {
		return timeR;
	}

	public void setTimeR(String timeR) {
		this.timeR = timeR;
	}

	public String getDateO() {
		return dateO;
	}

	public void setDateO(String dateO) {
		this.dateO = dateO;
	}

	public String getTimeO() {
		return timeO;
	}

	public void setTimeO(String timeO) {
		this.timeO = timeO;
	}

	public int getNumP() {
		return numP;
	}

	public void setNumP(int numP) {
		this.numP = numP;
	}

	public int getNumR() {
		return numR;
	}

	public void setNumR(int numR) {
		this.numR = numR;
	}

	public int getNumE() {
		return numE;
	}

	public void setNumE(int numE) {
		this.numE = numE;
	}

	public int getNumB() {
		return numB;
	}

	public void setNumB(int numB) {
		this.numB = numB;
	}

	public int getNumO() {
		return numO;
	}

	public void setNumO(int numO) {
		this.numO = numO;
	}

	public int getNumFAQ() {
		return numFAQ;
	}

	public void setNumFAQ(int numFAQ) {
		this.numFAQ = numFAQ;
	}

	@Override
	public String toString() {
		return "memberVo [kindP=" + kindP + ", nameC=" + nameC + ", phoneC=" + phoneC + ", addrC=" + addrC + ", etcR="
				+ etcR + ", pickup=" + pickup + ", idE=" + idE + ", pwE=" + pwE + ", nameE=" + nameE + ", phoneE="
				+ phoneE + ", nameB=" + nameB + ", headFAQ=" + headFAQ + ", bodyFAQ=" + bodyFAQ + ", nameO=" + nameO
				+ ", hireP=" + hireP + ", dateR=" + dateR + ", timeR=" + timeR + ", dateO=" + dateO + ", timeO=" + timeO
				+ ", numP=" + numP + ", numR=" + numR + ", numE=" + numE + ", numB=" + numB + ", numO=" + numO
				+ ", numFAQ=" + numFAQ + "]";
	}
	
}
	

