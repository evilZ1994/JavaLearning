package DataStructure.LinearStructure.Queue;

public class TestMyQueue {

    public static void main(String[] args) {
        // 创建一个队列
        MyQueue queue = new MyQueue();
        queue.add(7);
        queue.add(8);
        queue.add(9);
        // 出队
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        // 判断是否为空
        System.out.println(queue.isEmpty());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty());
    }
}
