package com.ll.stack;


import java.util.Scanner;

/**
 * @ClassName ArrayStackDemo
 * @Description
 * @Author 李振兴
 * @Date 2020/9/13 11:40
 **/
public class ArrayStackDemo {
    private int maxsize;
    private int stack[];
    private int top =-1;

    //定义栈的size
    public ArrayStackDemo(int maxsize) {
        this.maxsize = maxsize;
        stack=new int[this.maxsize];
    }

    //
    public boolean isFull(){
        return top==maxsize-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void push(int num){
        if (isFull()){
            System.out.println("栈已经满了添加失败");
            return;
        }
        top++;
        stack[top]=num;
    }

    public int pop(){
       if (isEmpty()){
           throw new RuntimeException("栈是空的了");
         }
          int po=stack[top];
          top--;
          return po;
    }

    public void show(){
        if (isEmpty()){
            System.out.println("栈是空的，没有数据");
            return;
        }
        //需要从栈的顶部开始往下打印
        for (int i = top; i >=0; i--) {
            System.out.println(stack[i]);
        }
    }
}

class test{
    public static void main(String[] args) {
        ArrayStackDemo stackDemo = new ArrayStackDemo(5);
        String key="";
        Scanner scanner=new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：表示添加数据到栈");
            System.out.println("pop：表示从栈取出数据");
            System.out.println("请输入你的选择");
            key=scanner.next();
            switch (key){
                case "show":
                    stackDemo.show();
                    break;
                case "exit":
                    flag=false;
                    break;
                case"push":
                    System.out.println("请输入一个数");
                    int value=scanner.nextInt();
                    stackDemo.push(value);
                    break;
                case "pop":
                    try{
                        System.out.println("你所取出来的数是"+stackDemo.pop());
                    }catch (Exception e){
                        System.out.println("栈是空的");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出程序");
    }
}
