package admin.dao;

import user.entity.Category;

public interface ACategoryDao {

	//更新分类
	public void update(Category category) throws Exception;

	//删除分类
	public void delete(String cid) throws Exception;

	//添加分类
	public void add(Category category) throws Exception;

}
