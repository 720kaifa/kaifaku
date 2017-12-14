package simpleoa.model;

import java.util.Date;

/**
 * Created by Luwer on 2017/12/4.
 */
public class WorkLog {

    private int id;
    private String relname;
    private int userid;
    private int worktime;
    private String jcontent;
    private String cdescribe;
    private String summary;
    private String projectname;
    private int projectid;
    private String workdate;
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

    public String getRelname() {
        return relname;
    }

    public void setRelname(String relname) {
        this.relname = relname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getWorktime() {
        return worktime;
    }

    public void setWorktime(int worktime) {
        this.worktime = worktime;
    }

    public String getJcontent() {
        return jcontent;
    }

    public void setJcontent(String jcontent) {
        this.jcontent = jcontent;
    }

    public String getCdescribe() {
        return cdescribe;
    }

    public void setCdescribe(String cdescribe) {
        this.cdescribe = cdescribe;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getWorkdate() {
        return workdate;
    }

    public void setWorkdate(String workdate) {
        this.workdate = workdate;
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
        return "WorkLog{" +
                "id=" + id +
                ", relname='" + relname + '\'' +
                ", userid=" + userid +
                ", worktime=" + worktime +
                ", jcontent='" + jcontent + '\'' +
                ", cdescribe='" + cdescribe + '\'' +
                ", summary='" + summary + '\'' +
                ", projectname='" + projectname + '\'' +
                ", projectid='" + projectid + '\'' +
                ", workdate='" + workdate + '\'' +
                ", IS_DELETE='" + IS_DELETE + '\'' +
                ", CREATE_USER='" + CREATE_USER + '\'' +
                ", CREATE_TIME='" + CREATE_TIME + '\'' +
                ", UPDATE_USER='" + UPDATE_USER + '\'' +
                ", UPDATE_TIME='" + UPDATE_TIME + '\'' +
                '}';
    }

}
