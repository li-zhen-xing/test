package com.ll.queue;

import java.util.Scanner;

/**
 * @ClassName CircleQueueArray
 * @Description
 * @Author 李振兴
 * @Date 2020/9/11 12:24
 **/
public class CircleQueue {
        public static void main(String[] args) {
        //创建一个队列
        Queue queue = new Queue(4);
        char key=' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            key=scanner.next().charAt(0);//接受一个字符
            switch (key){
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value=scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res=queue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case'h':
                    try {
                        int res=queue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
class Queue {
    private int maxSize;//数组最大的容量
    private int front;//队列头
    private int rear;//队列尾巴
    private int[] arr;//该数组用来存储数据，模拟队列

    //创建队列的构造器
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear+1)%maxSize ==front ;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断是否满
        if (isFull()) {
            System.out.println("队列满，不能添加");
            return;
        }
        arr[rear] = n;
        rear=(rear+1)%maxSize;//让rear后移
    }

    //获取队列的数据，出队列a
    public int getQueue() {
        //判断是否为空
        if (isEmpty()) {
            //通过抛出异常来处理
            throw new RuntimeException("队列空，不能取数据");
        }
        int value=arr[front];
        front=(front+1)%maxSize;//front后移
        return value;
    }

    //显示队列所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列是空的");
            return;
        }
        for (int i = front; i <front+ (rear+maxSize-front)%maxSize; i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }
    }

    //显示队列的头数据，不是取出数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列是空的，没有数据");
        }
        return arr[front];
    }
}

/*
 取模的原因是形成一个环形数组，内存中并不存在这样的环形存储结构，只是借助数组来进行抽象成一个环形
 具体实现概念如下：
 当数组达到了他的界限时循环数组会进行判断禁止添加元素，当取掉一个元素时，front的值会发生变化，front会+1，当添加一个值时循环数组会把他的rea下标进行
 加1（此时加上1如果大于循环数组的maxsize时他会）把rear的值重新从变为0，因为此刻数组是没满的
 （其实此刻的没满他只是抽象为一个没满，它实际是有值的，默认值是0如果rear经过一个循环，那么它的值是上一个取出来的元素的值但是此刻front下标加了1所以，这个值相当于被弃用了）
 它的front已经加了1所以可以添加，所以rear会变成0这个下标。
 */

//0 = 0; 1 = 0; 2 = 0; 3 = 0
//0 = 11; 1 = 0; 2 = 0; 3 = 0
//0 = 11; 1 = 22; 2 = 0; 3 = 0
//0 = 11; 1 = 22; 2 = 33; 3 = 0  rear3 front1

//取出11
//front=1 rear3
//0 = 11; 1 =22; 2 = 33; 3 = 0
//取出22
//front=2 rear3
//0 = 11; 1 =22; 2 = 33; 3 =0
//取出33
//front=3
//0 = 11; 1 =22; 2 = 33; 3 =0

//添加44
//front=3 rear0
//0 = 11; 1 =22; 2 = 33; 3 =44

//添加55
//front=3 rear1
//0 = 55; 1 =22; 2 = 33; 3 =44

//添加66
//front=3 rear2
//0 = 55; 1 =66; 2 = 33; 3 =44