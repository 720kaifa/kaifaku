package cairh.community.api.game.kxian.bean;

public class TrendDetail {
	private int    lineNo;		//点编号
	private String    marketTime;//HHMM
	private long   bizAmount;	//交易量
	private double lastPx;		//最新价
	private double avgPx;		//平均价
	public int getLineNo() {
		return lineNo;
	}
	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
	public String getMarketTime() {
		return marketTime;
	}
	public void setMarketTime(String marketTime) {
		this.marketTime = marketTime;
	}
	public long getBizAmount() {
		return bizAmount;
	}
	public void setBizAmount(long bizAmount) {
		this.bizAmount = bizAmount;
	}
	public double getLastPx() {
		return lastPx;
	}
	public void setLastPx(double lastPx) {
		this.lastPx = lastPx;
	}
	public double getAvgPx() {
		return avgPx;
	}
	public void setAvgPx(double avgPx) {
		this.avgPx = avgPx;
	}
}
