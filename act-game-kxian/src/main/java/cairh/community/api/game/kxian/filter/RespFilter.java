package cairh.community.api.game.kxian.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class RespFilter implements Filter {
	private static List<String> filterList = null;
	private static List<String> cacheList = null;
	static{
		if (null == filterList) {
			filterList = new ArrayList<String>();
			filterList.add(".css");
			filterList.add(".js");
		}
		if (null == cacheList) {
			cacheList = new ArrayList<String>();
			cacheList.add(".css");
			cacheList.add(".js");
		}
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			String url = req.getRequestURL().toString();
			String pUrl = url.substring(url.lastIndexOf("/")+1 );
			if (pUrl.indexOf(".action") != -1) {
				res.setHeader("Pragma","no-cache");
				res.setHeader("Cache-Control","no-cache, no-store");
				res.setDateHeader("Expires", 0);
			}
			for(String x:filterList){
				if(pUrl.indexOf(x) != -1){
					res.setCharacterEncoding("UTF-8");
				}
			}
			
			chain.doFilter(req, res);
	}



	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
