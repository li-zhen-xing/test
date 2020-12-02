package Annotation;

import java.lang.reflect.Field;

/**
 * @ClassName Main
 * @Description
 * @Author 李振兴
 * @Date 2020/11/3 15:15
 **/
public class Main {
    public static String buildSQL(){
        String result = null;
        //通过类名获得emp类的类对象
        Class empClass = Emp.class;
        //定义构建的字符串
        StringBuilder str=new StringBuilder("creat table");
        //获取注解类通过强制类型转换
        Table table = (Table)empClass.getAnnotation(Table.class);
        //通过table类获取注解的值
        String tablename = table.Tablename();
        str.append(" "+tablename+" (");
        //获取emp类中声明属性，包括私有的公共的保护的但是没有继承的
        Field[] fields = empClass.getDeclaredFields();
        for (Field field:fields) {
            //判断该属性是不是注解
            if (field.isAnnotationPresent(Colum.class)){
                //通过属性获得注解类对象
                Colum colum = field.getAnnotation(Colum.class);
                //获得注解类对象的属性
                String columName = colum.ColumName();
                String columType = colum.ColumType();
                String columLenght = colum.ColumLenght();
                String columConstrain = colum.ColumConstrain();
                if (colum.ColumType().equals("DATA")||colum.ColumType().equals("data")){
                    str.append(columName+" "+columType+" "+columConstrain+",");
                }else {
                    str.append(columName+" "+columType+" ("+columLenght+") "+columConstrain+",");
                }
                result = str.substring(0, str.length() - 1);
                result=result+")";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(buildSQL());
    }
}
