package gosu.view;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import gosu.data.gosuDao;

public class SidoComboBoxModel extends DefaultComboBoxModel<String> {
	private ArrayList<String> datas = new ArrayList<String>();
	
	public SidoComboBoxModel() {
		gosuDao dao = new gosuDao();
		datas = dao.allSido();
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
