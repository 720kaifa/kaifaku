package simpleoa.dao;

import simpleoa.model.Project;

import java.util.List;

/**
 * Created by Luwer on 2017/12/7.
 */
public interface IProjectDao {
    public List<Project> findAllByStatus(int projectstatus);
    public List<Project> findAll(int startRow,int pageSize);
    public int getCount();
    public int addProject(Project project);
    public Project findProjectById(int id);
    public int updateProject(Project project);
    public int delProject(int id);
}
