package simpleoa.service;

import simpleoa.model.User;

import java.util.List;

/**
 * Created by Luwer on 2017/11/28.
 */
public interface UserService {
    public User login(String account,String password);
    public boolean register(User user);
    public int addUser(String account,String relname,String role,String create_user);
    public int updateUser(User user,User suser);
    public User findUserById(int id);
    public List<User> findAll();
}
