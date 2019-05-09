package bmp.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import bmp.dao.IUserDao;
import bmp.dao.UserDaoImpl;
import bmp.vo.UserVO;

public class UserServiceImpl implements IUserService {
	
	private IUserDao dao;
	private static IUserService service; 
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	private UserServiceImpl() {
		dao = UserDaoImpl.getInstance(); 
	}
	
	public static IUserService getInstance() {
		if (service == null) {
			service = new UserServiceImpl();
		}
		
		return service;
	}
	
	@Override
	public int insertUser(UserVO user) {
		logger.info("insertUser...");
		return dao.insertUser(user);
	}

	@Override
	public int updateUser(UserVO user) {
		logger.info("updateUser...");
		return dao.updateUser(user);
	}

	@Override
	public int deleteUser(Map<String, String> idPwd) {
		logger.info("deleteUser...");
		return dao.deleteUser(idPwd);
	}

	@Override
	public UserVO readUser(UserVO user) {
		logger.info("readUser...");
		return dao.readUser(user);
	}

	@Override
	public List<UserVO> readAllUser() {
		logger.info("readAllUser...");
		return dao.readAllUser();
	}

	@Override
	public boolean checkUserId(String id) {
		logger.info("checkUserId...");
		return dao.checkUserId(id);
	}

	@Override
	public UserVO joinUser(Map<String, String> idPwd) {
		logger.info("JoinUser...");
		return dao.joinUser(idPwd);
	}

}
