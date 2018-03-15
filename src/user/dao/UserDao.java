package user.dao;

import user.entity.User;

public interface UserDao {

	// 用户注册
	public void add(User user) throws Exception;

	// 用户基础信息修改
	public void updateUser(User user) throws Exception;

	// 通过用户名和密码获得用户
	public User getByUsernameAndPwd(String username, String password) throws Exception;

	// 修改密码
	public User updatePwd(String uid,String pwd) throws Exception;
	
	// 用户注销
	public void cancel(String uid) throws Exception;
	
	// 检查是否被注册
	public boolean checkUser(String uid) throws Exception;

}
