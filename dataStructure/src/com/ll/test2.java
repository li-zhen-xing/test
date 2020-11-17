package com.ll;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName test2
 * @Description
 * @Author 李振兴
 * @Date 2020/10/21 10:19
 **/
public class test2 extends Exception {
    public test2(String message) {
        super(message);
    }
}
class ex{
    static ReentrantLock Lock = new ReentrantLock(true);
    public static void main(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                int a=1;
                char num=65;
                int x=1;
                while (true){
                    try {
                        Lock.lock();
                        if (a%2==0){

                            if (num>90){
                                num=65;
                                System.out.println(num);
                            }else {
                                System.out.println(num);
                            }
                            num++;
                            a++;
                        }else {
                            System.out.println(x);
                            x++;
                            a++;
                        }
                    }finally {
                        Lock.unlock();
                    }
                }
            }
        };
        new Thread(runnable).start();
    }
}
