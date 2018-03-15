package admin.service.impl;

import java.util.List;

import admin.dao.AdminDao;
import admin.dao.impl.AdminDaoImpl;
import admin.entity.Admin;
import admin.entity.Business;
import admin.entity.User;
import admin.service.AdminService;

public class AdminServiceImpl implements AdminService {

	// 通过账号和密码获取Admin
	@Override
	public Admin findAdmin(String aname, String password) throws Exception {
		AdminDao adminDao = new AdminDaoImpl();
		return adminDao.findAdmin(aname,password);
	}
	
	// 获取用户列表
	public List<User> findUser() throws Exception {
		AdminDao adminDao = new AdminDaoImpl();
		return adminDao.findUser();
	}

	// 通过状态获取用户列表
	@Override
	public List<User> findUserByState(String viewstate) throws Exception {
		AdminDao adminDao = new AdminDaoImpl();
		return adminDao.findUserByState(viewstate);
	}

	// 获取商店列表
	@Override
	public List<Business> findBusiness() throws Exception {
		AdminDao adminDao = new AdminDaoImpl();
		return adminDao.findBusiness();
	}

	// 查询禁用的店铺
	@Override
	public List<Business> findJYBusiness() throws Exception {
		AdminDao adminDao = new AdminDaoImpl();
		return adminDao.findJYBusiness();
	}

	// 查询申请注册的店铺
	@Override
	public List<Business> findSQBusiness() throws Exception {
		AdminDao adminDao = new AdminDaoImpl();
		return adminDao.findSQBusiness();
	}

}
