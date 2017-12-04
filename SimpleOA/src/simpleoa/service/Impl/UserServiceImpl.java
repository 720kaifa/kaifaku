package simpleoa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleoa.dao.IUserDao;
import simpleoa.model.User;
import simpleoa.service.UserService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by Luwer on 2017/11/28.
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private IUserDao userDao;

    @Override
    public User login(String account,String password) {
        User user=userDao.findUserByAccount(account);
        if(user!=null){
            return user;
        }else{
            return null;
        }
    }

    @Override
    public boolean register(User user) {
        user.setRole("Ordinaryuser");
        if(user.getBirthday()==null){
            Date now = new Date();
            user.setBirthday(now);
        }
        Calendar cal = Calendar.getInstance();
        int age=cal.get(Calendar.YEAR);
        cal.setTime(user.getBirthday());
        age=age-cal.get(Calendar.YEAR)+1;
        user.setAge(age);
        List<User> list=userDao.findAll();
        int num= Integer.parseInt(list.get(list.size()-1).getNumid().replaceAll("SA-",""))+1;
        user.setNumid("SA-"+num);
        int id=userDao.addUser(user);
        if(id>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
}
