package com.ll.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PolandNotation
 * @Description
 * @Author 李振兴
 * @Date 2020/9/13 23:06
 **/
public class PolandNotation {
    public static void main(String[] args) {
/*        //先定义逆波兰表达式
        //(3+4)*5-6  =>3 4 + 5 * 6 -
        //为了方便逆波兰表达式的表示使用空号隔开
        String suffixExpression="3 4 + 5 * 6 -";
        //思路
        //1.先将"3 4 + 5 * 6 -"仿佛到ArrayList中
        //2.将ArrayList传递给一个方法，配合栈完成计算
        List<String> list=getListString(suffixExpression);
        int res=calculate(list);
        System.out.println(res);*/
        String expression="1+((2+3)*4)-5";//它的后缀表达式为  1 2 3 + 4 * + 5 –
        //将中缀表达式转变成为list
        List<String> infixExpressionList=toInfixExpressionList(expression);
        //将中缀表达式的list转变为后缀表达式的list
        List ll=parseSuffixExpreesionList(infixExpressionList);
        //输入后缀表达式直接求出数据
        int result=calculate(ll);
        System.out.println(result);

    }

    //方法：中缀表达式转后缀表达式
    /*
        原理：
        1) 初始化两个栈：运算符栈 s1 和储存中间结果的栈 s2；
        2) 从左至右扫描中缀表达式；
        3) 遇到操作数时，将其压 s2；
        4) 遇到运算符时，比较其与 s1 栈顶运算符的优先级：
            1.如果 s1 为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
            2.否则，若优先级比栈顶运算符的高，也将运算符压入 s1；
            3.否则，将 s1 栈顶的运算符弹出并压入到 s2 中，再次转到(4-1)与 s1 中新的栈顶运算符相比较；
        5) 遇到括号时：
            (1) 如果是左括号“(”，则直接压入 s1
            (2) 如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
        6) 重复步骤 2 至 5，直到表达式的最右边
        7) 将 s1 中剩余的运算符依次弹出并压入 s2
        8) 依次弹出 s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     */
    //方法：将得到的中缀表达式对应的 List => 后缀表达式对应的
    public static List<String> parseSuffixExpreesionList(List<String> ls){
        //初始化两个栈：运算符栈s1和储存中间结果的栈s2，由于s2栈没有pop操作且最后要倒序输出所以直接用list替换
        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();
        //遍历传进来的中缀表达式list
        for (String item: ls){
            //如果是数字直接入s1栈
            if (item.matches("\\d+")) { //正则表达式
                //是数字直接入数栈
                s2.add(item);
            }else if (item.equals("(")){    //如果是（直接入栈
                s1.push(item);
            }else if (item.equals(")")){
                //如果是"）"弹出s1中的所有元素加入到s2中,直到弹出"（"为止,再消除s1中的"）"
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                //把")"出栈
                s1.pop();
            }else {
                //如果运算符优先级小于栈顶的元素，将s1中的元素弹出压到s2中直到要入栈的元素优先级大于栈顶再入s1栈,
                while (s1.size() != 0 && priority(s1.peek()) >= priority(item)) {
                    s2.add(s1.pop());
                }
                //运算符优先级大于栈顶的直接可入栈
                s1.push(item);
            }
        }
        //上述操作执行完把s1中所有的符号都弹出入到s2中
        if (!s1.isEmpty()){
            s2.add(s1.pop());
        }
        return s2;
    }

    //比较优先级的方法
    public static int priority(String oper){
        if (oper.equals("*")||oper.equals("/")){
            return 2;
        }else if (oper.equals("+")||oper.equals("-")){
            return 1;
        }else {
            return 0;
        }
    }


    //方法：将中缀表达式转成对应的List
    private static List<String> toInfixExpressionList(String s) {
        //定义一个List，存放中缀表达式对应的内容
        List<String> ls=new ArrayList<String>();
        //string字符中当前字符的下标
        int i=0;

        String str;
        char c;
        do {
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                ls.add(c+"");
                i++;
            }else {
                //while循环的目的是有可能数字不是单字符而是多字符组成的数字所以就需要遍历直到下一个数字不是数字时跳出循环
                str="";
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    //把每次遍历到的数字组合到一起，直到下一个不是数字为止
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
    }

    //将一个逆波兰表达式数据依次放入到ArrayList中
    public static List<String>getListString(String suffixExpression){
        //将suffixExpression用空格分割
        String[] split=suffixExpression.split(" ");
        List<String>list=new ArrayList<String>();
        for (String ele:split){
            list.add(ele);
        }
        return list;
    }

    //完成逆波兰表达式的运算
    /*
    1）从左至右扫描，将3和4压入栈；
    2）遇到+运算符，因此弹出4和3（4为栈顶元素，3为此顶元素）计算出3+4的值，再将计算结果入栈
    3）将5入栈
    4）接下来是*运算符，因此弹出5和7，计算出7*5，将35入栈；
    5）将6入栈；
    6）最后是-运算符，计算出35-6的值，即29，由此得出最终给结果
     */

    public static int calculate(List<String> ls) {
        //创建一个栈，只需要一个栈就可以
        Stack<String> stack = new Stack<String>();
        //遍历list
        for (String item : ls) {
            //正则表达式取出数据
            if (item.matches("\\d+")) {//匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int num=0;
                if (item.equals("+")) {
                    num = num1 + num2;
                    stack.push(num + "");
                } else if (item.equals("*")) {
                    num = num1 * num2;
                } else if (item.equals("-")) {
                    //后pop出来的值减去后pop出来的值
                    num = num2 - num1;
                } else if (item.equals("/")) {
                    num = num2 / num1;
                }else {
                    throw new RuntimeException("输入的运算符有错");
                }
                stack.push(num+"");
            }
        }
        //最后留在栈中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }
}
