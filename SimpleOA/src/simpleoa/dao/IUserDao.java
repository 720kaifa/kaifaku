package simpleoa.dao;

import simpleoa.model.User;

import java.util.List;

/**
 * Created by Luwer on 2017/11/28.
 */
public interface IUserDao {
    public User findUserByAccount(String account);
    public User findUserById(int id);
    public List<User> findAll();
    public int addUser(User user);
    public int updateUser(User user);
}
