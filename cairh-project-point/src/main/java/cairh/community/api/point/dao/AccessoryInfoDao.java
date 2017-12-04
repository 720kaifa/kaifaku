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
import cairh.community.api.point.model.AccessoryInfo;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


@Component
public class AccessoryInfoDao extends BaseDao<AccessoryInfo,java.lang.Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return AccessoryInfo.class;
	}
	
	public void saveOrUpdate(AccessoryInfo entity) {
		if(entity.getId() == null || entity.getId()==0)save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("AccessoryInfo.pageSelect",pageRequest);
	}
	
	public AccessoryInfo getByAccessCode(String accessCode) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("accessCode", accessCode);
		return (AccessoryInfo)getSqlMapClientTemplate().queryForObject("AccessoryInfo.getByAccessCode",params);
	}
	
	
	public AccessoryInfo getByAccesName(java.lang.String accesName) {
		return (AccessoryInfo)getSqlMapClientTemplate().queryForObject("AccessoryInfo.getByAccesName",accesName);
	}

	public void updateByCode(String accessCode, String status) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("accessCode", accessCode);
		params.put("status", status);
		getSqlMapClientTemplate().queryForObject("AccessoryInfo.updateByCode",params);
	}	

}
