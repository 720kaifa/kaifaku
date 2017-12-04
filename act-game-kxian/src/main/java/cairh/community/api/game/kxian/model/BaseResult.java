package cairh.community.api.game.kxian.model;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cairh.community.api.game.kxian.common.ErrorCode;

/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wanghh<br>
 * 开发时间: 2016年07月15日<br>
 */
public class BaseResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private String error_no;

	private String error_info;
	
	private Integer errorTimes;
	private Integer sendTimes;
	private String mobile;
	private String funAccountId;

	public static BaseResult SUCCESS = new BaseResult(ErrorCode.OK, "");

	public BaseResult() {

	}

	public String getFunAccountId() {
		return funAccountId;
	}

	public void setFunAccountId(String funAccountId) {
		this.funAccountId = funAccountId;
	}

	private BaseResult(String error_no, String error_info) {
		super();
		this.error_no = error_no;
		this.error_info = error_info;
	}

	public String getError_no() {
		return error_no;
	}

	public void setError_no(String error_no) {
		this.error_no = error_no;
	}

	public String getError_info() {
		return error_info;
	}

	public void setError_info(String error_info) {
		this.error_info = error_info;
	}

	public static BaseResult error(String error_info) {
		return new BaseResult(ErrorCode.ERROR_NO_NEGATIVE_1, error_info);
	}

	public static BaseResult error(String errorCode, String error_info) {
		return new BaseResult(errorCode, error_info);
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public Integer getErrorTimes() {
		return errorTimes;
	}

	public void setErrorTimes(Integer errorTimes) {
		this.errorTimes = errorTimes;
	}

	public Integer getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(Integer sendTimes) {
		this.sendTimes = sendTimes;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
