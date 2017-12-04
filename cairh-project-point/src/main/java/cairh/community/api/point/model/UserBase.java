package cairh.community.api.point.model;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang3.StringUtils;

import cairh.community.api.point.base.BaseEntity;

/**
 * 用户基本情报表
 */
public class UserBase extends BaseEntity {
		
	//date formats
	public static final String FORMAT_REG_TIME = DATE_TIME_FORMAT;
	public static final String FORMAT_UPD_TIME = DATE_TIME_FORMAT;
	public static final String FORMAT_FORBID_TIME = DATE_TIME_FORMAT;
	
	//columns START
	/**用户ID*/
	private java.lang.Long userId;
	/**账户ID*/
	private java.lang.Long accountId;
	/**用户名（系统默认）*/
	private java.lang.String userName;
	/**手机号码*/
	private java.lang.String mobile;
	/**昵称*/
	private java.lang.String nickName;
	/**头像路径*/
	private java.lang.String image;
	/**个性签名*/
	private java.lang.String sign;
	/**用户等级*/
	private java.lang.String rank;
	/**状态*/
	private java.lang.String status;
	/**注册时间*/
	private java.util.Date regTime;
	/**更新时间*/
	private java.util.Date updTime;
	/**禁言天数*/
	private String forbidDays;
	/**禁言时间*/
	private Date forbidTime;
	/**是否激活*/
	private String isAvtive;
	/**是否结转*/
	private String isCarryOver;
	/**是否绑定*/
	private String isBinding;
	/**绑定时间*/
	private java.util.Date bindingTime;
	/**解绑时间*/
	private java.util.Date unbindTime;
	//columns END

	public java.util.Date getBindingTime() {
		return bindingTime;
	}

	public void setBindingTime(java.util.Date bindingTime) {
		this.bindingTime = bindingTime;
	}

	public UserBase(){
	}

	public UserBase(
		java.lang.Long userId
	){
		this.userId = userId;
	}

	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setAccountId(java.lang.Long value) {
		this.accountId = value;
	}
	
	public java.lang.Long getAccountId() {
		return this.accountId;
	}
	public void setUserName(java.lang.String value) {
		this.userName = value;
	}
	
	public java.lang.String getUserName() {
		return this.userName;
	}
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setNickName(java.lang.String value) {
		this.nickName = value;
	}
	
	public java.lang.String getNickName() {
		if (StringUtils.isEmpty(this.nickName)) {
			return this.userName;
		}
		return this.nickName;
	}
	public void setImage(java.lang.String value) {
		this.image = value;
	}
	
	public java.lang.String getImage() {
		return this.image;
	}
	public void setSign(java.lang.String value) {
		this.sign = value;
	}
	
	public java.lang.String getSign() {
		return this.sign;
	}
	public void setRank(java.lang.String value) {
		this.rank = value;
	}
	
	public java.lang.String getRank() {
		return this.rank;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public String getRegTimeString() {
		return date2String(getRegTime(), FORMAT_REG_TIME);
	}
	public void setRegTimeString(String value) {
		setRegTime(string2Date(value, FORMAT_REG_TIME,java.util.Date.class));
	}
	public void setRegTime(java.util.Date value) {
		this.regTime = value;
	}
	
	public java.util.Date getRegTime() {
		return this.regTime;
	}
	public String getUpdTimeString() {
		return date2String(getUpdTime(), FORMAT_UPD_TIME);
	}
	public void setUpdTimeString(String value) {
		setUpdTime(string2Date(value, FORMAT_UPD_TIME,java.util.Date.class));
	}
	public void setUpdTime(java.util.Date value) {
		this.updTime = value;
	}
	
	public java.util.Date getUpdTime() {
		return this.updTime;
	}
	
	

	public String getForbidDays() {
		return forbidDays;
	}

	public void setForbidDays(String forbidDays) {
		this.forbidDays = forbidDays;
	}
	
	

	public String getIsAvtive() {
		return isAvtive;
	}

	public void setIsAvtive(String isAvtive) {
		this.isAvtive = isAvtive;
	}

	public String getIsCarryOver() {
		return isCarryOver;
	}

	public void setIsCarryOver(String isCarryOver) {
		this.isCarryOver = isCarryOver;
	}

	public String getIsBinding() {
		return isBinding;
	}

	public void setIsBinding(String isBinding) {
		this.isBinding = isBinding;
	}

	public Date getForbidTime() {
		return forbidTime;
	}

	public void setForbidTime(Date forbidTime) {
		this.forbidTime = forbidTime;
	}
	
	public java.util.Date getUnbindTime() {
		return unbindTime;
	}

	public void setUnbindTime(java.util.Date unbindTime) {
		this.unbindTime = unbindTime;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("UserId",getUserId())
			.append("AccountId",getAccountId())
			.append("UserName",getUserName())
			.append("Mobile",getMobile())
			.append("NickName",getNickName())
			.append("Image",getImage())
			.append("Sign",getSign())
			.append("Rank",getRank())
			.append("Status",getStatus())
			.append("RegTime",getRegTime())
			.append("UpdTime",getUpdTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserId())
			.append(getAccountId())
			.append(getUserName())
			.append(getMobile())
			.append(getNickName())
			.append(getImage())
			.append(getSign())
			.append(getRank())
			.append(getStatus())
			.append(getRegTime())
			.append(getUpdTime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof UserBase == false) return false;
		if(this == obj) return true;
		UserBase other = (UserBase)obj;
		return new EqualsBuilder()
			.append(getUserId(),other.getUserId())
			.append(getAccountId(),other.getAccountId())
			.append(getUserName(),other.getUserName())
			.append(getMobile(),other.getMobile())
			.append(getNickName(),other.getNickName())
			.append(getImage(),other.getImage())
			.append(getSign(),other.getSign())
			.append(getRank(),other.getRank())
			.append(getStatus(),other.getStatus())
			.append(getRegTime(),other.getRegTime())
			.append(getUpdTime(),other.getUpdTime())
			.isEquals();
	}

	@Override
	public String getKey() {
		return this.userId.toString();
	}
	@Override
	protected void initMethod(){
	}
}

