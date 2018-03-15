package admin.dao;

public interface ABusinessDao {

	// 升星
	public void changeaddStar(String bid) throws Exception;

	// 降星
	public void changejianStar(String bid) throws Exception;

	public void stopBusiness(String bid) throws Exception;

	//解禁用户
	public void openBusiness(String bid) throws Exception;

	//允许店铺注册
	public void okbusiness(String bid) throws Exception;
	
}
