package bmp.vo;

import java.util.List;

/**
 * 상점 정보를 저장하는 클래스
 * 
 * @author LDH
 *
 */
public class ShopVO {
	
	// 가게 번호
	private int sNum ;
	
	// 가게 이름
	private String name;
	
	// 주소
	private String addr1;
	
	private String addr2;
	
	// 전화번호
	private String tel;
	
	// 카테고리 번호
	private int cNum;
	
	// 사업자 아이디
	private String sId;
	
	// 사업활성화 여부
	private boolean actStatus;
	
	// 생성자
	public ShopVO() {	
		this.sNum = 0;
		this.name = null;
		this.addr1 = null;
		this.addr2 = null;
		this.tel = null;
		this.sId = null;
		this.actStatus = true;
	}
	
	public ShopVO(ShopVO shop) {
		this.sNum = shop.sNum;
		this.name = shop.name;
		this.addr1 = shop.addr1;
		this.addr2 = shop.addr2;
		this.tel = shop.tel;
		this.sId = shop.sId;
		this.actStatus = shop.actStatus;
	}
	
	// getter setter
	public int getsNum() {
		return sNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	
	public String getAddr2() {
		return addr1;
	}

	public void setAddr2(String addr2) {
		this.addr1 = addr2;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	
	public String getsId() {
		return sId;
	}

	public void setsId(String id) {
		this.sId = id;
	}
	
	public boolean isActStatus() {
		return actStatus;
	}

	public void setActStatus(boolean actStatus) {
		this.actStatus = actStatus;
	}
	

}
