package bmp.vo;

/**
 * 메뉴 정보를 저장하는 클래스
 * 
 * @author LDH
 */
public class MenuVO {	
	// 메뉴 번호	
	private int mNum;
	
	// 가게 번호	
	private int sNum;
	
	// 메뉴
	private String menu;
	
	// 가격
	private int price; 
	
	// getter setter
	public int getmNum() {
		return mNum;
	}
	
	public int getsNum() {
		return sNum;
	}
	public void setsNum(int sNum) {
		this.sNum = sNum;
	}
	
	public String getMenu() {
		return menu;
	}	
	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
