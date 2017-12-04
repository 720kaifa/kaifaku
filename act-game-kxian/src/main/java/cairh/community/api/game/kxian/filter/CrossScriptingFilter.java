package cairh.community.api.game.kxian.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cairh.community.api.game.kxian.util.ServletUtils;
  
@Component 
public class CrossScriptingFilter implements Filter {   
  
	private static String [] unfilterUrls = new String[]{};
	private static final Logger log = LoggerFactory.getLogger(CrossScriptingFilter.class);
	
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)    
        throws IOException, ServletException {  
    	try{
    		boolean flag = false;
    		if(unfilterUrls.length > 0){
    			for(String url:unfilterUrls){
        			if(ServletUtils.getRequestURIWithParam((HttpServletRequest) request).contains(url)){
        				flag = true;
        				break;
        			}
        		}
    		}
    		if(flag){
    			chain.doFilter(request, response);   
    		}else{
    			chain.doFilter(new RequestWrapper((HttpServletRequest) request), response);   
    		}
		       
    	}catch (Exception e) {
    		log.error(e.getMessage(),e);
		}
    }

	public void destroy() {
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}  
  
}  