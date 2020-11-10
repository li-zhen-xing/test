package com.ll.springboot_jsp_shiro.shiro.cache;

import com.ll.springboot_jsp_shiro.utils.ApplicaionContextUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.util.Collection;
import java.util.Set;

/**
 * @ClassName RedisCache
 * @Description
 * @Author 李振兴
 * @Date 2020/11/9 15:29
 **/
public class RedisCache<k,v> implements Cache<k,v> {

    private String cacheName;

    public RedisCache(){
    }

    public RedisCache(String cacheName){
        this.cacheName=cacheName;
    }

    @Override
    public v get(k k) throws CacheException {

        return (v) getRedisTemplate().opsForHash().get(this.cacheName,k.toString());
    }

    @Override
    public v put(k k, v v) throws CacheException {
        System.out.println("put key:"+k);
        System.out.println("put v:"+v);
        getRedisTemplate().opsForHash().put(this.cacheName,k.toString(),v);
        //System.out.println("---------------"+getRedisTemplate().opsForValue().get(k.toString()));
        return null;
    }

    @Override
    public v remove(k k) throws CacheException {
        return (v) getRedisTemplate().opsForHash().delete(this.cacheName,k.toString());
    }

    @Override
    public void clear() throws CacheException {
        getRedisTemplate().delete(this.cacheName);
    }

    @Override
    public int size() {
        return getRedisTemplate().opsForHash().size(this.cacheName).intValue();
    }

    @Override
    public Set<k> keys() {
        return getRedisTemplate().opsForHash().keys(this.cacheName);
    }

    @Override
    public Collection<v> values() {
        return getRedisTemplate().opsForHash().values(this.cacheName);
    }

    private RedisTemplate getRedisTemplate(){
        RedisTemplate redisTemplate = (RedisTemplate) ApplicaionContextUtils.getBean("redisTemplate");
        //修改key的序列化策略 设置为String类型，如果不修改默认是jdk的序列化方式key和value都是object对象 修改了可以在终端中看到正常的key
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置hash类型的key的序列化策略
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
