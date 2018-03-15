package admin.dao;

public interface AUserDao {

	// 更改用户的状态
	public void changeState(String uid,String state) throws Exception;
}
