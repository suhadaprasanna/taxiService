/**
 * 
 */
package gdc.service.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author suhada
 *
 */
@Configuration
public class RedisCacheService {

	private static final Logger logger = LoggerFactory.getLogger(RedisCacheService.class);
	
	@Value("${gdc.cache.redis.server}")
	private String server;
	
	@Value("${gdc.cache.redis.port}")
	private int port;
	
	@Value("${gdc.cache.redis.password}")
	private int password;
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		logger.debug("------>>Redis cache server:"+this.server+", port:"+this.port+"<<------");
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(this.server, this.port);
		return new JedisConnectionFactory(config);
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new GenericToStringSerializer<Object>(Object.class));
        //template.setHashValueSerializer(new JdkSerializationRedisSerializer());
		return template;
	}
}
