package cairh.community.api.point.base;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cairh.community.api.point.model.UserBase;
/**
 * @author fuzr
 */
@SuppressWarnings("unchecked")
public abstract class BaseService <E,PK extends Serializable>{
	
	protected Log log = LogFactory.getLog(getClass());

	protected abstract EntityDao getEntityDao();

	public E getById(PK id) {
		if(getClass().toString().contains("UserBase")){
			UserBase userBase = (UserBase)getEntityDao().getById(id);
			if(userBase!=null){
				userBase.setNickName(StringEscapeUtils.escapeHtml4(userBase.getNickName()));
			}
			return (E)userBase;
		}
		return (E)getEntityDao().getById(id);
	}

	public E save(E entity) {
		return  (E)getEntityDao().save(entity);
	}
	
	public void removeById(PK id) {
		getEntityDao().deleteById(id);
	}
	
	public int update(E entity) {
		return getEntityDao().update(entity);
	}
	
	public boolean isUnique(E entity, String uniquePropertyNames) {
		return getEntityDao().isUnique(entity, uniquePropertyNames);
	}
	
	public void insertBatch(List<E> list) {
		 getEntityDao().insertBatch(list);
	}
	
	
	
}
