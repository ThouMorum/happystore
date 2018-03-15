package admin.servlet.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.Category;
import user.service.CategoryService;
import user.service.impl.CategoryServiceImpl;
import admin.service.ACategoryService;
import admin.service.impl.ACategoryServiceImpl;

public class UpdateCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cid = request.getParameter("cid");
		String cname = request.getParameter("cname");
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = null;
		try {
			category = categoryService.getById(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		category.setCname(cname);
		ACategoryService acategoryService = new ACategoryServiceImpl();
		try {
			acategoryService.update(category);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/admin/AFindCategory").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
