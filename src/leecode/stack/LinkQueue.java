package leecode.stack;

public class LinkQueue {
    class Node{
        String value;
        Node next;

        public Node(String s){
            this.value = s;
        }
    }

    private Node head;
    private Node tail;
    public LinkQueue(){
        head = new Node("null");
        tail = head;
    }

    public void offer(String value){
        Node node = new Node(value);
        tail.next = node;
        tail = tail.next;
    }

    public String poll(){
        if(head == tail) return null;

        String value = head.next.value;
        head = head.next;
        return value;
    }


    public static void main(String[] args) {
        LinkQueue queue = new LinkQueue();
        queue.offer("a");
        queue.offer("b");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
