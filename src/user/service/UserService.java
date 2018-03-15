package user.service;

import user.entity.User;

public interface UserService {
	
	// 用户注册
	public void regist(User user) throws Exception;

	// 密码修改
	public User updatePwd(String uid,String pwd) throws Exception;

	// 用户注销
	public void cancel(String uid) throws Exception;
	
	// 用户基础信息修改
	public User updateUser(User user) throws Exception;
	
	// 用户登陆
	public User login(String username, String password) throws Exception;

	// 检查是否被注册
	public boolean checkUser(String username) throws Exception;

}
