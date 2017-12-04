/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.point.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户绑定信息表
 */
public class UserBindingInfo implements Serializable  {
		
	
	//columns START
	/**绑定编号*/
	private java.lang.Long bindNo;
	/**绑定日期*/
	private Date bindDate;
	/**用户编号*/
	private java.lang.Long userId;
	public Date getBindDate() {
		return bindDate;
	}

	public void setBindDate(Date bindDate) {
		this.bindDate = bindDate;
	}

	/**输入内容*/
	private java.lang.String accountContent;
	/**账户类型*/
	private java.lang.String accountType;
	/**备注*/
	private java.lang.String remark;

	public UserBindingInfo(){
	}

	public UserBindingInfo(
		java.lang.Long bindNo
	){
		this.bindNo = bindNo;
	}

	public void setBindNo(java.lang.Long value) {
		this.bindNo = value;
	}
	
	public java.lang.Long getBindNo() {
		return this.bindNo;
	}
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setAccountContent(java.lang.String value) {
		this.accountContent = value;
	}
	
	public java.lang.String getAccountContent() {
		return this.accountContent;
	}
	public void setAccountType(java.lang.String value) {
		this.accountType = value;
	}
	
	public java.lang.String getAccountType() {
		return this.accountType;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

}

