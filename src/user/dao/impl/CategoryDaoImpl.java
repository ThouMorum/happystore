package user.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import user.dao.CategoryDao;
import user.entity.Category;
import user.utils.DataSourceUtils;

public class CategoryDaoImpl implements CategoryDao{

	/*
	 * 查询所有分类
	 */
	@Override
	public List<Category> findAll() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category";
		return qr.query(sql, new BeanListHandler<>(Category.class));
	}
	
	/*
	 * 通过id获取一个分类
	 */
	@Override
	public Category getById(String cid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from category where cid = ? limit 1";
		return qr.query(sql, new BeanHandler<>(Category.class), cid);
	}
}
