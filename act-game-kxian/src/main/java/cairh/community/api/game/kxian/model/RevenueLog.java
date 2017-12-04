/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.model;

import java.io.Serializable;
import java.util.Date;

/**
 * RevenueLog
 */
public class RevenueLog implements Serializable {
		
	
	//columns START
	/**序列*/
	private Long id;
	/**用户id*/
	private Long userId;
	/**股票代码*/
	private String stockCode;
	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	/**名称*/
	private java.lang.String stockName;
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**游戏起始时间*/
	private Date startTime;
	/**游戏结束时间*/
	private Date endTime;
	/**收益率*/
	private java.math.BigDecimal revenueRate;
	private String revenueRatePer;
	public String getRevenueRatePer() {
		return revenueRatePer;
	}

	public void setRevenueRatePer(String revenueRatePer) {
		this.revenueRatePer = revenueRatePer;
	}

	/**涨跌率*/
	private java.math.BigDecimal navRatio;
	private String navRatioPer;
	
	public String getNavRatioPer() {
		return navRatioPer;
	}

	public void setNavRatioPer(String navRatioPer) {
		this.navRatioPer = navRatioPer;
	}

	private Date createTime;
	//columns END


	public RevenueLog(){
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setStockName(java.lang.String value) {
		this.stockName = value;
	}
	
	public java.lang.String getStockName() {
		return this.stockName;
	}
	public void setStartTime(java.sql.Timestamp value) {
		this.startTime = value;
	}
	
	public void setRevenueRate(java.math.BigDecimal value) {
		this.revenueRate = value;
	}
	
	public java.math.BigDecimal getRevenueRate() {
		return this.revenueRate;
	}
	public void setNavRatio(java.math.BigDecimal value) {
		this.navRatio = value;
	}
	
	public java.math.BigDecimal getNavRatio() {
		return this.navRatio;
	}

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



}

