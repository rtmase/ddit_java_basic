package bmp.vo;

public class CartVO {
	
	private int cNum;
	private int mNum;
	private int quantity;
	
	public CartVO() {	}
	
	public CartVO(int cNum, int mNum, int quantity) {
		this.cNum = cNum;
		this.mNum = mNum;
		this.quantity = quantity;
	}
	public int getcNum() {
		return cNum;
	}
	public void setcNum(int cNum) {
		this.cNum = cNum;
	}
	public int getmNum() {
		return mNum;
	}
	public void setmNum(int mNum) {
		this.mNum = mNum;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
