package com.ll.linkedlist;

import java.util.Stack;

/**
 * @ClassName SingleLinkedList
 * @Description
 * @Author 李振兴
 * @Date 2020/9/11 18:34
 **/
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "吴用", "智多星");
        HeroNode hero3 = new HeroNode(3, "林冲", "豹子头");
        HeroNode hero4= new HeroNode(4, "鲁智深", "花和尚");

        //HeroNode hero5= new HeroNode(4, "小菜鸡", "吃饭第一名");
        SingleLinkedList linkedList2 = new SingleLinkedList();
        HeroNode hero5 = new HeroNode(5, "宋江", "及时雨");
        HeroNode hero6 = new HeroNode(6, "吴用", "智多星");
        HeroNode hero7 = new HeroNode(7, "林冲", "豹子头");
        HeroNode hero8= new HeroNode(8, "鲁智深", "花和尚");

        linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero4);
        linkedList.showlist();
        System.out.println("---------------------------------------------------");

        /*linkedList2.add(hero5);
        linkedList2.add(hero6);
        linkedList2.add(hero7);
        linkedList2.add(hero8);
        linkedList2.showlist();

        System.out.println("-----------------------------------");
        SingleLinkedList doubleOrder = SingleLinkedList.doubleOrder(linkedList, linkedList2);
        doubleOrder.showlist();*/


        //链表反转利用一个新的链表接受数据来实现，拆分了原有的链表
/*        System.out.println("--------------------------------------------");
        SingleLinkedList.reverseList(linkedList.getHead());
        linkedList.showlist();*/

        //链表反转利用stock栈来实现，这个没有拆分原有的链表
/*
        System.out.println("--------------------------------------------");
        SingleLinkedList.reverse(linkedList.getHead());
*/

        //链表长度
/*        System.out.println("=========================");
        System.out.println(SingleLinkedList.gelenght(linkedList.getHead()));*/

/*        //查找链表倒数第k个元素
        System.out.println("-----------------------------------------");
        HeroNode lastNode=SingleLinkedList.findLastNode(linkedList.getHead(),0);
        System.out.println(lastNode);*/

        //按照顺序往链表中添加元素
/*        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero1);*/

        //修改链表中的元素
//        linkedList.update(hero5);

        //删除链表中指定的元素
/*        linkedList.delete(1);
        linkedList.showlist();*/


    }
}

class SingleLinkedList {

    //合并两个有序的单链表，合并之后仍然有序百度面试
    //思路：先把两个链表合并成一个链表合并顺序没要求，然后再遍历这个合并的链表分别取出数据再调用
    //之前老师所说的addByOrder方法有序的加入一个新的链表直接返回新的链表就可以了
    public static SingleLinkedList doubleOrder(SingleLinkedList linkedList1,SingleLinkedList linkedList2){
        //分别获的传进来的两个链表的head
        HeroNode headfirst=linkedList1.getHead();
        HeroNode headsecond=linkedList2.getHead();

        //建立一个新的链表这个链表任务用来合并传进来的两个链表中的所有元素
        SingleLinkedList newlinked=new SingleLinkedList();
        //这三个next用来保存临时数据，以防链表断裂一下是我对next的个人理解，如果不好理解直接debug一下就清晰明了了
        //这个next至关重要，debug跑一下就知道了，next的作用是接受temp的值，不用next的话直接temp.next=head.next;会导致
        // temp.next=null;也就是说你要把temp这个值放到新的链表中的话如果新的链表一个值都没有的话那么cur.next=null下一次循环就会直接跳出
        //当你加了next的话temp的值会保留再next中，当你这次循环结束了next的值它又赋给了temp。当下一次循环开启时next的值等于temp.next
        //此刻的temp等于上次循环时next的值，所以此刻的next等于next.next而temp的值等于上一次next的值而不是等于null（这个null是你加入到新链表中你要代替的那个位置的next值）
        //有点绕，但是debug跑一次可以立马理解。
        HeroNode next1=null;
        HeroNode next2=null;
        HeroNode next3=null;
        //定义2个标志遍历传进来的两个链表
        HeroNode temp1=headfirst.next;
        HeroNode temp2=headsecond.next;
        //head用来给新的链表赋值通过遍历直接赋值给新链表
        HeroNode head=newlinked.getHead();
        while (true){
            if (temp1!=null){
                next1=temp1.next;
                temp1.next=head.next;
                head.next=temp1;
                temp1=next1;
            }
            if (temp2!=null){
                next2=temp2.next;
                temp2.next=head.next;
                head.next=temp2;
                temp2=next2;
            }
            if (temp1==null && temp2==null){
                break;
            }
        }
        //定义temp用来遍历这个新的链表，把temp的值通过addByOrder方法传入
        HeroNode temp=newlinked.getHead().next;
        //定义一个返回结果的链表，add传入的数据全传入到这个链表中
        SingleLinkedList realy=new SingleLinkedList();
        while (true){
            next3=temp.next;
            realy.addByOrder(temp);
            temp=next3;
            if (temp==null){
                break;
            }
        }
        //返回目标链表
        return realy;
    }
// linkedList.addByOrder(hero1);

    //从尾到头打印单链表百度面试
    //思路：创建一个stock栈来接受链表数据
    //利用了栈的特性，先进后出原则
    public static void reverse(HeroNode head){
        //先判断链表中是否存在数据或者只存在一个就不需要反转
        if (head.next==null||head.next.next==null){
            return;
        }
        HeroNode cur =head.next;
        Stack stack=new Stack();
        while (cur!=null){
            stack.add(cur);
            cur=cur.next;
        }
        while (stack.size()!=0){
            System.out.println(stack.pop());
        }
    }

    //单向链表反转。腾讯面试
    //思路，新建一个新的链表接受数据；先把原有链表遍历取出数据，再将数据放入到新的链表的最前端，最后再把新的链表赋值给旧的链表
    //放入最前端有点类似于aabyorder方法，每次遍历到的数据都放到最前端
    //最重要的要定义一个变量接受head.next作为一个临时变量，如果不定义的话链表会发生断裂
    //这个next至关重要，debug跑一下就知道了，next的作用是接受temp的值，不用next的话直接cur.next=reversHead.next;会导致
    // cur.next=null;也就是说你要把temp这个值放到新的链表中的话如果新的链表一个值都没有的话那么cur.next=null下一次循环就会直接跳出
    //当你加了next的话temp的值会保留再next中，当你这次循环结束了next的值它又赋给了temp。当下一次循环开启时next的值等于temp.next
    //此刻的temp等于上次循环时next的值，所以此刻的next等于next.next而temp的值等于上一次next的值而不是等于null（这个null是你加入到新链表中你要代替的那个位置的next值）
    //有点绕，但是debug跑一次可以立马理解。
    public static void reverseList(HeroNode head){

        //先判断链表中是否存在数据或者只存在一个就不需要反转
        if (head.next==null||head.next.next==null){
            return;
        }
        //定义一个接受反转元素的头部
        HeroNode cur =head.next;
        HeroNode next=null;
        HeroNode reversHead=new HeroNode(0,"","");
        while(cur!=null){
            next=cur.next;
            cur.next=reversHead.next;
            reversHead.next=cur;
            cur=next;
        }
        head.next=reversHead.next;
    }


    //查找单链表的倒数第k个节点，新浪面试
    //思路，当我们需要获得倒数第k个时，可以先获得链表一共有多少个元素，然后再利用连败哦的size减去k时
    //此时这个元素刚好就是倒数第k个元素
    public static HeroNode findLastNode(HeroNode head,int index){
        if (head.next==null){
            return null;
        }
        int size = gelenght(head);
        HeroNode temp=head.next;
        for (int i=0;i<size-index;i++){
            temp=temp.next;
        }
        return temp;
    }

    //获取单链表节点的个数（如果是带头节点的不需要统计个数）
    //思路：当链表中不存在下一个元素时就结束while循环，返回计数值则可
    public static int gelenght(HeroNode head){
        if (head.next==null){
            return 0;
        }
        int lenght=0;
        HeroNode temp=head.next;
        while (temp!=null){
            lenght++;
            temp=temp.next;
        }
        return lenght;
    }

    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head=new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //添加到单向链表
    //思路，当不考虑顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){

        //因为head不能动，因此我们需要一个辅助变量temp
        HeroNode temp=head;
        while (true){
            //这个temp代表到了最后一个元素，他的next属性值为null代表后面没有元素了
            //所以此刻必须跳出循环此刻的temp就是元素
            if (temp.next==null){
                break;
            }
            //如果没有找到最后将temp后移
            temp=temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next=heroNode;
    }



    //添加数到单向链表
    //找到temp节点和temp.next节点，把需要出入的对象放入到这个节点中间
    //具体实现temp.next==heroNode  heroNode.next=temp.next 相当于直接插入在temp和temp.next节点的中间
    public void addByOrder(HeroNode heroNode){

        //因为head不能动，因此我们需要一个辅助变量temp
        HeroNode temp=head;

        //标识一个flag当插入的节点存在时会抛出插入失败信息
        boolean flag=false;
        while (true){
            //这个temp代表到了最后一个元素，他的next属性值为null代表后面没有元素了
            //所以此刻必须跳出循环此刻的temp就是元素
            if (temp.next==null){
                break;
            }
            //当temp下一个节点的id刚好大于要插入的节点id时就相当于找到了这个节点，因为temp是从头开始往后找的
            if (temp.next.no>heroNode.no){
                break;
            }
            //当存在这个id时也直接退出循环
            if (temp.next.no==heroNode.no){
                flag=true;
                break;
            }
            //如果没有找到最后将temp后移
            temp=temp.next;
        }
        if (flag){
            System.out.println(temp.next.no+"存在这个id，添加失败");
        }else{
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

    public void update(HeroNode newHeroNode){

        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为head不能动，因此我们需要一个辅助变量temp
        HeroNode temp=head.next;

        //标识一个flag当插入的节点存在时会抛出插入失败信息
        boolean flag=false;
        while (true){
            //这个temp代表到了最后一个元素，他的next属性值为null代表后面没有元素了
            //所以此刻必须跳出循环此刻的temp就是元素
            if (temp==null){
                break;
            }
            //当存在这个id时也直接退出循环
            if (temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            //如果没有找到最后将temp后移
            temp=temp.next;
        }
        if (flag){
            temp.no=newHeroNode.no;
            temp.name=newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else{
            System.out.println("不存在"+temp.next.no+"这个节点，无法修改");
        }
    }


    public void delete(int no){

        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为head不能动，因此我们需要一个辅助变量temp
        HeroNode temp=head;

        //标识一个flag当插入的节点存在时会抛出插入失败信息
        boolean flag=false;
        while (true){

            //链表中的最后一个节点
            if (temp.next==null){
                break;
            }
            //找到删除节点的前一个节点，temp.next代表temp的下一个节点，所以当temp.next.no=no时temp就是那个删除节点的前一个节点
            if (temp.next.no==no){
                flag=true;
                break;
            }
            //如果没有找到最后将temp后移
            temp=temp.next;
        }
        if (flag){
          temp.next=temp.next.next;
        }else{
            System.out.println("不存在"+no+"这个节点，无法删除");
        }
    }



    //遍历链表
    public void showlist(){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("该节点为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp=head.next;
        while (true){
            //链表此刻已经遍历完毕了 head.next=null；后面已经没有元素了直接跳出，
            // 不然会报空指针异常，因为最后面加了temp=temp.next会再去找下面的元素
            //下面的元素已经不存在了所以此刻必须跳出这里的temp不代表最后一个元素，代表最后一个元素的next属性
            if (temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp往后移，一直移到temp=null没有节点为止
            temp=temp.next;
        }
    }
}

class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}