package admin.servlet.promotion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.Category;
import user.entity.Promotion;
import user.service.CategoryService;
import user.service.impl.CategoryServiceImpl;
import admin.service.ACategoryService;
import admin.service.APromotionService;
import admin.service.impl.ACategoryServiceImpl;
import admin.service.impl.APromotionServiceImpl;

public class UpdatePromotionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pnid = request.getParameter("pnid");
		String pnname = request.getParameter("pnname");
		APromotionService aPromotionService = new APromotionServiceImpl();
		Promotion promotion = null;
		try {
			promotion = aPromotionService.getById(pnid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		promotion.setPnname(pnname);
		try {
			aPromotionService.update(promotion);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("/admin/AFindPromotion").forward(request,
				response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
