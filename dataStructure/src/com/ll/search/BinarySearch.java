package com.ll.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinarySearch 二分查找法
 * @Description
 * @Author 李振兴
 * @Date 2020/9/20 11:18
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={4,8,9,18,28,55,64,99,100,100,100,100};
        /*int i = Binary(arr, 0, arr.length - 1, 4);
        System.out.println(i);*/

        List list = Binary2(arr, 0, arr.length - 1, 100);
        System.out.println(list);
    }

    /**
     * 利用递归的二分查找法
     * @param arr 要查找的有序数组
     * @param left 左边开始位置的下标
     * @param right 右边结束位置的下标
     * @param findVal 你要查找的值
     * @return 返回查找到的值的下标
     */
    public static int Binary(int[]arr,int left,int right,int findVal){
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if (right<left){
            return -1;
        }
        if (findVal>midVal){
            return Binary(arr,mid+1,right,findVal);
        }else if (findVal<midVal){
            return Binary(arr,left,mid-1,findVal);
        }else {
            return mid;
        }
    }

    public static List Binary2(int[]arr,int left,int right,int findVal){
        int mid=(left+right)/2;
        int midVal=arr[mid];
        if (right<left){
            return new ArrayList<Integer>();
        }
        if (findVal>midVal){
            return Binary2(arr,mid+1,right,findVal);
        }else if (findVal<midVal){
            return Binary2(arr,left,mid-1,findVal);
        }else {
            /*
            判断mid左边和右边是否还有值和它一样，有就返回
             */
            List<Integer> count=new ArrayList<Integer>();
            int temp=mid-1;
            while (true){
                if (temp<0||arr[temp]!=findVal){
                    break;
                }
                count.add(temp);
                temp--;
            }
            count.add(mid);
            temp=mid+1;
            while (true){
                if (temp>arr.length-1||arr[temp]!=findVal){
                    break;
                }
                count.add(temp);
                temp++;
            }
            return count;
        }
    }
}
