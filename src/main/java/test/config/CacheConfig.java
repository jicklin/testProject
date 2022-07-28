package test.config;

import com.google.common.collect.Maps;
import com.zxhy.frame.common.cache.CustomRedisCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mal
 * @date 2021-04-01 17:15
 */
@Configuration
public class CacheConfig {

    @Bean
    public RedisTemplate redisTemplate() {
        return new RedisTemplate();
    }


    @Bean
    public CustomRedisCacheManager redisCacheManager() {
        CustomRedisCacheManager customRedisCacheManager = new CustomRedisCacheManager(redisTemplate());
        customRedisCacheManager.setTransactionAware(true);
        customRedisCacheManager.setUsePrefix(true);
        Map<String, Long> expires = new HashMap<>();
        expires.put("areaCache", 86400L);
        customRedisCacheManager.setExpires(expires);
        return customRedisCacheManager;

    }
}
