package simpleoa.service;

import simpleoa.model.User;

/**
 * Created by Luwer on 2017/12/4.
 */
public interface LoginLogService {
    public int addLodinLog(User user,String ip);
}
