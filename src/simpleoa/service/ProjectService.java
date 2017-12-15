package simpleoa.service;

import simpleoa.model.Project;
import simpleoa.model.User;

import java.util.List;

/**
 * Created by Luwer on 2017/12/7.
 */
public interface ProjectService {
    public List<Project> findAllByStatus(int projectstatus);
    public List<Project> findAll(int pageSize,int pageNum);
    public int getCount();
    public int addProject(Project project,User user);
    public int updateProject(Project project,User user);
    public int changeStatus(int id,User user,int status);
    public int delProject(int id);
    public Project findProjectById(int id);
    public List<Project> findLast();

}
