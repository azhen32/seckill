package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entitiy.SuccessKilled;

/**秒杀明细DAO
 * Created by azhen on 16-12-8.
 */
public interface SuccessKilledDao {

    /**
     * 插入秒杀细，可过滤重复
     * @param seckillId
     * @param userPhone
     * @return 插入的行数
     */
    Integer insertSuccessKilled(@Param("seckillId") Long seckillId, @Param("userPhone") Long userPhone);

    /**
     * 根据ID查询SuccessKilled并携带产品对象实体
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") Long seckillId,@Param("userPhone") Long userPhone);

}
