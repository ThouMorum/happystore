package business.servlet;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.entity.Business;
import business.entity.OrderItem;
import business.service.BItemService;
import business.service.impl.BItemServiceImpl;

/**
 * 商家订单项管理模块
 */
public class BusinessServlet_c extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *	查询该店家后台的订单项，进行列表展示 
	 */
	public String findAllByBid(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String bid = null;
		
		// 1.获取bid
		if(request.getSession().getAttribute("Business") == null) {
			throw new RuntimeException();
		}else {
			Business business = (Business) request.getSession().getAttribute("Business");
			bid = business.getBid();
		}

		// 2.调用BusinessService 通过bid获取商品列表
		BItemService bItemService = new BItemServiceImpl();
		List<OrderItem> orderItemList = bItemService.getListById(bid);

		// 3.添加到request中，进行转发
		request.setAttribute("orderItemList", orderItemList);
		return "/business/orderItem/list.jsp";
	}
	
	/**
	 *	查询该店家后台的订单项，判断是否发货，显示未发货的信息
	 */
	public String findNoByBid(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String bid = null;
		
		// 1.获取bid
		if(request.getSession().getAttribute("Business") == null) {
			throw new RuntimeException();
		}else {
			Business business = (Business) request.getSession().getAttribute("Business");
			bid = business.getBid();
		}

		// 2.调用BusinessService 通过bid获取商品列表
		BItemService bItemService = new BItemServiceImpl();
		List<OrderItem> orderItemList = new LinkedList<OrderItem>();

		
		// 3.进行判断
		for (OrderItem orderItem : bItemService.getListById(bid)) {
			if(orderItem.getIs_ok() == 0 ) {
				orderItemList.add(orderItem);
			}
		}
		
		// 4.添加到request中，进行转发
		request.setAttribute("orderItemList", orderItemList);
		return "/business/orderItem/list.jsp";
	}
	
	/**
	 *	查询该店家后台的订单项，判断是否发货，显示发货的信息
	 */
	public String findYesByBid(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String bid = null;
		
		// 1.获取bid
		if(request.getSession().getAttribute("Business") == null) {
			throw new RuntimeException();
		}else {
			Business business = (Business) request.getSession().getAttribute("Business");
			bid = business.getBid();
		}

		// 2.调用BusinessService 通过bid获取商品列表
		BItemService bItemService = new BItemServiceImpl();
		List<OrderItem> orderItemList = new LinkedList<OrderItem>();

		
		// 3.进行判断
		for (OrderItem orderItem : bItemService.getListById(bid)) {
			if(orderItem.getIs_ok() == 1 ) {
				orderItemList.add(orderItem);
			}
		}
		
		// 4.添加到request中，进行转发
		request.setAttribute("orderItemList", orderItemList);
		return "/business/orderItem/list.jsp";
	}

	/**
	 *	进行订单项的发货处理
	 */
	public String send(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// 1.获取订单项id
		String itemid = request.getParameter("itemid");
		
		// 2.调用BItemService 完成订单的发货处理
		BItemService bItemService = new BItemServiceImpl();
		bItemService.send(itemid);

		// 3.添加到request中，进行转发
		return findAllByBid(request, response);
	}
	
}
