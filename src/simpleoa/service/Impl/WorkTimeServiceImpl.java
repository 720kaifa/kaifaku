package simpleoa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleoa.dao.IWorkTimeDao;
import simpleoa.model.WorkLog;
import simpleoa.model.WorkTime;
import simpleoa.service.WorkTimeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luwer on 2017/12/12.
 */
@Service
public class WorkTimeServiceImpl implements WorkTimeService {

    @Autowired
    private IWorkTimeDao iWorkTimeDao;

    @Override
    public List<WorkTime> findAllByUserId(int userid, String role, int pageSize, int pageNum) {
        int startRow = (pageNum - 1) * pageSize;
        if(role.equals("SuperUser")||role.equals("AdminUser")){
            return iWorkTimeDao.findAllByUserId(0,startRow,pageSize);
        }else{
            return iWorkTimeDao.findAllByUserId(userid,startRow,pageSize);
        }
    }

    @Override
    public int getCount(int userid, String role) {
        System.out.println(role);
        System.out.println(role.equals("SuperUser")||role.equals("AdminUser"));
        if(role.equals("SuperUser")||role.equals("AdminUser")){
            return iWorkTimeDao.getCount(0);
        }else{
            return iWorkTimeDao.getCount(userid);
        }
    }
}
