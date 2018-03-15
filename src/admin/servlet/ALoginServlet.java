package admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.entity.Admin;
import admin.service.AdminService;
import admin.service.impl.AdminServiceImpl;

public class ALoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String aname = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 调用service进行
		AdminService adminService = new AdminServiceImpl();
		Admin admin = null;
		try {
			admin = adminService.findAdmin(aname,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (admin == null) {
			// 账号密码不匹配
			request.setAttribute("msg", "账号密码不匹配,请重新登陆");
			request.getRequestDispatcher("/admin/jsp/login.jsp").forward(request, response);
		} else {
			// 4.将admin放入session中 重定向
			request.getSession().setAttribute("Admin", admin);
			response.sendRedirect(request.getContextPath() + "/admin/jsp/home.jsp" );
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

}
