package user.service;

import user.entity.Business;

public interface BusinessService {
	
	// 通过id获取一个商家
	public Business getById(String bid) throws Exception;
}
