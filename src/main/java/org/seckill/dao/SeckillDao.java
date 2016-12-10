package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entitiy.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**秒杀商品DAO
 * Created by azhen on 16-12-8.
 */
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId
     * @param killDate
     * @return 如果影响行数 > 1,表示更新的记录行数
     */
    Integer reduceNumber(@Param("seckillId") Long seckillId,@Param("killTime") Date killDate);

    /**
     * 根据Id查询商品
     * @param seckillId
     * @return
     */
    Seckill queryById(Long seckillId);

    /**
     * 分页查询秒刷商品
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") Integer offset, @Param("limit") Integer limit);

    /**
     * 通过存储过程执行秒杀
     * @param paramMap
     */
    void killByProcedure(Map<String,Object> paramMap);
}
