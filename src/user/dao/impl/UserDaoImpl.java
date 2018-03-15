package user.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import user.dao.UserDao;
import user.entity.User;
import user.utils.DataSourceUtils;

public class UserDaoImpl implements UserDao {

	// 用户注册
	public void add(User user) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?);";
		qr.update(sql, user.getUid(), user.getUsername(), user.getPassword(),
				user.getName(), user.getEmail(), user.getTelephone(),
				user.getBirthday(), user.getSex(), 0);

	}

	// 用户基础信息修改
	public void updateUser(User user) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set username = ?,name = ?,email = ?,birthday = ?,telephone = ?,sex = ? where uid =? ";
		qr.update(sql, user.getUsername(), user.getName(), user.getEmail(),
				user.getBirthday(), user.getTelephone(), user.getSex(),
				user.getUid());
	}

	// 通过用户名和密码获得用户
	public User getByUsernameAndPwd(String username, String password)
			throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ? limit 1";
		return qr.query(sql, new BeanHandler<>(User.class), username, password);
	}

	// 修改密码
	@Override
	public User updatePwd(String uid, String pwd) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set password = ? where uid =?";
		qr.update(sql, pwd, uid);
		sql = "select * from user where uid = ? limit 1";
		return qr.query(sql, new BeanHandler<>(User.class), uid);
	}

	// 用户注销
	@Override
	public void cancel(String uid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set state = ? where uid =?";
		qr.update(sql, 1, uid);
	}

	// 检查是否被注册
	@Override
	public boolean checkUser(String userName) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? limit 1";
		User user = null;
		user = qr.query(sql, new BeanHandler<>(User.class), userName);
		if(user != null) {
			return true;
		}
		return false;
	}

}
