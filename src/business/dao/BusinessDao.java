package business.dao;

import java.util.List;

import business.entity.Business;
import business.entity.Category;
import business.entity.Product;
import business.entity.Promotion;

public interface BusinessDao {
	
	// 通过id获取一个商家
	public Business getById(String bid) throws Exception;
	
	// 通过id获取该商家提供的商品列表
	public List<Product> getListById(String bid) throws Exception;
	
	// 通过id获取删除产品
	public void deleteById(String pid) throws Exception;
	
	// 添加商品
	public void add(Product product) throws Exception;
	
	// 编辑商品
	public void update(Product product) throws Exception;
	
	// 查询促销类型
	public List<Promotion> findPromotion() throws Exception;
	
	// 查询产品分类
	public List<Category> findCategory() throws Exception;
}
