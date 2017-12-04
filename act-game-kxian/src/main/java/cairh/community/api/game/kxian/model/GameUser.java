/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.model;

import java.io.Serializable;
import java.util.Date;

/**
 * GameUser
 */
public class GameUser implements Serializable {
		
	
	//columns START
	/**id*/
	private java.lang.Long id;
	/**gameCode*/
	private java.lang.Long gameId;
	/**accountId*/
	private java.lang.Long accountId;
	/**玩游戏的次数*/
	private java.lang.Long count;
	/**今日玩游戏的次数*/
	private java.lang.Long todayCount;
	
	public java.lang.Long getTodayCount() {
		return todayCount;
	}
	public void setTodayCount(java.lang.Long todayCount) {
		this.todayCount = todayCount;
	}
	/**最后一次游戏时间*/
	private Date lastPlayTime;
	public java.lang.Long getId() {
		return id;
	}
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	public java.lang.Long getGameId() {
		return gameId;
	}
	public void setGameId(java.lang.Long gameId) {
		this.gameId = gameId;
	}
	public java.lang.Long getAccountId() {
		return accountId;
	}
	public void setAccountId(java.lang.Long accountId) {
		this.accountId = accountId;
	}
	public java.lang.Long getCount() {
		return count;
	}
	public void setCount(java.lang.Long count) {
		this.count = count;
	}
	public Date getLastPlayTime() {
		return lastPlayTime;
	}
	public void setLastPlayTime(Date lastPlayTime) {
		this.lastPlayTime = lastPlayTime;
	}


}

