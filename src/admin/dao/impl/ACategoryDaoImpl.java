package admin.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import user.entity.Category;
import admin.dao.ACategoryDao;
import admin.utils.DataSourceUtils;

public class ACategoryDaoImpl implements ACategoryDao {

	//更新分类
	@Override
	public void update(Category category) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update category set cname = ? where cid = ?";
		qr.update(sql,category.getCname(),category.getCid());
	}

	//删除分类
	@Override
	public void delete(String cid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update product set cid = null where cid = ?";
		qr.update(sql, cid);
		sql = "delete from category where cid = ?";
		qr.update(sql,cid);
	}

	//添加分类
	@Override
	public void add(Category category) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into category values(?,?)";
		qr.update(sql,category.getCid(),category.getCname());
	}

}
