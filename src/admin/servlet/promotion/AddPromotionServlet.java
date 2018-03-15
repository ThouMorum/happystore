package admin.servlet.promotion;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.entity.Promotion;
import admin.service.APromotionService;
import admin.service.impl.APromotionServiceImpl;

public class AddPromotionServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pnname = request.getParameter("pnname");

		Promotion promotion = new Promotion();
		promotion.setPnid(UUID.randomUUID().toString().replace("-", "")
				.toUpperCase());
		promotion.setPnname(pnname);

		APromotionService aPromotionService = new APromotionServiceImpl();
		try {
			aPromotionService.add(promotion);
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
