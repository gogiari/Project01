package com;

import java.awt.Font;

import javax.swing.JLabel;

public class Design {
	
	
	
	public Design() {

	}
	
//	public interface esnDesign {
//		public void geTitletFont(JLabel title);
//		public void geTitletFont2();
//	}
//	
//	public class IPhone implements esnDesign {
//	
//		@Override
//		public void geTitletFont(JLabel title) {
//			title.setFont(new Font("맑은 고딕", Font.BOLD, 18));
//		}
//	
//		@Override
//		public void geTitletFont2() {
//			// TODO Auto-generated method stub
//			
//		}
//	}

	public void getTitleFont(JLabel title) {
		title.setFont(new Font("맑은 고딕", Font.BOLD, 18));
	}
	
	public void getBodyFont1(JLabel body1) {
		body1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
	}
	

}
