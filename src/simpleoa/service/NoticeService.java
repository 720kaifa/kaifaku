package simpleoa.service;

import org.apache.ibatis.annotations.Param;
import simpleoa.model.Notice;
import simpleoa.model.User;

import java.util.List;

/**
 * Created by Luwer on 2017/12/19.
 */
public interface NoticeService {
    public int addNotice(Notice notice, User user);
    public List<Notice> findAllNotice(int pageSize,int pageNum);
    public int getCount();
}
