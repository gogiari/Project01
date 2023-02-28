package gosu.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import gosu.data.gosuDao;

public class ConstructorPage extends JFrame implements ActionListener {

   private JPanel mainPage;
   private JPanel FAQPane;
   private JLabel lblFaq;
   private JSeparator FAQ1;
   private JSeparator FAQ2;
   private JScrollPane userpane, gosupane, faqpane;
   private JTable userTable,gosuTable;

   
 
   public ConstructorPage() {
      setBackground(Color.WHITE);
      
     
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 795, 495);
      mainPage = new JPanel();
      mainPage.setBackground(new Color(0, 0, 0));
      mainPage.setBorder(new EmptyBorder(5, 5, 5, 5));
      
      setUndecorated(true);
      setVisible(true);
      setContentPane(mainPage);
      mainPage.setLayout(null);
      
      JPanel panel = new JPanel();
      panel.setForeground(SystemColor.textText);
      panel.setBackground(Color.WHITE);
      panel.setBounds(0, 0, 795, 495);
      mainPage.add(panel);
      panel.setLayout(null);
     
      setVisible(true);
      JLabel lblNewLabel_1 = new JLabel("X");
      lblNewLabel_1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            System.exit(0);
         }
      });
      lblNewLabel_1.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 17));
      lblNewLabel_1.setForeground(SystemColor.textHighlight);
      lblNewLabel_1.setBounds(775, 0, 22, 24);
      panel.add(lblNewLabel_1);
      
      JPanel ClientPane = new JPanel();
      ClientPane.setBackground(new Color(255, 255, 255));
      ClientPane.setBounds(0, 0, 794, 414);
      panel.add(ClientPane);
      ClientPane.setLayout(null);
     
      
      Button GosuBtn = new Button("GosuList");
      JPanel GosuPane = new JPanel();
      GosuPane.setBackground(new Color(255, 255, 255));
      GosuPane.setBounds(0, 0, 794, 414);
      panel.add(GosuPane);
      GosuPane.setLayout(null);
      
      JLabel lblGosu = new JLabel("Gosu List");
      lblGosu.setForeground(SystemColor.textHighlight);
      lblGosu.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 27));
      lblGosu.setBounds(317, 10, 154, 32);
      GosuPane.add(lblGosu);
      
      JSeparator gosu2 = new JSeparator();
      gosu2.setForeground(Color.BLACK);
      gosu2.setBounds(78, 25, 203, 2);
      GosuPane.add(gosu2);
      
      JSeparator separator_2 = new JSeparator();
      separator_2.setForeground(Color.BLACK);
      separator_2.setBounds(515, 25, 203, 2);
      GosuPane.add(separator_2);
      
      JPanel FAQPane;
      FAQPane = new JPanel();
      FAQPane.setBackground(new Color(255, 255, 255));
      FAQPane.setBounds(0, 0, 794, 414);
      panel.add(FAQPane);
      FAQPane.setLayout(null);
      
      JLabel lblFAQ;
      lblFAQ = new JLabel("FAQ List");
      lblFAQ.setForeground(SystemColor.textHighlight);
      lblFAQ.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 27));
      lblFAQ.setBounds(317, 10, 154, 32);
      FAQPane.add(lblFAQ);
      
      JSeparator FAQ2;
      FAQ2 = new JSeparator();
      FAQ2.setForeground(Color.BLACK);
      FAQ2.setBounds(78, 25, 203, 2);
      FAQPane.add(FAQ2);
      
      JSeparator FAQ1;
      FAQ1 = new JSeparator();
      FAQ1.setForeground(Color.BLACK);
      FAQ1.setBounds(515, 25, 203, 2);
      FAQPane.add(FAQ1);
      
      
      
      JPanel mainBtnPane = new JPanel();
      mainBtnPane.setBackground(new Color(135, 206, 250));
      mainBtnPane.setBounds(0, 411, 807, 95);
      panel.add(mainBtnPane);
      mainBtnPane.setLayout(null);
      
		
	
      Button FAQBtn = new Button("FAQ List");
      FAQBtn.setBounds(561, 0, 144, 83);
      mainBtnPane.add(FAQBtn);
      FAQBtn.setForeground(new Color(255, 255, 255));
      FAQBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
      FAQBtn.setBackground(new Color(135, 206, 250));
      
      
      JSeparator client1 = new JSeparator();
      client1.setForeground(Color.BLACK);
      client1.setBounds(78, 25, 203, 2);
      ClientPane.add(client1);
      
      JSeparator client2 = new JSeparator();
      client2.setForeground(Color.BLACK);
      client2.setBounds(515, 25, 203, 2);
      ClientPane.add(client2);

	  Button ClientLBtn = new Button("ClientList");
      JLabel lblClient = new JLabel("Client List");
      lblClient.setForeground(SystemColor.textHighlight);
      lblClient.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 27));
      lblClient.setBounds(317, 10, 154, 32);
      ClientPane.add(lblClient);
      
      
      
      ClientLBtn.setBounds(64, 0, 133, 83);
      mainBtnPane.add(ClientLBtn);
      ClientLBtn.setForeground(new Color(255, 255, 255));
      ClientLBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
      ClientLBtn.setBackground(new Color(135, 206, 250));
      
      GosuBtn.setForeground(Color.WHITE);
      GosuBtn.setFont(new Font("D2Coding", Font.PLAIN, 15));
      GosuBtn.setBackground(new Color(135, 206, 250));
      GosuBtn.setBounds(321, 0, 133, 83);
      mainBtnPane.add(GosuBtn);
      //회원 리스트
      userTable = new JTable();
      userTable.setModel(new DefaultTableModel(getUserList(), getUserColumnList() ) {
    	  @Override
    	  public boolean isCellEditable(int row, int column) {
    		  
    		  return false; 
    	  }				
      }
  	  );
      userTable.repaint();
      userpane = new JScrollPane(userTable);
      userpane.setBounds(0, 94, 794, 276);
      ClientPane.add(userpane);
      
      //고수 리스트
      gosuTable = new JTable();
      gosuTable.setModel(new DefaultTableModel(getGosuList(), getGosuColumnList()  ) {
    	  @Override
    	  public boolean isCellEditable(int row, int column) {
    		  
    		  return false; 
    	  }				
      }
      );
      gosuTable.repaint();
     gosupane = new JScrollPane(gosuTable);
     gosupane.setBounds(0, 94, 794, 276);
     GosuPane.add(gosupane);
    
     //FAQ 테이블리스트
     JTable FAQTable = new JTable();
     FAQTable.setModel(new DefaultTableModel(getFAQList(), getFAQColumnList() ) {;
     	@Override
     	public boolean isCellEditable(int row, int column) {
		  
		  return false; 
	  }				
     
     }
     );
     FAQTable.repaint();
     faqpane = new JScrollPane(FAQTable);
     faqpane.setBounds(0, 94, 794, 276);
     FAQPane.add(faqpane);
      
   
 
      ClientLBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ClientPane.setVisible(true);
			GosuPane.setVisible(false);
			FAQPane.setVisible(false);
		
		}
	});
      
      GosuBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ClientPane.setVisible(false);
			GosuPane.setVisible(true);
			FAQPane.setVisible(false);
			
		}
      });

      FAQBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ClientPane.setVisible(false);
			GosuPane.setVisible(false);
			FAQPane.setVisible(true);
		}
	});
 
   }
   

private Vector<Vector> getFAQList() {
	gosuDao dao = new gosuDao();
	Vector<Vector> list = dao.getFAQList();
	return list;
}
private Vector<String> getFAQColumnList() {
	Vector<String> cols = new Vector<>();
	cols.add("FAQ_CODE");
	cols.add("U_ID");
	cols.add("F_DATE");
	cols.add("F_HEAD");
	cols.add("F_BODY");
	cols.add("REPLY");
	cols.add("CHECK");
	return cols;
}

// 고수리스트
  private Vector<Vector> getGosuList() {
	gosuDao dao = new gosuDao();
	Vector<Vector> list = dao.getGosuList();
	return list;
}
private Vector<String> getGosuColumnList() {
	Vector<String> cols = new Vector<>();
	cols.add("업무번호");
	cols.add("중분류번호");
	cols.add("ID");
	cols.add("Price");
	cols.add("구군");
	return cols;
}


// 사용자 list
private Vector<Vector> getUserList() {
	gosuDao dao = new gosuDao();
	Vector<Vector> list = dao.getUserList();
	return list;
}// 사용자  lsit
private Vector<String> getUserColumnList() {
	Vector<String> cols = new Vector<>();
	cols.add("ID");
	cols.add("PW");
	cols.add("NAME");
	cols.add("EMAIL");
	cols.add("GENDER");
	cols.add("PHONE");
	cols.add("SIDO");
	cols.add("GUGUN");
	return cols;
}
@Override
public void actionPerformed(ActionEvent e) {

	}
public static void main(String[] args) {
	new ConstructorPage();
}
}

