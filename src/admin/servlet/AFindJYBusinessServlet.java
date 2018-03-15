package admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.entity.Business;
import admin.service.AdminService;
import admin.service.impl.AdminServiceImpl;

public class AFindJYBusinessServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.调用AdminService
		AdminService adminService = new AdminServiceImpl();
		List<Business> listBusiness = null;
		try {
			listBusiness = adminService.findJYBusiness();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 2.把listBusiness添加到request中，进行转发
		request.setAttribute("listBusiness", listBusiness);
		request.getRequestDispatcher("/admin/abusiness/list2.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
