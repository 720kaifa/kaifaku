package simpleoa.dao;

import simpleoa.model.NavMenu;

import java.util.List;

/**
 * Created by Luwer on 2017/12/7.
 */
public interface INavDao {
    public List<NavMenu> findAllByAut(int authority);

    public NavMenu findMenuById(int id);
}
