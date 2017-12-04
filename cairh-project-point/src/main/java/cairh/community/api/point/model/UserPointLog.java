package cairh.community.api.point.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cairh.community.api.point.util.DateUtil;

public class UserPointLog implements Serializable {
    /**
     *  null
     */
    private Long id;

    /**
     *  null
     */
    private Long userId;

    /**
     *  null
     */
    private Long occurPoints;

    /**
     *  null
     */
    private Long afterPoints;

    /**
     *  null
     */
    private String pointDefineCode;

    /**
     *  null
     */
    private String remark;

    /**
     *  null
     */
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String createTimeStr;
    
    /**1:商品消耗 2：非商品消耗 3获取积分 4其他*/
	private java.lang.String changeType;
	
    public String getCreateTimeStr() {
    	return  DateUtil.format(createTime, DateUtil.DATE_FORMAT);
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOccurPoints() {
        return occurPoints;
    }

    public void setOccurPoints(Long occurPoints) {
        this.occurPoints = occurPoints;
    }

    public Long getAfterPoints() {
        return afterPoints;
    }

    public void setAfterPoints(Long afterPoints) {
        this.afterPoints = afterPoints;
    }

    public String getPointDefineCode() {
        return pointDefineCode;
    }

    public void setPointDefineCode(String pointDefineCode) {
        this.pointDefineCode = pointDefineCode == null ? null : pointDefineCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public java.lang.String getChangeType() {
		return changeType;
	}

	public void setChangeType(java.lang.String changeType) {
		this.changeType = changeType;
	}
    
}