package leecode.tree;

import leecode.tree.TreeNode.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :

 * 返回其前序遍历: [1,3,5,6,2,4]。
 *https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 */
public class PreorderNtree {
    public static void main(String[] args) {
        Node root = Node.getNode();
        List<Integer> list = preorder(root);
        System.out.println(list);

    }

    public static List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        return helper(root,list);
    }

    public static List<Integer> helper(Node node,List<Integer> list){
        if(node != null){
            list.add(node.val);

            List<Node> nodeList = node.children;
            if(null != nodeList){
                for(Node childNode : nodeList){
                    helper(childNode,list);
                }
            }
        }
        return list;
    }
}
