package user.service.impl;

import java.util.List;

import user.dao.CategoryDao;
import user.dao.impl.CategoryDaoImpl;
import user.entity.Category;
import user.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	// 从数据库中查询出所有的分类
	@Override
	public List<Category> findAll() throws Exception {

		// 从数据库中获取
		CategoryDao categoryDao = new CategoryDaoImpl();

		return categoryDao.findAll();
	}
	
	// 通过id获取一个分类
	public Category getById(String cid) throws Exception {
		
		// 从数据库中获取
		CategoryDao categoryDao = new CategoryDaoImpl();

		return categoryDao.getById(cid);
	}

}
