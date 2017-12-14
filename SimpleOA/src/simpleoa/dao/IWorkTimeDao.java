package simpleoa.dao;

import org.apache.ibatis.annotations.Param;
import simpleoa.model.WorkTime;

import java.util.List;

/**
 * Created by Luwer on 2017/12/11.
 */
public interface IWorkTimeDao {
    public int addWorkTime(WorkTime workTime);
    public int updateWorkTime(WorkTime workTime);
    public WorkTime findWorkTimeByUserid(@Param("userid")int userid,@Param("projectid")int projectid);
    public List<WorkTime> findAllByUserId(@Param("userid")int userid,@Param("startRow")int startRow,@Param("pageSize")int pageSize);
    public int getCount(@Param("userid")int userid);
}
