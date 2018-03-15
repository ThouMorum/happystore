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

public class AFindUserByStateServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.获取参数
		String viewstate = request.getParameter("viewstate");
		
		// 1.调用AdminService
		AdminService adminService = new AdminServiceImpl();
		List<User> listUser = null;
		try {
			listUser = adminService.findUserByState(viewstate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 2 把页面的类型区分标志保存到request中
		// 如果在list2.jsp中读到viewnumber==1，表示是注销页面
		request.setAttribute("viewnumber", Integer.parseInt(viewstate));
		
		// 3.把listUser添加到request中，进行转发
		request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("/admin/auser/list2.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
