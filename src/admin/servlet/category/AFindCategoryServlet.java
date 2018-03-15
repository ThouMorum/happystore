package admin.servlet.category;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.Category;
import user.service.CategoryService;
import user.service.impl.CategoryServiceImpl;

public class AFindCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> listCategory = null;
		try {
			listCategory = categoryService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("listCategory", listCategory);
		request.getRequestDispatcher("/admin/category/list.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
