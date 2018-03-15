package user.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Serializable {
	// 存放购物车项的集合 key:商品的id cartitem:购物车项 使用map集合便于删除单个购物车项
	private Map<String, CartItem> map = new LinkedHashMap<>();

	// 总金额
	private Double total = 0.0;

	public Map<String, CartItem> getMap() {
		return map;
	}

	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * 获取所有的购物车项
	 */
	public Collection<CartItem> getItem() {
		return map.values();
	}

}