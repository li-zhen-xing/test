package com.ll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName test
 * @Description
 * @Author 李振兴
 * @Date 2020/10/19 9:59
 **/
public class test {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 100 ; i >0 ; i--) {
            integers.add(i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Collections.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (Integer AA:integers
        ) {
            //System.out.println(AA);
        }
        ArrayList<student> students = new ArrayList<>();

        student student1 = new student(1);
        student student2 = new student(8);
        student student3 = new student(71);
        student student4 = new student(6);
        student student5 = new student(2);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        Collections.sort(students);
        //students.sort(Collections.reverseOrder());
        for (student AA:students
        ) {
            System.out.println(AA.age);
        }
    }
}
class student implements Comparable<student>{
    int age;

    public student(int age) {
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(student o) {
        if (this.age>o.age){
            return 1;
        }else if (this.age<o.age){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("YYYY:MM:dd--HH:mm:SS");
        Date date = new Date();
        String date2=format.format(date);
        Date parse = format.parse(date2);
        System.out.println(parse);
        HashMap<String, String> ha = new HashMap<>();
        ha.put("ll","ll");
        ha.put("SS","SS");
        HashMap<Object, Object> map = new HashMap<>();
        map.put();
    }
}
