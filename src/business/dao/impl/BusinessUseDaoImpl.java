package business.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import user.entity.User;
import user.utils.DataSourceUtils;
import business.dao.BusinessUseDao;
import business.entity.Business;

public class BusinessUseDaoImpl implements BusinessUseDao {

	// 修改密码
	@Override
	public Business updatePwd(String bid, String pwd) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update business set buserpwd = ? where bid =?";
		qr.update(sql, pwd, bid);
		sql = "select * from business where bid = ? limit 1";
		return qr.query(sql, new BeanHandler<>(Business.class), bid);
	}

	// 登陆
	@Override
	public Business login(String bname, String pwd) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from business where bname = ? and buserpwd = ? limit 1";
		return qr.query(sql, new BeanHandler<>(Business.class), bname, pwd);
	}

	// 注册
	@Override
	public void regist(Business business) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into business(bid,address,bname,busername,buserpwd,email,telephone,stars,state,createdate) values(?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, business.getBid(), business.getAddress(),
				business.getBname(), business.getBusername(),
				business.getBuserpwd(), business.getEmail(),
				business.getTelephone(), business.getStars(),
				business.getState(), business.getCreatedate());
	}

	// 检查是否被注册
	@Override
	public boolean checkBusiness(String username) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from business where bname = ? limit 1";
		Business business = null;
		business = qr.query(sql, new BeanHandler<>(Business.class), username);
		if (business != null) {
			return true;
		}
		return false;
	}

	// 修改基础信息
	@Override
	public Business updateBusiness(Business business) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update business set address = ?,busername = ?,email = ?,telephone = ? where bname = ?";
		qr.update(sql, business.getAddress(), business.getBusername(),
				business.getEmail(), business.getTelephone(),
				business.getBname());
		sql = "select * from business where bname = ? limit 1";
		return qr.query(sql, new BeanHandler<>(Business.class), business.getBname());
	}
}
