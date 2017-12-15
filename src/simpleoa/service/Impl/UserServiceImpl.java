package simpleoa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleoa.dao.IUserDao;
import simpleoa.model.User;
import simpleoa.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Created by Luwer on 2017/11/28.
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private IUserDao iUserDao;

    @Override
    public User login(String account,String password) {
        User user=iUserDao.findUserByAccount(account);
        if(user!=null){
            return user;
        }else{
            return null;
        }
    }

    @Override
    public boolean register(User user) {
        user.setRole("Ordinaryuser");
        Calendar cal = Calendar.getInstance();
        int age=cal.get(Calendar.YEAR);
        age=age-cal.get(Calendar.YEAR)+1;
        user.setAge(age);
        List<User> list=iUserDao.findAll();
        int num= Integer.parseInt(list.get(list.size()-1).getNumid().replaceAll("SA-",""))+1;
        user.setNumid("SA-"+num);
        int id=iUserDao.addUser(user);
        if(id>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int addUser(String account, String relname,String role,String create_user) {
       User user =new User();
       user.setAccount(account);
       user.setRelname(relname);
       user.setRole(role);
       user.setPassword("123456");
       user.setCREATE_USER(create_user);
       List<User> list=iUserDao.findAll();
       int num= Integer.parseInt(list.get(list.size()-1).getNumid().replaceAll("SA-",""))+1;
       if(num<10){
           user.setNumid("SA-00"+num);
       }
       if(num>=10&&num<100){
           user.setNumid("SA-0"+num);
       }
       if(num>=100&&num<1000){
           user.setNumid("SA-"+num);
       }
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
       user.setCREATE_TIME(df.format(new Date()));
       return iUserDao.addUser(user);
    }

    @Override
    public int updateUser(User user,User suser) {
        suser.setAddress(user.getAddress());
        suser.setBirthday(user.getBirthday());
        suser.setEmail(user.getEmail());
        suser.setGender(user.getGender());
        suser.setInterest(user.getInterest());
        suser.setMphone(user.getMphone());
        suser.setQq(user.getQq());
        suser.setWx(user.getWx());
        Calendar cal = Calendar.getInstance();
        int age=cal.get(Calendar.YEAR)-Integer.parseInt(user.getBirthday().substring(0,4));
        suser.setAge(age);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        suser.setUPDATE_TIME(df.format(new Date()));
        suser.setUPDATE_USER(suser.getAccount());
        return iUserDao.updateUser(suser);
    }

    @Override
    public User findUserById(int id) {
        return iUserDao.findUserById(id);
    }

    @Override
    public List<User> findAll() {
        return iUserDao.findAll();
    }
}
