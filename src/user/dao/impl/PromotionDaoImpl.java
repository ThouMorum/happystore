package user.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import user.dao.PromotionDao;
import user.entity.Promotion;
import user.utils.DataSourceUtils;

public class PromotionDaoImpl implements PromotionDao {

	/*
	 * 通过id获取一个分类
	 */
	@Override
	public Promotion getById(String pnid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from promotion where pnid = ? limit 1";
		return qr.query(sql, new BeanHandler<>(Promotion.class), pnid);
	}
}
