package business.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import business.dao.BusinessDao;
import business.entity.Business;
import business.entity.Category;
import business.entity.Product;
import business.entity.Promotion;
import business.other.MyResultSetHandlerList;
import business.utils.DataSourceUtils;

public class BusinessDaoImpl implements BusinessDao {

	@Override
	public Business getById(String bid) throws Exception {
		return null;
	}

	@Override
	public List<Product> getListById(String bid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where bid = ?";
		return qr.query(sql, new MyResultSetHandlerList(), bid);
	}

	// 通过id获取删除产品
	@Override
	public void deleteById(String pid) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "delete from product where pid = ?";
		qr.update(sql, pid);
	}

	// 添加商品
	@Override
	public void add(Product product) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql, product.getPid(), product.getPname(), product
				.getMarket_price(), product.getShop_price(), product
				.getPnumber(), product.getIs_hot(), product.getPimage(),
				product.getPdate(), product.getPdesc(), product.getPromotion()
						.getPnid(), product.getCategory().getCid(), product
						.getBusiness().getBid());
	}

	// 查询促销类型
	@Override
	public List<Promotion> findPromotion() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from promotion";
		return qr.query(sql, new BeanListHandler<>(Promotion.class));
	}

	// 查询产品分类
	@Override
	public List<Category> findCategory() throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from category";
		return qr.query(sql, new BeanListHandler<>(Category.class));
	}

	// 编辑商品
	@Override
	public void update(Product product) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update product set pname = ?, market_price = ?,shop_price = ?,pnumber = ?,is_hot = ?,pimage = ?,pdesc = ?,pro_id = ?,cid = ? where pid = ?";
		qr.update(sql, product.getPname(), product.getMarket_price(), product
				.getShop_price(), product.getPnumber(), product.getIs_hot(),
				product.getPimage(), product.getPdesc(), product.getPromotion()
						.getPnid(), product.getCategory().getCid(), product
						.getPid());
	}
}
