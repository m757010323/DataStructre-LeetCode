package queue;

import java.util.Scanner;

/**
 * 用数组模拟环形队列成功
 * 在该环形队列中
 * 1.当队列不为空时，front指向队列的第一个元素，rear指向队列最后一个元素的下一个位置。
 * 2.当队列为空时，front=rear
 * 3.队列满时：（rear+1）%maxsize = front，少用一个存储空间，也就是数组的最后一个存数空间不用
 * 4.当前队列中有效的个数为(rear + maxSize - front) % maxSize 即队列的长度;
 */

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);
        boolean loop = true;
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列中获取数据");
            System.out.println("e(exit):退出");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArrayQueue.show();
                    break;

                case 'a':
                    System.out.println("请输入一个数字");
                    int a = scanner.nextInt();
                    circleArrayQueue.addQueue(a);
                    break;
                case 'g':
                    try {
                        int result = circleArrayQueue.getQueue();
                        System.out.printf("取出的数据为%d\n", result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class CircleArrayQueue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] arr;

    public CircleArrayQueue(int arrmaxSize) {
        arr = new int[arrmaxSize];
        front = 0;
        rear = 0;
        maxSize = arrmaxSize;
    }

    /**
     * 判断是否队空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断是否队满
     *
     *
     */
    public boolean isFull() {
        return (rear + 1) % (maxSize) == front;
    }

    /**
     * 添加数据
     *
     * @param number
     */
    public void addQueue(int number) {
        if (isFull()) {
            System.out.println("队已经满了,不能添加数据");
            return;
        }

        //因为该队列是环形队列,此时移动rear指针的时候需要注意越界
        arr[rear] = number;
        rear = (rear + 1) % maxSize;

    }

    /**
     * 取出队列中的数据
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("该队列是空");
        }

        //1.这里先把front对应的值保存到一个临时变量中
        //2.将front后移
        //3.将临时变量返回
        int getNum = arr[front];
        front = (front + 1) % maxSize;
        return getNum;

    }

    //显示队列的所有数据
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        //思路:从front开始遍历,遍历有效数据
        //
        int size = size();
        for (int i = front; i < front + size; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 获取当前队列的有效数据
     *
     * @return
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

}
