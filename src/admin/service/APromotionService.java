package admin.service;

import java.util.List;

import user.entity.Promotion;

public interface APromotionService {

	// 查询所有的促销类型
	public List<Promotion> findAll() throws Exception;
	
	// 通过id获取一个分类
	public Promotion getById(String pnid) throws Exception;
	
	//更新促销类型
	public void update(Promotion promotion) throws Exception;
	
	//删除促销联想
	public void delete(String pnid) throws Exception;
	
	//添加分类
	public void add(Promotion promotion) throws Exception;

}
