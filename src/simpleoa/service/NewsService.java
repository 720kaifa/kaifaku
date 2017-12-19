package simpleoa.service;

import simpleoa.model.News;
import simpleoa.model.User;

/**
 * Created by Luwer on 2017/12/19.
 */
public interface NewsService {
    public int addNews(News news, User user);
}
