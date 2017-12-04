package cairh.community.api.point.base;

import java.io.Serializable;
import java.util.List;
/**
 * @author fuzr
 */
public interface EntityDao <E,PK extends Serializable>{

	public Object getById(PK id);
	
	public void deleteById(PK id);
	
	public E save(E entity);
	
	public int update(E entity);

	public boolean isUnique(E entity, String uniquePropertyNames);
	
	public void insertBatch(final List<E> list);

}
