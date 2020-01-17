package leecode.tree;

import leecode.tree.TreeNode.TreeNode;

/**
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 *
 * 二叉搜索树保证具有唯一的值。
 *
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
public class RangeSumBST {
    int result = 0;
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTreeNode();
        RangeSumBST st = new RangeSumBST();
        System.out.println(st.rangeSumBST(treeNode,7,15));

    }

    public  int rangeSumBST(TreeNode root, int L, int R) {
        return helper(root,L,R);
    }

    private int helper(TreeNode root, int l, int r) {
        if(null == root) return result;

        if(root.val >= l && root.val <= r){
            result += root.val;
        }
        if(root.val > l){
            helper(root.left,l,r);
        }
        if(root.val < r){
            helper(root.right,l,r);
        }

        return result;
    }
}
