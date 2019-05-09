package bmp.dao;

import java.util.List;
import java.util.Map;

import bmp.vo.UserVO;

public interface IUserDao {
	
	/**
	 * 회원가입한 유저의 데이터를 추가하는 메서드
	 * 
	 * @param user 객체를 받아 DB에 저장
	 * @return 성공시 1을 반환, 실패시 -1 반환
	 */
	int insertUser(UserVO user);
	
	/**
	 * 유저의 회원정보를 수정하는 메서드
	 * 
	 * @param user 객체를 받아서 해당 유저에 관한 정보를 변경 
	 * @return 성공시 1을 반환, 실패시 -1 반환
	 */
	int updateUser(UserVO user);
	
	/**
	 * 유저가 회원탈퇴하는 메서드
	 * 
	 * @param idPwd <key: id, value: pwd> 값을 받아 해당 회원을 삭제  
	 * @return 성공시 1을 반환, 실패시 -1 반환
	 */
	int deleteUser(Map<String, String> idPwd);
	
	/**
	 * 원하는 유저의 정보를 가져오는 메서드
	 * 
	 * @param user 객체를 받아 해당하는 유저 정보 가져오기
	 * @return 해당하는 user의 정보를 반환
	 */
	UserVO readUser(UserVO user);
	
	/**
	 * 모든 유저들의 정보를 가져오는 메서드
	 * 
	 * @return List<UserVO> 에 정보를 담아서 반환
	 */
	List<UserVO> readAllUser();
	
	/**
	 * 같은 아이디가 존재하는 지 검사하는 메서드
	 * 
	 * @param id 를 받아 같은 id가 있는지 검사
	 * @return id 가 없으면 true 반환, 있으면 false 반환
	 */
	boolean checkUserId(String id);
	
	/**
	 * 접속하기 위해 아이디와 비밀번호를 검사하는 메서드
	 * @param idPwd <key: id, value: pwd> 값을 받아 해당 회원을 조회
	 * @return 성공시 해당 유저 정보를 반환, 실패시 null 반환
	 */
	UserVO joinUser(Map<String, String> idPwd);
}
