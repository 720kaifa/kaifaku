package simpleoa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleoa.dao.INoticeDao;
import simpleoa.model.Notice;
import simpleoa.model.User;
import simpleoa.service.NoticeService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Luwer on 2017/12/19.
 */
@Service
public class NoticeServiceImpl implements NoticeService{

    @Autowired
    private INoticeDao iNoticeDao;

    @Override
    public int addNotice(Notice notice, User user) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        notice.setCREATE_TIME(df.format(new Date()));
        notice.setCREATE_USER(user.getAccount());
        notice.setRelname(user.getRelname());
        return iNoticeDao.addNotice(notice);
    }

    @Override
    public List<Notice> findAllNotice(int pageSize,int pageNum) {
        int startRow = (pageNum - 1) * pageSize;
        return iNoticeDao.findAllNotice(startRow,pageSize);
    }

    @Override
    public int getCount() {
        return iNoticeDao.getCount();
    }
}
