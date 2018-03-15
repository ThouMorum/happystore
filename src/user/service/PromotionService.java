package user.service;

import user.entity.Promotion;

public interface PromotionService {
	
	// 通过id获取一个促销类型
	public Promotion getById(String pnid) throws Exception;
}
