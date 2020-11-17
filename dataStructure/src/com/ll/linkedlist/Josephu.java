package com.ll.linkedlist;

import javax.swing.*;

/**
 * @ClassName Josephu
 * @Description
 * @Author 李振兴
 * @Date 2020/9/13 0:48
 **/
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        list.addBoy(5);
//        list.showBoy();
        list.countBoy(1,2,5);
    }
}



//创建一个环形的链表
class CircleSingleLinkedList{
    //创建第一个节点
    private Boy first=null;

    //添加boy，
    public void addBoy(int nums){
        if (nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        //创建一个辅助节点来指向first因为第一个头部是不能动的，借助辅助节点来添加数据
        Boy cur=null;
        for (int i = 1; i <=nums ; i++) {
            Boy boy = new Boy(i);
            //第一个first比较特殊，他的next是指向自己的
            if (i==1){
                first=boy;
                first.setNext(first);
                cur=first;
            }
            cur.setNext(boy);
            boy.setNext(first);
            cur=boy;
        }
    }

    //遍历
    public void showBoy(){
        if (first==null){
            System.out.println("没有任何小孩");
            return;
        }
        Boy cur=first;
        while (true){
            System.out.println("小孩编号为"+cur.getNo());
            if (cur.getNext()==first){
                break;
            }
            cur=cur.getNext();
        }
    }

    /**
     * 创建josep约瑟夫环形链表
     * @param satrtNo 开始的小孩位置
     * @param countNum  数几次
     * @param nums  一开始多少个小孩
     */
    public void countBoy(int satrtNo,int countNum,int nums){
        //先对数据进行校验
        if (first==null||satrtNo==0||satrtNo>nums){
            System.out.println("参数输入错误");
            return;
        }
        //创建它指向first的后一个元素，目的是这个链表是个单向环形链表他的出圈必须找到后一个元素才能出圈
        Boy helper =first;
        while (true) {
            //如果helper的下一个元素等于first相当此时helper于它跑完了整个循环
            if (helper.getNext()==first){
                break;
            }
            //如果循环还没有跑完就让helper等于它的下一个next继续接着跑知道helper等于first为止。此时的helper为最后一个元素
            helper=helper.getNext();
        }
        //这里的循环是小孩开始的位置，从第几个开始就让first和helper的位置往前移动startNo-1
        for (int i = 0; i <satrtNo-1; i++) {
            first=first.getNext();
            helper=helper.getNext();
        }
        //数几次代表从第几个开始出列，然后每次都是从第几个开始出列，直到helper和first相等只有一个元素就跳出循环
        while (true){
            if (helper==first){
                break;
            }
            for (int i = 0; i < countNum-1; i++) {
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.println("小孩"+first.getNo()+"出圈");
            //first指向他的下一个节点，此时的first没有应用来应用它会被垃圾回收器回收
            first=first.getNext();
            //helper指向下一个新的first节点
            helper.setNext(first);
        }
        System.out.println("最后留在圈中的小孩编号"+first.getNo());
    }

}

//创建一个boy类标识一个节点
class Boy{
    private int no;//编号
    private Boy next;//指向下一个节点默认是null
    public Boy (int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}