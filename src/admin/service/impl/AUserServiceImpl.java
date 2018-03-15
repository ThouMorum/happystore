package admin.service.impl;

import admin.dao.AUserDao;
import admin.dao.impl.AUserDaoImpl;
import admin.service.AUserService;


public class AUserServiceImpl implements AUserService{
	
	// 更改用户的状态
	public void changeState(String uid,String state) throws Exception {
		AUserDao aUserDao= new AUserDaoImpl();
		aUserDao.changeState(uid,state);
	}
}
