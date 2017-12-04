package cairh.community.api.game.kxian.service;

import org.springframework.stereotype.Service;

import cairh.community.api.game.kxian.bean.KLineResult;



/**
 * 功能说明: 用户积分开放接口服务<br>
 * 系统版本: v1.0<br>
 * 开发人员: @author wangyx<br>
 * 开发时间: 2016年8月9日<br>
 */
@Service
public abstract class IKLineService  {

	
	public abstract KLineResult requestKLineList(String goodsCode,int period, int position,int num);

	//public abstract KLineCountResult requestKLineExRightList(String goodsCode,int exRight);

}
