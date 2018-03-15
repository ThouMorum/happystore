package admin.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import user.entity.Promotion;
import user.utils.DataSourceUtils;
import admin.dao.APromotionDao;

public class APromotionDaoImpl implements APromotionDao {

	// 查询所有的促销类型
	@Override
	public List<Promotion> findAll() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from promotion";
		return qr.query(sql, new BeanListHandler<>(Promotion.class));
	}
	
	// 通过id获取一个分类
	@Override
	public Promotion getById(String pnid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from promotion where pnid = ? limit 1";
		return qr.query(sql, new BeanHandler<>(Promotion.class), pnid);
	}
	
	//更新促销类型
	@Override
	public void update(Promotion promotion) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update promotion set pnname = ? where pnid = ?";
		qr.update(sql,promotion.getPnname(),promotion.getPnid());
	}

	//删除促销联想
	@Override
	public void delete(String pnid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update product set pro_id = null where pro_id = ?";
		qr.update(sql, pnid);
		sql = "delete from promotion where pnid = ?";
		qr.update(sql,pnid);
	}

	//添加分类
	@Override
	public void add(Promotion promotion) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into promotion values(?,?)";
		qr.update(sql,promotion.getPnid(),promotion.getPnname());
	}

}
