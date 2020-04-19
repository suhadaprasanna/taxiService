/**
 * 
 */
package gdc.service.caching.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

/**
 * @author suhada
 *
 */
@Repository
public interface CacheRepository<K> {

	/**
	 * Save caching object
	 * @param k
	 */
	public void save(K k);
	
	/**
	 * update caching object
	 * @param k
	 */
	public void update(K k);
	
	/**
	 * remove caching object
	 * @param k
	 */
	public void delete(K k);
	public void saveOrUpdate(K k);
	public void delete(String key);
	public Map findAll();
	public K findByKey(String key);
}
