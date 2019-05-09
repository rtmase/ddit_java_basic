package bmp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;

import bmp.util.Ibatis;
import bmp.vo.UserVO;

public class UserDaoImpl implements IUserDao {
	
	private static IUserDao dao;
	private SqlMapClient smc;
	
	private static Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	private UserDaoImpl() {
		smc = Ibatis.getInstance();
	}
	
	public static IUserDao getInstance() {
		if(dao == null){
			dao = new UserDaoImpl();
		}
		return dao;
	}
	
	@Override
	public int insertUser(UserVO user) {
		logger.info("insertUser...");
		
		Object obj = null;
		int addCnt = -1;
		
		try {
			obj = smc.insert("bmp.mapper.UserMapper.insertUser", user);
		} catch (SQLException e) {
			logger.debug("SQL INSERT ERROR");
			e.printStackTrace();
			
		}
		if (obj == null) {
			logger.info("SUCCESS INSERT USER");
			addCnt = 1;
		}
		else // 실패시 error가 들어감
			logger.info("FAILURE INSERT USER");
			
		return addCnt;
	}

	@Override
	public int updateUser(UserVO user) {
		logger.info("updateUser...");
		
		if (!checkUserId(user.getId())) {
			logger.info("NON-EXISTENT ID");
			return -1;
		}
		
		int setCnt = -1;
		try {
			setCnt = smc.update("bmp.mapper.UserMapper.updateUser",user);
		} catch (SQLException e) {
			logger.debug("SQL UPDATE ERROR");
			e.printStackTrace();
		}
		if (setCnt > 0) {
			logger.info("SUCCESS UPDATE USER");
		}
		else
			logger.info("FAILURE UPDATE USER");
		
		return setCnt;
	}

	@Override
	public int deleteUser(Map<String, String> idPwd) {
		logger.info("deleteUser...");
		Map<String, String> parameters = idPwd;
		
		if (!checkUserId(parameters.get("user_id"))) {
			logger.info("NON-EXISTENT ID");
			return -1;
		}
		
		int rmCnt = -1;
		
		try {
			rmCnt = smc.delete("bmp.mapper.UserMapper.deleteUSer",parameters);
		} catch (SQLException e) {
			logger.debug("SQL DELETE ERROR");
			e.printStackTrace();
		}
		if (rmCnt > 0) {
			logger.info("SUCCESS DELETE USER");
		}
		else
			logger.info("FAILURE DELETE USER");
		
		return rmCnt;
	}

	@Override
	public UserVO readUser(UserVO user) {
		logger.info("readUser...");
		
		UserVO found = null;
		
		try {
			found = (UserVO) smc.queryForObject("bmp.mapper.UserMapper.readUser",user);
		} catch (SQLException e) {
			logger.debug("SQL SELECT ERROR - READUSER");
			e.printStackTrace();
		}
		if (found == null) {
			logger.info("FAILURE SELECT USER");
		}	
		else
			logger.info("SUCCESS SELECT USER");
		
		return found;
	}

	@Override
	public List<UserVO> readAllUser() {
		logger.info("readAllUser...");
		
		List<UserVO> bList = new ArrayList<UserVO>();
		try {
			bList = smc.queryForList("bmp.mapper.UserMapper.readAllUser");
			
		} catch (SQLException e) {
			logger.debug("SQL SELECT ERROR - READALLUSER");
			e.printStackTrace();
		}
		if (bList != null) {
			logger.info("SUCCESS SELECT ALL USER");
		}
		else
			logger.info("FAILURE SELECT ALL USER");
		
		
		return bList;
	}

	@Override
	public boolean checkUserId(String id) {
		logger.info("checkUserId...");
		
		boolean isExist = true;
		int userIsExist = -1;
			
		try {
			userIsExist = (int) smc.queryForObject("bmp.mapper.UserMapper.checkId",id);
		} catch (SQLException e) {
			logger.info("SQL SELECT ERROR - ISEXIST");
			e.printStackTrace();
		}
		
		if (userIsExist > 0) {
			isExist = false;
			logger.info("SUCCESS SELECT ID");
		}
		
		return isExist;
	}

	@Override
	public UserVO joinUser(Map<String, String> idPwd) {
		logger.info("joinUser...");
		
		Map<String, String> parameters = idPwd;
		UserVO found = null;
		
		if (!checkUserId(parameters.get("user_id"))) {
			logger.info("NON-EXISTENT ID");
		}
		
		try {
			found = (UserVO) smc.queryForObject("bmp.mapper.UserMapper.joinUser",parameters);
		} catch (SQLException e) {
			logger.debug("SQL DELETE ERROR");
			e.printStackTrace();
		}
		if (found == null) {
			logger.info("FAILURE SELECT USER");
		}	
		else
			logger.info("SUCCESS SELECT USER");
		
		return found;
	}

}
