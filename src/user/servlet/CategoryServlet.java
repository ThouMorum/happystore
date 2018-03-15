package user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import user.entity.Category;
import user.service.CategoryService;
import user.service.impl.CategoryServiceImpl;

public class CategoryServlet extends BaseServlet {
	/**
	 * 查询所有的分类
	 */
	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.调用categoryservice 查询所有的分类 返回值list
		CategoryService cs = new CategoryServiceImpl();
		List<Category> clist = null;
		try {
			clist = cs.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 2.将返回值转成json格式 返回到页面上
		String json = JSONArray.fromObject(clist).toString();

		// 3.写回去
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(json);

		return null;
	}
}
