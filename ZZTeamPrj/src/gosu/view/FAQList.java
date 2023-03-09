package gosu.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gosu.data.gosuDao;






public class FAQList extends JFrame implements MouseListener{
	
	String uid;

	
	private JFrame frame;
	JButton       btnInsert,  btnRefresh, btnToExcel,btn1;
	JPanel        topPane;
	JPanel        topPane1;
	JTable        jTable;
	JScrollPane   pane; 
	JLabel        JLabel;
	
	FAQList           faqlist = null;
	FAQ                faq = null;  
    static FAQList    fList = null;																	
	
	public  FAQList(String uid) {
		this.uid = uid;
		initComponent();
	}
	
	public FAQList() {
		
	}

	// 부품(component) 배치, 배치방법(layout), 기능연결(addaction event 지정)
	private  void initComponent() {
		frame = new JFrame();
		
		topPane      =  new JPanel();
	 //   image1 = new ImageIcon("")
		JLabel       =  new JLabel("FAQ List");  
		JLabel.setPreferredSize(new Dimension(200, 50));
		JLabel.setFont(JLabel.getFont().deriveFont(40.0f));
		
		topPane.add( JLabel );
		
		
		this.add(topPane, BorderLayout.NORTH);
		
		jTable      =   new  JTable();		
		// data 를 model 에 담아서 채움
		jTable.setModel(
			new DefaultTableModel( getDataList() , getColumnList() ) {				
				// 기본 option 설정 - 각 cell 에 대한 편집가능여부 :isCellEditable
				@Override
				public boolean isCellEditable(int row, int column) {
				//	int  currLine = jTable.getSelectedRow();  // 선택한 줄만 수정가능
				//	if( row == currLine  )
				//		return true;			
					return false;   // 모든 cell 편집불가능
				}				
			}	
		);
		
		JLabel lblNewLabel = new JLabel("FAQ List");
		
		
		//jTable 의 Row 이 더블클릭(마우스 동작연결)되면
		jTable.addMouseListener( this );
		
		
		pane  = new JScrollPane( jTable );
		this.add( pane );
		
		topPane1      =  new JPanel();
		
		btn1 = new JButton("문의 사항 등록");
		btnRefresh   =  new JButton("새로고침"); 
		
		topPane1.add( btn1 );
		topPane1.add( btnRefresh );
		this.add(topPane1, BorderLayout.SOUTH);
		//frame.setVisible(true);

		
		//----------------------------------------------		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 500);
		setLocation(200, 200);
		setVisible(true);

	btn1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//new FAQ();
			
			String  id2  = uid;
			System.out.println( e );	
			if ( faq != null)
				faq.dispose();
			FAQList fff = FAQList.this;
			faq = new FAQ( id2, fff );
			
			
		}
	});	
	btnRefresh.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			jTableRefresh();
			
		}
	});
		
	}
	

	private Vector<?> getColumnList() {
		Vector<String>  cols = new Vector<>();
		cols.add("ID");
		cols.add("답변번호");// 문자배열 대신 사용		
		cols.add("제목");
		cols.add("내용");
		cols.add("답변여부");
		return  cols;
	}

	private Vector<Vector> getDataList() {
		gosuDao         dao   =  new gosuDao();
		Vector<Vector>  list  =  dao.getHList(uid);
		return  list;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 마우스를 클릭하면
				// button=1 : 왼쪽, button=2 : 가운데, button=3 : 오른쪽
				int     row = jTable.getSelectedRow();
				// int     col = jTable.getSelectedColumn();
				String  id  = (String) jTable.getValueAt(row, 0); 
				System.out.println( e );	
				if ( faq != null)
					faq.dispose();
				faq = new FAQ( id, this );				
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		fList = new FAQList(null);
	}
	
       public void jTableRefresh() {
		
		jTable.setModel(
			new DefaultTableModel( getDataList(),  getColumnList()  ) {

				@Override
				public boolean isCellEditable(int row, int column) {					
					return false;
				}
				
				
			}
		);  // jtable 새로운 데이터를 지정
		
		jTable.repaint();  // jtable을 새로 그린다
	}
       
}

		



