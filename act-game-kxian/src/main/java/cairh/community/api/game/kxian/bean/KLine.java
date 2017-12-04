package cairh.community.api.game.kxian.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class KLine implements Serializable {
	private Integer commonAttrTag;
	private String commonTime;
	public String getCommonTime() {
		return commonTime;
	}
	public void setCommonTime(String commonTime) {
		this.commonTime = commonTime;
	}
	private Integer goodsPriceOpen;
	private Integer goodsPriceHigh;
	private Integer goodsPriceLow;
	private Integer goodsPriceLast;
	private Integer goodsVolumeTotal;
	private Integer goodsValueTotal;
	private Integer goodsVolumeKeep;
	private Integer priceChange;
	private String priceChangeRate;
	public Integer getCommonAttrTag() {
		return commonAttrTag;
	}
	public void setCommonAttrTag(Integer commonAttrTag) {
		this.commonAttrTag = commonAttrTag;
	}
	public Integer getGoodsPriceOpen() {
		return goodsPriceOpen;
	}
	public void setGoodsPriceOpen(Integer goodsPriceOpen) {
		this.goodsPriceOpen = goodsPriceOpen;
	}
	public Integer getGoodsPriceHigh() {
		return goodsPriceHigh;
	}
	public void setGoodsPriceHigh(Integer goodsPriceHigh) {
		this.goodsPriceHigh = goodsPriceHigh;
	}
	public Integer getPriceChange() {
		return priceChange;
	}
	public void setPriceChange(Integer priceChange) {
		this.priceChange = priceChange;
	}
	public String getPriceChangeRate() {
		return priceChangeRate;
	}
	public void setPriceChangeRate(String priceChangeRate) {
		this.priceChangeRate = priceChangeRate;
	}
	public Integer getGoodsPriceLow() {
		return goodsPriceLow;
	}
	public void setGoodsPriceLow(Integer goodsPriceLow) {
		this.goodsPriceLow = goodsPriceLow;
	}
	public Integer getGoodsPriceLast() {
		return goodsPriceLast;
	}
	public void setGoodsPriceLast(Integer goodsPriceLast) {
		this.goodsPriceLast = goodsPriceLast;
	}
	public Integer getGoodsVolumeTotal() {
		return goodsVolumeTotal;
	}
	public void setGoodsVolumeTotal(Integer goodsVolumeTotal) {
		this.goodsVolumeTotal = goodsVolumeTotal;
	}
	public Integer getGoodsValueTotal() {
		return goodsValueTotal;
	}
	public void setGoodsValueTotal(Integer goodsValueTotal) {
		this.goodsValueTotal = goodsValueTotal;
	}
	public Integer getGoodsVolumeKeep() {
		return goodsVolumeKeep;
	}
	public void setGoodsVolumeKeep(Integer goodsVolumeKeep) {
		this.goodsVolumeKeep = goodsVolumeKeep;
	}

}