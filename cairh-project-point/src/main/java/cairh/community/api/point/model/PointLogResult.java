package cairh.community.api.point.model;


import java.util.Date;
import java.util.List;

import cairh.community.api.point.util.Page;


/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wangyx<br>
 * 开发时间: 2016年8月9日<br>
 */
public class PointLogResult extends BaseResult {
	
	private List<PointLog> data;

	private Page page;

	private long availablePoints;
	
	private String ifAccount;
	
	private String funAccountId;
	
	public long getAvailablePoints() {
		return availablePoints;
	}

	public void setAvailablePoints(long availablePoints) {
		this.availablePoints = availablePoints;
	}

	public List<PointLog> getData() {
		return data;
	}

	public void setData(List<PointLog> data) {
		this.data = data;
	}

	public String getIfAccount() {
		return ifAccount;
	}

	public void setIfAccount(String ifAccount) {
		this.ifAccount = ifAccount;
	}

	public String getFunAccountId() {
		return funAccountId;
	}

	public void setFunAccountId(String funAccountId) {
		this.funAccountId = funAccountId;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public static class PointLog {
		private long occurPoints;
		private long afterPoints;
		private String pointDefineCode;
		private String remark;
		private String createTime;
		
		public long getOccurPoints() {
			return occurPoints;
		}
		
		public void setOccurPoints(long occurPoints) {
			this.occurPoints = occurPoints;
		}

		public long getAfterPoints() {
			return afterPoints;
		}

		public void setAfterPoints(long afterPoints) {
			this.afterPoints = afterPoints;
		}
		
		public String getPointDefineCode() {
			return pointDefineCode;
		}

		public void setPointDefineCode(String pointDefineCode) {
			this.pointDefineCode = pointDefineCode;
		}

		public String getRemark() {
			return remark;
		}
		
		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

	}
	
}
