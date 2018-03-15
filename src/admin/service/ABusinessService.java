package admin.service;

public interface ABusinessService {

	//增加星级
	public void changeaddStar(String bid) throws Exception;
	
	//减少星级
	public void changejianStar(String bid) throws Exception;

	//禁用用户
	public void stopBusiness(String bid) throws Exception;

	//解禁用户
	public void openBusiness(String bid) throws Exception;

	//允许店铺注册
	public void okbusiness(String bid) throws Exception;
	
}
