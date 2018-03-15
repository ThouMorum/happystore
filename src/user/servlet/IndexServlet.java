package user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.Product;
import user.service.ProductService;
import user.service.impl.ProductServiceImpl;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 去数据库中查询最新商品和热门商品 将他们放入request域中 请求转发
		ProductService productService = new ProductServiceImpl();

		// 最新商品
		List<Product> newList = null;
		// 热门商品
		List<Product> hotList = null;

		try {
			newList = productService.findNew();
			hotList = productService.findHot();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 将俩个list放入域中
		request.setAttribute("newList", newList);
		request.setAttribute("hotList", hotList);

		// 转发到index.jsp页面
		request.getRequestDispatcher("/user/jsp/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
