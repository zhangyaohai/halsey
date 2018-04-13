package com.halsey.netty;

import java.util.Arrays;

/**
 * create by zhangyaohai
 * 2018-04-03 16:56
 **/
public class DKRJ {
    public static void main(String[] args) {
        //-Xss128k
        String[] arrStr1 = {"a", "b"};
        String[] arrStr2 = {"c", "d"};
        String[] arrStr3 = {"e", "f"};
        String[] arrStr4 = {"g", "h", "i"};
        String[] arrStr5 = {"j"};
        String[] arrStr6 = {"k", "u"};
        String[] arrStr7 = {"v", "w"};
        String[] res = dkejTotal(arrStr1, arrStr2, arrStr3, arrStr4, arrStr5, arrStr6, arrStr7, arrStr2, arrStr3, arrStr4, arrStr5, arrStr6, arrStr7
                , arrStr2, arrStr3, arrStr4, arrStr5, arrStr6, arrStr7, arrStr2, arrStr3, arrStr4, arrStr5, arrStr6, arrStr7, arrStr2, arrStr3, arrStr4, arrStr5, arrStr6, arrStr7
                , arrStr2, arrStr3, arrStr4, arrStr5, arrStr6, arrStr7, arrStr2, arrStr3, arrStr4, arrStr5, arrStr6, arrStr7, arrStr2, arrStr3, arrStr4, arrStr5, arrStr6, arrStr7);
        System.out.println(Arrays.toString(res));
    }

    public static String[] dkejTotal(String[]... arrStr){
        String[] res = dkej(arrStr[0], arrStr[1]);
        int j = 2;
        while(j < arrStr.length){
            res = dkej(res, arrStr[j]);
            j++;
        }
        return res;
    }

    public static String[] dkej(String[] arrStr1, String[] arrStr2){
        if(arrStr1.length == 0)
            return arrStr2;
        if(arrStr2.length == 0)
            return arrStr1;

        int size = arrStr2.length*arrStr1.length;
        String[] result = new String[size];
        int i = 0;
        for (String s: arrStr1) {
            for (String s2: arrStr2) {
                result[i] = s.concat("_").concat(s2);
                i++;
            }
        }
        return result;
    }
}
