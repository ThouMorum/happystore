package admin.service.impl;

import admin.dao.ABusinessDao;
import admin.dao.impl.ABusinessDaoImpl;
import admin.service.ABusinessService;

public class ABusinessServiceImpl implements ABusinessService {

	@Override
	public void changeaddStar(String bid) throws Exception {
		ABusinessDao aBusinessDao = new ABusinessDaoImpl();	
		aBusinessDao.changeaddStar(bid);
	}

	@Override
	public void changejianStar(String bid) throws Exception {
		ABusinessDao aBusinessDao = new ABusinessDaoImpl();	
		aBusinessDao.changejianStar(bid);
	}

	//禁用用户
	@Override
	public void stopBusiness(String bid) throws Exception {
		ABusinessDao aBusinessDao = new ABusinessDaoImpl();	
		aBusinessDao.stopBusiness(bid);	
	}

	//解禁用户
	@Override
	public void openBusiness(String bid) throws Exception {
		ABusinessDao aBusinessDao = new ABusinessDaoImpl();	
		aBusinessDao.openBusiness(bid);		
	}

	//允许店铺注册
	@Override
	public void okbusiness(String bid) throws Exception {
		ABusinessDao aBusinessDao = new ABusinessDaoImpl();	
		aBusinessDao.okbusiness(bid);	
	}

}
