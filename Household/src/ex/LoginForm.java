package ex;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginForm extends JFrame{
	FormDTO dto = new FormDTO();	//dto 객체 생성
	JTextField tf_id = new JTextField();
	String name="";
	
	public LoginForm() {
		super("Household_login"); //타이틀
		
		
        
        setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        JLabel lb_text1 = new JLabel("Login Page");
        JLabel lb_id = new JLabel("id");
        
        JLabel lb_pw = new JLabel("password");
        JPasswordField tf_pw = new JPasswordField();
        JButton btn_login = new JButton("로그인");
        JButton btn_join = new JButton("회원가입");
        
        lb_text1.setBounds(160, 20, 100, 30);
        lb_id.setBounds(100, 80, 30, 30);
        tf_id.setBounds(135, 80, 150, 30);
        lb_pw.setBounds(55, 120, 70, 30);
        tf_pw.setBounds(135, 120, 150, 30);
        btn_login.setBounds(45, 180, 120, 50);
        btn_join.setBounds(220, 180, 120, 50);
        
        
        
        setSize(400, 300); //창 크기 설정
        
        p1.add(lb_text1);
        p1.add(lb_id);
        p1.add(tf_id);
        p1.add(lb_pw);
        p1.add(tf_pw);
        p1.add(btn_login);
        p1.add(btn_join);
        add(p1);
 
        Dimension frameSize = getSize();
 
        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        /*	이벤트 코드	*/
        
        btn_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				name = tf_id.getText();
				String pw = tf_pw.getText();
				dto.setName(name);
				
				
				int result = FormDAO.login(name, pw);
				if(result==1){
					//로그인 성공 메시지
					JOptionPane.showMessageDialog(null, "로그인 성공! "+tf_id.getText()+"님, 환영합니다!", "login", 
						JOptionPane.PLAIN_MESSAGE);
					
					new HomeForm(name);
					setVisible(false);	//창 안보이게 하기
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
					
			}
				
				
        	
        });
        
        
        btn_join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object obj = e.getSource();
				
				if(tf_id.getText()!= null && tf_pw.getText()!= null) {
					dto.setName(tf_id.getText());
					dto.setPw(tf_pw.getText());
					
					try {
						FormDAO.create(dto);	//dto를 dao에 넘겨준다
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "회원가입 성공! 로그인 해주세요", "join", 
							JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "회원가입 실패...id, password 모두 입력해주세요!", "error", JOptionPane.PLAIN_MESSAGE);
				}
				
				
			}
        	
        	});
        
        
 
        
    }


}
