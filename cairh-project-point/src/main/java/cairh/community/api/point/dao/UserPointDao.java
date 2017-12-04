package cairh.community.api.point.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import cairh.community.api.point.base.BaseDao;
import cairh.community.api.point.model.UserPoint;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


@Component
public class UserPointDao extends BaseDao<UserPoint,java.lang.Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return UserPoint.class;
	}
	
	public void saveOrUpdate(UserPoint entity) {
		if(entity.getId() == null || entity.getId()==0)save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("UserPoint.pageSelect",pageRequest);
	}

	public UserPoint getByUserId(long userId) {
		return (UserPoint) getSqlMapClientTemplate().queryForObject("UserPoint.getByUserId", userId);
	}
	@SuppressWarnings("unchecked")
	public List<UserPoint> selectByExample(UserPoint entity) {
		return  this.getSqlMapClientTemplate().queryForList("UserPoint.pageSelect",entity);
	}

	public Page queryUserPointList(PageRequest pageRequest) {
		return pageQuery("UserPoint.queryUserPointList",pageRequest);
	}
	
	public int updateList(List<UserPoint> pointList) {
		int primaryKey = getSqlMapClientTemplate().update("UserPoint.update", pointList);
		return primaryKey;
	}
}
