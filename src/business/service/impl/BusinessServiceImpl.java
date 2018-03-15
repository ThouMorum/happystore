package business.service.impl;

import java.util.List;

import business.dao.BusinessDao;
import business.dao.impl.BusinessDaoImpl;
import business.entity.Category;
import business.entity.Product;
import business.entity.Promotion;
import business.service.BusinessService;

public class BusinessServiceImpl implements BusinessService{
	
	// 通过id获取该商家提供的商品列表
	public List<Product> getListById(String bid) throws Exception {
		BusinessDao businessDao = new BusinessDaoImpl(); 
		return businessDao.getListById(bid);
	}
	
	// 通过id获取删除产品
	@Override
	public void deleteById(String pid) throws Exception {
		BusinessDao businessDao = new BusinessDaoImpl(); 
		businessDao.deleteById(pid);
	}

	// 添加商品
	@Override
	public void add(Product product) throws Exception {
		BusinessDao businessDao = new BusinessDaoImpl(); 
		businessDao.add(product);
	}
	
	// 编辑商品
	@Override
	public void update(Product product) throws Exception {
		BusinessDao businessDao = new BusinessDaoImpl(); 
		businessDao.update(product);
	}

	// 查询促销类型
	@Override
	public List<Promotion> findPromotion() throws Exception {
		BusinessDao businessDao = new BusinessDaoImpl(); 
		return businessDao.findPromotion();
	}

	// 查询产品分类
	@Override
	public List<Category> findCategory() throws Exception {
		BusinessDao businessDao = new BusinessDaoImpl(); 
		return businessDao.findCategory();
	}
}
