package gosu.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class findClient extends JFrame {

	private JPanel contentPane;
	public findClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 602, 489);
		contentPane = new JPanel();
		
		setVisible(true);
		setContentPane(contentPane);
	}
	public static void main(String[] args) {
		new findClient();
	}

}
