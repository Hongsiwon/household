package ex;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ChangeBudgetForm extends JFrame{
	
	ChangeBudgetForm(List<FormDTO> inf_li){
		super("잔액 변경"); //타이틀
        int incomes= 0;
        int expenses= 0;
        int sum = 0;
        
        for(int i = 0; i<inf_li.size(); i++) {
        	incomes += inf_li.get(i).getIncome();
        	expenses += inf_li.get(i).getExpense();
        	System.out.println(inf_li.get(i).getDept());
        	System.out.println();
        }
        
        sum = incomes-expenses;
        
        setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        
        JLabel lb_text1 = new JLabel("잔액 변경");
        JLabel lb_text2 = new JLabel("<html>현재 잔액은 <br><br>"
        		+sum+ " 원 입니다.</html>");
        JLabel lb_text3 = new JLabel("변경할 금액");
        JTextField tf_price = new JTextField();
        JButton btn_update = new JButton("Update");
        
        
        lb_text1.setBounds(160, 15, 100, 30);
        lb_text2.setBounds(155, 50, 350, 200);
        lb_text3.setBounds(70, 220, 100, 30);
        tf_price.setBounds(160, 220, 150, 30);
        btn_update.setBounds(260, 330, 100, 50);


        setSize(400, 450);

        add(p1);
        p1.add(lb_text1);
        p1.add(lb_text2);
        p1.add(lb_text3);
        p1.add(tf_price);
        p1.add(btn_update);

        setLocationRelativeTo(null);	//가운데 정렬
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        
        btn_update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object obj = e.getSource();

				int pri = Integer.parseInt(tf_price.getText());
				FormDTO dto = new FormDTO();
				dto.setIncome(pri);
				dto.setName(inf_li.get(0).getName()); 	//로그인 한 사람으로 income 값 추가(잔액)
				dto.setDate(inf_li.get(0).getDate());
				dto.setDept("잔액 변경");
				try {
					FormDAO.write(dto);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "업데이트 성공! \n메뉴 화면으로 돌아갑니다.", "알림", 
						JOptionPane.PLAIN_MESSAGE);
				String name = null;
				new HomeForm(name);
				setVisible(false);

				
			}
        	
        });
	}

}
