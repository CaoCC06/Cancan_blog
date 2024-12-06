package com.cancan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // ---- 存储数据相关操作 ----

    /**
     * 向Redis中存储普通字符串类型的值
     *
     * @param key   Redis键
     * @param value 要存储的字符串值
     */
    public void setStringValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 向Redis中存储Java对象类型的值
     *
     * @param key   Redis键
     * @param value 要存储的Java对象
     */
    public void setObjectValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 向Redis的Hash结构中存储数据，指定Hash的键和值
     *
     * @param hashKey  Redis中Hash结构的键
     * @param key      Hash结构中要存储的子键
     * @param value    要存储的值，可以是任意类型，根据序列化配置进行转换
     */
    public void setHashValue(String hashKey, String key, Object value) {
        redisTemplate.opsForHash().put(hashKey, key, value);
    }

    // ---- 获取数据相关操作 ----

    /**
     * 从Redis中获取普通字符串类型的值
     *
     * @param key Redis键
     * @return 获取到的字符串值，如果不存在则返回null
     */
    public String getStringValue(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * 从Redis中获取Java对象类型的值
     *
     * @param key Redis键
     * @return 获取到的Java对象，如果不存在则返回null
     */
    public Object getObjectValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 从Redis的Hash结构中获取指定键的值
     *
     * @param hashKey Redis中Hash结构的键
     * @param key     Hash结构中要获取值的子键
     * @return 获取到的值，如果不存在则返回null
     */
    public Object getHashValue(String hashKey, String key) {
        return redisTemplate.opsForHash().get(hashKey, key);
    }

    // ---- 删除数据相关操作 ----

    /**
     * 根据键删除Redis中的数据
     *
     * @param key Redis键
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 删除Redis中Hash结构指定的子键对应的数据
     *
     * @param hashKey Redis中Hash结构的键
     * @param key     Hash结构中要删除的子键
     */
    public void deleteHashValue(String hashKey, String key) {
        redisTemplate.opsForHash().delete(hashKey, key);
    }

    // ---- 设置过期时间相关操作 ----

    /**
     * 设置指定Redis键的过期时间，单位为秒
     *
     * @param key     Redis键
     * @param timeout 过期时间，单位秒
     */
    public void setExpire(String key, long timeout) {
        setExpire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置指定Redis键的过期时间
     *
     * @param key     Redis键
     * @param timeout 过期时间数值
     * @param unit    时间单位（如秒、分钟、小时等）
     */
    public void setExpire(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

    // ---- 其他常用操作 ----

    /**
     * 判断Redis中指定的键是否存在
     *
     * @param key Redis键
     * @return 如果键存在返回true，否则返回false
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 对Redis中存储的数字类型的值进行自增操作（常用于计数器场景，如点赞数等）
     *
     * @param key Redis键
     * @return 自增后的值
     */
    public long increment(String key) {
        return redisTemplate.opsForValue().increment(key);
    }
}