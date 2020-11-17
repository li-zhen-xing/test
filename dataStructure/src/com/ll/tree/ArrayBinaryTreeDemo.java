package com.ll.tree;

/**数组以二叉树形式遍历出每一个数关系是
 * 必须为完全二叉树
 * 下一个左子节点为2n+1
 * 下一个右子节点为2n+2
 * 父节点为（n-1）/2
 * @ClassName ArrayBinaryTreeDemo
 * @Description
 * @Author 李振兴
 * @Date 2020/9/24 10:47
 **/
public class ArrayBinaryTreeDemo {

    private int[] arr;

    public ArrayBinaryTreeDemo(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public void infixOrder(){
        this.infixOrder(0);
    }

    public void postOrder(){
        this.postOrder(0);
    }

    public void preOrder(int no){
        if (arr==null||arr.length==0){
            System.out.println("该数组为空不能遍历");
            return;
        }
        System.out.println(arr[no]);
        if ((2*no+1)<arr.length){
            preOrder(2*no+1);
        }
        if ((2*no+2)<arr.length){
            preOrder(2*no+2);
        }
    }

    public void infixOrder(int no){
        if (arr==null||arr.length==0){
            System.out.println("该数组为空不能遍历");
            return;
        }
        if ((2*no+1)<arr.length){
            infixOrder(2*no+1);
        }
        System.out.println(arr[no]);
        if ((2*no+2)<arr.length){
            infixOrder(2*no+2);
        }
    }

    public void postOrder(int no){
        if (arr==null||arr.length==0){
            System.out.println("该数组为空不能遍历");
            return;
        }
        if ((2*no+1)<arr.length){
            postOrder(2*no+1);
        }
        if ((2*no+2)<arr.length){
            postOrder(2*no+2);
        }
        System.out.println(arr[no]);
    }
}
class test{
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7};
        ArrayBinaryTreeDemo tree = new ArrayBinaryTreeDemo(arr);
        //tree.preOrder();
        //tree.infixOrder();
        tree.postOrder();
    }
}
