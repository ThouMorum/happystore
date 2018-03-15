package admin.servlet.promotion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.Promotion;
import admin.service.APromotionService;
import admin.service.impl.APromotionServiceImpl;

public class UpdatePromotionUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pnid = request.getParameter("pnid");
		APromotionService aPromotionService = new APromotionServiceImpl();
		Promotion promotion = null;
		try {
			promotion = aPromotionService.getById(pnid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("promotion", promotion);
		request.getRequestDispatcher("/admin/promotion/edit.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
