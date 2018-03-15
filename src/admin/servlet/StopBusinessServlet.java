package admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.ABusinessService;
import admin.service.impl.ABusinessServiceImpl;

public class StopBusinessServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 获取参数
		String bid = request.getParameter("bid");

		// 2.调用AdminService
		ABusinessService aBusinessService = new ABusinessServiceImpl();
		try {
			aBusinessService.stopBusiness(bid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 3.回到list页面
		request.getRequestDispatcher("/admin/AFindBusiness").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
