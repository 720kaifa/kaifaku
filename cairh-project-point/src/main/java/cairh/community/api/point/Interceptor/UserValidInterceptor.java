package cairh.community.api.point.Interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cairh.community.api.point.exception.BizException;
import cairh.community.api.point.service.ITokenService;

/**
 * 用户有效性验证、token验证
 * Created by duanxq on 2016/12/20.
 */
public class UserValidInterceptor extends HandlerInterceptorAdapter{

    @Autowired
    private ITokenService tokenService;
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getParameter("userId");
        String accountId = request.getParameter("accountId");
        String token = request.getParameter("token");
        String encodeURI = request.getParameter("htsec_url");
        String decodeURI = request.getParameter("htsec_url1");
        logger.info("解析前地址："+encodeURI+",解析后地址："+decodeURI);
        logger.info("token:"+token+",user_id:"+userId+",accountId:"+accountId);
        if (isBlank(userId) && isBlank(accountId)) {
            return super.preHandle(request, response, handler);
        }
        //有用户标示，需要验证token信息
        Map<String, Object> userInfoByToken = tokenService.getUserInfoByToken(token);
        if (userInfoByToken == null) {
            throw new BizException("403", "请求拒绝");
        }
        //accountId为空，根据user_id查询accountId
        Map<String, Object> userBase;
 /*       if (StringUtils.isBlank(accountId)) {
            userBase = userInfoService.getUserBaseInfo(userId);
            if (userBase == null) {
                logger.warn("用户user_id:{}不存在", userId);
                throw new BizException("账号不存在 请联系管理员");
            }
            accountId = MapUtils.getString(userBase, "accountId");
        } else {
            userBase = userInfoService.getUserBaseInfoByAccountId(accountId);
            if (userBase == null) {
                logger.warn("用户account_id:{}不存在", accountId);
                throw new BizException("账号不存在 请联系管理员");
            }
        }
        if ("2".equals(MapUtils.getString(userBase, "status"))) {
            logger.warn("用户account_id:{}已删除", accountId);
            throw new BizException("账号不存在 请联系管理员");
        }
        String accountIdByToken = MapUtils.getString(userInfoByToken, "accountId");
        if (!StringUtils.equals(accountIdByToken, accountId)) {
            logger.warn("token检验失败，accountIdByToken:{},accountId:{}", accountIdByToken, accountId);
            throw new BizException("403", "请求拒绝");
        }*/
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
