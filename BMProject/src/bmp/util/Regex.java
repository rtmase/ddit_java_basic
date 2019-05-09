package bmp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 정규 표현식을 담은 클래스
 * @author LDH
 *
 */
public class Regex {
	
	/**
	 * user_id를 받아서 정규 표현식에 일치하는지 확인하는 메서드
	 * 
	 * @author LDH
	 * @param user_id
	 * @return flag
	 */
	public boolean regexId(String user_id) {
		
		boolean flag = false;
//		1. 영문으로만, '_'를 제외한 특수문자 안됨 
//		2. 영문, 숫자, '_'으로만 이루어진 4 ~ 11자 이하

		String idPattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{3,11}$";
				
		Pattern p = Pattern.compile(idPattern);
		Matcher m = p.matcher(user_id);
		
		if (!m.matches()) 
			System.out.println("아이디를 4~20자사이로 입력하세요");
		else
			flag = true;
		
		return flag;
	}
	
	public boolean regexPw(String user_pw) {
		
		boolean flag = false;
//		1. 영문(대소문자 구분), 숫자, 특수문자 조합
//		2. 5~12자리 사이 문자
//		5. 공백문자 사용 불가
		
//		String pwPattern = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{5,12}$";
		String pwPattern = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$";
		Pattern p = Pattern.compile(pwPattern);
		Matcher m = p.matcher(user_pw);
		
		if (!m.matches()) 
			System.out.println("영문(대소문자 구분), 숫자, 특수문자 5 ~ 12자 사이로 입력하세요");
		else
			flag = true;
		
		return flag;
	}
}
