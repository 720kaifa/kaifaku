/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.point.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 接入方信息表
 */
public class AccessoryInfo implements Serializable{
		
	
	//columns START
	/**id*/
	private Long id;
	/**接入方代码*/
	private java.lang.String accessCode;
	/**接入方名称*/
	private java.lang.String accesName;
	/**AES秘钥*/
	private java.lang.String aesKey;
	/**MD5秘钥*/
	private java.lang.String md5Key;
	/**creatTime*/
	private Date creatTime;
	/**updateTime*/
	private Date updateTime;
	/**0：可用  1：不可用*/
	private java.lang.String status;
	/**备注说明*/
	private java.lang.String remark;
	//columns END



	public Long getId() {
		return id;
	}


	public Date getCreatTime() {
		return creatTime;
	}


	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setAccessCode(java.lang.String value) {
		this.accessCode = value;
	}
	
	public java.lang.String getAccessCode() {
		return this.accessCode;
	}
	public void setAccesName(java.lang.String value) {
		this.accesName = value;
	}
	
	public java.lang.String getAccesName() {
		return this.accesName;
	}
	public void setAesKey(java.lang.String value) {
		this.aesKey = value;
	}
	
	public java.lang.String getAesKey() {
		return this.aesKey;
	}
	public void setMd5Key(java.lang.String value) {
		this.md5Key = value;
	}
	
	public java.lang.String getMd5Key() {
		return this.md5Key;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

}

