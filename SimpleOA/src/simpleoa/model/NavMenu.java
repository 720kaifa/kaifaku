package simpleoa.model;

/**
 * Created by Luwer on 2017/12/7.
 */
public class NavMenu {
    private int id;
    private String url;
    private String icon;
    private String lid;
    private String title;
    private int authority;//权限1为超级管理员可见,2为管理员可见,3为普通用户可见
    private int sort;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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
        return "NavMenu{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", lid='" + lid + '\'' +
                ", title='" + title + '\'' +
                ", authority=" + authority +
                ", sort=" + sort +
                ", IS_DELETE='" + IS_DELETE + '\'' +
                ", CREATE_USER='" + CREATE_USER + '\'' +
                ", CREATE_TIME='" + CREATE_TIME + '\'' +
                ", UPDATE_USER='" + UPDATE_USER + '\'' +
                ", UPDATE_TIME='" + UPDATE_TIME + '\'' +
                '}';
    }
}
