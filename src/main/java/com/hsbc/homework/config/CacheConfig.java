package com.hsbc.homework.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static com.hsbc.homework.constant.CacheConstant.CACHE_KEY_NAME;


@EnableCaching
@Configuration
public class CacheConfig extends CachingConfigurerSupport {


    private final static long MEM_EXPIRE_TIME_SECONDS_BY_AUTO_REFRESH = 30 * 60;


    @Bean(name = "memCacheManager")
    public CacheManager memCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        CaffeineCache incidentCache =
                new CaffeineCache(CACHE_KEY_NAME, caffeineBuilder(MEM_EXPIRE_TIME_SECONDS_BY_AUTO_REFRESH).build());

        cacheManager.setCaches(Arrays.asList(
                incidentCache
        ));
        return cacheManager;
    }


    private Caffeine<Object, Object> caffeineBuilder(long duration) {
        return Caffeine.newBuilder().expireAfterWrite(duration, TimeUnit.SECONDS).maximumSize(10_000);
    }




}
