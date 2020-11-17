package com.ll.tree;

import java.util.Arrays;

/**思路：利用大顶堆树结构来实现堆排序。
 * 原理：把数组按照大顶堆的形式存储每一个数据，大顶堆树特有的构造每一个父节点的值都大于它的两个字节点的值
 * 把数组排列成大顶堆树形结构时（这里的树形结构并不是真正的一颗树，而是排列方式和树的方式一样）
 * 然后把大顶堆树结构中的跟节点取出，再形成一颗大顶堆树再取出它的根节点依次取出一次形成大顶堆树，这样就形成了一个有序的数组
 * i下标这个节点对应的子节点下标为i*2+1，i*2+2
 * 第一个非叶子节点下标为arr.lenght/2-1
 * @ClassName HeapSort
 * @Description
 * @Author 李振兴
 * @Date 2020/9/26 11:43
 **/
public class HeapSort {
    public static void main(String[] args) {
        int arr[]={4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int arr[]){
        int temp=0;
        System.out.println("堆排序");
        //因为此刻还不是大顶堆树，所以从第一个非叶子节点开始调整成大顶堆树=>9, 6, 8, 5, 4
        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        /**
         * 将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端；
         * 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
         */
        for (int j = arr.length-1; j >0 ; j--) {
            //先记录arr[j]这个位置的值
            temp=arr[j];
            //交换，先把arr[j]这个位置赋值为9
            arr[j]=arr[0];
            //再把大顶堆树根的值用temp覆盖
            arr[0]=temp;
            //每交换一次树的长度就减少1而且减少的那个值是树的根，然后每次用数组的末端（没有发生交换的值）来代替根重新调整成树
            //从第0个位置开始调整，因为它之前已经是一颗大顶堆树了，所以可以直接从0开始调整无需重复多余的调整步骤
            adjustHeap(arr,0,j);
        }

    }

    /**
     * 功能：完成将以i对应的非叶子节点的树调整成大顶堆
     * 举例 int arr[]={4,6,8,5,9}; =>i=1=>adjustHeap=>得到{4，9，8，5，6}
     * 如果我们再次调用adjustHeap传入的是=>i=0=>adjustHeap=>得到{9，6，8，4，5}
     * @param arr 待调整的数组
     * @param i 非叶子节点再数组中的索引
     * @param lenght 表示对多少个元素继续调整，lenght势在逐渐减少
     */
    public static void adjustHeap(int arr[],int i,int lenght){
        int temp=arr[i];//先取出当前元素的值，保存再临时变量中
        //开始调整
        //说明
        //1.k=i*2+1是i节点的左子节点
        for (int k=i*2+1;k<lenght;k=k*2+1){
            if (arr[k]<arr[k+1]){//说明左子节点的值小于右子节点的值
                k++;//k 指向右子节点
            }
            if (arr[k]>temp){//如果子节点大于父节点
                arr[i]=arr[k];//把较大的值赋给当前节点
                i=k;//！！！i指向k，继续循环比较
            }else{
                break;
            }
        }
        //当for循环结束后，我们已经将i为父节点的最大值，放在了最顶(局部，以i为父节点)
        arr[i]=temp;
    }
}















