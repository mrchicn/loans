//package com.wjl.loans.utils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//
//
///**
// *
// * @author 李驰
// *
// * @date 2019年1月3日 下午4:46:37
// *
// * @descript 登录拦截器
// */
//public class LoginInterceptor extends BaseController implements HandlerInterceptor {
//	@Autowired
//	private CacheService cacheService;
//
//	@Override
//	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
//			Object arg2) {
//		// 1.解决跨域
//		this.addHead(httpServletRequest, httpServletResponse);
//		return true;
//	}
//
//	@Override
//	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
//			throws Exception {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
//			throws Exception {
//		// TODO Auto-generated method stub
//
//	}
//
//	/**
//	 *
//	 * @author 李驰
//	 *
//	 * @date 2019年3月8日 上午10:27:27
//	 *
//	 * @descript 添加请求头
//	 */
//	private void addHead(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
//		httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("origin"));
//		httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
//		httpServletResponse.setHeader("Access-Control-Allow-Headers",
//				"Origin,Content-Type,Accept,token,X-Requested-With");
//		httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
//
//	}
//
//}
