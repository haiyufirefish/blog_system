package com.ff.blog;

import redis.clients.jedis.Jedis;

public class TestRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
        System.out.println("connection success");
        //查看服务是否运行
        System.out.println("service is running: "+jedis.ping());
    }
}