package user.service.impl;

import user.dao.PromotionDao;
import user.dao.impl.PromotionDaoImpl;
import user.entity.Promotion;
import user.service.PromotionService;

public class PromotionServiceImpl implements PromotionService {

	// 通过id获取一个促销类型
	public Promotion getById(String pnid) throws Exception {

		// 从数据库中获取
		PromotionDao promotionDao = new PromotionDaoImpl();
		return promotionDao.getById(pnid);
	}

}
