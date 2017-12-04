/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 */

package cairh.community.api.game.kxian.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import cairh.community.api.game.kxian.base.BaseDao;
import cairh.community.api.game.kxian.model.GameUser;
import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;


@Component
public class GameUserDao extends BaseDao<GameUser,java.lang.Long>{
	
	@SuppressWarnings("unchecked")
	public Class getEntityClass() {
		return GameUser.class;
	}
	
	public void saveOrUpdate(GameUser entity) {
		if(entity.getId() == null || entity.getId()==0)save(entity); else update(entity);
	}
	
	public Page findByPageRequest(PageRequest pageRequest) {
		return pageQuery("GameUser.pageSelect",pageRequest);
	}

	public GameUser getByAcc(Long userId, Long gameKhero) {
		Map<String,Object> parameter = new HashMap<String, Object>();
		parameter.put("userId", userId);
		parameter.put("gameKhero", gameKhero);
		return (GameUser)getSqlMapClientTemplate().queryForObject("GameUser.getByAcc",parameter);
	}
	

}
