package leecode.tree;

import leecode.tree.TreeNode.TreeNode;

import java.util.Stack;

/**
 * 二叉树的遍历
 * 二叉树的遍历是对二叉树的一种基本操作，一般分为递归遍历和非递归遍历
 * 二叉树遍历分为前序遍历、中序遍历、后续遍历三种
 * 前序遍历为根、左、右
 * 中序遍历为左、根、右
 * 后续遍历为右、根、左
 *
 */
public class AgodicTree {


    public static void main(String[] args) {
        //构建二叉搜索树树
        TreeNode root = getTreeNode();

        //递归先序遍历
//        dlr1(root);

        //递归中序遍历
//        ldr2(root);

        //后续遍历  左右根
        lrd2(root);
    }

    /**
     * 迭代后续遍历
     * @param root
     */
    private static void lrd1(TreeNode root) {
        if(root == null) return;

        lrd1(root.left);
        lrd1(root.right);
        System.out.println(root.val);
    }


    /**
     * 非迭代后续遍历
     */
    /**
     *
     */
    private static void lrd2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> tag = new Stack<>();

        while (root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                tag.push(1);
                root = root.left;
            }else{
                if(tag.peek() == 2){
                    System.out.println(stack.pop().val);
                    tag.pop();
                }else{
                    tag.pop();
                    tag.push(2);
                    root = root.right;
                }
            }
        }
    }


    /**
     * 递归实现中序遍历
     * @param root
     */
    private static void ldr1(TreeNode root) {
        if(root == null) return;

        ldr1(root.left);
        System.out.println(root.val);
        ldr1(root.right);
    }

    /**
     * 非迭代中序遍历
     * @param root
     */
    private static void ldr2(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }
    /**
     * 前序递归遍历
     * @param root
     */
    public static void dlr1(TreeNode root){
        if(null != root){
            System.out.println(root.val);
            dlr1(root.left);
            dlr1(root.right);
        }
    }

    /**
     * 非递归循环遍历
     * @return
     */

    public static void dlr2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }

            if(! stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
    }





    public static TreeNode getTreeNode(){
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(23);
        TreeNode left11 = new TreeNode(14,left1,right1);

        TreeNode left2 = new TreeNode(34);
        TreeNode right2 = new TreeNode(47);
        TreeNode right11 = new TreeNode(39,left2,right2);

        TreeNode root = new TreeNode(30,left11,right11);
        return  root;
    }
}


