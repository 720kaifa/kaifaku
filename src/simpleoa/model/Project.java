package simpleoa.model;

/**
 * Created by Luwer on 2017/12/7.
 */
public class Project {
    private int id;//项目id
    private String projectname;//项目名称
    private String projectdec;//项目描述
    private String starttime;//项目开始时间
    private String endtime;//项目结束时间
    private String estimated;//预计结束时间
    private int projectstatus;//项目状态 1为正在进行 2为结束
    private String IS_DELETE;//是否删除
    private String CREATE_USER;//创建人
    private String CREATE_TIME;//创建时间
    private String UPDATE_USER;//更新人
    private String UPDATE_TIME;//更新时间


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectdec() {
        return projectdec;
    }

    public void setProjectdec(String projectdec) {
        this.projectdec = projectdec;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getEstimated() {
        return estimated;
    }

    public void setEstimated(String estimated) {
        this.estimated = estimated;
    }

    public int getProjectstatus() {
        return projectstatus;
    }

    public void setProjectstatus(int projectstatus) {
        this.projectstatus = projectstatus;
    }

    public String getIS_DELETE() {
        return IS_DELETE;
    }

    public void setIS_DELETE(String IS_DELETE) {
        this.IS_DELETE = IS_DELETE;
    }

    public String getCREATE_USER() {
        return CREATE_USER;
    }

    public void setCREATE_USER(String CREATE_USER) {
        this.CREATE_USER = CREATE_USER;
    }

    public String getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(String CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getUPDATE_USER() {
        return UPDATE_USER;
    }

    public void setUPDATE_USER(String UPDATE_USER) {
        this.UPDATE_USER = UPDATE_USER;
    }

    public String getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(String UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }


    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectname='" + projectname + '\'' +
                ", projectdec='" + projectdec + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", estimated='" + estimated + '\'' +
                ", projectstatus=" + projectstatus +
                ", IS_DELETE='" + IS_DELETE + '\'' +
                ", CREATE_USER='" + CREATE_USER + '\'' +
                ", CREATE_TIME='" + CREATE_TIME + '\'' +
                ", UPDATE_USER='" + UPDATE_USER + '\'' +
                ", UPDATE_TIME='" + UPDATE_TIME + '\'' +
                '}';
    }


}
