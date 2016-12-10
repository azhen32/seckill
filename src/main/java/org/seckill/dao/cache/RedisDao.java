package org.seckill.dao.cache;

import org.seckill.entitiy.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by azhen on 16-12-10.
 */
public class RedisDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JedisPool jedisPool;
    private RunTimeSchema<Seckill> schema = RunTimeSchema.createFrom(Seckill.class);
    public RedisDao(String ip,int port) {
        jedisPool = new JedisPool(ip,port);
    }

    public Seckill getSeckill(Long seckillId) {
        //redis操作逻辑
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + seckillId;
                byte[] bytes = jedis.get(key.getBytes());
                if(bytes != null) {
                    Seckill seckill = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes,seckill,schema);
                    return seckill;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    public String putSeckill(Seckill seckill) {
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + seckill.getSeckillId();
                byte[] bytes = ProtostuffIOUti.toByteArray(seckill,schema,allocate(LinkkedBuffer.DEFAULT_BUFFER_SIZE));
                //超时缓存
                int timeout = 60 * 60; //1小时
                String result = jedis.setex(key,timeout,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e) {

        }
        return null;
    }
}
