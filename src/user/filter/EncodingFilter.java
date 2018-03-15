package user.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 编码处理统一写到这里(servlet中不需要再处理编码)
 */
public class EncodingFilter implements Filter {

	// 过滤器业务处理方法：处理的公用的业务逻辑操作
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		// 转型
		final HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// 一、处理公用业务
		request.setCharacterEncoding("UTF-8"); // POST提交有效
		response.setContentType("text/html;charset=UTF-8");

		/*
		 * 出现GET中文乱码，是因为在request.getParameter方法内部没有进行提交方式判断并处理。 String name =
		 * request.getParameter("userName");
		 * 
		 * 解决：对指定接口的某一个方法进行功能扩展，可以使用代理! 对request对象(目标对象)，创建代理对象！
		 */
		HttpServletRequest proxy = (HttpServletRequest) Proxy.newProxyInstance(
				request.getClass().getClassLoader(), // 指定当前使用的累加载器
				new Class[] { HttpServletRequest.class }, // 对目标对象实现的接口类型
				new InvocationHandler() { // 事件处理器
					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						// 定义方法返回值
						Object returnValue = null;
						// 获取方法名
						String methodName = method.getName();
						// 判断：对getParameter方法进行GET提交中文处理
						if ("getParameter".equals(methodName)) {

							// 获取请求数据值【 <input type="text" name="userName">】
							String value = request.getParameter(args[0]
									.toString()); // 调用目标对象的方法

							// 获取提交方式
							String methodSubmit = request.getMethod(); // 直接调用目标对象的方法

							// 判断如果是GET提交，需要对数据进行处理 (POST提交已经处理过了)
							if ("GET".equals(methodSubmit)) {
								if (value != null && !"".equals(value.trim())) {
									// 处理GET中文
									value = new String(value
											.getBytes("ISO8859-1"), "UTF-8");
								}
							}
							return value;
						} else {
							// 执行request对象的其他方法
							returnValue = method.invoke(request, args);
						}

						return returnValue;
					}
				});

		// 二、放行 (执行下一个过滤器或者servlet)
		chain.doFilter(proxy, response); // 传入代理对象
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}
}
