package com.yidu.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {
    public static void main(String[] args) {
        try {
            //获取Employee类的类对象
            Class<?> clazz = Class.forName("com.yidu.demo.Employee");
            //使用反射技术来创建Employee对象
            Employee employee = (Employee) clazz.newInstance();
            //使用反射技术为对象赋值
            Field empIdField = clazz.getDeclaredField("empId");
            Field nameField = clazz.getDeclaredField("name");;
            Field ageField = clazz.getDeclaredField("age");;

            //取消访问检查
            empIdField.setAccessible(true);
            nameField.setAccessible(true);
            ageField.setAccessible(true);

            //为对象的成员属性赋值
            empIdField.set(employee,"0001");
            nameField.set(employee,"张三");
            ageField.setInt(employee,20);


            Method toStringMethod = clazz.getMethod("toString", null);

            Constructor empconstructor = clazz.getConstructor(String.class, String.class, int.class);
            Employee employy =(Employee) empconstructor.newInstance("0002","小周",18);

            System.out.println(ageField);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
