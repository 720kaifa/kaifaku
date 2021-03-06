package simpleoa.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import simpleoa.dao.IProjectDao;
import simpleoa.model.Project;
import simpleoa.model.User;
import simpleoa.service.ProjectService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Luwer on 2017/12/7.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private IProjectDao iProjectDao;

    public List<Project> findAllByStatus(int projectstatus) {
        return iProjectDao.findAllByStatus(projectstatus);
    }

    @Override
    public List<Project> findAll(int pageSize,int pageNum) {
        int startRow = (pageNum - 1) * pageSize;
        return iProjectDao.findAll(startRow,pageSize);
    }

    @Override
    public int getCount() {
        return iProjectDao.getCount();
    }

    @Override
    public int addProject(Project project, User user) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        project.setCREATE_TIME(df.format(new Date()));
        project.setProjectstatus(1);
        project.setCREATE_USER(user.getAccount());
        return iProjectDao.addProject(project);
    }

    @Override
    public int updateProject(Project project,User user){
        Project pro=iProjectDao.findProjectById(project.getId());
        pro.setProjectname(project.getProjectname());
        pro.setProjectdec(project.getProjectdec());
        pro.setStarttime(project.getStarttime());
        pro.setEstimated(project.getEstimated());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        pro.setUPDATE_TIME(df.format(new Date()));
        pro.setUPDATE_USER(user.getAccount());
        return iProjectDao.updateProject(pro);
    }

    @Override
    public int changeStatus(int id,User user,int status) {
        Project project=iProjectDao.findProjectById(id);
        project.setProjectstatus(status);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=df.format(new Date());
        project.setUPDATE_TIME(date);
        if(status==1){
            project.setEndtime("");
        }else{
            project.setEndtime(date.substring(0,10));
        }
        project.setUPDATE_USER(user.getAccount());
        return iProjectDao.updateProject(project);
    }

    @Override
    public int delProject(int id) {
        return iProjectDao.delProject(id);
    }

    @Override
    public Project findProjectById(int id){
        return iProjectDao.findProjectById(id);
    }

    @Override
    public List<Project> findLast(){
        return iProjectDao.findLast();
    }
}
