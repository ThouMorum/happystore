package user.service.impl;

import java.util.List;

import user.dao.ProductDao;
import user.dao.impl.ProductDaoImpl;
import user.entity.PageBean;
import user.entity.Product;
import user.service.ProductService;

public class ProductServiceImpl implements ProductService{
	/**
	 * 查询单个商品
	 */
	@Override
	public Product getByPid(String pid) throws Exception {
		ProductDao productDao=new ProductDaoImpl();
		return productDao.getByPid(pid);
	}

	/**
	 * 按类别分页查询商品
	 */
	@Override
	public PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception {
		ProductDao productDao=new ProductDaoImpl();
		//当前页数据
		List<Product> list=productDao.findByPage(currPage,pageSize,cid);
		
		//总条数
		int totalCount = productDao.getTotalCount(cid);
		
		return new PageBean<>(list, currPage, pageSize, totalCount);
	}

	/*
	 * 查询最新商品
	 */
	@Override
	public List<Product> findNew() throws Exception {
		ProductDao productDao=new ProductDaoImpl();
		return productDao.findNew();
	}

	/*
	 * 查询热门商品
	 */
	@Override
	public List<Product> findHot() throws Exception {
		ProductDao productDao=new ProductDaoImpl();
		return productDao.findHot();
	}

}
