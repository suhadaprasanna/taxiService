/**
 * 
 */
package gdc.service.caching.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * @author suhada
 *
 */
@Repository
public class RedisCacheRepository<T> {

	private RedisTemplate<String, T> redisTemplate;
	private HashOperations<String, Object, T> hashOperation;
	private ListOperations<String, T> listOperation;
	private ValueOperations<String, T> valueOperations;

	@Autowired
	RedisCacheRepository(RedisTemplate<String, T> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperation = redisTemplate.opsForHash();
		this.listOperation = redisTemplate.opsForList();
		this.valueOperations = redisTemplate.opsForValue();
	}

	// ----Map---------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param redisKey namespace key
	 * @param key unique key
	 * @param data save value
	 */
	public void putMap(String redisKey,Object key,T data) {
        hashOperation.put(redisKey, key, data);
    }
	/**
	 * 
	 * @param redisKey namespave key
	 * @param key unique key
	 * @return
	 */
	public T getEntityMap(String redisKey, Object key) {
		return hashOperation.get(redisKey, key);
	}
	/**
	 * 
	 * @param redisKey namespace key
	 * @return
	 */
	public Map<Object, T> getAllMap(String redisKey) {
		return hashOperation.entries(redisKey);
	}
	/**
	 * 
	 * @param redisKey namespace key
	 * @param key unique key
	 * @return
	 */
	public Long deleteMap(String redisKey, Object key) {
		return this.hashOperation.delete(redisKey, key);
	}
	// ----------------------------------------------------------------------------------------------------
	// ----Value-------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param key unique key
	 * @param value
	 */
	public void putValue(String key, T value) {
		valueOperations.set(key, value);
	}
	/**
	 * 
	 * @param key unique key
	 * @param value value or object
	 * @param timeout time
	 * @param unit
	 */
	public void putValue(String key, T value, long timeout, TimeUnit unit) {
		valueOperations.set(key, value, timeout, unit);
	}
	public T getValue(String key) {
		return valueOperations.get(key);
	}
	public List<T> getMultiValue(Collection list) {
		return valueOperations.multiGet(list);
	}
	// ----------------------------------------------------------------------------------------------------
	// ----List-------------------------------------------------------------------------------------------
	public void putList(String redisKey, T t, long time) {
		this.listOperation.set(redisKey, time, t);
	}
	// ----------------------------------------------------------------------------------------------------
	// ----Other-------------------------------------------------------------------------------------------
	public void setExpire(String key, long timeout, TimeUnit unit) {
		redisTemplate.expire(key, timeout, unit);
	}

}
