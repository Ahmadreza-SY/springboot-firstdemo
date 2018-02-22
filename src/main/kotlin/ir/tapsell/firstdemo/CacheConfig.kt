package ir.tapsell.firstdemo

import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.CachingConfigurerSupport
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate


@Configuration
@EnableCaching
class CacheConfig : CachingConfigurerSupport() {

    @Bean
    fun redisConnectionFactory(): JedisConnectionFactory {
        return JedisConnectionFactory()
    }

    @Bean
    fun redisTemplate(cf: RedisConnectionFactory): RedisTemplate<String, String> {
        val redisTemplate = RedisTemplate<String, String>()
        redisTemplate.connectionFactory = cf
        return redisTemplate
    }

    @Bean
    fun cacheManager(redisTemplate: RedisTemplate<*, *>): CacheManager {
        val cacheManager = RedisCacheManager(redisTemplate)

        // Set cache expiration to 20 min
        cacheManager.setDefaultExpiration(20 * 60)
        return cacheManager
    }
}