package user.service.impl;

import java.util.List;

import user.dao.OrderDao;
import user.dao.impl.OrderDaoImpl;
import user.entity.Order;
import user.entity.OrderItem;
import user.entity.PageBean;
import user.entity.User;
import user.service.OrderService;
import user.utils.DataSourceUtils;

public class OrderServiceImpl implements OrderService {
	
	// 添加订单
	@Override
	public void add(Order order) throws Exception {
		try {
			// 1.开启事务
			DataSourceUtils.startTransaction();

			OrderDao od = new OrderDaoImpl();
			// 2.向orders表中添加一个数据
			od.add(order);

			// 3.向orderitem中添加n条数据
			for (OrderItem oi : order.getItems()) {
				od.addItem(oi);
			}

			// 4.事务处理
			DataSourceUtils.commitAndClose();
		} catch (Exception e) {
			e.printStackTrace();
			DataSourceUtils.rollbackAndClose();
			throw e;
		}

	}

	// 分页查询我的订单
	@Override
	public PageBean<Order> findAllByPage(int currPage, int pageSize, User user)
			throws Exception {
		OrderDao od = new OrderDaoImpl();

		// 查询当前页数据
		List<Order> list = od.findAllByPage(currPage, pageSize, user.getUid());

		// 查询总条数
		int totalCount = od.getTotalCount(user.getUid());
		return new PageBean<>(list, currPage, pageSize, totalCount);
	}

	// 通过订单id获取订单
	@Override
	public Order getById(String oid) throws Exception {
		OrderDao od = new OrderDaoImpl();
		return od.getById(oid);
	}

	// 更新订单信息
	@Override
	public void update(Order order) throws Exception {
		OrderDao od = new OrderDaoImpl();
		od.update(order);
	}
	
	// 删除订单
	@Override
	public void delete(Order order) throws Exception {
		OrderDao od = new OrderDaoImpl();
		od.delete(order);
	}

}
