package bmp.vo;
/**
 * 사업자 정보를 저장하는 클래스
 * 
 * @author LDH
 *
 */
public class OwnerVO extends PersonP {
	
	// 사업자 번호
	private int corpNum;
	
	// 생성자
	public OwnerVO() {
		super();
	}
	
	public OwnerVO(String id, String pw, String name, String tel,int corpNum) {
		super(id,pw,name,tel,"사업자");
		this.corpNum = corpNum;
	}

	// getter setter
	public String getoId() {
		return super.getId();
	}

	public void setoId(String id) {
		super.setId(id);
	}

	public String getPw() {
		return super.getPw();
	}

	public void setPw(String pw) {
		super.setPw(pw);
	}

	public String getName() {
		return super.getName();
	}

	public void setName(String name) {
		super.setName(name);
	}
	
	public String getTel() {
		return super.getTel();
	}
	
	public void setTel(String tel) {
		super.setTel(tel);
	}
	
	public int getCorpNum() {
		return corpNum;
	}
	
	public String getGrade() {
		return super.getGrade();
	}

	public void setGrade(int num) {
		String grade = null;
		if (num == 6) 
			grade = "사업자";
		else {
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		
		super.setGrade(grade);
	}
	
	public void setCorpNum(int corpNum) {
		this.corpNum = corpNum;
	}
	
}
