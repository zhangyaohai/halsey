package com.halsey.netty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Jdbc {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        List<String> list2 = new ArrayList<String>();
        list2.add("c");
        list2.add("d");
        List<String> list3 = new ArrayList<String>();
        list3.add("e");
        list3.add("f");
        List<String> list4 = new ArrayList<String>();
        list4.add("g");
        list4.add("h");
        List<String> list5 = new ArrayList<String>();
        list5.add("i");
        list5.add("j");
        List<String> list6 = new ArrayList<String>();
        list6.add("k");
        list6.add("o");
        List<String> list7 = new ArrayList<String>();
        list7.add("p");
        list7.add("q");
        dd(list1, list2);
        System.out.println(result.toString());
    }
    final static List<String> result = new ArrayList<String>();

    public static void dd(List<String>... lists){
        int x = maxSize(lists);
        int y = lists.length;
        String[][] arrS = new String[y][x];
        // 将list 转换为 二维数组
        for (int i = 0; i <y ; i++) {
            List<String> lis = lists[i];
            for (int j = 0; j < x; j++) {
                if(j<lis.size())
                    arrS[i][j] = lis.get(j);
                else{
                    arrS[i][j] = "#";
                }
            }
        }
        build( x,  y, arrS);
    }

    static int  yy = 0;
    public static void build(int x, int y, String[][]arrS){
        if(yy < y){//将数组已全部拼接完的行 做废弃处理
            for (int i = 0; i <x ; i++) {

                for (int j = 0; j < y; j++) {

                }
                arrS[yy][i] = "#";
            }
            yy++;
            build( x,y, arrS);
        }
    }

    public static int maxSize(List<String>... lists){
        int result = 0;
        for (int i = 0; i < lists.length; i++) {
           if( result < lists[i].size()){
               result = lists[i].size();
           }
        }
        return result;
    }
}
