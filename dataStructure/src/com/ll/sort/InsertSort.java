package com.ll.sort;

import java.util.Arrays;

/**
 * @ClassName InsertSort
 * @Description
 * @Author 李振兴
 * @Date 2020/9/15 21:58
 **/
public class InsertSort {
    /**
     *插入排序思想：把n个待排序的元素堪称一个有序表和一个无序表，开始时有序表中只包含一个元素，
     *无序表中包含n-1个元素，排序过程中每次从无序表中取出第一个元素，把它的排序码一次与有序码进行比较
     * 将他插入到有序表中的适当位置，使之称为i虚拟的有序表
     */

    /*
    插入排序抽象成一个抓牌，如果抓的是第一张就不需要进行排序，没必要，如果抓的第二张就要和第一张牌进行比较，
    如果抓的第三张就需要和前面两站比较，第四张和前面三张比较。
     */
    public static void main(String[] args) {

        int[] arr={8,2,-1,9,3};

        //从抓的第二张牌开始排序
        for (int begin=1;begin<arr.length;begin++){
            //抽象理解
            //先记录抓的第二张牌大小
            int insert=arr[begin];
            //这是抓的第二张牌
            int cur=begin;
            //如果第二张牌比第一张牌小就要把第二张牌插入到第一张的位置，一直找位置直到正确为止。
            while (cur>0&&insert<arr[cur-1]){
                //把第一张牌的移到第二张牌
                arr[cur]=arr[cur-1];
                //继续往前比较
                cur--;
            }
            //如果没进入循环代表位置是正确的
            arr[cur]=insert;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void insert(int[]aa){
        for (int i = 1; i < aa.length; i++) {
            int insertValue=aa[i];
            //第几个要插入的值的前一个位置。根据它的思想来的不好理解的话看下思想就知道了
            int insertIndex=i-1;
            //当第几个要插入的值小于它当位置的前一个位置的值时会把它前一个位置的值往后面移动一个位置
            while (insertIndex>=0&&insertValue<aa[insertIndex]){
                //往后面移动一个位置
                aa[insertIndex+1]=aa[insertIndex];
                //第一个要插入值的前一个位置，再往前移动一个位置。如果那个值小于0时会结束循环，防止数组下标越界
                insertIndex--;
            }
            //这里不太好理解。举例如果你第一个要插入的值大于它当前位置的前一个位置的值时，
            // 他不会进入循环。那么它要插入的位置就是，它当前，前面一个位置再加一。就是原位置。
            //（当他跳出循环也就是找到要插入的位置时，此时的insertIndex是它要插入位置的前一个位置所以要加1）
            aa[insertIndex+1]=insertValue;
        }

    }
}