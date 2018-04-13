package com.halsey.netty.streamTest;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by zhangyaohai on 2017/9/23.
 */
public class TR {
    public static void main(String[] args) {
        Map<String, String> m = Maps.newHashMap();
        m.put("21", "111");
        Map<String, String> m2 = m;

        m.put("21", "333");
        m.forEach((k, v)->{
            System.out.println(k);
            System.out.println(v);
        });
        m2.forEach((k, v)->{
            System.out.println(k);
            System.out.println(v);
        });
    }
}
