/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import cairh.community.api.game.kxian.base.BaseDao;
import cairh.community.api.game.kxian.model.StockPool;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;



@Component
public class StockPoolDao extends BaseDao<StockPool,java.math.BigDecimal>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return StockPool.class;
	}
	
	public void saveOrUpdate(StockPool entity) {
		if(entity.getStockCode() == null || entity.getStockCode()=="")save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("StockPool.pageSelect",pageRequest);
	}
	
	public int getCount(){
		Map<String,Object> parameter = new HashMap<String, Object>();
		return (Integer)getSqlMapClientTemplate().queryForObject("StockPool.getCount",parameter);
	}

	public StockPool getByRow(int random){
		Map<String,Object> parameter = new HashMap<String, Object>();
		parameter.put("random", random);
		return (StockPool)getSqlMapClientTemplate().queryForObject("StockPool.getByRow",parameter);
	}
}
