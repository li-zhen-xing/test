package com.ll.tree;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @ClassName Banrtree
 * @Description
 * @Author 李振兴
 * @Date 2020/9/23 14:36
 **/
public class BinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "林冲");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "李逵");
        HeroNode node4 = new HeroNode(4, "武松");
        HeroNode node5 = new HeroNode(5, "松江");
        BinaryTree tree = new BinaryTree(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);


        /*//三种不同的遍历方式，前序遍历，中序遍历，后续遍历
        tree.preOrder();//1,2,3,5,4
        System.out.println("-------------------");
        tree.infixOrder();//2,1,5,3,4
        System.out.println("-------------------");
        tree.postOrder();//2,5,4,3,1*/

        /*//查找
        HeroNode heroNode = tree.postOrderSearch(5);
        System.out.println(heroNode);*/

        System.out.println("删除节点之前");
        tree.preOrder();
        System.out.println("删除节点之后");
        tree.delNode(6);
        tree.preOrder();

    }
}

class BinaryTree{
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public void preOrder(){
        if (this.root!=null){
            root.preOrder();
        }else {
            System.out.println("二叉树为空无法遍历");
        }
    }
    public void infixOrder(){
        if (this.root!=null){
            root.infixOrder();
        }else {
            System.out.println("二叉树为空无法遍历");
        }
    }
    public void postOrder(){
        if (this.root!=null){
            root.postOrder();
        }else {
            System.out.println("二叉树为空无法遍历");
        }
    }
    public HeroNode preOrderSearch(int no){
        if (this.root==null){
            System.out.println("二叉树为空，无法遍历");
        }
        return this.root.preOrderSearch(no);
    }

    public HeroNode infixOrderSerach(int no){
        if (this.root==null){
            System.out.println("二叉树为空，无法遍历");
        }
        return this.root.infixOrderSerach(no);
    }

    public HeroNode postOrderSearch(int no) {
        if (this.root == null) {
            System.out.println("二叉树为空，无法遍历");
        }
        return this.root.postOrderSearch(no);
    }

    public void delNode(int no){
        if (this.root==null){
            System.out.println("二叉树为空不能删除");
        }else if (this.root.getLeft()==null&&this.root.getRight()==null){
            System.out.println("这个节点就一个无需删除");
        }else {
            //加一个判断看是否删除成功
            boolean flag=this.root.delNode(no);
            if (flag){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败，不存在该节点");
            }
        }
    }
}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后续遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     *
     * @param no 传进来的编号，根据编号进行比对查找
     * @return 返回遍历到的节点对象
     */
    public HeroNode preOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.preOrderSearch(no);
        }
        //假设找到了就返回这个对象即可，不需要再往下找了，再往下找的话就会改变这个值，导致为null
        //如果缺少这一步，递归还会往下继续进行从而导致找到了却错过了它，悲惨啊。
        if (heroNode!=null){
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.preOrderSearch(no);
        }
        return heroNode;
    }

    public HeroNode infixOrderSerach(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.infixOrderSerach(no);
        }
        if (heroNode!=null){
            return heroNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            heroNode = this.right.infixOrderSerach(no);
        }
        return heroNode;
    }

    public HeroNode postOrderSearch(int no) {
        HeroNode heroNode = null;
        if (this.left != null) {
            heroNode = this.left.postOrderSearch(no);
        }
        if (heroNode!=null){
            return heroNode;
        }
        if (this.right != null) {
            heroNode = this.right.postOrderSearch(no);
        }
        if (heroNode!=null){
            return heroNode;
        }
        if (this.no == no) {
            return this;
        }
        return heroNode;
    }

    //删除节点
    public boolean delNode(int no){
        boolean flag=false;
        if (this.left!=null&&this.left.no==no){
            this.left=null;
            return true;
        }
        if (this.right!=null&&this.right.no==no){
            this.right=null;
            return true;
        }
        if (this.left!=null){
            flag=this.left.delNode(no);
        }
        if (this.right!=null){
            flag=this.right.delNode(no);
        }
        //如果删除成功flag为true就不会往往下执行了
        if (flag){
            return true;
        }
        //最后一步，如果flag为true就不会执行，否则这一步将会执行
        return false;
    }
}



































