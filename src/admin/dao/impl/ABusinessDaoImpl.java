package admin.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import admin.dao.ABusinessDao;
import admin.utils.DataSourceUtils;

public class ABusinessDaoImpl implements ABusinessDao {

	// 升星
	@Override
	public void changeaddStar(String bid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update business set stars = stars + 1 where bid = ?";
		qr.update(sql,bid);
	}

	// 降星
	@Override
	public void changejianStar(String bid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update business set stars = stars - 1 where bid = ?";
		qr.update(sql,bid);
	}

	// 禁用用户
	@Override
	public void stopBusiness(String bid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update business set state = 2 where bid = ?";
		qr.update(sql,bid);
	}

	// 解禁用户
	@Override
	public void openBusiness(String bid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update business set state = 1 where bid = ?";
		qr.update(sql,bid);
	}

	//允许店铺注册
	@Override
	public void okbusiness(String bid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update business set state = 1 where bid = ?";
		qr.update(sql,bid);
	}

}
