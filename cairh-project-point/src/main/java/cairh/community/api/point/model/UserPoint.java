package cairh.community.api.point.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserPoint implements Serializable {
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
    private Long totalPoints;

    /**
     *  null
     */
    private Long availablePoints;

    /**
     *  null
     */
    private Long frozenPoints;

    /**
     *  null
     */
    private Long usedPoints;

    /**
     *  null
     */
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private String createTimeStr;

    /**
     *  null
     */
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    private String updateTimeStr;
   

    /**
     *  null
     */
    private Integer status;
    
    /**
	 * null
	 */
	private String statusStr;
	
	/**
     *  null
     */
    private Date lastCheckinDate;

    /**
     *  null
     */
    private Integer continuousCheckinTimes;


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

    public Long getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Long totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Long getAvailablePoints() {
        return availablePoints;
    }

    public void setAvailablePoints(Long availablePoints) {
        this.availablePoints = availablePoints;
    }

    public Long getFrozenPoints() {
        return frozenPoints;
    }

    public void setFrozenPoints(Long frozenPoints) {
        this.frozenPoints = frozenPoints;
    }

    public Long getUsedPoints() {
        return usedPoints;
    }

    public void setUsedPoints(Long usedPoints) {
        this.usedPoints = usedPoints;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getStatusStr() {
		if (status == 0) {
			return "有效";
		} else if(status == -1){
			return "无效";
		}else {
			return "";
		}
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	
	public Date getLastCheckinDate() {
        return lastCheckinDate;
    }

    public void setLastCheckinDate(Date lastCheckinDate) {
        this.lastCheckinDate = lastCheckinDate;
    }

    public Integer getContinuousCheckinTimes() {
        return continuousCheckinTimes;
    }

    public void setContinuousCheckinTimes(Integer continuousCheckinTimes) {
        this.continuousCheckinTimes = continuousCheckinTimes;
    }
    
    public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

}
