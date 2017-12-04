package cairh.community.api.game.kxian.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cairh.community.api.game.kxian.exception.BizException;
import cairh.community.api.game.kxian.service.ITokenService;

/**
 * 用户有效性验证、token验证
 * Created by duanxq on 2016/12/20.
 */
public class UserValidInterceptor extends HandlerInterceptorAdapter{
	
	private static final String UTF_8 = "UTF-8";

    @Autowired
    private ITokenService tokenService;
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String mobileNo = request.getParameter("mobileNo");
        String encodeURI = request.getParameter("htsec_url");
        String decodeURI = request.getParameter("htsec_url1");
        
        if(StringUtils.isBlank(mobileNo)){
        	 throw new BizException("403", "请求拒绝");
        }
        
        String mobile = new String(Base64.decodeBase64(mobileNo.getBytes(UTF_8)), UTF_8);
        
        request.setAttribute("mobileNo", mobile);;
        
        logger.info("解析前地址："+encodeURI+",解析后地址："+decodeURI);
        logger.info("mobile:"+mobile);
        return super.preHandle(request, response, handler);
    }

    public boolean isBlank(String str) {
        return StringUtils.isBlank(str) || "null".equals(str);
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
