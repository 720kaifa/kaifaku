/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.point.model;

import java.io.Serializable;

/**
 * 社区用户积分星级匹配表
 */
public class UserLevel implements Serializable {
		
	//date formats
	
	//columns START
	/**id*/
	private java.lang.Long id;
	/**星级值*/
	private Integer starLevel;
	/**星级名称*/
	private java.lang.String levelName;
	/**积分期间-起始值*/
	private java.lang.Long pointBegin;
	/**积分期间-结束值 */
	private java.lang.Long pointEnd;
	/**备注*/
	private java.lang.String remark;
	//columns END

	public UserLevel(){
	}

	public UserLevel(
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
	
	public Integer getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(Integer starLevel) {
		this.starLevel = starLevel;
	}

	public void setLevelName(java.lang.String value) {
		this.levelName = value;
	}
	
	public java.lang.String getLevelName() {
		return this.levelName;
	}
	public void setPointBegin(java.lang.Long value) {
		this.pointBegin = value;
	}
	
	public java.lang.Long getPointBegin() {
		return this.pointBegin;
	}
	public void setPointEnd(java.lang.Long value) {
		this.pointEnd = value;
	}
	
	public java.lang.Long getPointEnd() {
		return this.pointEnd;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

}

