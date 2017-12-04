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
import cairh.community.api.game.kxian.model.UserRevenue;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;



@Component
public class UserRevenueDao extends BaseDao<UserRevenue,java.lang.Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return UserRevenue.class;
	}
	
	public void saveOrUpdate(UserRevenue entity) {
		if(entity.getUserId() == null || entity.getUserId()==0)save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("UserRevenue.pageSelect",pageRequest);
	}

	public List<UserRevenue> rankingList(Integer count) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count+1);
		return  this.getSqlMapClientTemplate().queryForList("UserRevenue.rankingList",map);
	}
	
	public List<UserRevenue> getList() {
		Map<String, Object> map = new HashMap<String, Object>();
		return  this.getSqlMapClientTemplate().queryForList("UserRevenue.getList",map);
	}

/*	public void updateList(List<UserRevenue> userRevenues) {
		this.getSqlMapClientTemplate().update("UserRevenue.updateList",userRevenues);
	}*/

	public UserRevenue getRank(Long userId) {
		Map<String,Object> parameter = new HashMap<String, Object>();
		parameter.put("userId", userId);
		return (UserRevenue)getSqlMapClientTemplate().queryForObject("MaHistoryRanking.getRank",parameter);
	}
}
