package admin.service;


public interface AUserService {
	
	// 更改用户的状态
	public void changeState(String uid,String state) throws Exception;
}
