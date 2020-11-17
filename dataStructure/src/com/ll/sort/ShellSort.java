package com.ll.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
        //int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

        // 创建要给80000个的随机的数组
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //shellSort(arr); //交换式
        shellSort2(arr);//移位方式

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        //System.out.println(Arrays.toString(arr));
    }

    // 使用逐步推导的方式来编写希尔排序
    // 希尔排序时， 对有序序列在插入时采用交换法,
    // 思路(算法) ===> 代码
    public static void shellSort(int[] arr) {

        int temp = 0;
        int count = 0;
        // 根据前面的逐步分析，使用循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }

		/*

		// 希尔排序的第1轮排序
		// 因为第1轮排序，是将10个数据分成了 5组
		for (int i = 5; i < arr.length; i++) {
			// 遍历各组中所有的元素(共5组，每组有2个元素), 步长5
			for (int j = i - 5; j >= 0; j -= 5) {
				// 如果当前元素大于加上步长后的那个元素，说明交换
				if (arr[j] > arr[j + 5]) {
					temp = arr[j];
					arr[j] = arr[j + 5];
					arr[j + 5] = temp;
				}
			}
		}

		System.out.println("希尔排序1轮后=" + Arrays.toString(arr));//


		// 希尔排序的第2轮排序
		// 因为第2轮排序，是将10个数据分成了 5/2 = 2组
		for (int i = 2; i < arr.length; i++) {
			// 遍历各组中所有的元素(共5组，每组有2个元素), 步长5
			for (int j = i - 2; j >= 0; j -= 2) {
				// 如果当前元素大于加上步长后的那个元素，说明交换
				if (arr[j] > arr[j + 2]) {
					temp = arr[j];
					arr[j] = arr[j + 2];
					arr[j + 2] = temp;
				}
			}
		}

		System.out.println("希尔排序2轮后=" + Arrays.toString(arr));//

		// 希尔排序的第3轮排序
		// 因为第3轮排序，是将10个数据分成了 2/2 = 1组
		for (int i = 1; i < arr.length; i++) {
			// 遍历各组中所有的元素(共5组，每组有2个元素), 步长5
			for (int j = i - 1; j >= 0; j -= 1) {
				// 如果当前元素大于加上步长后的那个元素，说明交换
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println("希尔排序3轮后=" + Arrays.toString(arr));//
		*/
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {

        // 增量gap, 并逐步的缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j-gap];
                        j -= gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }

            }
        }
    }

}
class shell{
    public static void main(String[] args) {
        /*
        假设十一个数分成五个步长那么每个组就有两个数，第一组就三个数，那个数的下标是不会超过lenght的
        先对第一组进行排序，在对第二组进行排序，最后一组直接设置好位置无序排序
        每个组里面的排序的方式选择插入排序。所以可以直接调用插入排序；
        两个步长就分成两组进行排序。
        依次类推一个步长就分成1组进行排序
         */

        int []arr={0,18,22,6,8,99,1,9,4,3,8,7,22,44,66,88};
        //每次循环设置不同步长直到减到1为止，步长的设置至今没有一个最好的选择，这是希尔排序最大的一个争议
        for (int step = arr.length / 2; step > 0; step /= 2) {
            //step是步长，就是分几组排列，col代表第0组排列到到step-1组
            for (int col = 0; col < step; col++) {//对第col列进行排序
                /**
                 * 第一组第一个值下标是col、第二个下标是col+step、第三个下标是col+2*step他的下标不能超过lenght超过代表越界了
                 * 这里直接调用插入排序来对每一组进行排序，从第col+step个开始排序，第一个元素没必要拍因为他是第一个元素
                 */
                for (int begin=col+step;begin<arr.length;begin+=step){
                    //记录开始排序的那个值
                    int insert=arr[begin];
                    //记录这个值的下标用来移动前一个元素
                    int cur=begin;
                    //当cur的值小于col时，代表已经到最前面了那个位置了，他是从col开始排的肯定不能小于col小于的话代表排到前一组去了，
                    //如果此时是第一组那么就没有前一组了那就下标越界了
                    while (cur>col&&insert<arr[cur-step]){
                        arr[cur]=arr[cur-step];
                        //再往前比较直到到达最前面或者这个值比前面那个值大时退出循环
                        cur-=step;
                    }
                    //说明当前值比前面那个值大所以直接插入当前位置即可
                    arr[cur]=insert;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
