package leecode.stack;

import java.util.Stack;

public class MockIe {
    private Stack<String> pre;
    private Stack<String> next;

    public MockIe(){
        pre = new Stack<>();
        next = new Stack<>();
    }

    public void addWeb(String url){
        pre.push(url);
        next.clear();
    }

    public String back(){
        String url = pre.pop();
        next.push(url);
        return pre.peek();
    }

    public String forword(){
        String url = next.pop();
        pre.push(url);
        return pre.peek();
    }

    public static void main(String[] args) {
        MockIe mockIe = new MockIe();
        mockIe.addWeb("a");
        mockIe.addWeb("b");
        mockIe.addWeb("c");
        System.out.println(mockIe.back());
        mockIe.addWeb("d");
        System.out.println(mockIe.back());
        System.out.println(mockIe.forword());


    }
}
