package com.wjl.loans.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author  gaow
 * @date 2020年5月20日17:02:58
 * @descript 登录拦截器,解决跨域问题
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object arg2) {
		// 1.解决跨域
		this.addHead(httpServletRequest, httpServletResponse);
		return true;
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	/**
	 *
	 * @author 李驰
	 *
	 * @date 2019年3月8日 上午10:27:27
	 *
	 * @descript 添加请求头
	 */
	private void addHead(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("origin"));
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
		httpServletResponse.setHeader("Access-Control-Allow-Headers",
				"Origin,Content-Type,Accept,token,X-Requested-With");
		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

	}

}
