package simpleoa.service;

import simpleoa.model.User;
import simpleoa.model.WorkLog;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Luwer on 2017/12/4.
 */
public interface WorkLogService {
    public List<WorkLog> findAllByUserId(int userid,int pageSize,int pageNum) ;
    public int getCount(int userid);
    public int addWorklog(WorkLog workLog,User user) throws ParseException;
    public WorkLog findWorklogById(int id);
    public int updateWorklog(WorkLog workLog,User user);
    public int delWorklog(int id);
}
