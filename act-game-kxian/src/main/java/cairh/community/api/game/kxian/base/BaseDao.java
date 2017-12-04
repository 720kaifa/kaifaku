package cairh.community.api.game.kxian.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientCallback;

import cn.org.rapid_framework.page.Page;
import cn.org.rapid_framework.page.PageRequest;
import cn.org.rapid_framework.util.MapAndObject;

import com.ibatis.common.util.PageList;
import com.ibatis.sqlmap.client.SqlMapClientDaoSupport;
import com.ibatis.sqlmap.client.SqlMapExecutor;
/**
 * @author fuzr
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public abstract class BaseDao<E,PK extends Serializable> extends SqlMapClientDaoSupport implements EntityDao<E,PK> {
    protected final Log log = LogFactory.getLog(getClass());
    
	public abstract Class getEntityClass();
  
	public E getById(PK y) {
        E e = (E) getSqlMapClientTemplate().queryForObject(getFindByPrimaryKeyQuery(), y);
        return e;
    }
    
	public void deleteById(PK id) {
		getSqlMapClientTemplate().delete(getDeleteQuery(), id);
	}
	
    public E save(E entity) {
		@SuppressWarnings("unused")
		E primaryKey = (E)getSqlMapClientTemplate().insert(getInsertQuery(), entity);
		return primaryKey;
    }
    
	public int update(E entity) {
		
		@SuppressWarnings("unused")
		int primaryKey = getSqlMapClientTemplate().update(getUpdateQuery(), entity);
		return primaryKey;
	}
	
	

    public String getFindByPrimaryKeyQuery() {
        return getEntityClass().getSimpleName()+".getById";
    }
  
    public String getInsertQuery() {
        return getEntityClass().getSimpleName()+".insert";
    }

    public String getUpdateQuery() {
    	return getEntityClass().getSimpleName()+".update";
    }

    public String getDeleteQuery() {
    	return getEntityClass().getSimpleName()+".delete";
    }

    public String getCountQuery() {
		return getEntityClass().getSimpleName() +".count";
	}
    public String getFindByPropertiesQuery(){
    	return getEntityClass().getSimpleName() +".getByProperties";
    }
	public Page pageQuery(String statementName, PageRequest pageRequest) {
		Page page = new Page(pageRequest,100);
		Map otherFilters = new HashMap();
		otherFilters.put("offset", page.getFirstResult());
		otherFilters.put("pageSize", page.getPageSize());
		otherFilters.put("lastRows", page.getFirstResult() + page.getPageSize());
		otherFilters.put("sortColumns", pageRequest.getSortColumns());
		Map parameterObject = new MapAndObject(otherFilters,pageRequest.getFilters());
		return pageQuery(statementName,parameterObject,pageRequest);
		 
	}
	
	/**
	 * <b>Summary1: </b>
	 *     pageQuery(请用一句话描述这个方法的作用)
	 * @param statementName
	 * @param paramObject
	 * @param pageRequest
	 * @return
	 */
	protected Page pageQuery(String statementName, Object paramObject, PageRequest pageRequest) {
		PageList pl = getSqlMapClientTemplate().queryForPageList(statementName, paramObject,pageRequest.getPageNumber(),pageRequest.getPageSize());
		Page<E> page = new Page(pageRequest,pl.getTotalCount());
		page.setResult(pl.getDataList());
		return page;
	}
	
	
	protected Page pageQuery(String statementName, PageRequest pageRequest, int limitPage) {
		Page page = pageQuery(statementName, pageRequest);
		Page pageRet = null;
		if(page.getLastPageNumber()>limitPage){
			pageRet = new Page(pageRequest,limitPage*pageRequest.getPageSize());
			pageRet.setResult(page.getResult());
		}else
			pageRet = page;
		return pageRet;
	}
	

	public boolean isUnique(E entity, String uniquePropertyNames) {
		throw new UnsupportedOperationException();
	}
	
	
	public List<E> getByProperties(E entity){
		return this.getSqlMapClientTemplate().queryForList(getFindByPropertiesQuery(), entity);
	}
	
	public void insertBatch(final List<E> list) throws DataAccessException {
		final String statement = getInsertQuery();
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch(); // 一定要有，通知开始批量
				int batch = 0;
				for (E e:list) {
					executor.insert(statement, e);
					batch++;
					if (batch >= 500) {
						executor.executeBatch();
						batch = 0;
					}
				}
				executor.executeBatch(); // 将最后的数据执行，最后不够500条的数据
				return null;
			}
		}, statement);
	}

}
