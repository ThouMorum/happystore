package admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 店铺实体
 */
public class Business implements Serializable{

	private String bid;		// id
	private String bname;	// 店铺名称
	private String address;	// 店铺地址
	private Date createdate;  // 店铺创建时间
	
	private String buserpwd; // 店铺密码 （通过店铺名登录）
	
	private String busername; // 店铺所有者姓名
	private String telephone; // 店铺所有者电话
	private String email; 	  // 店铺所有者email
	private String sex;	      // 店铺所有者性别
	
	private Integer stars;	   // 店铺的星级（1-5星）
	private Integer state = 0; // 店铺的状态 
	// 0 待审核 1 正常 2 .。
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getBuserpwd() {
		return buserpwd;
	}
	public void setBuserpwd(String buserpwd) {
		this.buserpwd = buserpwd;
	}
	public String getBusername() {
		return busername;
	}
	public void setBusername(String busername) {
		this.busername = busername;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
