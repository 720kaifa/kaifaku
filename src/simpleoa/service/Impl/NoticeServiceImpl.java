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
        if(notice.getIstop()==1){
            Notice not=iNoticeDao.findNoticeByIstop(1);
            if(not!=null){
                not.setIstop(2);
            }
            iNoticeDao.updateNotice(not);
        }
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

    @Override
    public Notice findNoticeById(int id) {
        return iNoticeDao.findNoticeById(id);
    }

    @Override
    public int updateNotice(Notice notice, User user) {
        Notice onotice=iNoticeDao.findNoticeById(notice.getId());
        onotice.setTitle(notice.getTitle());
        onotice.setContent(notice.getContent());
        onotice.setIstop(notice.getIstop());
        onotice.setUPDATE_USER(user.getAccount());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        onotice.setUPDATE_TIME(df.format(new Date()));
        if(notice.getIstop()==1){
            Notice not=iNoticeDao.findNoticeByIstop(1);
            if(not!=null){
                not.setIstop(2);
            }
            iNoticeDao.updateNotice(not);
        }
        return iNoticeDao.updateNotice(onotice);
    }

    @Override
    public int delNotice(int id) {
        return iNoticeDao.delNotice(id);
    }

    @Override
    public Notice getNotice() {
        Notice notice=iNoticeDao.findNoticeByIstop(1);
        if(notice==null){
            List<Notice> list=iNoticeDao.findLastNotice();
            notice=list.get(0);
        }
        return notice;
    }


}
