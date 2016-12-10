drop database if EXISTS seckill;
 CREATE DATABASE seckill;
 USE seckill;
 CREATE TABLE seckill (
  `seckill_id` bigint AUTO_INCREMENT COMMENT '商品库存id',
  `name` varchar(120) not null comment '商品名称',
  `number` int not null comment '库存数量',
  `start_time` TIMESTAMP not null comment '秒杀开启时间',
  `end_time` TIMESTAMP  not null  default CURRENT_TIMESTAMP comment '秒杀结束时间',
  `create_time` TIMESTAMP not null default CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY(seckill_id),
  key idx_start_time(start_time),
  key idx_end_time(end_time),
  key idx_create_time(create_time)
 ) engine=InnoDB AUTO_INCREMENT= 1000 default charset=utf8 comment='秒杀库存表';

 insert into
  seckill(name,number,start_time,end_time)
 values
  ('1000元秒杀iphone7',100,'2016-11-01 00:00:00','2016-11-02 00:00:00'),
  ('500元秒杀iPad2',200,'2016-11-01 00:00:00','2016-11-02 00:00:00'),
  ('300元秒杀小米4',300,'2016-11-01 00:00:00','2016-11-02 00:00:00'),
  ('200元秒杀红米note',400,'2016-11-01 00:00:00','2016-11-02 00:00:00');

-- 秒杀成功明细表

-- 用户登录认证相关信息
create table success_killed(
  `seckill_id` bigint not null comment '秒杀商品id',
  `user_phone` bigint not null comment '用户手机号',
  `state` tinyint not null default -1 comment '状态表示 -1：无效 0:成功 1：已付款',
  `create_time` TIMESTAMP not null default CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (seckill_id,user_phone),/*联合主键*/
  KEY idx_create_time(create_time)
)engine=InnoDB AUTO_INCREMENT= 1000 default charset=utf8 comment='秒杀成功明细表';