package bmp.vo;

public class PersonP {
	
	// 아이디
	private  String id;
	
	// 비밀번호
	private String pw;
	
	// 이름
	private String name;
	
	// 전화번호( '-' 제외)
	private String tel;
	
	// 등급 (1 ~ 3 : 일반회원,VIP,VVIP / 6 : 사업자 / 0 : 관리자)
	private String grade;
	
	// 생성자
	public PersonP() {
		this.grade = "일반회원";
	}

	public PersonP(String id, String pw, String name, String tel, String grade) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
