package com.ll.linkedlist;

/**
 * @ClassName DoubleLinkedListDemo
 * @Description
 * @Author 李振兴
 * @Date 2020/9/12 22:19
 **/
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "吴用", "智多星");
        HeroNode2 hero3 = new HeroNode2(3, "林冲", "豹子头");
        HeroNode2 hero4= new HeroNode2(4, "鲁智深", "花和尚");

        linkedList.add(hero1);
        linkedList.add(hero2);
        linkedList.add(hero3);
        linkedList.add(hero4);

        linkedList.showlist();
        System.out.println("----------------------------------------------");

        //修改节点
        /*HeroNode2 hero5=new HeroNode2(2,"公孙离","小女人");
        linkedList.update(hero5);*/

        //删除节点
        //linkedList.delete(4);
        linkedList.showlist();
    }




}
class DoubleLinkedList{
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode2 head=new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }
    //添加节点到尾部
    public void add(HeroNode2 heroNode2){
        HeroNode2 temp=head;
        while (true){
            if (temp.next==null){
                break;
            }
            temp=temp.next;
        }
        temp.next=heroNode2;
        heroNode2.pre=temp;
    }

    //删除指定节点
    public void delete(int no){

        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为head不能动，因此我们需要一个辅助变量temp
        HeroNode2 temp=head.next;

        //标识一个flag当插入的节点存在时会抛出插入失败信息
        boolean flag=false;
        while (true){

            //链表中的最后一个节点
            if (temp==null){
                break;
            }
            //找到删除节点的前一个节点，temp.next代表temp的下一个节点，所以当temp.next.no=no时temp就是那个删除节点的前一个节点
            if (temp.no==no){
                flag=true;
                break;
            }
            //如果没有找到最后将temp后移
            temp=temp.next;
        }
        if (flag){
            temp.pre.next=temp.next;
            //最后一个节点删除如果不做判断会报空指针异常，因为temp.next=null了所以不存在他的pre属性所以会报异常
            if (temp.next==null){
                temp.pre=null;
            }else {
                temp.next.pre=temp.pre;
            }
        }else{
            System.out.println("不存在"+no+"这个节点，无法删除");
        }
    }

    //修改一个节点信息
    public void update(HeroNode2 newHeroNode){

        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //因为head不能动，因此我们需要一个辅助变量temp
        HeroNode2 temp=head.next;

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


    //遍历链表
    public void showlist(){
        //判断链表是否为空
        if (head.next==null){
            System.out.println("该节点为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp=head.next;
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

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickname) {
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
