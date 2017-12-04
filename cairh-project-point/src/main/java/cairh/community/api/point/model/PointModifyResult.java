package cairh.community.api.point.model;

/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wangyx<br>
 * 开发时间: 2016年8月9日<br>
 */
public class PointModifyResult extends BaseResult {
	
	private long occurPoints;
	private long totalPoints;
	private int isFrist;
	
	
	public int getIsFrist() {
		return isFrist;
	}

	public void setIsFrist(int isFrist) {
		this.isFrist = isFrist;
	}

	public long getOccurPoints() {
		return occurPoints;
	}
	
	public void setOccurPoints(long occurPoints) {
		this.occurPoints = occurPoints;
	}

	public long getTotalPoints() {
		return totalPoints;
	}
	
	public void setTotalPoints(long totalPoints) {
		this.totalPoints = totalPoints;
	}
	
}
