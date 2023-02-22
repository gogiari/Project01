package project.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class mainPage extends JFrame implements ActionListener {

   private JPanel mainPage;
   private JTable listReser;
   public mainPage() {
      setBackground(Color.WHITE);
      
     // setIconImage(Toolkit.getDefaultToolkit().getImage("/images/KakaoTalk_20230221_221845625.png"));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 795, 495);
      mainPage = new JPanel();
      mainPage.setBackground(Color.WHITE);
      mainPage.setBorder(new EmptyBorder(5, 5, 5, 5));
      
      setUndecorated(true);
      setVisible(true);
      setContentPane(mainPage);
      mainPage.setLayout(null);
      
      JPanel panel = new JPanel();
      panel.setForeground(SystemColor.textText);
      panel.setBackground(Color.WHITE);
      panel.setBounds(35, 10, 760, 475);
      mainPage.add(panel);
      panel.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("Reservation List");
      lblNewLabel.setForeground(SystemColor.textHighlight);
      lblNewLabel.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 27));
      lblNewLabel.setBounds(262, 10, 236, 55);
      panel.add(lblNewLabel);
      
      // 예약 리스트 insert
      setVisible(true);
      listReser = new JTable();
      listReser.setForeground(SystemColor.activeCaption);
      listReser.setBackground(SystemColor.activeCaption);
      listReser.setBounds(706, 340, -673, -240);
      panel.add(listReser);
      
      Button newReservation = new Button("New");
      newReservation.setForeground(SystemColor.textHighlight);
      newReservation.setBackground(SystemColor.window);
      newReservation.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 15));
      newReservation.setBounds(416, 374, 109, 24);
      panel.add(newReservation);
      newReservation.addActionListener(this);
      
      Button schedule = new Button("Schedule");
      schedule.setForeground(SystemColor.textHighlight);
      schedule.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 15));
      schedule.setBackground(Color.WHITE);
      schedule.setBounds(567, 374, 109, 24);
      panel.add(schedule);
      
      TextField textField = new TextField();
      textField.setBounds(27, 375, 132, 23);
      panel.add(textField);
      
      Button findR = new Button("Find");
      findR.setForeground(SystemColor.textHighlight);
      findR.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 15));
      findR.setBackground(Color.WHITE);
      findR.setBounds(165, 374, 78, 24);
      panel.add(findR);
      
      JSeparator separator = new JSeparator();
      separator.setForeground(SystemColor.menuText);
      separator.setBounds(47, 34, 203, 2);
      panel.add(separator);
      
      JSeparator separator_1 = new JSeparator();
      separator_1.setForeground(Color.BLACK);
      separator_1.setBounds(510, 34, 203, 2);
      panel.add(separator_1);
      
      JLabel lblNewLabel_1 = new JLabel("X");
      lblNewLabel_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.exit(0);
         }
      });
      lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 17));
      lblNewLabel_1.setForeground(SystemColor.textHighlight);
      lblNewLabel_1.setBounds(738, 0, 22, 24);
      panel.add(lblNewLabel_1);
   }
   
   //add ReserVation
   @Override
   public void actionPerformed(ActionEvent e) {
      new client();
      
   }
}