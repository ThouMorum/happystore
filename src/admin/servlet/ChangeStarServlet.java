package admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.ABusinessService;
import admin.service.impl.ABusinessServiceImpl;

public class ChangeStarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag = request.getParameter("flag");
		String bid = request.getParameter("bid");

		// 调用AdminService
		ABusinessService aBusinessService = new ABusinessServiceImpl();
		if ("zhenjia".equals(flag)) {
			try {
				aBusinessService.changeaddStar(bid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("jianshao".equals(flag)) {
			try {
				aBusinessService.changejianStar(bid);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 转发
		request.getRequestDispatcher("/admin/AFindBusiness").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
