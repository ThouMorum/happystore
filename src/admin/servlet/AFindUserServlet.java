package admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.entity.User;
import admin.service.AdminService;
import admin.service.impl.AdminServiceImpl;
import business.entity.Product;

public class AFindUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.调用AdminService
		AdminService adminService = new AdminServiceImpl();
		List<User> listUser = null;
		try {
			listUser = adminService.findUser();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 2.添加到request中，进行转发
		request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("/admin/auser/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
