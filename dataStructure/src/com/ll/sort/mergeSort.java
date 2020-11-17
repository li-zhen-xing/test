package com.ll.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName mergeSort归并排序
 * @Description
 * @Author 李振兴
 * @Date 2020/9/18 18:04
 **/
public class mergeSort {
    public static void main(String[] args) {
        //测试归并排序速度
        int []bb=new int[80000];
        for (int i = 0; i < 80000; i++) {
            bb[i]=(int)(Math.random()*80000);
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dd=simpleDateFormat.format(date);
        System.out.println(dd);
        mergeSort(bb,0,bb.length);
        Date dat=new Date();
        String cc=simpleDateFormat.format(dat);
        System.out.println(cc);
/*        int[]a={2,8,9,10,4,5,6,7};
        mergeSort(a,0,a.length);
        System.out.println(Arrays.toString(a));*/
    }
    public static  void mergeSort(int[]arr,int L,int R){
        //当不能再进行归并排序时直接退出
        if (R==L){
            return;
        }
        int M=(L+R)/2;
        //先对左边进行归并排序
        mergeSort(arr,L,M);
        //再对右边进行归并排序
        mergeSort(arr,M+1,R);
        //他的原理是其实他还是一个独立的数组只不过是把一个数组分成了很多个模块，再对这个模块进行合并排序交换位置
        merge(arr,L,M,R);
    }

    /**
     *
     * @param arr 将一个，左右两边都是有序数字的数组合并成一个有序数组
     * @param begin 开始位置的下标
     * @param mid   中间位置的下标
     * @param end   数组尾部的下标
     */

    public static void merge(int[] arr,int begin,int mid,int end){
        //左边数组长度
        int left_size=mid-begin;
        //右边数组长度
        int right_size=end-mid;
        int[]left=new int [left_size];
        int[]right=new int[right_size];

        for (int i = begin; i <mid ; i++) {
            left[i-begin]=arr[i];
        }
        for (int i = mid; i <end ; i++) {
            right[i-mid]=arr[i];
        }
        //左边数组的开始下标
        int L_index=0;
        //右边数组的开始下标
        int R_index=0;
        //要排序的数组开始位置下标
        int arr_index=begin;
        //当左边数组下标小于他的size并且右边的下标小于他的 size时说明还在交换中
        while (L_index<left_size&&R_index<right_size){
            //当左边的值大于右边的值时把左边的值放入数组中
            if (left[L_index]>right[R_index]){
                arr[arr_index]=right[R_index];
                //此时数组的下标和左边的下标同时增加
                R_index++;
                arr_index++;
            }else {
            arr[arr_index]=left[L_index];
                L_index++;
                arr_index++;
            }
        }
        //当右边的下标大于他的size时说明右边放满了，此时可以把左边的元素都放入数组中
        while (L_index<left_size){
            arr[arr_index]=left[L_index];
            L_index++;
            arr_index++;
        }
        //当左边的下标大于他的size时说明左边放满了，此时可以把右边的元素都放入数组中
        while (R_index<right_size){
            arr[arr_index]=right[R_index];
            R_index++;
            arr_index++;
        }

    }
}

