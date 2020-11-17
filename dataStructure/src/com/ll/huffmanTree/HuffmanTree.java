package com.ll.huffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**构建赫夫曼树
 * 原理：树的带权路径最段
 * 带权路径=节点的权值*节点的路径长度
 * 把权值大的节点放到靠近root节点的地方，把权值小的节点放到叶子节点处
 * 实现步骤：
 * 先把排序成一个有序数组，然后把权值小的合并成为一个权值，且让合并出来的值也看作是也给单一的节点，再进行排序，然后还是选择权值
 * 最小的两个节点进行合并，就这样依次合并排序，直到最后只剩下一个节点，所形成的树就是赫夫曼树
 * @ClassName HuffmanTree
 * @Description
 * @Author 李振兴
 * @Date 2020/9/26 16:31
 **/
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[]={13,7,8,3,29,6,1};
        Node node=creatHuffmanTree(arr);
        System.out.println(node);
        node.preOreder();
    }

    //创建赫夫曼树
    public static Node creatHuffmanTree(int arr[]){
        //第一步为了操作方便
        //1.遍历arr数组
        //2.将arr的每个元素构成一个Node
        //3.将Node放入到ArrayList中
        List<Node> nodes=new ArrayList<Node>();
        for (int value :arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size()>1) {
            //将nodes进行排序从小到大
            Collections.sort(nodes);
            //先从第一个元素和第二个元素开始合并
            Node nodeleft = nodes.get(0);
            //先从第一个元素和第二个元素开始合并
            Node noderight = nodes.get(1);
            //把先前的两个子节点合并成一个父节点
            Node parent = new Node(nodeleft.value + noderight.value);
            //把两个子节点赋值给父节点
            parent.left=nodeleft;
            parent.right=noderight;
            //合并后移除这两个元素
            nodes.remove(nodeleft);
            nodes.remove(noderight);
            //把合并好的节点加入到集合中再次进行整体排序
            nodes.add(parent);
        }
        //返回树
        return nodes.get(0);
    }
}

class Node implements Comparable<Node> {
    int value;
   Node left;
   Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大排序
        return this.value-o.value;
    }

    public void preOreder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOreder();
        }
        if (this.right!=null){
            this.right.preOreder();
        }
    }

}
