package com.ll.domain;

import java.util.ArrayList;

public class Person {
    String name;
    String sex;
    String age;
    String salary;

    public void Person(String name, String sex, String age, String salary) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void construct(ArrayList<String> list){
        this.name=list.get(0);
        this.sex=list.get(1);
        this.age=list.get(2);
        this.salary=list.get(3);
    }
}
