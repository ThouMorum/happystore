package admin.service.impl;

import java.util.List;

import user.entity.Promotion;
import admin.dao.APromotionDao;
import admin.dao.impl.APromotionDaoImpl;
import admin.service.APromotionService;

public class APromotionServiceImpl implements APromotionService {

	
	@Override
	public List<Promotion> findAll() throws Exception {
		APromotionDao aPromotionDao = new APromotionDaoImpl();
		return aPromotionDao.findAll();
	}

	// 通过id获取一个分类
	@Override
	public Promotion getById(String pnid) throws Exception {
		APromotionDao aPromotionDao = new APromotionDaoImpl();
		return aPromotionDao.getById(pnid);
	}

	//更新促销类型
	@Override
	public void update(Promotion promotion) throws Exception {
		APromotionDao aPromotionDao = new APromotionDaoImpl();
		aPromotionDao.update(promotion);
	}

	//删除促销联想
	@Override
	public void delete(String pnid) throws Exception {
		APromotionDao aPromotionDao = new APromotionDaoImpl();
		aPromotionDao.delete(pnid);
	}

	//添加分类
	@Override
	public void add(Promotion promotion) throws Exception {
		APromotionDao aPromotionDao = new APromotionDaoImpl();
		aPromotionDao.add(promotion);
	}
	
}
