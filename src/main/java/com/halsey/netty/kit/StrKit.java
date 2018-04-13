package com.halsey.netty.kit;

/**
 * create by zhangyaohai
 * 2018-02-06 14:37
 **/
public class StrKit {
    public static String firstCharToLowerCase(String str){
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    public static String firstCharToUpperCase(String str){
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] -= ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    public static boolean isBank(String str) {
        if(str == null) {
            return true;
        }
        int len = str.length();
        if(len == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            switch (str.charAt(i)) {
                case  ' ':
                case  '\t':
                case  '\n':
                case  '\r':
                    System.out.println(12);
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
