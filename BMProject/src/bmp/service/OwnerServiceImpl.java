package bmp.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import bmp.dao.IOwnerDao;
import bmp.dao.OwnerDaoImpl;
import bmp.view.MainViewController;
import bmp.vo.OwnerVO;

public class OwnerServiceImpl implements IOwnerService {
	
	private IOwnerDao dao;
	private static Logger logger = Logger.getLogger(OwnerServiceImpl.class);
	private static IOwnerService service; 
	
	private OwnerServiceImpl() {
		dao = OwnerDaoImpl.getInstance(); 
	}
	
	public static IOwnerService getInstance() {
		if (service == null) {
			service = new OwnerServiceImpl();
		}
		
		return service;
	}
	
	@Override
	public int insertOwner(OwnerVO owner) {
		logger.info("insertOwner...");
		return dao.insertOwner(owner);
	}

	@Override
	public int updateOwner(OwnerVO owner) {
		logger.info("updateOwner...");
		return dao.updateOwner(owner);
	}

	@Override
	public int deleteOwner(Map<String, String> idPwd) {
		logger.info("deleteOwner...");
		return dao.deleteOwner(idPwd);
	}

	@Override
	public OwnerVO readOwner(OwnerVO owner) {
		logger.info("readOwner...");
		return dao.readOwner(owner);
	}

	@Override
	public List<OwnerVO> readAllOwner() {
		logger.info("readAlOwner...");
		return dao.readAllOwner();
	}

	@Override
	public boolean checkOwnerId(String id) {
		logger.info("checkOwnerId...");
		return dao.checkOwnerId(id);
	}

	@Override
	public OwnerVO joinOwner(Map<String, String> idPwd) {
		logger.info("joinOwner...");
		return dao.joinOwner(idPwd);
	}

}
