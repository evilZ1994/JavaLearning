package QuestionCollection.TwoStackImplementQueue;

public class Test {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.push(10);
        myQueue.push(9);
        myQueue.push(8);
        System.out.println(myQueue.pop());
        myQueue.push(7);
        myQueue.push(6);
        System.out.println(myQueue.pop());
        myQueue.push(5);
        myQueue.push(4);

        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.pop());
        }
    }
}
