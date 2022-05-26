package ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FormDAO {

	FormDAO() {

	}

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static ResultSet rs = null;

	// DB연동 메소드
	private static void connDB() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/household", "root", "1234");
			System.out.println("DB 연결 완료");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 실행 에러");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean create(FormDTO dto) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;

		String name = dto.getName();
		String pw = dto.getPw();

		String join_sql = "INSERT INTO member(name, pw) VALUES ('" + name + "', '" + pw + "')";

		try {
			connDB();
			pstmt = conn.prepareStatement(join_sql);
			pstmt.executeUpdate(join_sql);

			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("에러");
			flag = false;
		}
		return flag;
	}

	public static int login(String name, String pw) {

		try {
			connDB();
			String login_sql = "SELECT COUNT(*) FROM member WHERE name = ? AND pw = ?";
			pstmt = conn.prepareStatement(login_sql);

			pstmt.setString(1, name);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getInt(1) == 1) {
					System.out.println(rs.getInt(1));
					return 1; // 로그인 성공
				} else {
					return 0; // 비밀번호 불일치
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // DB오류
	}

	public static void write(FormDTO dto) {
		
		String name = dto.getName();
		String date = dto.getDate();
		String dept = dto.getDept();
		int income = dto.getIncome();
		int expense = dto.getExpense();

		System.out.println(date);
		System.out.println(dept);
		System.out.println(income);
		System.out.println(expense);

		String write_sql = "INSERT INTO data(id, date, dept, income, expense) VALUES " + "('" + name + "', '" + date
				+ "', '" + dept + "', '" + income + "', '" + expense + "')";
		try {
			connDB();
			pstmt.executeUpdate(write_sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<FormDTO> output(String name) {

		String output_sql = "SELECT id, date, dept, income, expense FROM data where id = ?";
		FormDTO dto = null;
		List<FormDTO> inf_li = new ArrayList();

		try {
			connDB();
			pstmt = conn.prepareStatement(output_sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				dto=new FormDTO();
				dto.setName(rs.getString("id"));
				dto.setDate(rs.getString("date"));
				dto.setDept(rs.getString("dept"));
				dto.setIncome(rs.getInt("income"));
				dto.setExpense(rs.getInt("expense"));
				System.out.println(dto.getDate());
				System.out.println(dto.getDept());
				System.out.println(dto.getIncome());
				System.out.println(dto.getExpense());
				inf_li.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return inf_li;
	}

}
