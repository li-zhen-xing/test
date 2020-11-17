package com.ll.recursion;

/**
 * @ClassName RecursionTest
 * @Description
 * @Author 李振兴
 * @Date 2020/9/14 20:26
 **/
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
    }
    public static void test(int n){
        System.out.println("你好");
        if (n==1){
            return;
        }
        else {
            test(n-1);
        }

        System.out.println("n="+n);
    }
}
//你好 f3 你好 f2 你好 f1