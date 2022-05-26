package ex;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class WriteForm extends JFrame{
	
	FormDTO dto = new FormDTO();	//dto 객체 생성
	LoginForm log = new LoginForm();
	
	WriteForm(String name){
		super("가계부 작성"); //타이틀
        
		
        setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        
        JLabel lb_text1 = new JLabel("가계부 작성");
        JLabel lb_date = new JLabel("날짜");
        JTextField tf_date = new JTextField();
        JLabel lb_dept = new JLabel("분류");
        JTextField tf_dept = new JTextField();
        JLabel lb_income = new JLabel("수입");
        JTextField tf_income = new JTextField();
        JLabel lb_expense = new JLabel("지출");
        JTextField tf_expense = new JTextField();
        
        

        lb_text1.setBounds(155, 25, 100, 30);
        lb_date.setBounds(90, 100, 50, 30);
        tf_date.setBounds(125, 100, 170, 30);
        lb_dept.setBounds(90, 150, 50, 30);
        tf_dept.setBounds(125, 150, 170, 30);
        lb_income.setBounds(90, 200, 50, 30);
        tf_income.setBounds(125, 200, 170, 30);
        lb_expense.setBounds(90, 250, 50, 30);
        tf_expense.setBounds(125, 250, 170, 30);
        JButton btn_update = new JButton("Update");
        JButton btn_back = new JButton("뒤로가기");
        
        btn_update.setBounds(260, 330, 100, 50);
        btn_back.setBounds(50, 330, 100, 50);
        
        setSize(400, 450);

        add(p1);
        p1.add(lb_text1);
        p1.add(lb_date);
        p1.add(tf_date);
        p1.add(lb_dept);
        p1.add(tf_dept);
        p1.add(lb_income);
        p1.add(tf_income);
        p1.add(lb_expense);
        p1.add(tf_expense);
        p1.add(btn_update);
        p1.add(btn_back);

        setLocationRelativeTo(null);	//가운데 정렬
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        /*	이벤트 코드	*/
        
        btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				String in = tf_income.getText();
				String ex = tf_expense.getText();
				
				if(tf_income.getText() != null || tf_expense != null) {
					
					if(in.isEmpty()) {
						in = "0";
					}else if(ex.isEmpty()) {
						ex = "0";
					}
					
					dto.setDate(tf_date.getText());
					dto.setDept(tf_dept.getText());
					dto.setIncome(Integer.parseInt(in));
					dto.setExpense(Integer.parseInt(ex));
					dto.setName(name);
					
					try {
						FormDAO.write(dto);	//dto를 dao에 넘겨준다
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
					
				}else {
					
				}
				
				
				
				JOptionPane.showMessageDialog(null, "업데이트 성공! \n메뉴 화면으로 돌아갑니다.", "알림", 
						JOptionPane.PLAIN_MESSAGE);
				new HomeForm(name);
				setVisible(false);
			}
        	
        });
        
        btn_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "이전 화면으로 돌아갑니다", "안내", 
						JOptionPane.PLAIN_MESSAGE);
				new HomeForm(name);
				setVisible(false);
			}
        	
        });
        
        
	}

}
