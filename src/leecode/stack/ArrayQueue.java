package leecode.stack;

public class ArrayQueue {
    private int capacity;
    private int head;
    private int tail;
    private String[] array;

    public ArrayQueue(int capacity){
        this.capacity = capacity;
        this.array = new String[capacity];
        this.head=0;
        this.tail=0;
    }

    public ArrayQueue(){
        this(10);
    }



    public boolean offer(String s){
        if(tail == capacity){
            if(head == 0) return  false;
            for(int i = head;i<tail;i++){
                array[head-i] = array[i];
            }
            tail -= head;
            head = 0;
        }

        array[tail] = s;
        tail ++;
        return true;
    }

    public String pop(){
        if(head == tail) return null;
        return array[head++];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(2);
        queue.offer("a");
        System.out.println(queue.pop());
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");


        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
