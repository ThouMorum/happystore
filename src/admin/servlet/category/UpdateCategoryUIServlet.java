package admin.servlet.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.Category;
import user.service.CategoryService;
import user.service.impl.CategoryServiceImpl;

public class UpdateCategoryUIServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cid = request.getParameter("cid");
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = null;
		try {
			category = categoryService.getById(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("category", category);
		request.getRequestDispatcher("/admin/category/edit.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
