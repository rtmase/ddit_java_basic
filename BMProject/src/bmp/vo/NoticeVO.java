package bmp.vo;

import java.util.Date;
/**
 * 공지사항의 정보를 저장하는 클래스
 * 
 * @author LDH
 *
 */
public class NoticeVO {
	
	// 공지 번호
	private int nNum;
	
	// 제목
	private String title;
	
	// 내용
	private String content;
	
	// 타입
	private String type;
	
	// 날짜
	private Date date;

	// getter setter
	public int getnNum() {
		return nNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
