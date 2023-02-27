package gosu.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;


import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class FAQ extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private ImageIcon imgTest;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FAQ window = new FAQ();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FAQ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 850, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 834, 507);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		ImageIcon icon = new ImageIcon("faq.png");
		Image     img = icon.getImage();
		Image changeImg = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel lblNewLabel = new JLabel(icon);
		
		getContentPane().add( lblNewLabel );
		setSize(200,200);
		setVisible(true);
		
		
		
		
		
		/* JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\GGG\\Desktop\\\uC0AC\uC9C4\\faq.png"));
		lblNewLabel.setBounds(165, 10, 573, 487);
		panel.add(lblNewLabel);
		*/
		
	
		
		JLabel lblNewLabel_1 = new JLabel("\uC81C\uBAA9");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(58, 81, 91, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uBB38\uC758\uB0B4\uC6A9");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(31, 193, 107, 42);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("RE");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(58, 344, 57, 37);
		panel.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setText("\uC81C\uBAA9\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		textField.setBounds(180, 81, 542, 42);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrbyte = new JTextArea();
		txtrbyte.setText("4000byte \uC774\uB0B4\uB85C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		txtrbyte.setBounds(180, 142, 542, 138);
		panel.add(txtrbyte);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("\uB2F5\uBCC0");
		textArea_1.setBounds(180, 312, 542, 115);
		panel.add(textArea_1);
		
		JButton btnNewButton = new JButton("\uB4F1\uB85D");
		btnNewButton.setBounds(235, 445, 97, 37);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.setBounds(480, 445, 97, 37);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("FAQ");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel_4.setBounds(367, 10, 97, 60);
		panel.add(lblNewLabel_4);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Savetxt();
				
			}

			private void Savetxt() {
				
				
			}
		});
		
		
	}
}
