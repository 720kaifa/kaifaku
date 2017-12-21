package simpleoa.dao;

import org.apache.ibatis.annotations.Param;
import simpleoa.model.News;
import simpleoa.model.Notice;

import java.util.List;

/**
 * Created by Luwer on 2017/12/19.
 */
public interface INewsDao {
    public int addNews(News news);
    public List<News> findAllNews(@Param("startRow")int startRow, @Param("pageSize")int pageSize);
    public int getCount();
}
