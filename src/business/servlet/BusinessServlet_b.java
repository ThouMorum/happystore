package business.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.ProductService;
import user.service.impl.ProductServiceImpl;
import business.entity.Business;
import business.entity.Category;
import business.entity.Product;
import business.entity.Promotion;
import business.service.BusinessService;
import business.service.impl.BusinessServiceImpl;

/**
 * 商家产品管理模块
 */
public class BusinessServlet_b extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 查询该店家提供的商品，进行列表展示
	 */
	public String findAllByBid(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 1.获取bid
		Business business = (Business) request.getSession().getAttribute(
				"Business");
		String bid = business.getBid();

		// 2.调用BusinessService 通过bid获取商品列表
		BusinessService businessService = new BusinessServiceImpl();
		List<Product> productList = businessService.getListById(bid);

		// 3.添加到request中，进行转发
		request.setAttribute("productList", productList);
		return "/business/product/list.jsp";
	}

	/**
	 * 先查询促销类型和产品分类，跳转到添加页面，
	 */
	public String addUI(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 调用BusinessService 获取产品分类列表
		BusinessService businessService = new BusinessServiceImpl();
		List<Category> categoryList = businessService.findCategory();
		List<Promotion> promotionList = businessService.findPromotion();

		// 添加到request中，进行转发
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("promotionList", promotionList);
		return "/business/product/add.jsp";
	}

	/**
	 * 通过pid删除商品
	 */
	public String deleteById(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 1.获取pid
		String pid = request.getParameter("pid");

		// 2.调用BusinessService 通过pid删除产品
		BusinessService businessService = new BusinessServiceImpl();
		businessService.deleteById(pid);

		// 3.进行转发
		return "/Business_Pro?method=findAllByBid";
	}

	/**
	 * 获取到pid，查询数据后返回到edit.jsp
	 */
	public String editUI(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 1.获取pid
		String pid = request.getParameter("pid");

		// 2.调用Service 通过pid获取产品
		ProductService ProductService = new ProductServiceImpl();
		user.entity.Product product = ProductService.getByPid(pid);

		// 3.调用BusinessService 获取产品分类列表
		BusinessService businessService = new BusinessServiceImpl();
		List<Category> categoryList = businessService.findCategory();
		List<Promotion> promotionList = businessService.findPromotion();

		// 添加到request中，进行转发
		request.setAttribute("categoryList", categoryList);
		request.setAttribute("promotionList", promotionList);
		request.setAttribute("bproduct", product);
		return "/business/product/edit.jsp";
	}

}
