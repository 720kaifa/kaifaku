package cairh.community.api.game.kxian.bean;

import java.io.Serializable;

public class KLineCount implements Serializable {
	private float mutiNum;
	private float addNum;
	public float getMutiNum() {
		return mutiNum;
	}
	public void setMutiNum(float mutiNum) {
		this.mutiNum = mutiNum;
	}
	public float getAddNum() {
		return addNum;
	}
	public void setAddNum(float addNum) {
		this.addNum = addNum;
	}
	public String getCommonTime() {
		return commonTime;
	}
	public void setCommonTime(String commonTime) {
		this.commonTime = commonTime;
	}
	private String commonTime;

}