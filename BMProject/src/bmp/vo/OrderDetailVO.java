package bmp.vo;
/**
 * 주문 상세 정보를 저장하는 클래스
 * 
 * @author LDH
 *
 */
public class OrderDetailVO {
	
	// 주문 상세 번호
	private int dNum;
	
	// 주문 번호
	private int oNum;
	
	// 메뉴 번호
	private int mNum;
	
	// 메뉴 수량
	private int detail_qty;

	public OrderDetailVO() {	}
	
	public OrderDetailVO(int dNum, int oNum, int mNum, int detail_qty) {
		super();
		this.dNum = dNum;
		this.oNum = oNum;
		this.mNum = mNum;
		this.detail_qty = detail_qty;
	}

	public int getdNum() {
		return dNum;
	}

	public void setdNum(int dNum) {
		this.dNum = dNum;
	}

	public int getoNum() {
		return oNum;
	}

	public void setoNum(int oNum) {
		this.oNum = oNum;
	}

	public int getmNum() {
		return mNum;
	}

	public void setmNum(int mNum) {
		this.mNum = mNum;
	}

	public int getDetail_qty() {
		return detail_qty;
	}

	public void setDetail_qty(int detail_qty) {
		this.detail_qty = detail_qty;
	}
	
	
	
}
