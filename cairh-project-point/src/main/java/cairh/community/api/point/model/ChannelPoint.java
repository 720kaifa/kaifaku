package cairh.community.api.point.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 渠道表
 */
public class ChannelPoint implements Serializable{
		
	//date formats
	
	//columns START
	/**渠道id*/
	private java.lang.Long id;
	/**渠道名称*/
	private java.lang.String name;
	/**渠道等级,1一级渠道,2二级渠道,3三级渠道,4四级渠道*/
	private java.lang.String channelRank;
	/**上级渠道id*/
	private java.lang.Long parentId;
	/**是否为叶子节点.1是叶子节点,0不是叶子节点*/
	private java.lang.String isLeafNode;
	/**积分数量*/
	private java.lang.Long points;
	/**备注*/
	private java.lang.String remark;
	/**状态,1有效, 2无效*/
	private java.lang.String status;
	/**是否可以修改 0可修改 -1不可修改*/
	private java.lang.String isModify;
	/**渠道编号*/
	private java.lang.String channelCode;
	/**是否展示,1展示,2不展示*/
	private java.lang.String isShow;
	//columns END

	public ChannelPoint(){
	}

	public ChannelPoint(
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
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	
	public java.lang.String getIsShow() {
		return isShow;
	}

	public void setIsShow(java.lang.String isShow) {
		this.isShow = isShow;
	}

	public void setChannelRank(java.lang.String value) {
		this.channelRank = value;
	}
	
	public java.lang.String getChannelRank() {
		return this.channelRank;
	}
	public void setParentId(java.lang.Long value) {
		this.parentId = value;
	}
	
	public java.lang.Long getParentId() {
		return this.parentId;
	}
	public void setIsLeafNode(java.lang.String value) {
		this.isLeafNode = value;
	}
	
	public java.lang.String getIsLeafNode() {
		return this.isLeafNode;
	}
	public void setPoints(java.lang.Long value) {
		this.points = value;
	}
	
	public java.lang.Long getPoints() {
		return this.points;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.lang.String getIsModify() {
		return isModify;
	}

	public void setIsModify(java.lang.String isModify) {
		this.isModify = isModify;
	}

	public java.lang.String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(java.lang.String channelCode) {
		this.channelCode = channelCode;
	}


}

