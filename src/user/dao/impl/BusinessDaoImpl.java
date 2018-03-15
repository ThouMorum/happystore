package user.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import user.dao.BusinessDao;
import user.entity.Business;
import user.utils.DataSourceUtils;

public class BusinessDaoImpl implements BusinessDao {

	// 通过id获取一个商家
	@Override
	public Business getById(String bid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from business where bid = ? limit 1";
		return qr.query(sql, new BeanHandler<>(Business.class), bid);
	}
}
