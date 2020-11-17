package com.ll.hashtab;

import java.util.Scanner;

/** 哈希表，是一个数组和链表组成的数据结构，用一个数组来存储链表，值存在链表中，链表存在数组中。
 * @ClassName HashTabDemo
 * @Description
 * @Author 李振兴
 * @Date 2020/9/20 22:52
 **/
public class HashTabDemo {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("添加请输入add");
            System.out.println("查找请输入show");
            System.out.println("退出请输入exit");
            String next = scanner.next();
            switch (next) {
                case "add":
                    System.out.println("请输入ID");
                    int id = scanner.nextInt();
                    System.out.println("请输入名字");
                    String name = scanner.next();
                    hashTab.add(new Emp(id, name));
                    break;
                case "show":
                    hashTab.list();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}

class Emp{
    int id;
    String name;
    Emp next;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList{
    Emp head;
    public void add(Emp emp){
        Emp curEmp=head;
        if (curEmp==null){
            head=emp;
            return;
        }
        while (true){
            if (curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        curEmp.next=emp;
    }

    public void list(){
        if (head==null){
            System.out.println("链表为空");
            return;
        }
        Emp curEmp=head;
        while (true){
            System.out.println("ID为："+curEmp.id+"名字为："+curEmp.name);
            if (curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
    }
}

class HashTab{
    private EmpLinkedList [] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedListArray=new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i]=new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        int no=emp.id%size;
        empLinkedListArray[no].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list();
        }
    }
}



























