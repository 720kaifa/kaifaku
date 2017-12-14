package simpleoa.dao;

import simpleoa.model.LoginLog;

import java.util.List;

/**
 * Created by Luwer on 2017/12/4.
 */
public interface ILoginDao {
    public int addLoginLog(LoginLog loginLog);
    public List<LoginLog> findAll(int userid);
    public int delLoginById(int id);
}
