package simpleoa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleoa.dao.ILoginDao;
import simpleoa.model.LoginLog;
import simpleoa.model.User;
import simpleoa.service.LoginLogService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Luwer on 2017/12/4.
 */
@Service
public class LoginLogServiceImpl implements LoginLogService{
    @Autowired
    private ILoginDao loginDao;
    @Override
    public int addLodinLog(User user, String loginip) {
        LoginLog loginLog=new LoginLog();
        loginLog.setAccount(user.getAccount());
        loginLog.setLoginip(loginip);
        loginLog.setRelname(user.getRelname());
        loginLog.setUserid(user.getId());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        loginLog.setCREATE_TIME(df.format(new Date()));
        loginLog.setCREATE_USER("SYSTEM");
        List<LoginLog> logList=loginDao.findAll(user.getId());
        if(logList.size()>=100){
            loginDao.delLoginById(logList.get(0).getId());
        }
        return loginDao.addLoginLog(loginLog);
    }
}
