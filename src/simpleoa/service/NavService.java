package simpleoa.service;

import simpleoa.model.NavMenu;
import simpleoa.model.User;

import java.util.List;

/**
 * Created by Luwer on 2017/12/7.
 */
public interface NavService {
    public List<NavMenu> findAllByAut(User user);
}
