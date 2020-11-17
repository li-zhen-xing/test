package com.ll.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**快速排序本质：逐渐将每一个元素都转变为轴点元素
 * @ClassName quickSort
 * @Description
 * @Author 李振兴
 * @Date 2020/9/18 10:05
 **/
public class quickSort {

    public static void main(String[] args) {

        //测试快速排序速度
        int []bb=new int[80000];
        for (int i = 0; i < 80000; i++) {
            bb[i]=(int)(Math.random()*80000);
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dd=simpleDateFormat.format(date);
        System.out.println(dd);
        sort(bb,0,bb.length);
        Date dat=new Date();
        String cc=simpleDateFormat.format(dat);
        System.out.println(cc);

        /*int[]a={2,8,9,10,4,5,6,7};
        sort(a,0,a.length);
        System.out.println(Arrays.toString(a));*/
    }


    public static void sort(int[]arr,int begin,int end){
        //如果数只有一个元素就排好序了直接退出
        if (end-begin<2){
            return;
        }
        //获取中间轴点的下标
        int mid=pivotIndex(arr,begin,end);
        //对左边进行排序
        sort(arr,begin,mid);
        //对右边进行排序
        sort(arr,mid+1,end);
    }

    /**
     * 通过获取轴点来排序，每获取一次轴点都会对数组进行排序
     * @param arr
     * @param begin
     * @param end
     * @return 返回轴点的位置
     */
    public static int pivotIndex(int[] arr, int begin, int end) {
        //最开始选取轴点为最左边元素，先备份轴点位置的值
        int pivot = arr[begin];
        //末尾元素的下标是end-1
        end=end-1;
        //一直查找轴点直到找到轴点为止条件是end==begin代表找到了轴点
        while (begin < end) {
            while (begin < end) {
                //先从右往左排，如果end位置的值大于轴点的值，end直接往左移动一个位置（代表这个值放在轴点右边）
                if (pivot < arr[end]) {
                    end--;
                } else {
                    //如果end位置的值小于轴点的值，那就用end的值覆盖begin位置的值，因为begin最开始代表轴点的位置
                    //此时end位置那个值没有引用指向它是一个垃圾
                    arr[begin] = arr[end];
                    //覆盖后，begin往右边移动一个位置相当于把end位置的值放到了begin下标的左边
                    begin++;
                    //如果执行了这一步就跳出此次循环，需要换方向扫描，就要从左往右扫描
                    break;
                }
            }
            while (begin < end) {
                //从左边开始往右边扫描，如果左边的值小于轴点的值那就直接begin++代表把值放到轴点左边
                if (pivot > arr[begin]) {
                    begin++;
                } else {
                    //如果左边的值大于轴点的值，就把begin位置的值覆盖end那个位置没有引用指向它的垃圾位置的值
                    arr[end] = arr[begin];
                    //覆盖后，end往左边移动一个位置相当于把begin位置的值放到了end下标的右边
                    end--;
                    //如果执行了这一步就跳出此次循环，需要换方向扫描，就要从右往左扫描
                    break;
                }
            }
        }
        //当退出循环时代表它已经找到了轴点位置，轴点位置是end==begin，此刻再把备份的轴点位置的值覆盖上去
        arr[begin]=pivot;
        //返回轴点的位置
        return begin;
    }
}
