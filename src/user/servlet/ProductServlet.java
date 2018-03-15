package user.servlet;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.PageBean;
import user.entity.Product;
import user.service.ProductService;
import user.service.impl.ProductServiceImpl;

/**
 * 商品servlet
 */
public class ProductServlet extends BaseServlet {

	private String createValue(HttpServletRequest request,String id) {
		
		Cookie[] cookies = request.getCookies();
		String prodHist = null;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("prodHist")){
					prodHist = cookie.getValue();
					break;
				}
			}
		}
		
		// null或没有prodHist
		if(cookies==null || prodHist==null){
			//直接返回传入的id
			return id;
		}
		
		//String -> String[] ->  Collection :为了方便判断重复id
		String[] ids = prodHist.split("-");
		Collection colls = Arrays.asList(ids); 
		// Collection -> LinkedList
		LinkedList list = new LinkedList(colls);
		
		//不超过7个
		if(list.size()<7){
			//id重复
			if(list.contains(id)){
				//去除重复id，把传入的id放最前面
				list.remove(id);
				list.addFirst(id);
			}else{
				//直接把传入的id放最前面
				list.addFirst(id);
			}
		}else{
			//id重复
			if(list.contains(id)){
				//去除重复id，把传入的id放最前面
				list.remove(id);
				list.addFirst(id);
			}else{
				//去最后的id，把传入的id放最前面
				list.removeLast();
				list.addFirst(id);
			}
		}
		
		// LinedList -> String 
		StringBuffer sb = new StringBuffer();
		for (Object object : list) {
			sb.append(object+"-");
		}
		//去掉最后的-号
		String result = sb.toString();
		result = result.substring(0, result.length()-1);
		return result;
	}
	
	/**
	 * 通过id查询单个商品详情
	 */
	public String getById(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1.获取商品的id
		String pid = request.getParameter("pid");

		// 2.调用service
		ProductService ps = new ProductServiceImpl();
		Product product = ps.getByPid(pid);
		
		// 3.此处需要处理浏览记录
		// 3.1.创建cookie
		Cookie cookie = new Cookie("prodHist",createValue(request,pid));
		cookie.setMaxAge(1*7*24*60*60);//一周
		// 3.2.发送cookie
		response.addCookie(cookie);
		
		// 4.将结果放入request中 请求转发
		request.setAttribute("product", product);
		return "/user/jsp/product_info.jsp";
	}

	/**
	 * 分页查询数据
	 */
	public String findByPage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String cid = request.getParameter("cid");
		int currPage = Integer.parseInt(request.getParameter("currPage"));
		int pageSize = 12; // 设置每页显示的条数

		// 2.调用service 返回值pagebean
		ProductService productService = new ProductServiceImpl();;
		PageBean<Product> pageBean = productService.findByPage(currPage, pageSize, cid);

		// 3.显示浏览过的商品
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			List<Product> hisList = new LinkedList<Product>();
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("prodHist")){
					String prodHist = cookie.getValue(); 
					String[] ids = prodHist.split("-");
					//遍历浏览过的商品id
					for (String id : ids) {
						Product product = productService.getByPid(id);
						hisList.add(product);
					}
				}
				
			}
			request.setAttribute("hisList", hisList);
		}
		
		// 4.将结果放入request中 请求转发
		request.setAttribute("pageBean", pageBean);
		return "/user/jsp/product_list.jsp";
	}

}
