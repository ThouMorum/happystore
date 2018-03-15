package user.servlet;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.Cart;
import user.entity.CartItem;
import user.entity.Order;
import user.entity.OrderItem;
import user.entity.PageBean;
import user.entity.User;
import user.service.OrderService;
import user.service.impl.OrderServiceImpl;

/**
 * 订单模块
 */
public class OrderServlet extends BaseServlet {

	// 添加订单
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 0.判断用户是否登录
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg",
					"您还暂未登录，请先<a href='" + request.getContextPath()
							+ "/User?method=loginUI'>登录</a>");
			return "/user/jsp/msg.jsp";
		}

		// 1.封装数据
		Order order = new Order();
		// 1.1 订单id
		order.setOid(UUID.randomUUID().toString().replace("-", "")
				.toUpperCase());

		// 1.2 订单时间
		order.setOrdertime(new Date());

		// 1.3 总金额
		// 获取session中cart
		Cart cart = (Cart) request.getSession().getAttribute("cart");

		order.setTotal(cart.getTotal());

		// 1.4 订单的所有订单项
		for (CartItem cartItem : cart.getItem()) {
			OrderItem oi = new OrderItem();

			// 设置id
			oi.setItemid(UUID.randomUUID().toString().replace("-", "")
					.toUpperCase());

			// 设置购买数量
			oi.setCount(cartItem.getCount());

			// 设置小计
			oi.setSubtotal(cartItem.getSubtotal());

			// 设置product
			oi.setProduct(cartItem.getProduct());

			// 设置order
			oi.setOrder(order);

			// 添加到list中
			order.getItems().add(oi);
		}

		// 1.5 设置用户
		order.setUser(user);

		// 2.调用service 添加订单
		OrderService os = new OrderServiceImpl();
		os.add(order);

		// 3.将order放入request域中,请求转发
		request.setAttribute("bean", order);

		// 4.清空购物车
		request.getSession().removeAttribute("cart");
		return "/user/jsp/order_info.jsp";
	}

	/*
	 * 分页查询我的订单
	 */
	public String findAllByPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1.获取当前页
		int currPage = 0;
		if (request.getParameter("currPage") == null) {
			currPage = 1;
		} else {
			currPage = Integer.parseInt(request.getParameter("currPage"));
		}
		int pageSize = 3;

		// 2.获取用户
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("msg",
					"您还暂未登录，请先<a href='" + request.getContextPath()
							+ "/User?method=loginUI'>登录</a>");
			return "/user/jsp/msg.jsp";
		}

		// 3.调用service
		OrderService os = new OrderServiceImpl();
		PageBean<Order> bean = os.findAllByPage(currPage, pageSize, user);

		// 4.将PageBean放入request域中
		request.setAttribute("pb", bean);

		return "/user/jsp/order_list.jsp";
	}

	/*
	 * 通过id获取订单
	 */
	public String getById(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1.获取oid
		String oid = request.getParameter("oid");

		// 2.调用service 通过oid 返回值:order
		OrderService os = new OrderServiceImpl();
		Order order = os.getById(oid);

		// 3.将order放入request域中
		request.setAttribute("bean", order);

		return "/user/jsp/order_info.jsp";
	}

	/*
	 * 提交支付的订单
	 */
	public String pay(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 接受参数
		String address = request.getParameter("address");
		String name = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String oid = request.getParameter("oid");

		// 通过id获取order
		OrderService s = new OrderServiceImpl();
		Order order = s.getById(oid);

		order.setAddress(address);
		order.setName(name);
		order.setTelephone(telephone);

		// 修改订单状态为 已支付
		order.setState(1);

		// 更新order
		s.update(order);

		// 查询新订单情况，并跳转到订单列表页面
		String spath = findAllByPage(request, response);
		return spath;
	}

	/*
	 * 确认收货
	 */
	public String updateState(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1.获取 oid
		String oid = request.getParameter("oid");

		// 2.调用service 修改订单状态
		OrderService os = new OrderServiceImpl();
		Order order = os.getById(oid);
		order.setState(3);
		os.update(order);

		// 3.重定向
		response.sendRedirect(request.getContextPath()
				+ "/Order?method=findAllByPage&currPage=1");
		return null;
	}

	/*
	 * 退单
	 */
	public String quitItem(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1.获取 oid
		String oid = request.getParameter("oid");

		// 2.调用service 删除订单
		OrderService os = new OrderServiceImpl();
		Order order = os.getById(oid);
		os.delete(order);

		// 3.转发
		request.setAttribute("msg", "退单成功");
		return "/user/jsp/msg.jsp";
	}
	
	/*
	 * 退款
	 */
	public String quitMoney(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1.获取 oid
		String oid = request.getParameter("oid");
		
		// 2.进行退款的一系列金钱操作
		
		// 3.调用service 删除订单
		OrderService os = new OrderServiceImpl();
		
		// 4.删除订单
		Order order = os.getById(oid);
		double money = 0.0;
		money = order.getTotal();
		
		os.delete(order);

		// 5.转发
		request.setAttribute("msg", "退款成功，您的￥ '"+money+"' 已经退回您账号，请进行核查!!");
		return "/user/jsp/msg.jsp";
	}
}
