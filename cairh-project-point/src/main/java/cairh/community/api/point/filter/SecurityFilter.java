package cairh.community.api.point.filter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能说明: 安全过滤器<br>
 * 系统版本: v1.0<br>
 * 开发人员: @author kongdy<br>
 * 开发时间: 2015年10月8日<br>
 */
@Component
public class SecurityFilter implements Filter {

	@Override
	public void destroy() {}

	/**
	 * now the doFilter will filter the request ,using the Wrapper class to wrap the request
	 * and in the wrapper class, it will handle the XSS issue
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (checkCsrf((HttpServletRequest) request, (HttpServletResponse) response)) {
			return;
		}
		chain.doFilter(request, response);
	}

	private boolean checkCsrf(HttpServletRequest request, HttpServletResponse response) {
		boolean Csrf = false;
		String origin = request.getHeader("Origin");
		String referer = request.getHeader("Referer");
			try {
				//只接受POST请求
				/*if (StringUtils.isEmpty(origin)) {
					response.sendError(403, "请求拒绝");
					Csrf = true;
				}else */
				if(StringUtils.isNotEmpty(referer) && StringUtils.isNotEmpty(origin) && !StringUtils.startsWith(referer, origin)) {
					response.sendError(403, "请求拒绝");
					Csrf = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		return Csrf;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}
}