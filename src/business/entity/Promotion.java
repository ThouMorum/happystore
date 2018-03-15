package business.entity;

import java.io.Serializable;

/**
 * 促销类型实体
 */
public class Promotion implements Serializable {
	private String pnid;
	private String pnname;

	public String getPnid() {
		return pnid;
	}

	public void setPnid(String pnid) {
		this.pnid = pnid;
	}

	public String getPnname() {
		return pnname;
	}

	public void setPnname(String pnname) {
		this.pnname = pnname;
	}

}