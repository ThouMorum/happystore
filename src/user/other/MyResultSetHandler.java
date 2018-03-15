package user.other;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import user.entity.Business;
import user.entity.Category;
import user.entity.Product;
import user.entity.Promotion;
import user.service.BusinessService;
import user.service.CategoryService;
import user.service.PromotionService;
import user.service.impl.BusinessServiceImpl;
import user.service.impl.CategoryServiceImpl;
import user.service.impl.PromotionServiceImpl;

public class MyResultSetHandler implements ResultSetHandler {

	@Override
	public Product handle(ResultSet rs) throws SQLException {
		if (rs.next()) {
			Product product = new Product();
			product.setPid(rs.getString("pid"));
			product.setPname(rs.getString("pname"));
			product.setMarket_price(rs.getDouble("market_price"));
			product.setShop_price(rs.getDouble("shop_price"));
			product.setPimage(rs.getString("pimage"));
			product.setIs_hot(rs.getInt("is_hot"));
			product.setPnumber(rs.getInt("pnumber"));
			product.setMarket_price(rs.getDouble("market_price"));
			product.setPdesc(rs.getString("pdesc"));

			String pro_id = rs.getString("pro_id");
			// 封装Promotion
			PromotionService promotionService = new PromotionServiceImpl();
			Promotion promotion = null;
			try {
				promotion = promotionService.getById(pro_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			product.setPromotion(promotion);

			String cid = rs.getString("cid");
			// 封装Category
			CategoryService categoryService = new CategoryServiceImpl();
			Category category = null;
			try {
				category = categoryService.getById(cid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			product.setCategory(category);

			String bid = rs.getString("bid");
			// 封装Business
			BusinessService BusinessService = new BusinessServiceImpl();
			Business business = null;
			try {
				business = BusinessService.getById(bid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			product.setBusiness(business);

			return product;
		}
		return null;
	}
}
