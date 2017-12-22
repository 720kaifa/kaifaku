package simpleoa.service;

import simpleoa.model.News;
import simpleoa.model.User;

import java.util.List;

/**
 * Created by Luwer on 2017/12/19.
 */
public interface NewsService {
    public int addNews(News news, User user);
    public List<News> findAllNews(int pageSize, int pageNum);
    public int getCount();
    public News findNewsById(int id);
    public int updateNews(News news,User user);
    public int delNews(int id);
    public News getLastNews();
}
