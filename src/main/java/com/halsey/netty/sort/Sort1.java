package com.halsey.netty.sort;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

/**
 * create by zhangyaohai
 * 2018-02-28 18:29
 **/
public class Sort1 {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(new Date()));


        int arr[] = {1,6,22,6,3,43,5,98,345443,67,2,56};
        System.out.println(Arrays.toString(arr));
        sort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int [] sort1(int [] arr){
        int x=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                x++;
                int temp;
                if(arr[i] > arr[j]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] sort2(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] sort3(int[] arr, int x, int y){

        return arr;
    }



}
