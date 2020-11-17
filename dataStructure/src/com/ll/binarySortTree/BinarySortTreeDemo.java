package com.ll.binarySortTree;

/**二叉排序树
 * 原理：比root节点大的放到节点右边比节点小的放到节点左边
 * 实现：创建节点类，节点类带有一个int属性进行比较
 * @ClassName BinarySortTreeDemo
 * @Description
 * @Author 李振兴
 * @Date 2020/10/8 10:05
 **/
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.deletNode(7);
        binarySortTree.infixOrder();
    }
}

/**
 * 定义节点
 */
class Node {
    int value;
    Node left;
    Node right;

    @Override
    public String toString() {
        return "Node{" +
                "Value=" + value +
                '}';
    }

    /**
     * 构造方法
     *
     * @param value 传入节点的大小
     */
    public Node(int value) {
        this.value = value;
    }

    /**
     * 定义添加节点的方法
     *
     * @param node 要添加的节点
     */
    public void add(Node node) {
        //如果传入节点的值小于该节点的值就往左边添加
        if (node.value < this.value) {
            //找到了叶子节点就添加到叶子节点
            if (this.left == null) {
                this.left = node;
            } else {
                //继续递归查找叶子节点，然后再添加到叶子节点上
                this.left.add(node);
            }
        } else {
            //如果传入节点的值不小于该节点的值就往右边添加
            if (this.right == null) {
                //找到了叶子节点就添加到叶子节点
                this.right = node;
            } else {
                //继续递归添加
                this.right.add(node);
            }
        }
    }

    /**
     * 进行中序遍历
     * 为什么要进行中序遍历：因为中序遍历先是遍历左边节点然后再遍历本身再遍历右边节点
     * 而二叉排序树刚好符合这一特性，左子节点的值小于父节的值，父节点的值小于父节点右子节点的值
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 根据输入的值查找某个节点
     *
     * @param value 节点的值
     * @return 这个节点
     */
    public Node search(int value) {
        //如果当前节点的值刚好等于要查找的值则直接返回
        if (this.value == value) {
            return this;
        } else if (value < this.value) {//如果要查找的节点的值小于当前节点的值则往左边查找
            //如果左边没有值了则代表没有该值查找不到直接返回null
            if (this.left == null) {
                return null;
            } else {
                //往左边递归查找
                return this.left.search(value);
            }
        } else { //当前节点的值大于或者等于要查找的节点的值
            if (this.right == null) {//如果右边节点的值为空还没找到那个接待你，则找不到了直接返回null
                return null;
            } else {
                //往有右边递归查找
                return this.right.search(value);
            }
        }
    }

    /**
     * 根据输入子节点的值查找这个子节点的父节点
     *
     * @param value 要查找的节点的子节点的值
     * @return 要查找的父节点
     */
    public Node searchParent(int value) {
        //如果当前节点的左子节点或者右子节点的值等于传入的值则代表这个节点就是要查找的父节点，这个left或者right的null判断很重要如果他没有子节点根本不需要进行判断
        if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
            return this;
        } else {//如果传入的小于当前节点的值则往左边递归查找
            if (value < this.value && this.left != null) {
                return this.left.searchParent(value);
            } else if (value >= this.value && this.right != null) { //如果传入的值大于当前节点的值则往右边递归
                return this.right.searchParent(value);
            } else {
                //没有找到返回null
                return null;
            }
        }
    }
}

/**
 * 定义二叉排序树
 */
class BinarySortTree {
    //定义根节点
    private Node root;

    //定义添加节点的方法，直接调用Node类的添加方法，因为添加方法都是用此类的而不是用Node类的
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //定义中序遍历，也是直接调用
    public void infixOrder() {
        if (root == null) {
            return;
        } else {
            root.infixOrder();
        }
    }

    //查找节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    //查找父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    /**
     * 根据输入的节点查这个节点的子节点的最小值
     *
     * @param node
     * @return
     */
    public int findMin(Node node) {
        //如果他还有左子节点则一直遍历
        while (node.left != null) {
            node = node.left;
        }
        //查到的最左边的子节点的最小值
        int temp = node.value;
        //在二叉树中删除该子节点
        deletNode(node.value);
        //返回这个子节点的最小值
        return temp;
    }

    /**
     * 根据输入的节点查找该节点的最大的子节点的值
     *
     * @param node 要查找的节点
     * @return 这个节点的醉倒的子节点的值
     */
    public int findMax(Node node) {
        //如果它还有右子节点就一直遍历
        while (node.right != null) {
            node = node.right;
        }
        //查找到最右边的右子节点的最大值
        int temp = node.value;
        //删除这个节点
        deletNode(temp);
        //返回该节点
        return temp;
    }

    /**
     * 删除二叉排序树的节点
     * 思路：分为三种情况
     * 第一种删除的是叶子节点
     * 先查找这个节点的父节点根据父节点判断这个叶子节点是父节点的左子节点还有右子节点，在令它的左子节点或者右子节点等有null即可
     * 第二种删除的是有一个子节点的
     * 第一步一样，然后查找这个节点看它左子节点还是右子节点有值，直接俄用父节点的left或者right来等于这个删除节点的子节点
     * 第三种删除的是有两个子节点的
     * 有两种方式：查找该节点的右子节点构成的二叉树的里面最小的值把这个值找来替代那个删除节点的值
     * 第一种方式原理：因为你删除的是两个节点，这个节点它有左子节点和右子节点你不能像前面那两种情况一样直接用它的父节点来替代，在这种情况下行不通，
     * 所以需要保留原有的树的结构然后删除的是那个节点的值，还不能破坏二叉树的规则，所以有两种方式第一种从删除节点的左子节点构成的二叉树中找到一个最大的节点来替换删除节点
     * 的值，且删除这个最大的节点这样就可以重塑成一颗二叉树了，因为左子节点的最大值是放在左子节点的最右边的（此刻理解可以想象这棵树很多层）
     * 为什么要取最大的呢，假设你取的不是最大的那么他就会矛盾（为什么矛盾呢，因为在排序二叉树中比父节点大的值放在右边小的放在左边，你现在取得不是最大的值来作为父节点
     * 那么不在左边会出现比这个父节点还大的值，所以以要取最大的）方式二同理取右节点的最小即可
     * @param value 要删除的节点的值
     */
    public void deletNode(int value) {
        if (root == null) {
            return;
        } else {
            //待删除的节点
            Node target = search(value);
            //删除节点的父节点
            Node parent = searchParent(value);
            //如果是叶子节点
            if (target.left == null && target.right == null) {
                //先判断它是父节点的左子节点还是右子节点
                if (parent.left == target) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (target.left != null && target.right != null) {//删除的节点有两个子节点
                target.value = findMin(target.right);//方式一：查找该节点的右子节点构成的二叉树的里面最小的值把这个值找来替代那个删除节点的值
                target.value = findMax(target.left);//方式二：查找该节点的左子节点构成的二叉树里面的最大的值，把这个值用来替换删除节点的值
            } else {//第三种情况，删除的节点只有一个子节点
                //判断有没有父节点，如果删除的是root节点，root节点就没有父节点
                if (parent != null) {
                    if (target.left != null & target.right == null) {//先判断待删除的节点的子节点是左子节
                        //再判断它是它父节点的左子节点还是右子节点
                        if (parent.left == target) {
                            //父节点是左子节点直接令父节点的左子节点等于它的左子节点即可
                            parent.left = target.left;
                        } else {
                            //父节点是右子节点直接令它父节点的右子节点等有它的子节点即可
                            parent.right = target.left;
                        }
                    } else {
                        //是root结点的话直接让root节点它等于左节点即可
                        root = target.left;
                    }

                } else {//待删除的节点的子节点是右子节点
                    //判断有没有父节点，如果删除的是root节点，root节点就没有父节点
                    if (parent != null) {
                        //再判断它是它父节点的左子节点还是右子节点
                        if (parent.left == target) {
                            //父节点是左子节点直接令父节点的左子节点等于它的左子节点即可
                            parent.left = target.right;
                        } else {
                            //父节点是右子节点直接令它父节点的右子节点等有它的子节点即可
                            parent.right = target.right;
                        }
                    } else {
                        //是root结点的话直接让root节点它等于右节点即可
                        root = target.right;
                    }

                }
            }
        }
    }
}