package com.ll.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @ClassName BubbleSort
 * @Description
 * @Author 李振兴
 * @Date 2020/9/15 16:15
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int [] arr={-1,-3,9,8,7};
/*       //性能测试冒泡排序的时间复杂度是O(n^2)
        int []bb=new int[80000];
        for (int i = 0; i < 80000; i++) {
            bb[i]=(int)(Math.random()*80000);
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dd=simpleDateFormat.format(date);
        System.out.println(dd);
       new BubbleSort().bubble(bb);
        Date dat=new Date();
        String cc=simpleDateFormat.format(dat);
        System.out.println(cc);*/

        //System.out.println(Arrays.toString(arr));


    }

    //冒泡排序
    public void bubble(int[] arr){
        //设置一个标志假设后面的比较没有发生值的交替，那就是有序的则不要在继续比较下去了直接跳出循环
        boolean flag=false;

        //一共要比较lenght-2次，因为数组长度为lenght从0开始所以循环lenght-1次，假设所有都是倒序的最多也就比较lenght-2次
        for (int j=0;j<arr.length-2;j++){
            //temp的作用用来做一个中间转化量帮助arr[i]>arr[i+1]做转换的
            int temp =0;
            //每循环一次就比较出最大值放到末尾，因为下一次无需比较最大值只需要找到第二大即可所以lenght-1-j
            for (int i = 0; i < arr.length-1-j; i++) {
                if (arr[i]>arr[i+1]){
                    //如果发生比较则把flag设置为true
                    flag=true;
                    temp=arr[i+1];
                    arr[i+1]=arr[i];
                    arr[i]=temp;
                }
            }
            //如果flag为false则跳出循环，说明没有进行值的交换
            if (!flag){
                break;
            }else {
                //如果发生了比较那就把flag重置为false让flag不跳出下次循环（这里前提是没发生值的交换）发生值的交换一样跳出循环
                flag=false;
            }
        }
    }
}
class bubbleexplain{
    public static void main(String[] args) {
        int[] array = {-2,-10,100,90,12};
        //temp的作用用来做一个中间转化量帮助arr[i]>arr[i+1]做转换的
        int lala = 0;
        //每循环一次就比较出最大值放到末尾，因为下一次无需比较最大值只需要找到第二大即可所以l
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                //如果发生比较则把flag设置为true
                lala = array[i + 1];
                array[i + 1] = array[i];
                array[i] = lala;
            }
        }
        System.out.println("第一次排序"+Arrays.toString(array));

        for (int i = 0; i < array.length - 1-1; i++) {
            if (array[i] > array[i + 1]) {
                //如果发生比较则把flag设置为true
                lala = array[i + 1];
                array[i + 1] = array[i];
                array[i] = lala;
            }
        }
        System.out.println("第二次排序"+Arrays.toString(array));

        for (int i = 0; i < array.length - 1-1-1; i++) {
            if (array[i] > array[i + 1]) {
                //如果发生比较则把flag设置为true
                lala = array[i + 1];
                array[i + 1] = array[i];
                array[i] = lala;
            }
        }
        System.out.println("第三次排序"+Arrays.toString(array));

        for (int i = 0; i < array.length - 1-1-1; i++) {
            if (array[i] > array[i + 1]) {
                //如果发生比较则把flag设置为true
                lala = array[i + 1];
                array[i + 1] = array[i];
                array[i] = lala;
            }
        }
        System.out.println("第四次排序"+Arrays.toString(array));
    }

}
