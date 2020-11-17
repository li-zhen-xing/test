package com.ll.sort;

import java.util.Arrays;

/**基数排序
 * @ClassName RadixSort
 * @Description
 * @Author 李振兴
 * @Date 2020/9/19 23:33
 **/
public class RadixSort {
    public static void main(String[] args) {

    int arr[]={53,3,542,748,14,214};
    Radix(arr);
        System.out.println(Arrays.toString(arr));

/*
        //定义一个二维数组记录桶的个数和桶里面的数据
        int[][]bucket=new int[10][arr.length];
        //定义一个数组记录每个桶中有多少个数据。这个一维数组中值就是桶里面有几个值，一共有10个桶
        int[]bucketElementCounts=new int[10];
        //取出数组中的每一个值放入到桶中
        for (int i = 0; i < arr.length; i++) {
            //取得数组中末尾的数
            int num=arr[i]%10;
            //根据数组末尾的值选择对应的桶放入，bucketElementCounts[num]代表第num个桶里面有几个值最开始他的值为0然后放入这个值后它的值就加一
            bucket[num][bucketElementCounts[num]]=arr[i];
            //记录桶里面值的个数的数组加一
            bucketElementCounts[num]++;
        }
        //依次从第0个桶开始取出桶中数据放入排序数组中，z代表排序数组的下标从第0个开始给它赋值
        for (int i = 0,z=0; i < 10; i++) {
            //判断桶中是否有数据，有数据就取桶中数据
            if (bucketElementCounts[i]!=0){
                //取出第i个桶里面的所有数据，根据bucketElementCounts[i]的大小判断里面有几个值
                for (int j = 0; j <bucketElementCounts[i] ; j++) {
                    //把第i个桶里面的每一个值都赋给排序数组
                    arr[z]=bucket[i][j];
                    //每赋一个值下标就往后移动一个位置
                    z++;
                }
            }
            //当这个桶中的所欲数据都被取出时再清零，不然下一次循环会产生冲突
            bucketElementCounts[i]=0;
        }
        System.out.println(Arrays.toString(arr));

        //第二轮
        for (int i = 0; i < arr.length; i++) {
            int num=arr[i]/10%10;
            bucket[num][bucketElementCounts[num]]=arr[i];
            bucketElementCounts[num]++;
        }
        for (int i = 0,z=0; i < 10; i++) {
            if (bucketElementCounts[i]!=0){
                for (int j = 0; j <bucketElementCounts[i] ; j++) {
                    arr[z]=bucket[i][j];
                    z++;
                }
            }
            bucketElementCounts[i]=0;
        }
        System.out.println(Arrays.toString(arr));

        //第三轮
        for (int i = 0; i < arr.length; i++) {
            int num=arr[i]/100%10;
            bucket[num][bucketElementCounts[num]]=arr[i];
            bucketElementCounts[num]++;
        }
        for (int i = 0,z=0; i < 10; i++) {
            if (bucketElementCounts[i]!=0){
                for (int j = 0; j <bucketElementCounts[i] ; j++) {
                    arr[z]=bucket[i][j];
                    z++;
                }
            }
            bucketElementCounts[i]=0;
        }
        System.out.println(Arrays.toString(arr));

 */

    }
    public static void  Radix(int[] arr){
        //利用选择排序算法找出最大值，就是最大的位数
        int max=0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>max){
                max=arr[i];
            }
        }
        //获取最大值的位数
        int count= String.valueOf(max).length();
        //定义一个n用来区别每个数该放入哪个桶
        for (int h = 0,n=1; h < count; h++,n*=10) {
            //定义一个二维数组记录桶的个数和桶里面的数据
            int[][]bucket=new int[10][arr.length];
            //定义一个数组记录每个桶中有多少个数据。这个一维数组中值就是桶里面有几个值，一共有10个桶
            int[]bucketElementCounts=new int[10];
            //取出数组中的每一个值放入到桶中
            for (int i = 0; i < arr.length; i++) {
                //根据取模来取得数组中末尾的数
                int num=arr[i]/n%10;
                //根据数组末尾的值选择对应的桶放入，bucketElementCounts[num]代表第num个桶里面有几个值最开始他的值为0然后放入这个值后它的值就加一
                bucket[num][bucketElementCounts[num]]=arr[i];
                //记录桶里面值的个数的数组加一
                bucketElementCounts[num]++;
            }
            //依次从第0个桶开始取出桶中数据放入排序数组中，z代表排序数组的下标从第0个开始给它赋值
            for (int i = 0,z=0; i < 10; i++) {
                //判断桶中是否有数据，有数据就取桶中数据
                if (bucketElementCounts[i]!=0){
                    //取出第i个桶里面的所有数据，根据bucketElementCounts[i]的大小判断里面有几个值
                    for (int j = 0; j <bucketElementCounts[i] ; j++) {
                        //把第i个桶里面的每一个值都赋给排序数组
                        arr[z]=bucket[i][j];
                        //每赋一个值下标就往后移动一个位置
                        z++;
                    }
                }
                //当这个桶中的所欲数据都被取出时再清零，不然下一次循环会产生冲突
                bucketElementCounts[i]=0;
            }
        }
    }
}
