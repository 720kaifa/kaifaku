/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.dao;

import org.springframework.stereotype.Component;

import cairh.community.api.game.kxian.base.BaseDao;
import cairh.community.api.game.kxian.model.MaUserinfo;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


@Component
public class MaUserinfoDao extends BaseDao<MaUserinfo,Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return MaUserinfo.class;
	}
	
	public void saveOrUpdate(MaUserinfo entity) {
		if(entity.getUserId() == null || entity.getUserId()==0)save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("MaUserinfo.pageSelect",pageRequest);
	}
	

}
