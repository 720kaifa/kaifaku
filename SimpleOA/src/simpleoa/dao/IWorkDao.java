package simpleoa.dao;

import simpleoa.model.WorkLog;

import java.util.List;

/**
 * Created by Luwer on 2017/12/4.
 */
public interface IWorkDao {
    public List<WorkLog> findAll();
}
