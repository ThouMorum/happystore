package business.service;

import business.entity.Business;

public interface BusinessUseService {
	
	// 修改密码
	public Business updatePwd(String bid,String pwd) throws Exception;
	
	// 登陆
	public Business login(String bname,String pwd) throws Exception;
	
	// 注册
	public void regist(Business business) throws Exception;
	
	// 检查是否被注册
	public boolean checkBusiness(String username) throws Exception;
	
	// 修改基础信息
	public Business updateBusiness(Business business) throws Exception;
	
}
