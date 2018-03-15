package user.service;

import java.util.List;

import user.entity.Category;

public interface CategoryService {
	
	// 从数据库中查询出所有的分类
	public List<Category> findAll () throws Exception;
	
	// 通过id获取一个分类
	public Category getById(String cid) throws Exception;
}
