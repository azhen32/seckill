package org.seckill.dto;

import org.seckill.entitiy.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;

/**
 * 封装秒杀执行后结果
 * Created by azhen on 16-12-9.
 */
public class SeckillExecution {
    private Long seckillId;
    private int state;  //秒杀执行结果
    private String stateInfo;   //转台`状态标识

    private SuccessKilled successKilled;//  秒杀成功对象

    /**
     *
     * @param seckillId
     * @param statEnum
     * @param successKilled
     */
    public SeckillExecution(Long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    /**
     *
     * @param seckillId
     * @param statEnum
     */
    public SeckillExecution(Long seckillId, SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStateInfo();
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
