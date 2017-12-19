package simpleoa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleoa.dao.INewsDao;
import simpleoa.model.News;
import simpleoa.model.User;
import simpleoa.service.NewsService;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        return iNewsDao.addNews(news);
    }
}
