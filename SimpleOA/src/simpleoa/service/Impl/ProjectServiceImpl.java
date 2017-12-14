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
    private IProjectDao projectDao;

    public List<Project> findAllByStatus(int projectstatus) {
        return projectDao.findAllByStatus(projectstatus);
    }

    @Override
    public List<Project> findAll(int pageSize,int pageNum) {
        int startRow = (pageNum - 1) * pageSize;
        return projectDao.findAll(startRow,pageSize);
    }

    @Override
    public int getCount() {
        return projectDao.getCount();
    }

    @Override
    public int addProject(Project project, User user) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        project.setCREATE_TIME(df.format(new Date()));
        project.setProjectstatus(1);
        project.setCREATE_USER(user.getAccount());
        return projectDao.addProject(project);
    }

    @Override
    public int stopProject(int id,User user) {
        Project project=projectDao.findAllById(id);
        project.setProjectstatus(2);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=df.format(new Date());
        project.setUPDATE_TIME(date);
        project.setEndtime(date.substring(0,10));
        project.setUPDATE_USER(user.getAccount());
        return projectDao.updateProject(project);
    }

    @Override
    public int delProject(int id) {
        return projectDao.delProject(id);
    }
}
