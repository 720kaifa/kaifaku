/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.point.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cairh.community.api.point.base.BaseDao;
import cairh.community.api.point.model.ChannelPoint;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


@Component
public class ChannelPointDao extends BaseDao<ChannelPoint,java.lang.Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return ChannelPoint.class;
	}
	
	public void saveOrUpdate(ChannelPoint entity) {
		if(entity.getId() == null || entity.getId()==0)save(entity); else update(entity);
	}
	
	/**
	 * 改方法的name为模糊查询
	 * @param pageRequest
	 * @return
	 */
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("ChannelPoint.pageSelect",pageRequest);
	}
	
	/**
	 * 根据渠道名称模糊查询
	 * @param name
	 * @return
	 */
	public List<ChannelPoint> getByNamelike(String name){
		List<ChannelPoint> list = new ArrayList<ChannelPoint>();
		list = getSqlMapClientTemplate().queryForList("ChannelPoint.getByName", name);
		return list;
	}
	
	public ChannelPoint getBy(Map<String, Object> params) {
		return  (ChannelPoint)this.getSqlMapClientTemplate().queryForObject("ChannelPoint.getBy",params);
	}
	
	public List<Map<String, Object>> getListBy(Map<String, Object> params) {
		return  getSqlMapClientTemplate().queryForList("ChannelPoint.getListBy",params);
	}
}
