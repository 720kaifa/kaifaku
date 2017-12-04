package cairh.community.api.game.kxian.model;

import java.util.List;

import cairh.community.api.game.kxian.util.Page;

/**
 * Created by luyj on 2016/9/22.
 */
public class RevenueLogResult extends BaseResult{
	private String totalRevenueRate;//总收益率

	/**名次*/
	private Integer ranking;
	
	private String error_no;

	private String error_info;
	
	private Page page;
	
	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public String getError_no() {
		return error_no;
	}

	
	public void setError_no(String error_no) {
		this.error_no = error_no;
	}

	
	public String getError_info() {
		return error_info;
	}

	
	public void setError_info(String error_info) {
		this.error_info = error_info;
	}

	public String getTotalRevenueRate() {
		return totalRevenueRate;
	}

	public void setTotalRevenueRate(String totalRevenueRate) {
		this.totalRevenueRate = totalRevenueRate;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	private List<RevenueLog> data;
    public List<RevenueLog> getData() {
		return data;
	}

	public void setData(List<RevenueLog> data) {
		this.data = data;
	}

	private int count;
	
	
	private RevenueLog revenueLog;
	
	private String proportion;
	
	public String getProportion() {
		return proportion;
	}

	public void setProportion(String proportion) {
		this.proportion = proportion;
	}

	public RevenueLog getRevenueLog() {
		return revenueLog;
	}

	public void setRevenueLog(RevenueLog revenueLog) {
		this.revenueLog = revenueLog;
	}



	private String revenueRatePer;
	private String navRatioPer;
	private String revenueRateNow;//持仓收益率

	
	public String getRevenueRateNow() {
		return revenueRateNow;
	}


	
	public void setRevenueRateNow(String revenueRateNow) {
		this.revenueRateNow = revenueRateNow;
	}


	public String getRevenueRatePer() {
		return revenueRatePer;
	}

	public void setRevenueRatePer(String revenueRatePer) {
		this.revenueRatePer = revenueRatePer;
	}

	public String getNavRatioPer() {
		return navRatioPer;
	}

	public void setNavRatioPer(String navRatioPer) {
		this.navRatioPer = navRatioPer;
	}

	public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
