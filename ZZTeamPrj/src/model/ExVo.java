package model;

public class ExVo {
	
	//data 출력 Fields
	private String exBigList, 
				   exMidList,
				   exWsido;
	
	public ExVo() {};
	public ExVo(String exBigList) {
		this.exBigList = exBigList;		
	};
	public ExVo(String exBigList, String exMidList, String exWsido) {
		super();
		this.exBigList = exBigList;
		this.exMidList = exMidList; 
		this.exWsido = exWsido;
	}
	
	//data 출력 Fields
		public String getExBigList() {
			return exBigList;
		}
		
		public void setExBigList(String exBigList) {
			this.exBigList = exBigList;
		}
		
		public String getExMidList() {
			return exMidList;
		}
		
		public void setExMidList(String exMidList) {
			this.exMidList = exMidList;
		}
		
		public String getExWsido() {
			return exWsido;
		}
		
		public void setExWsido(String exWsido) {
			this.exWsido = exWsido;
		}

		//data 출력 Fields toString
		@Override
		public String toString() {
			return "ExVo [exBigList=" + exBigList + ", exMidList=" + exMidList + ", exWsido=" + exWsido + "]";
		};
}
