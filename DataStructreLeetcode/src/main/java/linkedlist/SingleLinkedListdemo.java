package linkedlist;

public class SingleLinkedListdemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(new HeroNode(1,"张飞","小黑脸"));
        singleLinkedList.add(new HeroNode(2,"关羽","小红脸"));
        singleLinkedList.list();
    }
}
//初始化一个Linkedlsit管理节点
class SingleLinkedList{
    //初始化一个头节点
    private HeroNode head = new HeroNode(0,"","");
    //添加节点思路
    //1.找到next节点为null的节点
    //2.将这个节点的next指向新加入的节点
    public void add(HeroNode heroNode){
        HeroNode temp = head;
        while(true){
            //判断节点是否为最后的节点
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    //遍历列表
    //1.链表为空时直接显示链表为空
    public void list(){
        if(head.next == null){
            System.out.println("该链表为空");
            return;
        }
        //链表不为空的时候创建一个辅助的变量帮忙遍历该链表
        HeroNode temp  = head.next;
        while(true){
            //判断节点是否到最后
            if (temp == null){
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}

//创建节点类
class HeroNode{
    public int no;
    public String name;
    public String nikeName;
    public HeroNode next;

    public HeroNode(int no, String name, String nikeName) {
        this.no = no;
        this.name = name;
        this.nikeName = nikeName;
    }

    //为了显示方便,重写toString方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nikeName='" + nikeName + '\'' +
                '}';
    }
}
