package simpleoa.service;

import simpleoa.model.Notice;
import simpleoa.model.User;

/**
 * Created by Luwer on 2017/12/19.
 */
public interface NoticeService {
    public int addNotice(Notice notice, User user);
}
