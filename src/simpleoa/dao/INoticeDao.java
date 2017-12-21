package simpleoa.dao;

import org.apache.ibatis.annotations.Param;
import simpleoa.model.Notice;

import java.util.List;

/**
 * Created by Luwer on 2017/12/19.
 */
public interface INoticeDao {
    public int addNotice(Notice notice);
    public List<Notice> findAllNotice(@Param("startRow")int startRow, @Param("pageSize")int pageSize);
    public int getCount();
    public Notice findNoticeByIstop(int istop);
    public Notice findNoticeById(int id);
    public int updateNotice(Notice notice);
    public int delNotice(int id);
    public List<Notice> findLastNotice();
}
