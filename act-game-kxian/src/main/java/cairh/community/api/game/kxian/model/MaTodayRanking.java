/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.model;

import java.io.Serializable;

/**
 * K线今日排行表
 */
public class MaTodayRanking implements Serializable {
		
	//date formats
	
	//columns START
	/**用户标识*/
	private Long userId;
	/**收益率*/
	private java.math.BigDecimal rate;
	public String getRatePer() {
		return ratePer;
	}

	public void setRatePer(String ratePer) {
		this.ratePer = ratePer;
	}

	/**收益率*/
	private String ratePer;
	/**时间精确到日*/
	private Integer datetime;
	/**rank*/
	private Integer rank;
	private String  nickName;
	
	//columns END
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public java.math.BigDecimal getRate() {
		return rate;
	}
	
	public void setRate(java.math.BigDecimal rate) {
		this.rate = rate;
	}
	
	public Integer getDatetime() {
		return datetime;
	}
	
	public void setDatetime(Integer datetime) {
		this.datetime = datetime;
	}
	
	public Integer getRank() {
		return rank;
	}
	
	public void setRank(Integer rank) {
		this.rank = rank;
	}


	

}

