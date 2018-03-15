package user.service;

import user.entity.Order;
import user.entity.PageBean;
import user.entity.User;

public interface OrderService {
	
	// 添加订单
	public void add(Order order) throws Exception;

	// 分页查询我的订单
	public PageBean<Order> findAllByPage(int currPage, int pageSize, User user) throws Exception;

	// 通过订单id获取订单
	public Order getById(String oid) throws Exception;

	// 更新订单信息
	public void update(Order order) throws Exception;
	
	// 删除订单
	public void delete(Order order) throws Exception;
}
