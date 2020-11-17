package com.ll.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName SelectSort
 * @Description
 * @Author 李振兴
 * @Date 2020/9/15 19:58
 **/
public class SelectSort {
    /*
    1.选择排序一共有数组大小减一轮排序
    2.每一轮排序，有时一个循环，循坏的规则
    2.1先假定当前这个数是最小数
    2.2然后和后面的每个数进行比较，如果发现有比当前等效的数就重新确定最小数，并得到下标
    2.3当遍历到数组的最后是，就得到本轮最小数和下标
    2.4交换值
     */
    public static void main(String[] args) {
/*        int[] arr={2,8,-1,9,3};
        int[] lalal={-8,9,100,50,-2,-99};
        new SelectSort().Select(lalal);
        System.out.println(Arrays.toString(lalal));*/

/*        //性能测试冒泡排序的时间复杂度是O(n^2)
        //速度明显快于冒泡排序法
        int []bb=new int[80000];
        for (int i = 0; i < 80000; i++) {
            bb[i]=(int)(Math.random()*80000);
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dd=simpleDateFormat.format(date);
        System.out.println(dd);
        new SelectSort().Select(bb);
        Date dat=new Date();
        String cc=simpleDateFormat.format(dat);
        System.out.println(cc);*/

        //System.out.println(Arrays.toString(arr));
/*        //第一轮
        //先假设第一个数字是最小值
        int min=arr[0];
        //假设最小值的下标是0
        int index=0;
        //从第二个位置开始和假设的值比较
        for (int i = 0+1; i < arr.length; i++) {
            //如果假设的值大于比较的值的话那就把比较的值赋给假设的最小值下标也一样
            if (min>arr[i]){
                //主要目的记录最小值的大小和下标
                min=arr[i];
                index=i;
            }
        }
        //如果当前值确实是最小值那就不需要进行交换，index的值也就不会发生改变
        if (index!=0) {
            //把假设的最小值和真实的最小值位置进行互换，改变真实最小值位置的值把假设的最小值赋给它
            arr[index] = arr[0];
            //把真实的最小值赋给开始的位置
            arr[0] = min;
        }
        System.out.println(Arrays.toString(arr));

        //第二轮
        min=arr[1];
        index=1;
        for (int i = 0+1+1; i < arr.length; i++) {
            if (min>arr[i]){
                min=arr[i];
                index=i;
            }
        }
        if(index!=1) {
            arr[index] = arr[1];
            arr[1] = min;
        }
        System.out.println(Arrays.toString(arr));

        //第三轮
        min=arr[2];
        index=2;
        for (int i = 0+1+1; i < arr.length; i++) {
            if (min>arr[i]){
                min=arr[i];
                index=i;
            }
        }
        if (index!=2) {
            arr[index] = arr[2];
            arr[2] = min;
        }
        System.out.println(Arrays.toString(arr));

        //第四轮
        min=arr[3];
        index=3;
        for (int i = 0+1+1+1; i < arr.length; i++) {
            if (min>arr[i]){
                min=arr[i];
                index=i;
            }
        }
        if (index != 3) {
            arr[index] = arr[3];
            arr[3] = min;
        }
        System.out.println(Arrays.toString(arr));

*/
    }
    public void Select(int[] arr){
        for (int j = 0; j < arr.length-1; j++) {
            //先假设第一个数字是最小值
            int min=arr[j];
            //假设最小值的下标是0
            int index=j;
            //从第二个位置开始和假设的值比较
            for (int i = j+1; i < arr.length; i++) {
                //如果假设的值大于比较的值的话那就把比较的值赋给假设的最小值下标也一样
                if (min>arr[i]){
                    //主要目的记录最小值的大小和下标
                    min=arr[i];
                    index=i;
                }
            }
            //如果当前值确实是最小值那就不需要进行交换，index的值也就不会发生改变
            if (index!=j) {
                //把假设的最小值和真实的最小值位置进行互换，改变真实最小值位置的值把假设的最小值赋给它
                arr[index] = arr[j];
                //把真实的最小值赋给开始的位置
                arr[j] = min;
            }
        }
    }
}

