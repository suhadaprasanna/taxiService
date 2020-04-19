/**
 * 
 */
package gdc.service.caching.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import gdc.utility.pojo.reservation.Reservation;

/**
 * @author suhada
 *
 */
@Repository
public class ReservationCacheRepoImpl implements CacheRepository<Reservation>{

	private String KEY ="RESERVATION";
    private RedisCacheRepository<Reservation> redisCache;
    
    @Autowired
    ReservationCacheRepoImpl(RedisCacheRepository<Reservation> redisCache){
    	this.redisCache = redisCache;
    }
	
	/* (non-Javadoc)
	 * @see gdc.service.caching.dao.CacheRepository#save(java.lang.Object)
	 */
	@Override
	public void save(Reservation k) {
		this.redisCache.putMap(KEY, k.getTraceId(), k);
	}

	/* (non-Javadoc)
	 * @see gdc.service.caching.dao.CacheRepository#update(java.lang.Object)
	 */
	@Override
	public void update(Reservation k) {
		this.redisCache.putMap(KEY, k.getTraceId(), k);
	}
	
	/* (non-Javadoc)
	 * @see gdc.service.caching.dao.CacheRepository#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public void saveOrUpdate(Reservation k) {
		this.redisCache.putMap(KEY, k.getTraceId(), k);
	}

	/* (non-Javadoc)
	 * @see gdc.service.caching.dao.CacheRepository#delete(java.lang.Object)
	 */
	@Override
	public void delete(Reservation k) {
		this.redisCache.deleteMap(KEY, k.getTraceId());
	}

	/* (non-Javadoc)
	 * @see gdc.service.caching.dao.CacheRepository#delete(java.lang.String)
	 */
	@Override
	public void delete(String key) {
		this.redisCache.deleteMap(KEY, key);
	}
	
	/* (non-Javadoc)
	 * @see gdc.service.caching.dao.CacheRepository#findAll()
	 */
	@Override
	public Map findAll() {
		return this.redisCache.getAllMap(KEY);
	}

	/* (non-Javadoc)
	 * @see gdc.service.caching.dao.CacheRepository#findByKey(java.lang.String)
	 */
	@Override
	public Reservation findByKey(String key) {
		return this.redisCache.getEntityMap(KEY, key);
	}

}
