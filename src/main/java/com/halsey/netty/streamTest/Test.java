package com.halsey.netty.streamTest;

/**
 * Created by zhangyaohai on 2017/9/12.
 */
public class Test {
    public static void main(String[] args) {
        String s = "20171203";
        char[] chars = s.toCharArray();
        String ss = s.substring(0,4)+s.substring(4,6)+s.substring(6,8);
        System.out.println(ss);
    }


}
