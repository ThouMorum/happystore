package user.service.impl;

import user.dao.UserDao;
import user.dao.impl.UserDaoImpl;
import user.entity.User;
import user.service.UserService;

public class UserServiceImpl implements UserService {

	// 用户注册
	@Override
	public void regist(User user) throws Exception {
		UserDao dao = new UserDaoImpl();
		if (user == null) {
			throw new RuntimeException();
		}
		dao.add(user);
	}

	// 密码修改
	@Override
	public User updatePwd(String uid, String pwd) throws Exception {
		UserDao dao = new UserDaoImpl();
		return dao.updatePwd(uid, pwd);
	}

	// 用户注销
	@Override
	public void cancel(String uid) throws Exception {
		UserDao dao = new UserDaoImpl();
		if (uid == null) {
			throw new RuntimeException();
		}
		dao.cancel(uid);
	}

	// 账号基础信息修改
	@Override
	public User updateUser(User user) throws Exception {
		UserDao dao = new UserDaoImpl();
		if (user == null) {
			throw new RuntimeException();
		}
		dao.updateUser(user);
		return dao.getByUsernameAndPwd(user.getUsername(),user.getPassword());
	}

	// 用户登陆
	@Override
	public User login(String username, String password) throws Exception {
		UserDao dao = new UserDaoImpl();
		return dao.getByUsernameAndPwd(username, password);
	}

	// 检查是否被注册
	@Override
	public boolean checkUser(String username) throws Exception {
		UserDao dao = new UserDaoImpl();
		return dao.checkUser(username);
	}

}
