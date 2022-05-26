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
import javax.swing.text.AttributeSet.ColorAttribute;

public class HomeForm extends JFrame{
	 HomeForm(String name){
	        super("Household_HOME"); //타이틀
	        
	        setLayout(new BorderLayout());
	        JPanel p1 = new JPanel();
	        p1.setLayout(null);
	        
	        JLabel lb_text1 = new JLabel("메뉴");
	        JButton btn_check = new JButton("가계부 조회");
	        JButton btn_write = new JButton("가계부 작성");
	        JButton btn_exit = new JButton("exit");
	        
	        lb_text1.setBounds(180, 30, 100, 30);
	        btn_check.setBounds(45, 120, 130, 50);
	        btn_write.setBounds(210, 120, 130, 50);
	        btn_exit.setBounds(300, 220, 70, 30);


	        setSize(400, 300);

	        add(p1);
	        p1.add(lb_text1);
	        p1.add(btn_check);
	        p1.add(btn_write);
	        p1.add(btn_exit);

	        setLocationRelativeTo(null);	//가운데 정렬
	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	        setVisible(true);
	        
	        btn_check.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					System.out.println("조회버튼클릭");
					try {
						
						new CheckForm(FormDAO.output(name));
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
					
					setVisible(false);	//창 안보이게 하기
				}
	        	
	        });
	        
	        btn_write.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					new WriteForm(name);
					setVisible(false);
				}
	        	
	        });
	        
	        btn_exit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JOptionPane.showMessageDialog(null, "프로그램을 종료합니다.", "종료", 
							JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}
	        	
	        });
	    }

}
