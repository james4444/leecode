package leecode.stack;

public class LinkStack {
    class Node{
        public String s;
        public Node next;
        public Node pre;

        public Node(String s){
            this.s = s;
        }
    }

    public Node root;
    public Node tail;
    public LinkStack(){
        root = new Node(null);
        tail = root;
    }

    public boolean push(String s){
        Node node = new Node(s);
        node.pre = tail;
        tail.next = node;
        tail = tail.next;
        return true;
    }

    public String pop(){
        if(tail == root){
            return null;
        }

        String s = tail.s;
        tail = tail.pre;
        return s;
    }

    public static void main(String[] args) {
        LinkStack stack = new LinkStack();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
