package leecode.tree;

import leecode.tree.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        List<List<Integer>> result = levelOrder(treeNode);


    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();

        if(root == null) return result;


        List<Integer> list = new LinkedList<>();
        list.add(root.val);
        result.add(list);


        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;

        while (!queue.isEmpty() || !queue2.isEmpty()){
            if(flag){
                list = new LinkedList<>();
                while (!queue.isEmpty()){
                    TreeNode treeNode = queue.poll();
                    if(null != treeNode.left){
                        list.add(treeNode.left.val);
                        queue2.offer(treeNode.left);
                    }
                    if(null != treeNode.right){
                        list.add(treeNode.right.val);
                        queue2.offer(treeNode.right);
                    }
                }
                if(!list.isEmpty()){
                    result.add(list);
                    flag = false;
                }
            }else{
                list = new LinkedList<>();
                while (!queue2.isEmpty()){
                    TreeNode treeNode = queue2.poll();
                    if(null != treeNode.left){
                        list.add(treeNode.left.val);
                        queue.offer(treeNode.left);
                    }
                    if(null != treeNode.right){
                        list.add(treeNode.right.val);
                        queue.offer(treeNode.right);
                    }
                }
                if(!list.isEmpty()){
                    result.add(list);
                    flag = true;
                }
            }
        }
        return result;
    }
}
