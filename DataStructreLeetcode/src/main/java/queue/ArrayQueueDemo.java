package queue;

import java.util.Scanner;

/**
 * 用数组模拟队列 该队列仅仅只能用一次
 * 取出数据后则不能重复使用
 *  1. front指向队头的前一位,rear指向队尾,初始是rear= front =-1
 *  2. 队空时 rear == front
 *  3. 队满时 (rear + 1 ) % maxSize == front
 *  4. 队列的有效数据为:(rear - front)
 */

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        boolean loop = true;
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中获取数据");
            System.out.println("h(head):查看队列的头数据");
            System.out.println("e(exit):退出");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.show();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int a = scanner.nextInt();
                    arrayQueue.addQueue(a);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.printf("取出的数据为%d\n",result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.printf("该队列的头为%d\n",head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }
}

//使用数组队列模拟一个ArrayQueue类
class ArrayQueue{
    private int maxsize;//数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数据用来存放数据模拟队列
    public ArrayQueue(int arrMaxsize){
        maxsize=arrMaxsize;
        front=-1;//指向队列头
        rear=-1;//指向队列尾
        arr = new int[arrMaxsize];
    }

    //判断是否队满
    public boolean isFull(){
        return rear==maxsize-1;
    }
    //判断是否队空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据.入队
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队已满");
            return;
        }
        rear++;
        arr[rear]=n;
    } //显示队列的所有数据
    public void show(){
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //取出数据.出队
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列是空");
        }
        front++;
        return arr[front];
    }


    //显示头数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("没有数据");
        }
        return arr[front+1];
    }
    //显示尾数据
    public int rearQueue(){
        if(isEmpty()){
            throw new RuntimeException("没有数据");
        }
        return arr[rear];
    }
}
