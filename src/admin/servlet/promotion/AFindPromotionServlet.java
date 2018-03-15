package admin.servlet.promotion;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.Promotion;
import admin.service.APromotionService;
import admin.service.impl.APromotionServiceImpl;

public class AFindPromotionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		APromotionService aPromotionService = new APromotionServiceImpl();
		List<Promotion> promotionList = null;
		try {
			promotionList = aPromotionService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("promotionList", promotionList);
		request.getRequestDispatcher("/admin/promotion/list.jsp").forward(request,
				response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
