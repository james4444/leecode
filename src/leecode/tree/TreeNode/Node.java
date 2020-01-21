package leecode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 多叉树
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public static Node getNode(){
        List<Node> list1 = new LinkedList<>();
        Node left1 = new Node(5);
        Node right1 = new Node(6);
        list1.add(left1);
        list1.add(right1);

        Node left11 = new Node(3,list1);

        List<Node> list2 = new LinkedList<>();
        Node left12 = new Node(2);
        Node left13 = new Node(4);

        list2.add(left11);
        list2.add(left12);
        list2.add(left13);

        Node root = new Node(1,list2);

        return  root;

    }
}
