package business.service.impl;

import business.dao.BusinessUseDao;
import business.dao.impl.BusinessUseDaoImpl;
import business.entity.Business;
import business.service.BusinessUseService;

public class BusinessUseServiceImpl implements BusinessUseService {
	// 修改密码
	public Business updatePwd(String bid, String pwd) throws Exception {
		BusinessUseDao bud = new BusinessUseDaoImpl();
		return bud.updatePwd(bid, pwd);
	}

	// 登陆
	@Override
	public Business login(String bname, String pwd) throws Exception {
		BusinessUseDao bud = new BusinessUseDaoImpl();
		return bud.login(bname, pwd);
	}

	// 注册
	public void regist(Business business) throws Exception {
		BusinessUseDao bud = new BusinessUseDaoImpl();
		bud.regist(business);
	}

	// 检查是否被注册
	@Override
	public boolean checkBusiness(String username) throws Exception {
		BusinessUseDao bud = new BusinessUseDaoImpl();
		return bud.checkBusiness(username);	
	}

	// 修改基础信息
	@Override
	public Business updateBusiness(Business business) throws Exception {
		BusinessUseDao bud = new BusinessUseDaoImpl();
		return bud.updateBusiness(business);	
	}
	
	
}
