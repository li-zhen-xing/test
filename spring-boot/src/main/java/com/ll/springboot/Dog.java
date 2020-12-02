package com.ll.springboot;

/**
 * @ClassName Dog
 * @Description
 * @Author 李振兴
 * @Date 2020/10/3 21:14
 **/
public class Dog {
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
