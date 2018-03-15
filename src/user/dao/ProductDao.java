package user.dao;

import java.util.List;

import user.entity.Product;

public interface ProductDao {

	/*
	 * 通过pid查询物品的信息
	 */
	public Product getByPid(String pid) throws Exception;

	/*
	 * 分页查询物品列表 
	 */
	public List<Product> findByPage(int currPage, int pageSize, String cid) throws Exception;

	/*
	 * 查询总记录数 
	 */
	public int getTotalCount(String cid) throws Exception;
	
	/*
	 * 查询最新商品
	 */
	public List<Product> findNew() throws Exception;

	/*
	 * 查询热门商品
	 */
	public List<Product> findHot() throws Exception;
}
