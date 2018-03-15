package admin.service;

import java.util.List;

import admin.entity.Admin;
import admin.entity.Business;
import admin.entity.User;

public interface AdminService {
	
	// 通过账号和密码获取Admin
	public Admin  findAdmin(String aname,String password) throws Exception;
	
	// 获取用户列表
	public List<User> findUser() throws Exception;

	// 通过状态，获取用户列表
	public List<User> findUserByState(String viewstate) throws Exception;

	// 获取商店列表
	public List<Business> findBusiness() throws Exception;

	// 查询禁用的店铺
	public List<Business> findJYBusiness() throws Exception;

	// 查询申请注册的店铺
	public List<Business> findSQBusiness() throws Exception;
}
