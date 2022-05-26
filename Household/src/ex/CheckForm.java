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
import javax.swing.WindowConstants;

public class CheckForm extends JFrame {
	CheckForm(List<FormDTO> inf_li) {
		super("잔액조회"); // 타이틀
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(null);

		JLabel lb_ch = new JLabel("조회");
		JButton btn_budget = new JButton("잔액변경");
		JButton btn_back = new JButton("뒤로가기");
		JLabel infor_da = new JLabel("날짜");
		JLabel infor_de = new JLabel("memo");
		JLabel infor_in = new JLabel("수입");
		JLabel infor_ex = new JLabel("지출");

		for (int i = 0; i < inf_li.size(); i++) {
			JLabel infor_date = new JLabel(inf_li.get(i).getDate());
			JLabel infor_dept = new JLabel(inf_li.get(i).getDept());
			JLabel infor_income = new JLabel(Integer.toString(inf_li.get(i).getIncome()));
			JLabel infor_expense = new JLabel(Integer.toString(inf_li.get(i).getExpense()));

			infor_date.setBounds(50, 50 + 20 * (i + 1), 150, 30);
			infor_dept.setBounds(200, 50 + 20 * (i + 1), 150, 30);
			infor_income.setBounds(350, 50 + 20 * (i + 1), 150, 30);
			infor_expense.setBounds(500, 50 + 20 * (i + 1), 150, 30);

			p1.add(infor_date);
			p1.add(infor_dept);
			p1.add(infor_income);
			p1.add(infor_expense);
		}

		infor_da.setBounds(60, 40, 150, 30);
		infor_de.setBounds(210, 40, 150, 30);
		infor_in.setBounds(360, 40, 150, 30);
		infor_ex.setBounds(510, 40, 150, 30);

		lb_ch.setBounds(280, 10, 100, 30);
		btn_budget.setBounds(470, 320, 90, 25);
		btn_back.setBounds(370, 320, 90, 25);

		setSize(600, 400);

		add(p1);
		p1.add(lb_ch);
		p1.add(btn_budget);
		p1.add(infor_da);
		p1.add(infor_de);
		p1.add(infor_in);
		p1.add(infor_ex);
		p1.add(btn_back);

		setLocationRelativeTo(null); // 가운데 정렬
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);

		btn_budget.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();

				new ChangeBudgetForm(inf_li);
				setVisible(false);
			}

		});
		
		btn_back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "이전 화면으로 돌아갑니다", "안내", 
						JOptionPane.PLAIN_MESSAGE);
				String name = null;
				new HomeForm(name);
				setVisible(false);
			}
			
		});

	}

}
