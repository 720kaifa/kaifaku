/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.model;

import java.io.Serializable;


/**
 * 股票池
 */
public class StockPool implements Serializable {
		
	//date formats
	
	//columns START
	/**股票代码*/
	private java.lang.String stockCode;
	/**名称*/
	private java.lang.String stockName;
	/**市场标识*/
	private Long marketCode;
	/**是否有效*/
	private Long status;
	//columns END

	public StockPool(){
	}


	public java.lang.String getStockCode() {
		return stockCode;
	}


	public void setStockCode(java.lang.String stockCode) {
		this.stockCode = stockCode;
	}


	public java.lang.String getStockName() {
		return stockName;
	}

	public void setStockName(java.lang.String stockName) {
		this.stockName = stockName;
	}

	public Long getMarketCode() {
		return marketCode;
	}

	public void setMarketCode(Long marketCode) {
		this.marketCode = marketCode;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	
}

