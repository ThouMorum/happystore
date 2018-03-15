package business.service.impl;

import java.util.List;

import business.dao.BItemDao;
import business.dao.impl.BItemDaoImpl;
import business.entity.OrderItem;
import business.service.BItemService;

public class BItemServiceImpl implements BItemService{

	// 通过id获取该商家的所有订单项信息
	@Override
	public List<OrderItem> getListById(String bid) throws Exception {
		BItemDao bItemServiceDao = new BItemDaoImpl(); 
		return bItemServiceDao.getListById(bid);
	}
	
	// 完成订单的发货处理
	public void send(String itemid) throws Exception {
		BItemDao bItemServiceDao = new BItemDaoImpl(); 
		bItemServiceDao.send(itemid);
	}
	
}
