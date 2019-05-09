package bmp.vo;
/**
 * 리뷰에 대한 정보를 저장하는 클래스
 * 
 * @author LDH
 *
 */
public class ReviewVO {
	
	// 리뷰 번호
	private int rNum;
	
	// 유저 아이디
	private String id;
	
	// 주문 번호
	private int oNum;
	
	// 가게 이름
	private String name;
	
	// 내용
	private String content;
	
	// 별점
	private int star;
	
	// getter setter
	public int getrNum() {
		return rNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public int getoNum() {
		return oNum;
	}

	public void setoNum(int oNum) {
		this.oNum = oNum;
	}

}
