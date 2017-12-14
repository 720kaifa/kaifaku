package simpleoa.model;

import java.util.Date;

/**
 * Created by Luwer on 2017/12/4.
 */
public class LoginLog {

    private int id;
    private String relname;
    private String account;
    private int userid;
    private String loginip;
    private String logintime;
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

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
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
        return "LoginLog{" +
                "id=" + id +
                ", relname='" + relname + '\'' +
                ", account='" + account + '\'' +
                ", userid=" + userid +
                ", loginip='" + loginip + '\'' +
                ", logintime=" + logintime +
                ", IS_DELETE='" + IS_DELETE + '\'' +
                ", CREATE_USER='" + CREATE_USER + '\'' +
                ", CREATE_TIME='" + CREATE_TIME + '\'' +
                ", UPDATE_USER='" + UPDATE_USER + '\'' +
                ", UPDATE_TIME='" + UPDATE_TIME + '\'' +
                '}';
    }

}
