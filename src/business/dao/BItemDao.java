package business.dao;

import java.util.List;

import business.entity.OrderItem;

public interface BItemDao {

	// 通过id获取该商家的所有订单项信息
	public List<OrderItem> getListById(String bid) throws Exception;
	
	// 完成订单的发货处理
	public void send(String itemid) throws Exception;
}
