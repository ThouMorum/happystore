package user.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.Cart;
import user.entity.CartItem;
import user.entity.Product;
import user.service.ProductService;
import user.service.impl.ProductServiceImpl;

/**
 * 购物车模块
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 获取购物车
	 */
	public Cart getCart(HttpServletRequest request) {
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		// 判断购物车是否为空
		if (cart == null) {
			// 创建一个cart
			cart = new Cart();

			// 添加到session中
			request.getSession().setAttribute("cart", cart);
		}
		return cart;
	}

	/**
	 * 添加到购物车
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1.获取pid和数量
		String pid = request.getParameter("pid");
		int count = Integer.parseInt(request.getParameter("count"));

		// 2.调用productservice 通过pid获取一个商品
		ProductService ps = new ProductServiceImpl();
		Product product = ps.getByPid(pid);

		// 3.组装成CartItem
		CartItem cartItem = new CartItem(product, count);

		// 4.添加到购物车
		Cart cart = getCart(request);
		// 4.1先判断购物车中有无该商品
		if (cart.getMap().containsKey(pid)) {
			// 有
			// 设置购买数量 需要获取该商品之前的购买数量+现在的购买数量(item.getCount)
			// 获取购物车中购物车项
			CartItem oItem = cart.getMap().get(pid);
			oItem.setCount(oItem.getCount() + cartItem.getCount());
		} else {
			// 没有 将购物车项添加进去
			cart.getMap().put(pid, cartItem);
		}
		// 4.2.添加完成之后 修改金额
		cart.setTotal(cart.getTotal() + cartItem.getSubtotal());

		// 5.重定向
		response.sendRedirect(request.getContextPath() + "/user/jsp/cart.jsp");
		return null;
	}

	/**
	 * 从购物车中移除购物车项
	 */
	public String remove(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1.获取商品的pid，并通过pid获得Cart
		String pid = request.getParameter("pid");
		Cart cart = getCart(request);

		// 2.通过pid删除map
		CartItem removeItem = cart.getMap().remove(pid);

		// 3.修改金额
		cart.setTotal(cart.getTotal() - removeItem.getSubtotal());

		// 4.重定向
		response.sendRedirect(request.getContextPath() + "/user/jsp/cart.jsp");
		return null;
	}

	/**
	 * 清空购物车
	 */
	public String clear(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取购物车 清空
		Cart cart = getCart(request);
		// 1.map置空
		cart.getMap().clear();

		// 2.金额归零
		cart.setTotal(0.0);
		response.sendRedirect(request.getContextPath() + "/user/jsp/cart.jsp");
		return null;
	}

}
