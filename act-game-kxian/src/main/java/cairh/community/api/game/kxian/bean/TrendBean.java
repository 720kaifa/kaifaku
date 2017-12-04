package cairh.community.api.game.kxian.bean;

import java.util.ArrayList;
import java.util.List;

public class TrendBean {
	
	private String marketCode;		//市场	1-sh   2-sz
	private String stockCode;		// 代码   000001
	private String stockName;		//上证指数
	private int issueDate;			//日期
	private double preClosePrice;	//昨收盘价
	private double openPrice;		//开盘价
	
	private List<TrendDetail>  lines =  new  ArrayList<TrendDetail>();

	
	public double getPreClosePrice() {
		return preClosePrice;
	}

	public void setPreClosePrice(double preClosePrice) {
		this.preClosePrice = preClosePrice;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public String getMarketCode() {
		return marketCode;
	}

	public void setMarketCode(String marketCode) {
		this.marketCode = marketCode;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	

	public int getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(int issueDate) {
		this.issueDate = issueDate;
	}

	public List<TrendDetail> getLines() {
		return lines;
	}

	public void setLines(List<TrendDetail> lines) {
		this.lines = lines;
	}

	
	
}
