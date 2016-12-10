package org.seckill.dao;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entitiy.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})  //加载配置文件
public class SeckillDaoTest {
    @Resource
    private SeckillDao seckillDao;
     @Test
    public void testQueryById() throws Exception {
        Long id = 1000L;
         Seckill seckill = seckillDao.queryById(id);
         System.out.println(seckill.getName());
         System.out.println(seckill);
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for(Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }
    @Test
    public void testReductNumber() throws Exception{
        Date killTime = new Date();
        long countTime = seckillDao.reduceNumber(1000L,killTime);
        System.out.println(countTime);
    }


}
