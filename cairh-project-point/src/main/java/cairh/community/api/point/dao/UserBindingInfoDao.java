/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.point.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import cairh.community.api.point.base.BaseDao;
import cairh.community.api.point.model.UserBindingInfo;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


@Component
public class UserBindingInfoDao extends BaseDao<UserBindingInfo,java.lang.Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return UserBindingInfo.class;
	}
	
	public void saveOrUpdate(UserBindingInfo entity) {
		if(entity.getBindNo() == null || entity.getBindNo()==0)save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("UserBindingInfo.pageSelect",pageRequest);
	}

	public UserBindingInfo getBy(String accountValue,String accountType) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("accountValue", accountValue);
		params.put("accountType", accountType);
		return (UserBindingInfo)getSqlMapClientTemplate().queryForObject("UserBindingInfo.getBy", params);
	}

	public void modifyUserId(Long beginId, Long afterId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("beginId", beginId);
		params.put("afterId", afterId);
		getSqlMapClientTemplate().update("UserBindingInfo.modifyUserId", params);
		
	}

	public UserBindingInfo ifBinDing(Long userId) {
		return (UserBindingInfo)getSqlMapClientTemplate().queryForObject("UserBindingInfo.ifBinDing", userId);
	}

	public Integer getCountByUserId(Long userId) {
		return (Integer)getSqlMapClientTemplate().queryForObject("UserBindingInfo.getCountByUserId", userId);
	}
	

}
