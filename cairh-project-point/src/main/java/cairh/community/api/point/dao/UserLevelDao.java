/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.point.dao;

import org.springframework.stereotype.Component;

import cairh.community.api.point.base.BaseDao;
import cairh.community.api.point.model.UserLevel;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


@Component
public class UserLevelDao extends BaseDao<UserLevel,java.lang.Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return UserLevel.class;
	}
	
	public void saveOrUpdate(UserLevel entity) {
		if(entity.getId() == null || entity.getId()==0)save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("UserLevel.pageSelect",pageRequest);
	}
	
	public UserLevel getStart(Long point){
		return (UserLevel)getSqlMapClientTemplate().queryForObject("UserLevel.getStart", point);
	}
	

}
