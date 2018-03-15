package user.dao;

import user.entity.Promotion;

public interface PromotionDao {
	
	// 通过id获取一个促销分类
	public Promotion getById(String pnid) throws Exception;
}
