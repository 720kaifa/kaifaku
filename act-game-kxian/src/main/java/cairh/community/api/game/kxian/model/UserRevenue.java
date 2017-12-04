/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.model;

import java.io.Serializable;

/**
 * UserRevenue
 */
public class UserRevenue implements Serializable {
		
	//date formats
	
	//columns START
	/**用户id*/
	private Long userId;
	/**昵称*/
	private java.lang.String nikeName;
	/**总收益率*/
	private java.math.BigDecimal totalRevenueRate;
	/**总收益率*/
	private String totalRevenueRatePer;
	public String getTotalRevenueRatePer() {
		return totalRevenueRatePer;
	}

	public void setTotalRevenueRatePer(String totalRevenueRatePer) {
		this.totalRevenueRatePer = totalRevenueRatePer;
	}

	/**名次*/
	private Integer ranking;
	//columns END

	public UserRevenue(){
	}


	
	public Long getUserId() {
		return userId;
	}

	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public java.lang.String getNikeName() {
		return nikeName;
	}

	public void setNikeName(java.lang.String nikeName) {
		this.nikeName = nikeName;
	}

	public java.math.BigDecimal getTotalRevenueRate() {
		return totalRevenueRate;
	}

	public void setTotalRevenueRate(java.math.BigDecimal totalRevenueRate) {
		this.totalRevenueRate = totalRevenueRate;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}


	
}

