package bmp.vo;

import java.sql.Date;
/**
 * 주문에 대한 정보를 저장하는 클래스
 * 
 * @author LDH
 *
 */
public class OrderVO {
	
	// 주문 번호
	private int oNum;
	
	// 상점 번호
	private int sNum;
	
	// 아이디
	private String uId;
	
	// 주문 날짜
	private Date date;

	public OrderVO(int oNum, int sNum, String uId, Date date) {
		super();
		this.oNum = oNum;
		this.sNum = sNum;
		this.uId = uId;
		this.date = date;
	}

	public int getoNum() {
		return oNum;
	}

	public void setoNum(int oNum) {
		this.oNum = oNum;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
