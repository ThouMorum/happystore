package admin.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import admin.dao.AdminDao;
import admin.entity.Admin;
import admin.entity.Business;
import admin.entity.User;
import admin.utils.DataSourceUtils;

public class AdminDaoImpl implements AdminDao {

	// 通过账号和密码获取Admin
	@Override
	public Admin findAdmin(String aname, String password) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from admin where aname = ? and password = ? limit 1";
		return qr.query(sql, new BeanHandler<>(Admin.class), aname, password);
	}

	// 获取用户列表
	@Override
	public List<User> findUser() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user";
		return qr.query(sql, new BeanListHandler<>(User.class));
	}

	// 通过状态，获取用户列表
	@Override
	public List<User> findUserByState(String viewstate) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where state = ?";
		return qr.query(sql, new BeanListHandler<>(User.class),Integer.parseInt(viewstate));
	}

	// 获取商店列表
	@Override
	public List<Business> findBusiness() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from business";
		return qr.query(sql, new BeanListHandler<>(Business.class));
	}

	// 查询禁用的店铺
	@Override
	public List<Business> findJYBusiness() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from business where state = 2";
		return qr.query(sql, new BeanListHandler<>(Business.class));
	}

	// 查询申请注册的店铺
	@Override
	public List<Business> findSQBusiness() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from business where state = 0";
		return qr.query(sql, new BeanListHandler<>(Business.class));
	}

}
