package com.ll.producerdata;

/**
 * @ClassName test
 * @Description
 * @Author 李振兴
 * @Date 2020/10/21 13:01
 **/
public class test {
    public static void main(String[] args) {
        ValueOp valueOp = new ValueOp();
        ProducerThread producer = new ProducerThread(valueOp);
        ComsumerThread comsumer = new ComsumerThread(valueOp);
        ProducerThread producer1 = new ProducerThread(valueOp);
        ComsumerThread comsumer1 = new ComsumerThread(valueOp);
        ProducerThread producer2 = new ProducerThread(valueOp);
        ComsumerThread comsumer2 = new ComsumerThread(valueOp);

        producer.start();
        comsumer.start();
        producer1.start();
        comsumer1.start();
        producer2.start();
        comsumer2.start();
    }
}
