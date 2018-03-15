package user.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import user.entity.User;
import user.other.MyConventer;
import user.service.UserService;
import user.service.impl.UserServiceImpl;
import user.utils.MD5Utils;

/**
 * 和用户相关的servlet
 */
public class UserServlet extends BaseServlet {

	/**
	 * ajax 检验账号是否重复
	 */
	public String checkUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		String userName = null;
		userName = request.getParameter("username");
		UserService userService = new UserServiceImpl();
		try {
			if (userService.checkUser(userName)) {
				response.getWriter().write("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 用户注册
	 */
	public String regist(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1.封装数据
		User user = new User();

		String yzmcode = request.getParameter("yzmcode");

		String zcmsg = (String) request.getSession(false).getAttribute("yzmsg");
		if (!yzmcode.equalsIgnoreCase(zcmsg)) {
			request.setAttribute("msg", "验证码出错!!");
			return "/user/jsp/msg.jsp";
		}

		// 注册自定义转化器
		ConvertUtils.register(new MyConventer(), Date.class);
		BeanUtils.populate(user, request.getParameterMap());

		// 设置用户id
		user.setUid(UUID.randomUUID().toString().replace("-", "").toUpperCase());

		// 加密密码
		user.setPassword(MD5Utils.md5(user.getPassword()));

		// 调用service完成注册
		UserService s = new UserServiceImpl();
		s.regist(user);

		// 页面请求转发
		request.setAttribute("msg",
				"用户注册已成功,请点击<a href='" + request.getContextPath()
						+ "/user/jsp/login.jsp'>登陆</a>");

		return "/user/jsp/msg.jsp";
	}

	/**
	 * 跳转到登录页面
	 */
	public String loginUI(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		return "/user/jsp/login.jsp";
	}

	/**
	 * 登录
	 */
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 1.获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String logincode = request.getParameter("logincode");

		String loginmsg = (String) request.getSession(false).getAttribute(
				"yzmsg");

		if (!logincode.equalsIgnoreCase(loginmsg)) {
			request.setAttribute("msg", "验证码出错!!");
			return "/user/jsp/login.jsp";
		}

		password = MD5Utils.md5(password);

		// 2.调用serive完成登录操作 返回user
		UserService s = new UserServiceImpl();
		User user = s.login(username, password);

		// 3.判断用户
		if (user == null) {
			// 用户名密码不匹配
			request.setAttribute("msg", "账号密码不匹配,请重新登陆");
			return "/user/jsp/login.jsp";
		} else {
			// 继续判断用户的状态是否可以正常使用
			if (0 != user.getState()) {
				request.setAttribute("msg", "账号不能正常使用,可能被注销或被禁用,请与系统管理员联系!!");
				return "/user/jsp/msg.jsp";
			}
		}

		// 4.将user放入session中 重定向
		request.getSession().setAttribute("user", user);
		response.sendRedirect(request.getContextPath());

		return null;
	}

	/**
	 * 用户登出
	 */
	public String logout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 干掉session
		request.getSession().invalidate();

		// 重定向
		response.sendRedirect(request.getContextPath() + "/");

		return null;
	}

	/**
	 * 用户账号注销
	 */
	public String stopUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 通过session，获取账户的uid
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String uid = user.getUid();

		// 干掉session
		session.invalidate();

		// 调用Service，注销账号
		UserService s = new UserServiceImpl();
		try {
			s.cancel(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 重定向
		response.sendRedirect(request.getContextPath() + "/");
		return null;
	}

	/**
	 * 用户账号基础信息修改
	 */
	public String updateUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 通过session，获取账户的uid
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		// 获得前台取得的数据
		String email = request.getParameter("email");
		user.setEmail(email);
		String name = request.getParameter("name");
		user.setName(name);
		String sex = request.getParameter("sex");
		user.setSex(sex);
		String birthday = request.getParameter("birthday");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(birthday);
			user.setBirthday(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String telephone = request.getParameter("telephone");
		user.setTelephone(telephone);

		// 调用Service，更改信息
		UserService s = new UserServiceImpl();
		User newUser = null;
		try {
			newUser = s.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 干掉session,并重新把用户添加到session中
		session.invalidate();
		request.getSession().setAttribute("user", newUser);

		// 重定向
		response.sendRedirect(request.getContextPath() + "/");
		return null;
	}

	/**
	 * 用户账号密码修改
	 */
	public String updatePwd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 通过session，获取账户的uid
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String uid = user.getUid();

		// 获得账户的密码
		String oldpwd = request.getParameter("oldpwd");
		if(!MD5Utils.md5(oldpwd).equals(user.getPassword())) {
			request.setAttribute("msg", "修改时，密码出错!!");
			return "/user/jsp/msg.jsp";
		}
		
		// 获得账户的密码
		String newPwd = request.getParameter("newpwd");
		if(newPwd == null) {
			request.setAttribute("msg", "新密码为空!!");
			return "/user/jsp/msg.jsp";
		}
		// 加密密码
		String pwd = MD5Utils.md5(newPwd);

		// 调用Service，注销账号
		UserService s = new UserServiceImpl();
		User newUser = null;
		try {
			// 获取最新的User，保存到session中
			newUser = s.updatePwd(uid, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 干掉session
		session.invalidate();
		// 将新用户保存到session中
		request.getSession().setAttribute("user", newUser);
		response.sendRedirect(request.getContextPath());

		return null;
	}

}
