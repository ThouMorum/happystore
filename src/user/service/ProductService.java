package user.service;

import java.util.List;

import user.entity.PageBean;
import user.entity.Product;


public interface ProductService {

	/*
	 * 通过pid获得详细信息
	 */
	public Product getByPid(String pid) throws Exception;

	/*
	 * 分页查询物品
	 */
	public PageBean<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;

	/*
	 * 查询最新商品
	 */
	public List<Product> findNew() throws Exception;

	/*
	 * 查询热门商品
	 */
	public List<Product> findHot() throws Exception;
	
}
