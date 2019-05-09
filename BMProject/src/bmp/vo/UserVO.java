package bmp.vo;

/**
 * 유저 정보를 저장하는 클래스
 * 
 * @author LDH
 *
 */
public class UserVO extends PersonP {
	
	// 주소
	private String addr1;
	
	// 상세 주소
	private String addr2;
	
	// 포인트
	private int point;
	
	// 생성자
	public UserVO() {
		super();
		addr1 = null;
		addr2 = null;
		point = 0;
	}
	
	public UserVO(String id, String pw, String name, String tel, String addr1, String addr2) {
		super(id,pw,name,tel,"일반회원");
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.point = 0;
	}
	
	// getter, setter
	public String getuId() {
		return super.getId();
	}

	public void setuId(String id) {
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
	
	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	
	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}


	public String getTel() {
		return super.getTel();
	}

	public void setTel(String tel) {
		super.setTel(tel);
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point += point;
	}

	public String getGrade() {
		return super.getGrade();
	}

	public void setGrade(int num) {
		String grade = null;
		if (num == 1) 
			grade = "일반회원";
		else if (num == 2) 
			grade = "VIP";
		else if (num == 3) 
			grade ="VVIP";
		else if (num == 0) 
			grade = "관리자";
		else {
			System.out.println("잘못입력하셨습니다.");
			return;
		}
		
		super.setGrade(grade);
	}
	
//	// 등업 메서드 - dao
//		public int upPoint(){
//			
//			int num = 0;
//			
//			count++;
//			if (count > 5) 
//				num = 2;
//			else if (count > 10) 
//				num = 3;
//			else if (count > 20) 
//				num = 4;
//			
//			return num;
//		}
	
	
}
