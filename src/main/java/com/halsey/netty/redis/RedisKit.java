package com.halsey.netty.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public class RedisKit {
    private static String  hostName = "localhost";
    private static int  port = 6379;

    public static void main(String[] args) throws Exception{
        Jedis conn = getConnection();
        long l = conn.setnx("w","12");
        String s = new String(Files.readAllBytes(Paths.get("D:\\git\\halsey\\src\\main\\java\\com\\halsey\\netty\\redis\\test.lua")));
        Object ob =  conn.eval(s);
        System.out.println(ob.toString());
    }

    public static Jedis getConnection(){
       return new JedisPool(new JedisPoolConfig(), hostName, port).getResource();
    }
}
