package cairh.community.api.game.kxian.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;



public class BaseController extends DispatcherServlet{
	private static final long serialVersionUID = 1L;
	public static final String SYSTEM_ERROR = "系统繁忙，请稍后重试。";
	protected  HttpServletRequest request;
	protected  HttpServletResponse response;
	
	protected String channelCookieKey = "shortUrl";
	
	/*@Autowired
	private UserBaseService userBaseService;*/
	
	public int getIntParameter(HttpServletRequest request, String parName,int defaultNum){
		try{
			int par = Integer.parseInt(request.getParameter(parName));
			request.setAttribute("par_"+parName,par);
			return par;
		}catch (NumberFormatException e) {
			return defaultNum;
		}
	}
	
	public String getStrParameter(HttpServletRequest request, String param, String defaultValue) {
		String value = request.getParameter(param);
		if(value == null || value.isEmpty()
				|| value.equalsIgnoreCase("null") || value.equalsIgnoreCase("undefined") ){
			value = defaultValue;
		}else{
			value =value.trim();
		}
		request.setAttribute("par_"+param,value);
		return value;
	}
	
	public long getLongParameter(HttpServletRequest request, String param, long defaultValue) {
		String value = request.getParameter(param);
		long val;
		if(value == null || value.isEmpty()
				|| value.equalsIgnoreCase("null") || value.equalsIgnoreCase("undefined") ){
			val = defaultValue;
		}else{
			value =value.trim();
			val =  Long.parseLong(value);
		}
		request.setAttribute("par_"+param,val);
		
		return val;
	}
	
	protected int getIntParameter(String parName,int defaultNum){
		try{
			int par = Integer.parseInt(getRequest().getParameter(parName));
			getRequest().setAttribute("par_"+parName,par);
			return par;
		}catch (NumberFormatException e) {
			return defaultNum;
		}
	}

	/**
	 * 
	 */
	public void setCRHCookie(String name, String value, int maxAge, HttpServletResponse response){
		/*if(!com.cairenhui.oos.util.StringUtil.isBlank(value)) {
			if(value.contains("/")) {
				value = value.substring(0, value.indexOf("/"));
			}
			Cookie cookie = new Cookie(name,  value);
			cookie.setMaxAge(maxAge);
			cookie.setPath("/");
			cookie.setDomain(ConfigProperties.get("oos.cookie.domain") );
			response.addCookie(cookie);
		}*/
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
}
