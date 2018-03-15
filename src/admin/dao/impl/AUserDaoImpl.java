package admin.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import admin.dao.AUserDao;
import admin.utils.DataSourceUtils;

public class AUserDaoImpl implements AUserDao {

	@Override
	public void changeState(String uid, String state) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set state = ? where uid = ?";
		qr.update(sql,state,uid);
	}

}
