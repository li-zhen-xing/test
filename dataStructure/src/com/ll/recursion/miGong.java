package com.ll.recursion;

/**
 * @ClassName miGong
 * @Description
 * @Author 李振兴
 * @Date 2020/9/14 22:29
 **/
public class miGong {
    public static void main(String[] args) {
        int map[][] = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
/*        map[1][2] = 1;
        map[2][2] = 1;*/
        /*for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }*/
        Boolean aa=setWay(map, 1, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println(aa);
    }

    //重要的一点！！！！
    //搞清楚return的含义这个方法就很简单明了了，
    //return的定义：结束当前函数。
    //在递归方法中他遇到了函数他就会从这个位置进去调用它，如果再后面它还调用了也会接着调用直到这个方法结束或者return了他就会返回到上一次调用他的位置
    // 那么此刻他就开始从调他本身的位置开始执行，如果执行过程中还遇到了递归函数那他就继续接着调用直到这个调用的函数正常结束或者return了。
    // {注意，它执行的位置是他调用函数的入口处开始往下执行}搞清这点很重要
    //就拿这两个点map[1][2] = 1;map[2][2] = 1;设置为1来举例，当他设置为1时，如果从1，1开始他会把自己设置为2然后执行if中的setWay(map, i + 1, j)递归方法
    //进去后因为map【2，1】(由于简便直接写成[])的值为0他会进入if (map[i][j] == 0) 中，然后设置map【2，1】=2；后面先是进入setWay(map, i + 1, j)递归方法
    //它传的值为(int[][] map, int i, int j)i=3，j=1，由于map【3，1】=1；所以直接return，{那么直接结束这个函数回到调用这个函数的位置开始往下执行}，他会依次调用下面的方法
    // 把map设置为3，此刻它还是返回false他会回到他的上一个位置也就是调用函数进入这个位置的位置依次往下执行也会把map设置为3那么此刻回到main程序中直接退出setway这个方法
    //相当于栈里面的这个栈变成一个空栈了，每执行一次调用自己本身都相当于入栈，栈满了就按顺序出栈直到到底底部结束这个方法。


    //这里的true和false的以随便设置，作用是用来跳出循环。。如果你要判断小球是否可以到达规定的点此刻设置true和false是有用的。
    //但是只有最后一个循环那个true和false的值才能起到作用其他中间设置的都可以随便设，他们的作用用来跳出当前函数
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                    //小球往下走
                if (setWay(map, i + 1, j)) {
                    return true;
                    //小球往右走
                } else if (setWay(map, i, j + 1)) {
                    return true;
                    //小球往上走
                } else if (setWay(map, i - 1, j)) {
                    return true;
                    //小球往左走
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
