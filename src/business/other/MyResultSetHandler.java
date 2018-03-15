package business.other;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import user.entity.Business;
import user.entity.Category;
import user.entity.Promotion;
import user.service.BusinessService;
import user.service.CategoryService;
import user.service.PromotionService;
import user.service.impl.BusinessServiceImpl;
import user.service.impl.CategoryServiceImpl;
import user.service.impl.PromotionServiceImpl;
import business.entity.Product;

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
			// ·â×°Promotion
			PromotionService promotionService = new PromotionServiceImpl();
			Promotion promotion = null;
			try {
				promotion = promotionService.getById(pro_id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			business.entity.Promotion bpromotion = new business.entity.Promotion();
			bpromotion.setPnid(promotion.getPnid());
			bpromotion.setPnname(promotion.getPnname());
			product.setPromotion(bpromotion);

			String cid = rs.getString("cid");
			// ·â×°Category
			CategoryService categoryService = new CategoryServiceImpl();
			Category category = null;
			try {
				category = categoryService.getById(cid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			business.entity.Category bcategory = new business.entity.Category();
			bcategory.setCid(category.getCid());
			bcategory.setCname(category.getCname());
			product.setCategory(bcategory);

			String bid = rs.getString("bid");
			// ·â×°Business
			BusinessService BusinessService = new BusinessServiceImpl();
			Business business = null;
			try {
				business = BusinessService.getById(bid);
			} catch (Exception e) {
				e.printStackTrace();
			}
			business.entity.Business bbusiness = new business.entity.Business();
			bbusiness.setBid(business.getBid());
			bbusiness.setAddress(business.getAddress());
			bbusiness.setBname(business.getBname());
			bbusiness.setBusername(business.getBusername());
			bbusiness.setBuserpwd(business.getBuserpwd());
			bbusiness.setCreatedate(business.getCreatedate());
			bbusiness.setTelephone(business.getTelephone());
			bbusiness.setState(business.getState());
			bbusiness.setStars(business.getStars());
			bbusiness.setSex(business.getSex());
			bbusiness.setEmail(business.getEmail());
			product.setBusiness(bbusiness);

			return product;
		}
		return null;
	}
}
