/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cairh.community.api.game.kxian.base.BaseDao;
import cairh.community.api.game.kxian.model.RevenueLog;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;



@Component
public class RevenueLogDao extends BaseDao<RevenueLog,Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return RevenueLog.class;
	}
	
	public void saveOrUpdate(RevenueLog entity) {
		if(entity.getId() == null || entity.getId()==0)save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("RevenueLog.pageSelect",pageRequest);
	}
	
	public int getCountByCode(String storkCode){
		Map<String,Object> parameter = new HashMap<String, Object>();
		parameter.put("storkCode", storkCode);
		return (Integer)getSqlMapClientTemplate().queryForObject("RevenueLog.getCountByCode",parameter);
	}
	
	public int getCountLessRe(String storkCode,BigDecimal revenueRate){
		Map<String,Object> parameter = new HashMap<String, Object>();
		parameter.put("storkCode", storkCode);
		parameter.put("revenueRate", revenueRate);
		return (Integer)getSqlMapClientTemplate().queryForObject("RevenueLog.getCountLessRe",parameter);
	}

	public List<RevenueLog> getLogList(Map<String, Object> params) {
		return getSqlMapClientTemplate().queryForList("RevenueLog.getLogList",params);
	}

	public int countByExample(Map<String, Object> params){
		return (Integer)getSqlMapClientTemplate().queryForObject("RevenueLog.countByExample", params);
	}

}
