package bmp.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ibatis.sqlmap.client.SqlMapClient;

import bmp.util.Ibatis;
import bmp.vo.OwnerVO;

public class OwnerDaoImpl implements IOwnerDao {
	
	private static IOwnerDao dao;
	private SqlMapClient smc;
	
	private static Logger logger = Logger.getLogger(OwnerDaoImpl.class);
	
	private OwnerDaoImpl() {
		smc = Ibatis.getInstance();
	}
	
	public static IOwnerDao getInstance() {
		if(dao == null){
			dao = new OwnerDaoImpl();
		}
		return dao;
	}
	
	@Override
	public int insertOwner(OwnerVO owner) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOwner(OwnerVO owner) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOwner(Map<String, String> idPwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OwnerVO readOwner(OwnerVO owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OwnerVO> readAllOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkOwnerId(String id) {
		logger.info("checkOwnerId...");
		
		boolean isExist = true;
		int ownerIsExist = -1;
			
		try {
			ownerIsExist = (int) smc.queryForObject("bmp.mapper.OwnerMapper.checkId",id);
		} catch (SQLException e) {
			logger.info("SQL SELECT ERROR - ISEXIST");
			e.printStackTrace();
		}
		
		if (ownerIsExist > 0) {
			isExist = false;
			logger.info("SUCCESS SELECT ID");
		}
		
		return isExist;
	}

	@Override
	public OwnerVO joinOwner(Map<String, String> idPwd) {
		Map<String, String> parameters = idPwd;
		OwnerVO found = null;
		
		if (!checkOwnerId(parameters.get("user_id"))) {
			logger.info("NON-EXISTENT ID");
		}
		
		try {
			found = (OwnerVO) smc.queryForObject("bmp.mapper.OwnerMapper.joinOwner",parameters);
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
