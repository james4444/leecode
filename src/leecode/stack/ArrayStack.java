package leecode.stack;

import java.util.Arrays;

/**
 * 用数组实现一个可以自动扩容的顺序栈
 */
public class ArrayStack {
    private String[] stack;
    private int capacity;
    int size = 0;

    public ArrayStack(){
        this.capacity = 10;
        stack = new String[10];
    }

    public ArrayStack(int capacity){
        this.capacity = capacity;
        stack = new String[capacity];
    }

    public void push(String s){
        //未超过容量
        if(size >= capacity){
            this.capacity = capacity*2;
            stack = Arrays.copyOf(stack,capacity);
        }
        stack[size++] = s;
    }

    public String pop(){
        if(size <= 0) return null;
        return stack[--size];
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(2);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
