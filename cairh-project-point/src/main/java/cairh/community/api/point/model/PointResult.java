package cairh.community.api.point.model;

/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wangyx<br>
 * 开发时间: 2016年8月9日<br>
 */
public class PointResult extends BaseResult {
	
	private long totalPoints;
	private long availablePoints;
	private long frozenPoints;
	private long usedPoints;
	private Integer starLevel;

	public long getTotalPoints() {
		return totalPoints;
	}
	
	public void setTotalPoints(long totalPoints) {
		this.totalPoints = totalPoints;
	}
	
	public long getAvailablePoints() {
		return availablePoints;
	}

	public void setAvailablePoints(long availablePoints) {
		this.availablePoints = availablePoints;
	}
	
	public long getFrozenPoints() {
		return frozenPoints;
	}

	public Integer getStarLevel() {
		return starLevel;
	}

	public void setStarLevel(Integer starLevel) {
		this.starLevel = starLevel;
	}

	public void setFrozenPoints(long frozenPoints) {
		this.frozenPoints = frozenPoints;
	}
	
	public long getUsedPoints() {
		return usedPoints;
	}
	
	public void setUsedPoints(long usedPoints) {
		this.usedPoints = usedPoints;
	}
	
	
}
