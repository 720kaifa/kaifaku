/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.model;

import java.io.Serializable;

/**
 * 积分记录表
 */
public class MaUserPointLog implements Serializable {
		
	
	//columns START
	/**流水id*/
	private java.lang.Long id;
	/**用户id*/
	private java.lang.Long userId;
	/**手机号*/
	private java.lang.String mobile;
	/**积分变化值*/
	private java.lang.Long occurPoints;
	/**1消耗  2获取*/
	private java.lang.String type;
	/**游戏标示*/
	private java.lang.String gameId;
	/**备注*/
	private java.lang.String remark;
	/**积分配置信息ID*/
	private java.lang.String code;
	/**时间*/
	private java.sql.Timestamp createTime;
	//columns END

	public MaUserPointLog(){
	}

	public MaUserPointLog(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setOccurPoints(java.lang.Long value) {
		this.occurPoints = value;
	}
	
	public java.lang.Long getOccurPoints() {
		return this.occurPoints;
	}
	public void setType(java.lang.String value) {
		this.type = value;
	}
	
	public java.lang.String getType() {
		return this.type;
	}
	public void setGameId(java.lang.String value) {
		this.gameId = value;
	}
	
	public java.lang.String getGameId() {
		return this.gameId;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setCode(java.lang.String value) {
		this.code = value;
	}
	
	public java.lang.String getCode() {
		return this.code;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

	
}

