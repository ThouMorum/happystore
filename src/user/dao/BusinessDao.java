package user.dao;

import user.entity.Business;

public interface BusinessDao {
	
	// 通过id获取一个商家
	public Business getById(String bid) throws Exception;
}
