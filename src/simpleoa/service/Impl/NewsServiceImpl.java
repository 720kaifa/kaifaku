package simpleoa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleoa.dao.INewsDao;
import simpleoa.model.News;
import simpleoa.model.User;
import simpleoa.service.NewsService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Luwer on 2017/12/19.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private INewsDao iNewsDao;


    @Override
    public int addNews(News news, User user) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        news.setCREATE_TIME(df.format(new Date()));
        news.setCREATE_USER(user.getAccount());
        news.setRelname(user.getRelname());
        if(news.getIstop()==1){
            News ne=iNewsDao.findNewsByIstop(1);
            if(ne!=null){
                ne.setIstop(2);
            }
            iNewsDao.updateNews(ne);
        }
        return iNewsDao.addNews(news);
    }

    @Override
    public List<News> findAllNews(int pageSize, int pageNum) {
        int startRow = (pageNum - 1) * pageSize;
        return iNewsDao.findAllNews(startRow,pageSize);
    }

    @Override
    public int getCount() {
        return iNewsDao.getCount();
    }

    @Override
    public News findNewsById(int id) {
        return iNewsDao.findNewsById(id);
    }

    @Override
    public int updateNews(News news, User user) {
        News onews=iNewsDao.findNewsById(news.getId());
        onews.setTitle(news.getTitle());
        onews.setContent(news.getContent());
        onews.setIstop(news.getIstop());
        onews.setUPDATE_USER(user.getAccount());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        onews.setUPDATE_TIME(df.format(new Date()));
        if(news.getIstop()==1){
            News ne=iNewsDao.findNewsByIstop(1);
            if(ne!=null){
                ne.setIstop(2);
            }
            iNewsDao.updateNews(ne);
        }
        return iNewsDao.updateNews(onews);
    }

    @Override
    public int delNews(int id) {
        return iNewsDao.delNews(id);
    }

    @Override
    public News getLastNews() {
        News news=iNewsDao.findNewsByIstop(1);
        if(news==null){
            List<News> list=iNewsDao.findLastNews();
            if(list.size()>0){
                news=list.get(0);
            }else{
                news=null;
            }
        }
        return news;
    }
}
