package cairh.community.api.point.filter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
  
public final class RequestWrapper extends HttpServletRequestWrapper {   
       
    public RequestWrapper(HttpServletRequest servletRequest) {   
        super(servletRequest);   
    }   
       
    @Override
    public String[] getParameterValues(String parameter) {   
  
      String[] values = super.getParameterValues(parameter);   
      if (values==null)  {   
                  return null;   
          }   
      int count = values.length;   
      String[] encodedValues = new String[count];   
      for (int i = 0; i < count; i++) {   
                 encodedValues[i] = cleanXSS(values[i]);   
       }     
      return encodedValues;    
    }   
     
    @Override
    public String getParameter(String parameter) {   
          String value = super.getParameter(parameter);   
          if (value == null) {   
                 return null;    
                  }   
          return cleanXSS(value);   
    }   
    
    @Override
    public String getHeader(String name) {   
        String value = super.getHeader(name);   
        if (value == null)   
            return null;   
        return cleanXSS(value);   
           
    }   
  
 
    
	/**
	 * 将容易引起xss漏洞的半角字符直接替换成全角字符
	 * 
	 * @param s
	 * @return
	 */
	public static String cleanXSS(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}
		StringBuilder sb = new StringBuilder(s.length() + 16);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '>':
				sb.append('＞');// 全角大于号
				break;
			case '<':
				sb.append('＜');// 全角小于号
				break;
			case '\'':
				sb.append('‘');// 全角单引号
				break;
			case '\"':
				sb.append('“');// 全角双引号
				break;
//			case '&':
//				sb.append('＆');// 全角
//				break;
			case '\\':
				sb.append('＼');// 全角斜线
				break;
			case '#':
				sb.append('＃');// 全角井号
				break;
			case '(':
				sb.append('（');// 全角左括号
				break;
			case ')':
				sb.append('）');// 全角右括号
				break;
			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}

}  