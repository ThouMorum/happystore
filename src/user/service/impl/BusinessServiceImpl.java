package user.service.impl;

import user.dao.BusinessDao;
import user.dao.impl.BusinessDaoImpl;
import user.entity.Business;
import user.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {

	// 通过id获取一个商家
	public Business getById(String bid) throws Exception {
		
		// 从数据库中获取
		BusinessDao businessDao = new BusinessDaoImpl();

		return businessDao.getById(bid);
	}

}
