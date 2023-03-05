package api.googlemap;

import java.awt.BorderLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MapSuchView extends JFrame {
	
	private JTextField txtMapSuch = new JTextField(30);
	private JButton btnMapSuch = new JButton("검색");
	private Panel pMap = new Panel();
	private GoogleApi googleAPI = new GoogleApi();
	private String location = "부산 그린컴퓨터 ";
	private JLabel googleMap;
	
	public MapSuchView() {
		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		
		
		googleAPI.downloadMap(location);
		googleMap = new JLabel(googleAPI.getMap(location));
		googleAPI.fileDelete(location);
		add(googleMap);
		setTitle("고객님위치");
		
		//pMap.add(txtMapSuch);
		//pMap.add(btnMapSuch); // 검색버튼
		
		//add(pMap, BorderLayout.NORTH);
		//add(googleMap, BorderLayout.CENTER);
		
		
		
		setResizable(false);
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MapSuchView();
	}

}
