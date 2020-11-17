package com.ll.producerdata;

/**
 * @ClassName ProducerThread
 * @Description
 * @Author 李振兴
 * @Date 2020/10/21 12:56
 **/
public class ProducerThread extends Thread {
    ValueOp valueOp;

    public ProducerThread(ValueOp valueOp) {
        this.valueOp=valueOp;
    }

    public void ProducerThread(ValueOp valueOp){
        this.valueOp=valueOp;
    }

    @Override
    public void run() {
        while (true){
            valueOp.setValue();
        }
    }
}
