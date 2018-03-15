package business.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.utils.MD5Utils;
import business.entity.Business;
import business.service.BusinessUseService;
import business.service.impl.BusinessUseServiceImpl;
public class BusinessServlet_a extends BaseServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户账号密码修改
	 */
	public String updatePwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 通过session，获取账户的bid
		HttpSession session = request.getSession();
		Business businessUse = (Business) session.getAttribute("Business");
		String bid = businessUse.getBid();

		// 获得账户的旧密码
		String oldpwd = request.getParameter("oldpwd");
		if(!MD5Utils.md5(oldpwd).equals(businessUse.getBuserpwd())) {
			request.setAttribute("msg", "修改时，密码出错!!");
			return "/business/jsp/msg.jsp";
		}
		
		// 获得账户的新密码
		String newPwd = request.getParameter("newpwd");
		if(newPwd == null) {
			request.setAttribute("msg", "新密码为空!!");
			return "/business/jsp/msg.jsp";
		}
		// 加密密码
		String pwd = MD5Utils.md5(newPwd);

		// 调用Service，注销账号
		BusinessUseService bus = new BusinessUseServiceImpl();
		Business newBusiness = null;
		try {
			// 获取最新的Business，保存到session中
			newBusiness = bus.updatePwd(bid, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 干掉session
		session.invalidate();
		// 将新用户保存到session中
		request.getSession().setAttribute("Business", newBusiness);
		request.setAttribute("msg", "密码修改成功!!!");
		return "/business/jsp/msg.jsp";
	}
	
	/**
	 * 账号注册
	 */
	public String register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取参数
		String busername = request.getParameter("username");
		String email = request.getParameter("email");
		String bname = request.getParameter("name"); //店名
		String address = request.getParameter("address");
		String telephone = request.getParameter("telephone");
		String buserpwd = request.getParameter("password");
		
		// 验证码验证
		String code = request.getParameter("code");
		String yzmsg = (String) request.getSession(false).getAttribute(
				"yzmsg");

		if (!code.equalsIgnoreCase(yzmsg)) {
			request.setAttribute("msg", "在进行店铺管理系统注册时,验证码出错!!");
			return "/user/jsp/msg.jsp";
		}
		
		// 设置参数
		Business business = new Business();
		business.setAddress(address);
		business.setBid(UUID.randomUUID().toString().replace("-", "").toUpperCase());
		business.setBname(bname);
		business.setBusername(busername);
		business.setBuserpwd(MD5Utils.md5(buserpwd));
		business.setCreatedate(new Date());
		business.setEmail(email);
		// 初始时，state=0 提交完注册 还未可用 
		business.setState(0);
		business.setTelephone(telephone);
		// 默认，店铺创建时星级为3
		business.setStars(3);
		
		// 调用service完成注册
		BusinessUseService bus = new BusinessUseServiceImpl();
		try {
			bus.regist(business);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

		// 页面请求转发
		request.setAttribute("msg",
				"店铺注册已成功,等待运营商批准，请点击<a href='" + request.getContextPath()
						+ "/business/jsp/index.jsp'>登陆</a>");

		return "/user/jsp/msg.jsp";
	}
	

	/**
	 * 登录
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1.获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String logincode = request.getParameter("yz");

		String loginmsg = (String) request.getSession(false).getAttribute(
				"yzmsg");

		if (!logincode.equalsIgnoreCase(loginmsg)) {
			request.setAttribute("msg", "在进行店铺管理系统登陆时,验证码出错!!");
			return "/business/jsp/index.jsp";
		}

		password = MD5Utils.md5(password);

		// 2.调用serive完成登录操作 返回user
		BusinessUseService bus = new BusinessUseServiceImpl();
		Business business = bus.login(username, password);

		// 3.判断用户
		if (business == null) {
			// 账号密码不匹配
			request.setAttribute("msg", "账号密码不匹配,请重新登陆");
			return "/business/jsp/index.jsp";
		} else {
			// 继续判断用户的状态是否可以正常使用
			if (1 != business.getState()) {
				request.setAttribute("msg", "账号不能正常使用,可能未允许注册,或被禁用等,请与系统管理员联系!!");
				return "/business/jsp/index.jsp";
			}
		}

		// 4.将user放入session中 重定向
		request.getSession().setAttribute("Business", business);
		response.sendRedirect(request.getContextPath() + "/business/jsp/home.jsp" );

		return null;
	}
	
	/**
	 * ajax 检验账号是否重复
	 */
	public String checkBusiness(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		String userName = null;
		userName = request.getParameter("username");
		BusinessUseService bus = new BusinessUseServiceImpl();
		try {
			if (bus.checkBusiness(userName)) {
				response.getWriter().write("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 账号信息修改
	public String updateBusiness(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取参数
		String busername = request.getParameter("busername");
		String email = request.getParameter("email");
//		String bname = request.getParameter("bname"); //店名
		String address = request.getParameter("address");
		String telephone = request.getParameter("telephone");
		
		// 设置参数
		Business business = (Business) request.getSession().getAttribute("Business");
		business.setAddress(address);
		business.setBusername(busername);
		business.setEmail(email);
		business.setTelephone(telephone);
		
		// 调用service完成注册
		BusinessUseService bus = new BusinessUseServiceImpl();
		try {
			bus.updateBusiness(business);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

		// 干掉session,并重新把添加到session中
		request.getSession().invalidate();
		request.getSession().setAttribute("Business", business);
		
		// 页面请求转发
		request.setAttribute("msg","店铺基础信息修改成功!!!");
		return "/business/jsp/msg.jsp";
	}
	
	
}
