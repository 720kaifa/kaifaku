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
import cairh.community.api.game.kxian.model.MaHistoryRanking;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


@Component
public class MaHistoryRankingDao extends BaseDao<MaHistoryRanking,Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return MaHistoryRanking.class;
	}
	
	public void saveOrUpdate(MaHistoryRanking entity) {
		if(entity.getUserId() == null || entity.getUserId()==0)save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("MaHistoryRanking.pageSelect",pageRequest);
	}

	public List<MaHistoryRanking> historyRanking(Integer time) {
		return  this.getSqlMapClientTemplate().queryForList("MaHistoryRanking.historyRanking",time);
	}
	
	public MaHistoryRanking getRank(Long userId,int intTime) {
		Map<String,Object> parameter = new HashMap<String, Object>();
		parameter.put("userId", userId);
		parameter.put("intTime", intTime);
		return (MaHistoryRanking)getSqlMapClientTemplate().queryForObject("MaHistoryRanking.getRank",parameter);
	}

	public List<MaHistoryRanking> myGamePointLog(Long userId,int startRow, int endRow) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("startRow", startRow);
		params.put("endRow", endRow);
		return getSqlMapClientTemplate().queryForList("MaHistoryRanking.myGamePointLog",params);
	}

	public int myGamePointCount(Long userId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("MaHistoryRanking.myGamePointCount",userId);
	}

	public int getToalPoint(Long userId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("MaHistoryRanking.getToalPoint",userId);
	}
	
}
