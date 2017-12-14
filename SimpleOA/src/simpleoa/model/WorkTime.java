package simpleoa.model;

/**
 * Created by Luwer on 2017/12/11.
 */
public class WorkTime {
    private int id;
    private int userid;
    private String relname;
    private int projectid;
    private String projectname;
    private int projectstatus;
    private int tmworktime;//本月工时
    private int twworktime;//本周工时
    private int coworktime;//工时总计
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public int getProjectstatus() {
        return projectstatus;
    }

    public void setProjectstatus(int projectstatus) {
        this.projectstatus = projectstatus;
    }

    public int getTmworktime() {
        return tmworktime;
    }

    public void setTmworktime(int tmworktime) {
        this.tmworktime = tmworktime;
    }

    public int getTwworktime() {
        return twworktime;
    }

    public void setTwworktime(int twworktime) {
        this.twworktime = twworktime;
    }

    public int getCoworktime() {
        return coworktime;
    }

    public void setCoworktime(int coworktime) {
        this.coworktime = coworktime;
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
        return "WorkTime{" +
                "id=" + id +
                ", userid=" + userid +
                ", relname='" + relname + '\'' +
                ", projectid=" + projectid +
                ", projectname='" + projectname + '\'' +
                ", projectstatus=" + projectstatus +
                ", tmworktime=" + tmworktime +
                ", twworktime=" + twworktime +
                ", coworktime=" + coworktime +
                ", IS_DELETE='" + IS_DELETE + '\'' +
                ", CREATE_USER='" + CREATE_USER + '\'' +
                ", CREATE_TIME='" + CREATE_TIME + '\'' +
                ", UPDATE_USER='" + UPDATE_USER + '\'' +
                ", UPDATE_TIME='" + UPDATE_TIME + '\'' +
                '}';
    }
}
