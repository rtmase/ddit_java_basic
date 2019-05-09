package bmp.vo;

/**
 * 카테고리 정보를 저장하는 클래스
 * 
 * @author LDH
 *
 */
public class CategoryVO {
	
	// 카테고리 번호
	private int cNum;
	
	// 카테고리 이름
	private String categoryName;

	
	public int getcNum() {
		return cNum;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String name) {
		this.categoryName = name;
	}
	
	
}
