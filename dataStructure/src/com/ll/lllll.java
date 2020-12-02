package com.ll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName lllll
 * @Description
 * @Author 李振兴
 * @Date 2020/11/21 2:02
 **/
public class lllll {
    public static void main(String[] args) {
        String str="abcabcabc";
        System.out.println(one(str));
    }
    public static int lengthOfLongestSubstring(String s) {
        int start=0,count=0,logest=0;
        int[] a=new int[128];
        int j=0;
        while(j<a.length){
            a[j]=-1;
            j++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(a[s.toCharArray()[i]]<start){
                a[s.toCharArray()[i]]=i;
                count++;
            }else {
                if (count>logest)
                    logest=count;
                count=i-a[s.toCharArray()[i]];
                start=a[s.toCharArray()[i]]+1;
                a[s.toCharArray()[i]]=i;
            }
        }
        if (count>logest)
            logest=count;
        return logest;
    }
    public static int one(String s){
        // 建立一个数组，下标是char的ASCII值
        int[] last = new int[128];
        //给数组每个char下标的数组赋值为-1表示开始位置的前一个位置
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        //窗口长度
        int res = 0;
        // 窗口开始位置
        int start = 0;
        for(int i = 0; i < n; i++) {
            //获取每个字符对应的ASCII值，作为数组的下标，因为下标是唯一的如果出现重复的字符，那么他们的ASCII值一定相等
            //字符存储在数组中的位置
            int index = s.charAt(i);
            //窗口开始位置，如果这个下标存储的元素已经在数组中存储过了，那么读取他的存储位置，窗口就从他原来存储过的位置的下一个坐标开始，因为那个数已经出现过依次。
            start = Math.max(start, last[index] + 1);
            //窗口的大小，如果存储的值没有在数组中存储过，那么每次存储他都会随着i加而增加，如果那个数存储过，那么就要减去窗口的位置，因为你进行了一次新的窗口，前面的窗口应该忽略掉，前面如果不忽略掉那里面就会有有重复的值存在。为什么要+1是因为，窗口的位置是从0开始的
            res   = Math.max(res, i - start + 1);
            //字符数组在字符串中的位置，index是数组的下标也就是字符串的值，数组的值是字符出现在s这个字符串中的位置
            last[index] = i;
        }

        return res;
    }
}
