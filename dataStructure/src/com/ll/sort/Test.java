package com.ll.sort;

import java.util.Arrays;

/**
 * @ClassName Test
 * @Description
 * @Author 李振兴
 * @Date 2020/9/16 9:49
 **/
public class Test {
    public static void main(String[] args) {
        /*int[]aa={-1,-5,5,20,2};
        int temp=0;
        for (int j = 0; j < aa.length-1; j++) {
            for (int i = 0; i < aa.length - 1; i++) {
                if (aa[i]>aa[i+1]){
                    temp=aa[i];
                    aa[i]=aa[i+1];
                    aa[i+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(aa));*/

        /*int[]aa={-1,-5,5,20,2};
        for (int j = 0; j < aa.length-1; j++) {
            int min=aa[j];
            int index=j;
            for (int i = 1+j ; i <aa.length ; i++) {
                if (aa[i]<min){
                    min=aa[i];
                    index=i;
                }
            }
            aa[index]=aa[j];
            aa[j]=min;
        }
        System.out.println(Arrays.toString(aa));*/


        /**
         *插入排序思想：把n个待排序的元素堪称一个有序表和一个无序表，开始时有序表中只包含一个元素，
         *无序表中包含n-1个元素，排序过程中每次从无序表中取出第一个元素，把它的排序码一次与有序码进行比较
         * 将他插入到有序表中的适当位置，使之称为i虚拟的有序表
         */
        /*int[]aa={-1,-5,5,20,2};
        for (int i = 1; i < aa.length; i++) {
            int insertValue=aa[i];
            int index=i-1;
            while (index>=0&&insertValue<aa[index]){
                aa[index+1]=aa[index];
                index--;
            }
            aa[index+1]=insertValue;
        }
        System.out.println(Arrays.toString(aa));*/

        /*
        此方法插入位置就是插入值的下标位置和上面不同的就是这点
         */
        int insert=0;
        int index=0;
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

        for (int i = 1 ; i <arr.length; i++) {
            insert=arr[i];
            index=i;
            while (index>0&&insert<arr[index-1]){
                arr[index]=arr[index-1];
                index--;
            }
            arr[index]=insert;
        }

        System.out.println(Arrays.toString(arr));

    }
}





































