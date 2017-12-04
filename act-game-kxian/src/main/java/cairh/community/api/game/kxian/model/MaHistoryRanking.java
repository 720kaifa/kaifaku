/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.model;

import java.io.Serializable;

/**
 * K线历史排行表
 */
public class MaHistoryRanking implements Serializable {
		
	//date formats
	
	//columns START
	/**用户标识*/
	private Long userId;
	/**收益率*/
	private java.math.BigDecimal rate;
	/**收益率*/
	private String ratePer;
	public String getRatePer() {
		return ratePer;
	}


	public void setRatePer(String ratePer) {
		this.ratePer = ratePer;
	}


	/**时间精确到日*/
	private Integer datetime;
	/**名次*/
	private Integer rank;
	private String nickName;
	
	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	//columns END
	private Integer prizePoint;
	
	
	
	public Integer getPrizePoint() {
		return prizePoint;
	}

	
	public void setPrizePoint(Integer prizePoint) {
		this.prizePoint = prizePoint;
	}

	public MaHistoryRanking(){
	}

	public void setRate(java.math.BigDecimal value) {
		this.rate = value;
	}
	
	public java.math.BigDecimal getRate() {
		return this.rate;
	}

	
	public Long getUserId() {
		return userId;
	}

	
	public void setUserId(Long userId) {
		this.userId = userId;
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

