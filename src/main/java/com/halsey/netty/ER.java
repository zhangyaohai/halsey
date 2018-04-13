package com.halsey.netty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create by zhangyaohai
 * 2018-04-02 10:07
 **/
public class ER {

    public static void main(String[] args) {
        String s = "q_s_f_g_d_O_J_D_N_K";
        List<String> result = splitC(s.split("_"), 8, new ArrayList<>());
        System.out.println(result.toString());
    }

    private static List<String> splitC(String[] s, int selectN, List<String> result) {
        boolean flag = true;
        if(selectN <1 || selectN >s.length){
            throw  new RuntimeException("The args is error");
        }

        if(selectN == 1){
           return Arrays.asList(s);
        }

        for (int i = 0; i <= (s.length - selectN) && flag; i++) {//根据组合参数  确保选出的最后一个元素长度为selectn
            int p = i; // p 类似
            for (int j = p; j <= (s.length - selectN) && flag; j++) {//根据组合参数  确保选出的最后一个元素长度为selectn
                StringBuffer sb = new StringBuffer(s[i]);
                for (int k = 1; k < selectN && flag; k++) {
                    if ((j+k)>=s.length){ //
                        p++;
                        if(p > (s.length - selectN))
                            flag = false;
                        else
                            j = p;
                        break;
                    }
                    sb.append("_").append(s[j+k]);
                }
                result.add(sb.toString());
            }
        }
        return  result;
    }
}
