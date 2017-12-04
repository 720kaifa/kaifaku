package cairh.community.api.game.kxian.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cairh.community.api.game.kxian.bean.KLine;
import cairh.community.api.game.kxian.bean.KLineResult;
import cairh.community.api.game.kxian.bean.SisapResult;
import cairh.community.api.game.kxian.service.IKLineService;
import cairh.community.api.game.kxian.util.ConfigProperties;
import cairh.community.api.game.kxian.util.HttpClientUtils;
import cairh.community.api.game.kxian.util.StringUtil;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 功能说明: <br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wangyx<br>
 * 开发时间: 2016年8月9日<br>
 */
@Service
public class KLineServiceImpl extends IKLineService {

	private static List<KLine> list;
	
	private static Logger logger = Logger.getLogger(KLineServiceImpl.class);
	
	public static final String hqTempUrl = ConfigProperties.get("hq.server.url", "http://quote.vstock.cairenhui.com");
	public static final String SYNC_KLINE_URL = ConfigProperties.get("hq.kline.url", "/quote/kline.json?");//k线

	public KLineResult requestKLineList(String goodsCode,int period, int position,int num){
		KLineResult k = new KLineResult();
		requestKLine(goodsCode, period, position, num);
		int count = 1;
		while(true){
			count++;
			if(count == 10){
				k.setError_info("获取行情失败");
				k.setError_no("-1");
				break;
			}
			if(list.size() != 0){
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		logger.info(list.size());
		
		k.setCount(list.size());
		k.setData(list);
		return k;
	}
	
	public static void requestKLine(String goodsCode,int period, int position,int numCount){
		list = new ArrayList<KLine>();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("code", goodsCode);
		param.put("type", 1);
		param.put("candlePeriod",period);
		param.put("candleMode",1);//前复权K线
		param.put("dataCount",numCount);
		SisapResult httpPost =HttpClientUtils.httpPost(hqTempUrl+SYNC_KLINE_URL, param);
		if(httpPost!=null){
			String resultStr = MapUtils.getString(httpPost.getResultMap(), "result");
			JSONObject jsonResultStr = JSONObject.parseObject(resultStr);
			JSONArray resultArray = JSONArray.parseArray(jsonResultStr.getString("detail_list"));
			int num = resultArray.size();
			//涨跌额
			double todayPrice = 0;
			double yesterdayPrice = 0;
			for(int i =0; i < num; i++){
				JSONObject resultJson=resultArray.getJSONObject(i);
				KLine kLine = new KLine();
				String minTime = resultJson.getString("min_time");
				Double openPx = resultJson.getDoubleValue("open_px")*100;
				Double highPx = resultJson.getDoubleValue("high_px")*100;
				Double lowPx = resultJson.getDoubleValue("low_px")*100;
				Double closePx = resultJson.getDoubleValue("close_px")*100;
				Double businessAmount = resultJson.getDoubleValue("business_amount")*100;
				Double businessBalance = resultJson.getDoubleValue("business_balance")*100;
				kLine.setCommonTime(minTime);
				kLine.setGoodsPriceOpen(openPx.intValue());
				kLine.setGoodsPriceHigh(highPx.intValue());
				kLine.setGoodsPriceLow(lowPx.intValue());
				kLine.setGoodsPriceLast(closePx.intValue());
				//kLine.setGoodsVolumeTotal(df1.format(resultJson.getDoubleValue("business_amount")));//成交量
				kLine.setGoodsVolumeTotal(businessAmount.intValue());//成交量
				kLine.setGoodsValueTotal(businessBalance.intValue());//成交额
				kLine.setGoodsVolumeKeep(0);//持仓量  ....新接口没有这个字段....
				yesterdayPrice = todayPrice;
				todayPrice = closePx;
				Double priceChange=todayPrice-yesterdayPrice;
				//涨跌额
				kLine.setPriceChange(priceChange.intValue());
				//涨跌率
				if(i!=0){
				kLine.setPriceChangeRate(StringUtil.percent((new BigDecimal(todayPrice).subtract(new BigDecimal(yesterdayPrice)))
						.divide(new BigDecimal(yesterdayPrice),4,BigDecimal.ROUND_HALF_UP)));//除法保留四位
				}
				list.add(kLine);
			}
			
			
		}
	}
	
    public static void main(String[] args) {
    	KLineResult k = new KLineResult();
    	requestKLine("SH600570", 6, 0, 80);
    	int count = 1;
		while(true){
			count++;
			if(count == 10){
				k.setError_info("获取k线行情失败");
				k.setError_no("-1");
    			break;
			}
			if(list.size() != 0){
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		k.setCount(list.size());
		k.setData(list);
    	System.out.println(k.getData());
    }
	
}
