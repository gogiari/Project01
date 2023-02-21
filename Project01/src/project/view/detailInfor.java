package project.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class detailInfor extends JFrame {
	 private JPanel contentPane;
	   GridBagConstraints gbc;
	   
	   JLabel label1;
	   JLabel label2;
	   JLabel label3;
	   JLabel label4;
	   JLabel label5;
	   JLabel label6;
	   
	    JTextArea texta;
	    
	    JButton button1;
	    JButton button2;
	    JButton button3;
	    ButtonGroup group;
	    
	    JRadioButton radio1;
	    JRadioButton radio2;
	    JRadioButton radio3;
	    JRadioButton radio4;
	    
	    JTextField textf1;
	    JTextField textf2;
	    JTextField textf3;
	    JTextField textf4;
	    JTextField textf5;
	    
	    UtilDateModel model;
	    JDatePanelImpl datePanel;
	    JDatePickerImpl datePicker;
	    
	    public detailInfor() {
	        super.getContentPane().setBackground(Color.white);
	        this.setTitle("예약 상세 정보");
	        init();
	        
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setSize(1000,800);
	        setVisible(true);
	     }
	    
	    private void init() {     
	        setBounds(800, 250, 1000, 800);
	        contentPane = new JPanel();
	            
	          setContentPane(contentPane);
	          contentPane.setLayout(null);
	          
	          int marginx = 100;
	          int panelwidth = 800;
	        //panel----------------------------------------------
	          JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	          panel.setBounds(marginx, 50, panelwidth, 35);
	          contentPane.add(panel);
	          //panel.setBackground(Color.GREEN);
	          
	          label1 = new JLabel("예약 상세 정보");
	          label1.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
	          label1.setBorder(BorderFactory.createEmptyBorder(0 , 0, 0 , 260));
	          panel.add(label1);
	          
	          button1 = new JButton("픽업위치 확인");
	          button1.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
	          button1.setBorder(BorderFactory.createEmptyBorder(5 , 10, 5 , 10));
	          panel.add(button1);
	          
	        //panel_1----------------------------------------------
	          JPanel panel_1 = new JPanel(new GridBagLayout());
	          panel_1.setBounds(marginx, 120, panelwidth, 40);
	          contentPane.add(panel_1);
	          gbc = new GridBagConstraints();
	          gbc.fill = GridBagConstraints.BOTH;
	          gbc.ipady = 4;
	          Font font = new Font("Malgun Gothic", Font.BOLD, 14);
	          Font font2 = new Font("Malgun Gothic", Font.PLAIN, 14);
	          
	          gbc.gridx = 0;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.weightx = 0.1;
	          gbc.insets = new Insets(0, 0, 0, 3);
	          label1 = new JLabel("회원 이름");
	          label1.setFont(font);
	          panel_1.add(label1, gbc);
	          
	          gbc.gridx = 1;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.weightx = 0.3;
	          gbc.insets = new Insets(0, 0, 0, 40);
	          textf1 = new JTextField(15);
	          textf1.setFont(font2);
	          panel_1.add(textf1, gbc);
	          
	          gbc.gridx = 2;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.weightx = 0.1;
	          gbc.insets = new Insets(0, 5, 0, 7);
	          label2 = new JLabel("펫 이름");
	          label2.setFont(font);
	          panel_1.add(label2, gbc);
	          
	          gbc.gridx = 3;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.weightx = 0.3;
	          gbc.insets = new Insets(0, 0, 0, 0);
	          textf2 = new JTextField(15);
	          textf2.setFont(font2);
	          panel_1.add(textf2, gbc);
	          
	        //panel_2----------------------------------------------
	          JPanel panel_2 = new JPanel(new GridBagLayout());
	          panel_2.setBounds(marginx, 180, panelwidth, 40);
	          contentPane.add(panel_2);
	          
	          gbc.gridx = 0;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.weightx = 0.1;
	          gbc.insets = new Insets(0, 0, 0, 3);
	          label3 = new JLabel("예약 시간");
	          label3.setFont(font);
	          panel_2.add(label3, gbc);
	          
	          gbc.gridx = 1;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.weightx = 0.3;
	          gbc.insets = new Insets(0, 0, 0, 40);
	          textf3 = new JTextField(15);
	          textf3.setFont(font2);
	          panel_2.add(textf3, gbc);
	          
	          gbc.gridx = 2;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.weightx = 0.1;
	          gbc.insets = new Insets(0, 0, 0, 0);
	          label4 = new JLabel("예약 내용");
	          label4.setFont(font);
	          panel_2.add(label4, gbc);
	          
	          gbc.gridx = 3;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.weightx = 0.3;
	          gbc.insets = new Insets(0, 0, 0, 0);
	          textf4 = new JTextField(15);
	          textf4.setFont(font2);
	          panel_2.add(textf4, gbc);
	          
	        //panel_3----------------------------------------------
	          JPanel panel_3 = new JPanel(new GridBagLayout());
	          panel_3.setBounds(marginx, 240, panelwidth, 40);
	          contentPane.add(panel_3);

	          gbc.gridx = 0;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.weightx = 0;
	          gbc.insets = new Insets(0, 0, 0, 7);
	          label5 = new JLabel("예상 시간");
	          label5.setFont(font);
	          panel_3.add(label5, gbc);
	          
	          gbc.gridx = 1;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.weightx = 0.1;
	          gbc.insets = new Insets(0, 30, 0, 0);
	          textf5 = new JTextField(15);
	          textf5.setFont(font2);
	          panel_3.add(textf5, gbc);        
	          
	        //panel_4----------------------------------------------
	          JPanel panel_4 = new JPanel(new BorderLayout());
	          panel_4.setBounds(marginx, 300, 100, 200);
	          contentPane.add(panel_4);
	          
	          gbc.gridx = 0;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.weightx = 0;
	          gbc.insets = new Insets(0, 0, 0, 0);
	          label6 = new JLabel("특이사항");
	          label6.setFont(font);
	          panel_4.add(label6);

	        //panel_5----------------------------------------------
	          JPanel panel_5 = new JPanel(new BorderLayout());
	          panel_5.setBounds(200, 300, 700, 200);
	          contentPane.add(panel_5);
	          
	          gbc.insets = new Insets(0, 20, 0, 0);
	          texta = new JTextArea(4, 20);
	          texta.setFont(font2);
	          panel_5.add(new JScrollPane(texta));
	          
	        //panel_6----------------------------------------------
	          JPanel panel_6 = new JPanel(new GridBagLayout());
	          panel_6.setBounds(marginx, 530, panelwidth, 40);
	          contentPane.add(panel_6);
	          gbc.weightx = 0.1;
	          gbc.weighty = 0.1;
	          gbc.fill = GridBagConstraints.CENTER;
	          
	          gbc.gridx = 0;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.insets = new Insets(0, 240, 0, 0);
	          this.button1 = new JButton("저장");
	          panel_6.add(button1, gbc);
	          
	          gbc.gridx = 1;
	          gbc.gridy = 0;
	          gbc.gridwidth = 1;
	          gbc.gridheight = 1;
	          gbc.insets = new Insets(0, 0, 0, 260);
	          this.button2 = new JButton("예약조회");
	          panel_6.add(button2, gbc);
	          
	          //기능------------------------------------------------

	     }

	    public static void main(String[] args) {
	        new detailInfor();
	     }



}
