package com.ll.stack;

/**
 * @ClassName calculator
 * @Description
 * @Author 李振兴
 * @Date 2020/9/13 20:11
 **/
public class calculator {

    public static void main(String[] args) {
        String expression="30+20*6-2";
        //先创建两个栈，数栈符号栈
        ArrayStackDemo2 numStack = new ArrayStackDemo2(10);
        ArrayStackDemo2 operStack = new ArrayStackDemo2(10);
        //定义需要的相关变量
        int index=0;//用于扫描
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        String keepNum="";
        char ch=' ';//每次扫描得到char保存的ch
        //开始while循环的扫描expression
        while(true){
            //依次得到expression的每一个字符
            ch=expression.substring(index,index+1).charAt(0);
            if (operStack.isOper(ch)){//如果是运算符
                //判断当前的符号栈是否为空，如果为空直接入栈
                if (!operStack.isEmpty()){
                    //如果符号栈有操作符就进行比较，如果当前的操作符优先级小于或者等于栈中的优先级，就需要从数栈中pop出俩个数，
                    //再符号栈中pop一个符号，进行运算，得到结果，入数栈，然后将当前的操作符入栈
                    if (operStack.priority(ch)<=operStack.priority(operStack.top())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=numStack.cal(num1,num2,oper);
                        //把运算的结果入数栈
                        numStack.push(res);
                        //把当前的操作符入符号栈
                        operStack.push(ch);
                    }else {
                        //优先级大于直接把ch入栈
                        operStack.push(ch);
                    }
                }else {
                    //如果符号栈为空直接把ch入栈
                    operStack.push(ch);
                }
            }else{//如果是数字，则直接入栈
                //因为char转成int时他对应的数字要大于48，相当于char的值是3他变成int后他的值就是51了
                //numStack.push(ch-48);
                //思路分析
                //1.当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2.再处理数，需要向expression的表达式的index后再看一位，如果是数就进行扫描如果是操作符就直接入栈
                //3.因此我们需要定义一个变量字符串用于拼接
                //处理多位数
                keepNum +=ch;
                //如果ch已经是expression的最后一位，就直接入栈
                if(index==expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一个字符时不时数字，如果是数字就继续扫描，如果是运算符就直接入栈
                    //注意是看后一位不是index++
                    if (operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        //如果后一位是运算符，则入栈keepNum="1"或者"123"
                        numStack.push(Integer.parseInt(keepNum));
                        //重要，keepNum要清空不然他这次结果会累积到下一次
                        keepNum="";
                    }
                }
            }
            //让index+1，并判断是否扫描到expression的最后
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        //当表达式扫描完成，就顺序的从数栈和符号栈pop出相应的数和符号并运行
        while(true){
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个数字【结果】
            if (operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res=numStack.cal(num1,num2,oper);
            //把运算的结果入数栈
            numStack.push(res);
        }
        System.out.println("表达式的结果是"+numStack.pop());
    }
}

class ArrayStackDemo2 {
    private int maxsize;
    private int stack[];
    private int top =-1;

    //定义栈的size
    public ArrayStackDemo2(int maxsize) {
        this.maxsize = maxsize;
        stack=new int[this.maxsize];
    }

    //
    public boolean isFull(){
        return top==maxsize-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void push(int num){
        if (isFull()){
            System.out.println("栈已经满了添加失败");
            return;
        }
        top++;
        stack[top]=num;
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈是空的了");
        }
        int po=stack[top];
        top--;
        return po;
    }

    public void show(){
        if (isEmpty()){
            System.out.println("栈是空的，没有数据");
            return;
        }
        //需要从栈的顶部开始往下打印
        for (int i = top; i >=0; i--) {
            System.out.println(stack[i]);
        }
    }

    //返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
    //数字越大，则优先级越高；  因为chatr他也是一个int类型的
    public int priority(int oper){
        if (oper=='*'||oper=='/'){
            return 1;
        }else if (oper=='+'||oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val){
        return  val=='+'||val=='-'||val=='*'||val=='/';
    }

    // 计算方法
    public int cal(int num1,int num2,int oper){
        int res=0;
        switch (oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
            default:
                break;
        }
        return res;
    }

    //获取栈顶的值，但不是真正的pop出那个值
    public int top(){
        return stack[top];
    }

}























