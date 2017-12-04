package simpleoa.service;

import simpleoa.model.User;

/**
 * Created by Luwer on 2017/11/28.
 */
public interface UserService {
    public User login(String account,String password);
    public boolean register(User user);
    public int updateUser(User user);
    public User findUserById(int id);
}
