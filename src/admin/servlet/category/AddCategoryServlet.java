package admin.servlet.category;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.Category;
import admin.service.ACategoryService;
import admin.service.impl.ACategoryServiceImpl;

public class AddCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cname = request.getParameter("cname");

		Category category = new Category();
		category.setCid(UUID.randomUUID().toString().replace("-", "")
				.toUpperCase());
		category.setCname(cname);

		ACategoryService acategoryService = new ACategoryServiceImpl();
		try {
			acategoryService.add(category);
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
