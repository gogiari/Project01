package project.view;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class client extends JFrame implements ActionListener {
   
   
   private JTextField phone;
   private JTextField nameC;
   private JTextField nameP;
   private JTextField etcField;
   private JTextField pickUp;
   private JPanel     client;
   
   public client() {
      
      client = new JPanel();
      client.setBackground(Color.WHITE);
      client.setBounds(0, 0, 662, 516);
      setContentPane(client);
      client.setLayout(null);
      
      
      JPanel panel = new JPanel();
      panel.setForeground(SystemColor.textText);
      panel.setBackground(Color.WHITE);
      panel.setBounds(-17, -34, 835, 542);
      client.add(panel);
      panel.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("Register");
      lblNewLabel.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 30));
      lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
      lblNewLabel.setBounds(245, 10, 186, 41);
      panel.add(lblNewLabel);
      
      phone = new JTextField();
      phone.setFont(new Font("D2Coding", Font.ITALIC, 15));
      phone.setBackground(Color.WHITE);
      phone.setBounds(45, 108, 107, 21);
      //panel.add();
      phone.setColumns(10);
      
      JLabel lblPhone = new JLabel("Phone");
      lblPhone.setFont(new Font("D2Coding", Font.ITALIC, 15));
      lblPhone.setBounds(45, 89, 65, 18);
      panel.add(lblPhone);
      
      Button findC = new Button("Find");
      findC.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 11));
      findC.setBounds(158, 106, 39, 23);
      panel.add(findC);
      findC.addActionListener(this);
      
      nameC = new JTextField();
      nameC.setFont(new Font("D2Coding", Font.ITALIC, 15));
      nameC.setColumns(10);
      nameC.setBackground(Color.WHITE);
      nameC.setBounds(45, 157, 107, 21);
      panel.add(nameC);
      
      JLabel lblName = new JLabel("Name");
      lblName.setFont(new Font("D2Coding", Font.ITALIC, 15));
      lblName.setBounds(45, 140, 65, 18);
      panel.add(lblName);
      
      nameP = new JTextField();
      nameP.setFont(new Font("D2Coding", Font.ITALIC, 15));
      nameP.setColumns(10);
      nameP.setBackground(Color.WHITE);
      nameP.setBounds(45, 205, 127, 24);
      panel.add(nameP);
      
      JLabel lblPet = new JLabel("Pet");
      lblPet.setFont(new Font("D2Coding", Font.ITALIC, 15));
      lblPet.setBounds(45, 188, 65, 18);
      panel.add(lblPet);
      
      etcField = new JTextField();
      etcField.setFont(new Font("D2Coding", Font.ITALIC, 15));
      etcField.setColumns(10);
      etcField.setBackground(Color.WHITE);
      etcField.setBounds(45, 278, 208, 155);
      panel.add(etcField);
      
      JLabel lblEtc = new JLabel("Etc");
      lblEtc.setFont(new Font("D2Coding", Font.ITALIC, 15));
      lblEtc.setBounds(45, 250, 65, 18);
      panel.add(lblEtc);
      
      Choice dayR = new Choice();
      dayR.setBounds(339, 108, 118, 21);
      panel.add(dayR);
      
      JLabel lblDay = new JLabel("Day");
      lblDay.setFont(new Font("D2Coding", Font.ITALIC, 15));
      lblDay.setBounds(340, 89, 65, 18);
      panel.add(lblDay);
      
      Choice timeR = new Choice();
      timeR.setBounds(339, 157, 118, 21);
      panel.add(timeR);
      
      JLabel lblTime = new JLabel("Time");
      lblTime.setFont(new Font("D2Coding", Font.ITALIC, 15));
      lblTime.setBounds(340, 140, 65, 18);
      panel.add(lblTime);
      
      JLabel lblPickup = new JLabel("PickUp");
      lblPickup.setFont(new Font("D2Coding", Font.ITALIC, 15));
      lblPickup.setBounds(340, 188, 65, 18);
      panel.add(lblPickup);
      
      pickUp = new JTextField();
      pickUp.setFont(new Font("D2Coding", Font.ITALIC, 15));
      pickUp.setColumns(10);
      pickUp.setBackground(Color.WHITE);
      pickUp.setBounds(339, 205, 118, 21);
      panel.add(pickUp);
      
      Button pickUpFind = new Button("Find");
      pickUpFind.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 11));
      pickUpFind.setBounds(463, 205, 39, 23);
      panel.add(pickUpFind);
      
      JLabel lblNewLabel_1 = new JLabel("X");
      lblNewLabel_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.exit(0);
         }
      });
      lblNewLabel_1.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 18));
      lblNewLabel_1.setBounds(752, 10, 21, 15);
      panel.add(lblNewLabel_1);
      
      setVisible(true);
      
      
   }
   // 전화번호로 찾기 버튼
   @Override
   public void actionPerformed(ActionEvent e) {
      
   }
   public static void main(String[] args) {
   new client();   
   }
}