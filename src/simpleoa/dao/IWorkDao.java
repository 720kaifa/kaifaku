package simpleoa.dao;

import simpleoa.model.WorkLog;

import java.util.List;

/**
 * Created by Luwer on 2017/12/4.
 */
public interface IWorkDao {
    public List<WorkLog> findAllByUserId(int userid,int startRow,int pageSize);
    public int getCount(int userid);
    public int addWorklog(WorkLog workLog);
    public WorkLog findWorklogById(int id);
    public int updateWorklog(WorkLog workLog);
    public int delWorklog(int id);
}
