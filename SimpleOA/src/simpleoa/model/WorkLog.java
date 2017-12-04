package simpleoa.model;

import java.util.Date;

/**
 * Created by Luwer on 2017/12/4.
 */
public class WorkLog {
    private int id;
    private String relname;
    private String account;
    private int userid;
    private Date createtime;
    private int worktime;
    private String jcontent;
    private String cdescribe;
    private String summary;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    @Override
    public String toString() {
        return "WorkLog{" +
                "id=" + id +
                ", relname='" + relname + '\'' +
                ", account='" + account + '\'' +
                ", userid=" + userid +
                ", createtime=" + createtime +
                ", worktime=" + worktime +
                ", jcontent='" + jcontent + '\'' +
                ", cdescribe='" + cdescribe + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
