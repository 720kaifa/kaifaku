package simpleoa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleoa.dao.IProjectDao;
import simpleoa.dao.IWorkDao;
import simpleoa.dao.IWorkTimeDao;
import simpleoa.model.User;
import simpleoa.model.WorkLog;
import simpleoa.model.WorkTime;
import simpleoa.service.WorkLogService;
import simpleoa.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Luwer on 2017/12/4.
 */
@Service
public class WorklLogServiceImpl implements WorkLogService {

    @Autowired
    private IWorkDao iWorkDao;

    @Autowired
    private IWorkTimeDao iWorkTimeDao;

    @Autowired
    private IProjectDao iProjectDao;

    @Override
    public List<WorkLog> findAllByUserId(int userid,int pageSize,int pageNum) {
        int startRow = (pageNum - 1) * pageSize;
        return iWorkDao.findAllByUserId(userid,startRow,pageSize);
    }

    @Override
    public int getCount(int userid) {
        return iWorkDao.getCount(userid);
    }


    @Override
    public int addWorklog(WorkLog workLog,User user) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        workLog.setCREATE_TIME(df.format(new Date()));
        workLog.setRelname(user.getRelname());
        workLog.setCREATE_USER(user.getAccount());
        workLog.setUserid(user.getId());

        int result=iWorkDao.addWorklog(workLog);
        if(result>0){
            WorkTime workTime=iWorkTimeDao.findWorkTimeByUserid(user.getId(),workLog.getProjectid());
            if(workTime==null){
                workTime=new WorkTime();
                workTime.setUserid(user.getId());
                workTime.setRelname(user.getRelname());
                workTime.setProjectid(workLog.getProjectid());
                workTime.setProjectname(workLog.getProjectname());
                workTime.setProjectstatus(iProjectDao.findAllById(workLog.getProjectid()).getProjectstatus());
                workTime.setTmworktime(workLog.getWorktime());
                workTime.setTwworktime(workLog.getWorktime());
                workTime.setCoworktime(workLog.getWorktime());
                workTime.setCREATE_USER("SYSTEM");
                workTime.setCREATE_TIME(df.format(new Date()));
                workTime.setUPDATE_TIME(df.format(new Date()));
                iWorkTimeDao.addWorkTime(workTime);
            }else{
                if(DateUtil.GetMonthDate(workTime.getUPDATE_TIME(),"yyyy-MM-dd HH:mm:ss")!=
                        DateUtil.GetMonthDate(workLog.getWorkdate(),"yyyy-MM-dd")){
                    workTime.setTmworktime(0);
                }

                if(DateUtil.GetWeekDate(workTime.getUPDATE_TIME(),"yyyy-MM-dd HH:mm:ss")!=
                        DateUtil.GetWeekDate(workLog.getWorkdate(),"yyyy-MM-dd")){
                    workTime.setTwworktime(0);
                }
                workTime.setTmworktime(workTime.getTmworktime()+workLog.getWorktime());
                workTime.setTwworktime(workTime.getTwworktime()+workLog.getWorktime());
                workTime.setCoworktime(workTime.getCoworktime()+workLog.getWorktime());
                workTime.setUPDATE_USER("SYSTEM");
                workTime.setCREATE_TIME(df.format(new Date()));
                iWorkTimeDao.updateWorkTime(workTime);
            }
        }
        return result;
    }

    @Override
    public WorkLog findWorklogById(int id) {
        return iWorkDao.findWorklogById(id);
    }

    @Override
    public int updateWorklog(WorkLog workLog, User user) {
        WorkLog workl=iWorkDao.findWorklogById(workLog.getId());
        workl.setJcontent(workLog.getJcontent());
        workl.setProjectid(workLog.getProjectid());
        workl.setProjectname(workLog.getProjectname());
        workl.setCdescribe(workLog.getCdescribe());
        workl.setWorktime(workLog.getWorktime());
        workl.setSummary(workLog.getSummary());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        workl.setUPDATE_TIME(df.format(new Date()));
        workl.setCREATE_USER(user.getAccount());
        return iWorkDao.updateWorklog(workl);
    }

    @Override
    public int delWorklog(int id) {
        return iWorkDao.delWorklog(id);
    }
}
