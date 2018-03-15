package admin.servlet.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.ACategoryService;
import admin.service.impl.ACategoryServiceImpl;

public class DeleteCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cid = request.getParameter("cid");
		
		ACategoryService acategoryService = new ACategoryServiceImpl();
		try {
			acategoryService.delete(cid);
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
