package com.ll.producerdata;

/**
 * @ClassName ValueOp
 * @Description
 * @Author 李振兴
 * @Date 2020/10/21 12:46
 **/
public class ValueOp {
    String value="";
    public void setValue(){
        synchronized (this){
            while (!value.equals("")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.value=System.currentTimeMillis()+"";
            System.out.println("设置value值为："+value);
            this.notifyAll();
        }
    }

    public void getvalue(){
        synchronized (this){
            while (value.equals("")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("取到value值为："+value);
            this.value="";
            this.notifyAll();
        }
    }
}
