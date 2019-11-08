package leecode.stack;

public class MyQueueTest {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        int param_2 = myQueue.pop();
        int param_3 = myQueue.pop();
        boolean param_4 = myQueue.empty();
    }
}
