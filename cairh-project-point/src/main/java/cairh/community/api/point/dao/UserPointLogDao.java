package cairh.community.api.point.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cairh.community.api.point.base.BaseDao;
import cairh.community.api.point.model.UserPointLog;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


@Component
public class UserPointLogDao extends BaseDao<UserPointLog,java.lang.Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return UserPointLog.class;
	}
	
	public void saveOrUpdate(UserPointLog entity) {
		if(entity.getId() == null || entity.getId()==0)save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("UserPointLog.pageSelect",pageRequest);
	}
	public int countByExample(Map<String, Object> params){
		return (Integer)getSqlMapClientTemplate().queryForObject("UserPointLog.countByExample", params);
	}
	
	public List<UserPointLog> selectByExample(Map<String, Object> params){
		return  this.getSqlMapClientTemplate().queryForList("UserPointLog.selectByExample",params);
	}

	public List<Map<String, Object>> userExpendPoints(Integer beginDate,
			Integer endDate, int startRow, int endRow) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("beginDate", beginDate);
		params.put("endDate", endDate);
		params.put("startRow", startRow);
		params.put("endRow", endRow);
		
		return this.getSqlMapClientTemplate().queryForList("UserPointLog.userExpendPoints", params);
	}

	public List<Map<String,Object>> queryUserPointLogList(Map<String, Object> params) {
		return getSqlMapClientTemplate().queryForList("UserPointLog.queryUserPointLogList", params);
	}

	public void saveList(List<Map<String, Object>> mapList) {
		getSqlMapClientTemplate().insert("UserPointLog.insert", mapList);
		
	}
	
	public void add(Map<String, Object> mapList) {
		getSqlMapClientTemplate().insert("UserPointLog.insert", mapList);
		
	}
	
	public List<UserPointLog> queryByChangeType(Map<String, Object> params){
		return getSqlMapClientTemplate().queryForList("UserPointLog.queryByChangeType", params);
	}

	public void modifyUserId(Long beginId, Long afterId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("beginId", beginId);
		params.put("afterId", afterId);
		getSqlMapClientTemplate().update("UserPointLog.modifyUserId", params);
	}
}
