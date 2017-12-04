/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.model;

import java.io.Serializable;

/**
 * 游戏用户信息表
 */
public class MaUserinfo implements Serializable {
		
	//date formats
	
	//columns START
	/**用户标识*/
	private Long userId;
	/**手机号*/
	private java.lang.String mobile;
	/**头像路径*/
	private java.lang.String image;
	/**昵称*/
	private java.lang.String nickName;
	//columns END

	public MaUserinfo(){
	}

	
	
	public Long getUserId() {
		return userId;
	}


	
	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setImage(java.lang.String value) {
		this.image = value;
	}
	
	public java.lang.String getImage() {
		return this.image;
	}
	public void setNickName(java.lang.String value) {
		this.nickName = value;
	}
	
	public java.lang.String getNickName() {
		return this.nickName;
	}

}

