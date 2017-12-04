/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cairh.community.api.game.kxian.base.BaseDao;
import cairh.community.api.game.kxian.model.MaTodayRanking;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


@Component
public class MaTodayRankingDao extends BaseDao<MaTodayRanking,Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return MaTodayRanking.class;
	}
	
	public void saveOrUpdate(MaTodayRanking entity) {
		if(entity.getUserId() == null || entity.getUserId()==0)save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("MaTodayRanking.pageSelect",pageRequest);
	}

	public List<MaTodayRanking> todayRanking(int time) {
		return  this.getSqlMapClientTemplate().queryForList("MaTodayRanking.todayRanking",time);
	}

	public MaTodayRanking getRank(Long userId,int intTime) {
		Map<String,Object> parameter = new HashMap<String, Object>();
		parameter.put("userId", userId);
		parameter.put("intTime", intTime);
		return (MaTodayRanking)getSqlMapClientTemplate().queryForObject("MaTodayRanking.getRank",parameter);
	}
	
	public List<MaTodayRanking> todayAll(int time) {
		return  this.getSqlMapClientTemplate().queryForList("MaTodayRanking.todayAll",time);
	}

	public void deleteByTime(int intTime) {
		getSqlMapClientTemplate().delete("MaTodayRanking.deleteByTime", intTime);
	}
}
