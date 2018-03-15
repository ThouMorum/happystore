package user.dao;

import java.util.List;

import user.entity.Order;
import user.entity.OrderItem;

public interface OrderDao {
	
	// 添加订单
	public void add(Order order) throws Exception;

	// 添加订单项
	public void addItem(OrderItem oi) throws Exception;

	// 分页查询我的订单
	public List<Order> findAllByPage(int currPage, int pageSize, String uid)
			throws Exception;

	// 通过id查询订单总计
	public int getTotalCount(String uid) throws Exception;

	// 通过订单id获取订单
	public Order getById(String oid) throws Exception;

	// 更新订单信息
	public void update(Order order) throws Exception;
	
	// 删除订单
	public void delete(Order order) throws Exception;
	
}
