package gosu.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gosu.data.faqVo;
import gosu.data.gosuDao;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class rep extends JFrame{
	
	
	ConstructorPage Conspage;
	TextField fcodetxt,idtxt,datetxt,headtxt,bodytxt,reptxt;
	Button sendBtn;
	
	public rep() {

	
		setVisible(true);
		setSize(new Dimension(477, 585));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setLayout(null);
		panel.setBounds(0, 0, 462, 547);
		getContentPane().add(panel);
		
		JLabel lblFaqcode = new JLabel("F_Code");
		lblFaqcode.setForeground(new Color(0, 0, 0));
		lblFaqcode.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		lblFaqcode.setBackground(new Color(0, 0, 0));
		lblFaqcode.setBounds(10, 10, 60, 15);
		panel.add(lblFaqcode);
		
		fcodetxt = new TextField();
		fcodetxt.setForeground(Color.BLACK);
		fcodetxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		fcodetxt.setColumns(10);
		fcodetxt.setBackground(Color.WHITE);
		fcodetxt.setBounds(10, 31, 71, 23);
		panel.add(fcodetxt);
		fcodetxt.setEditable(false);
		
		JLabel lblUid = new JLabel("U_ID");
		lblUid.setForeground(new Color(0, 0, 0));
		lblUid.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		lblUid.setBackground(Color.WHITE);
		lblUid.setBounds(128, 10, 60, 15);
		panel.add(lblUid);
		
		idtxt = new TextField();
		idtxt.setForeground(Color.BLACK);
		idtxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		idtxt.setColumns(10);
		idtxt.setBackground(Color.WHITE);
		idtxt.setBounds(128, 31, 71, 23);
		panel.add(idtxt);
		idtxt.setEditable(false);
		
		JLabel lblFdate = new JLabel("F_date");
		lblFdate.setForeground(new Color(0, 0, 0));
		lblFdate.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		lblFdate.setBackground(Color.WHITE);
		lblFdate.setBounds(252, 10, 60, 15);
		panel.add(lblFdate);
		
		datetxt = new TextField();
		datetxt.setForeground(Color.BLACK);
		datetxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		datetxt.setColumns(10);
		datetxt.setBackground(Color.WHITE);
		datetxt.setBounds(252, 31, 71, 23);
		panel.add(datetxt);
		datetxt.setEditable(false);
		
		JLabel lblhead = new JLabel("head");
		lblhead.setForeground(new Color(0, 0, 0));
		lblhead.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		lblhead.setBackground(Color.WHITE);
		lblhead.setBounds(10, 60, 60, 15);
		panel.add(lblhead);
		
		headtxt = new TextField();
		headtxt.setForeground(Color.BLACK);
		headtxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		headtxt.setColumns(10);
		headtxt.setBackground(Color.WHITE);
		headtxt.setBounds(10, 81, 275, 23);
		panel.add(headtxt);
		headtxt.setEditable(false);
		
		JLabel lblbody = new JLabel("body");
		lblbody.setForeground(new Color(0, 0, 0));
		lblbody.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		lblbody.setBackground(Color.WHITE);
		lblbody.setBounds(10, 110, 60, 15);
		panel.add(lblbody);
		
		bodytxt = new TextField("\uC544\uC774\uB514");
		bodytxt.setForeground(Color.BLACK);
		bodytxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		bodytxt.setColumns(10);
		bodytxt.setBackground(Color.WHITE);
		bodytxt.setBounds(10, 131, 442, 150);
		panel.add(bodytxt);
		bodytxt.setEditable(false);
		
		JLabel lblbody_1 = new JLabel("Rep");
		lblbody_1.setForeground(new Color(0, 0, 0));
		lblbody_1.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 15));
		lblbody_1.setBackground(Color.WHITE);
		lblbody_1.setBounds(10, 287, 60, 15);
		panel.add(lblbody_1);
		
		reptxt = new TextField("답변 :");
		reptxt.setForeground(Color.BLACK);
		reptxt.setFont(new Font("Sitka Text", Font.ITALIC, 13));
		reptxt.setColumns(10);
		reptxt.setBackground(Color.WHITE);
		reptxt.setBounds(10, 308, 442, 159);
		panel.add(reptxt);
		
		sendBtn = new Button("Send");
		sendBtn.setForeground(new Color(0, 0, 0));
		sendBtn.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
		sendBtn.setBackground(new Color(255, 255, 255));
		sendBtn.setBounds(80, 500, 96, 23);
		panel.add(sendBtn);
		sendBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repFaq();				
			}
		});
		
		Button cancelBtn = new Button("Cancel");
		cancelBtn.setForeground(new Color(0, 0, 0));
		cancelBtn.setFont(new Font("D2Coding", Font.BOLD | Font.ITALIC, 14));
		cancelBtn.setBackground(new Color(255, 255, 255));
		cancelBtn.setBounds(249, 500, 96, 23);
		panel.add(cancelBtn);
		
		FocusEvent();
	}

	

	private void FocusEvent() {
		reptxt.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (reptxt.getText().trim().length() == 0) {
					reptxt.setText("답변 :");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (reptxt.getText().trim().equals("답변 :")) {
					reptxt.setText("");
				}
			}
		});
		
	}



	protected void repFaq() {
		String id = this.idtxt.getText();
		gosuDao dao = new gosuDao();
		int choice  =   JOptionPane.showConfirmDialog(null, 
				id + "님의 글에 답글을 작성하시겠습니까? ",
				"확인",
				JOptionPane.OK_CANCEL_OPTION);
		int aftcnt = 0;
		String  msg    = "";
		if( choice == 0) {
			faqVo vo =  getViewData();
			aftcnt      =  dao.updateMember( vo );
			if( aftcnt > 0 )
				msg     =  id + "님의 문의글에 답글이 작성되었습니다.";
			else
				msg     =  id + "답글이 작성되지 않았습니다";
		} else {
			msg = "취소를 선택하였습니다";
		}
		JOptionPane.showConfirmDialog(null, 
				msg,
				"수정",
				JOptionPane.OK_OPTION);
		
		this.dispose();
		Conspage.dispose();
		Conspage = new ConstructorPage();
		
		
	}



	private faqVo getViewData() {
		String rep = this.reptxt.getText();
		String id = this.idtxt.getText();
		faqVo vo = new faqVo(id,rep);
		return vo;
	}



	public rep(String fcode, String uid, String fdate, String fhead, String fbody, ConstructorPage Conspage) {
		this();
		this.Conspage = Conspage;
		fcodetxt.setText(fcode);
		idtxt.setText(uid);
		datetxt.setText(fdate);
		headtxt.setText(fhead);
		bodytxt.setText(fbody);
		
	}
}
