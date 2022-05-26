package ex;


public class FormDTO {
	   
	   
    private String name;
    private String pw;
    private String user;
    private String date;
    private String dept;
    private int income;
    private int expense;
 
    //이클립스팁 : Getter/Setter 만들기
    //우클릭 -> source->Generate Getters And Setters-> [Select AlL] -> [OK]
   
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getExpense() {
		return expense;
	}

	public void setExpense(int expense) {
		this.expense = expense;
	}

	
    //DTO 객체 확인
    //이클립스팁 : toString() 자동생성: 우클릭 -> source -> Generate toString->[OK]
	
	@Override
	public String toString() {
		return "FormDTO [name=" + name + ", pw=" + pw + ", user=" + user + ", date=" + date + ", dept=" + dept
				+ ", income=" + income + ", expense=" + expense + "]";
	}

	
}