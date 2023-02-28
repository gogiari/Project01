package gosu.view;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import gosu.data.gosuDao;

public class GugunComboBoxModel extends DefaultComboBoxModel<String> {
		private ArrayList<String> datas = new ArrayList<String>();
		
		public GugunComboBoxModel(String sido) {
			gosuDao dao = new gosuDao();
			datas = dao.allGugun(sido);
		}
		@Override
		public int getSize() {
			return datas.size();
		}

		@Override
		public String getElementAt(int index) {
			return datas.get(index);
		}


}


