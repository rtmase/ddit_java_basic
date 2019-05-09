package bmp.util;

import com.ibatis.sqlmap.client.SqlMapClient;

import bmp.vo.OwnerVO;
import bmp.vo.UserVO;

/**
 *  로그인한 사람의 정보를 저장하는 클래스
 *  
 * @author LDH
 *
 */
public class Session {
	
	private static UserVO loginUser;
	private static OwnerVO loginOwner;
//	private static  sessionlogin;
	private static Session session;
	private Session() { }
	
	public static Session getInstance() {
		if (session == null) {
			session = new Session();
		}
		
		return session;
	}
	
	public UserVO getLoginUser() {
		return loginUser;
	}
	
	public OwnerVO getLoginOwner() {
		return loginOwner;
	}
	
	public void setLoginUser(UserVO loginUser) {
		this.loginUser = loginUser;
	}
	
	public void setLoginOwner(OwnerVO loginOwner) {
		this.loginOwner = loginOwner;
	}
}
