package com.yidu.demo;

public class Employee {
    private String empId;
    private String name;
    private  int age;

    public Employee(String empId, String name, int age) {
        this.empId = empId;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Employee() {
    }

}
