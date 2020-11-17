package com.ll.recursion;

/**
 * @ClassName Queen8
 * @Description
 * @Author 李振兴
 * @Date 2020/9/15 10:05
 **/
public class Queen8 {
    public static void main(String[] args) {
        Queen8 queen=new Queen8();
        //只能从第0个位置开始摆放（因为计算机是从第0个位置开始计算的回溯的）
        queen.check(0);

    }
    int max=8;
    //定义一个一维数组接受皇后位置，因为每一行只能摆一个皇后所以可以直接定义成一维数组
    int[]arry=new int[max];

    //打印皇后位置，当数组赋值完成后打印
    private void print(){
        for (int i = 0; i < 8; i++) {
            System.out.print(arry[i]+" ");
        }
        System.out.println();
    }

    //判当前位置是否与上面的所有位置产生冲突
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (arry[i]==arry[n]||Math.abs(n-i)==Math.abs(arry[n]-arry[i])){
                return false;
            }
        }
        return true;
    }

    //摆放皇后
    private void check(int n){
        if (n==max){
            print();
            return;//return代表当前函数结束，回溯到上一个调用它的函数又开始回溯，直至回溯到栈底就结束该方法。
        }
        for (int i = 0; i < max; i++) {
            arry[n]=i;//把当前皇后放到第一个位置
            if (judge(n)){  //判断当前位置是否与上面所有位置是否产生冲突，产生冲突就直接往下走再一次for循环，位置移动一下
                check(n+1);
            }
        }
    }
}
