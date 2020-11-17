package com.ll.producerdata;

/**
 * @ClassName ComsumerThread
 * @Description
 * @Author 李振兴
 * @Date 2020/10/21 13:00
 **/
public class ComsumerThread extends Thread  {
    ValueOp valueOp;

    public ComsumerThread(ValueOp valueOp) {
        this.valueOp=valueOp;
    }

    public void ComsumerThread(ValueOp valueOp){
        this.valueOp=valueOp;
    }

    @Override
    public void run() {
        while (true){
            valueOp.getvalue();
        }
    }
}
