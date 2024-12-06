package com.cancan.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Configuration
public class RedisConfiguration {

    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    static {
        // 配置FastJSON白名单，添加允许反序列化的类型
        ParserConfig.getGlobalInstance().addAccept("com.cancan.LoginUser");
    }

    /**
     * 配置RedisTemplate，使其能够存储和读取Java对象，使用FastJSON进行序列化与反序列化
     *
     * @param redisConnectionFactory Redis连接工厂，由Spring自动注入
     * @return 配置好的RedisTemplate实例
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 设置键（Key）的序列化方式为StringRedisSerializer，这样键以字符串形式存储在Redis中
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        // 设置值（Value）的序列化方式为FastJSON序列化器
        redisTemplate.setValueSerializer(fastJsonRedisSerializer());

        // 设置Hash的键（Hash Key）的序列化方式，同样采用StringRedisSerializer
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        // 设置Hash的值（Hash Value）的序列化方式，使用FastJSON序列化器
        redisTemplate.setHashValueSerializer(fastJsonRedisSerializer());

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 创建FastJSON序列化器，用于Redis中值的序列化与反序列化操作
     *
     * @return FastJSON序列化器实例
     */
    private RedisSerializer<Object> fastJsonRedisSerializer() {
        return new RedisSerializer<Object>() {
            @Override
            public byte[] serialize(Object o) {
                if (o == null) {
                    return new byte[0];
                }
                try {
                    return JSON.toJSONString(o, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
                } catch (Exception e) {
                    throw new RuntimeException("FastJSON序列化失败：" + e.getMessage(), e);
                }
            }

            @Override
            public Object deserialize(byte[] bytes) {
                if (bytes == null || bytes.length == 0) {
                    return null;
                }
                try {
                    String str = new String(bytes, DEFAULT_CHARSET);
                    return JSON.parse(str);
                } catch (Exception e) {
                    throw new RuntimeException("FastJSON反序列化失败：" + e.getMessage(), e);
                }
            }
        };
    }

    /**
     * 提供一个Redis操作的工具类，方便设置缓存过期时间等操作
     *
     * @return RedisUtils实例
     */
    @Bean
    public RedisUtils redisUtils(RedisTemplate<String, Object> redisTemplate) {
        return new RedisUtils(redisTemplate);
    }

    /**
     * Redis操作工具类，封装了常用的Redis操作方法，这里重点体现设置过期时间的功能
     */
    public static class RedisUtils {

        private final RedisTemplate<String, Object> redisTemplate;

        public RedisUtils(RedisTemplate<String, Object> redisTemplate) {
            this.redisTemplate = redisTemplate;
        }

        /**
         * 设置指定key的缓存过期时间
         *
         * @param key     要设置过期时间的Redis键
         * @param timeout 过期时间，单位为秒
         */
        public void setExpire(String key, long timeout) {
            setExpire(key, timeout, TimeUnit.SECONDS);
        }

        /**
         * 设置指定key的缓存过期时间，可指定时间单位
         *
         * @param key     要设置过期时间的Redis键
         * @param timeout 过期时间数值
         * @param unit    时间单位（如秒、分钟、小时等）
         */
        public void setExpire(String key, long timeout, TimeUnit unit) {
            redisTemplate.expire(key, timeout, unit);
        }

    }
}