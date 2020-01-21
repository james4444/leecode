package leecode.tree;

import leecode.tree.TreeNode.TreeNode;

public class SearchBST {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();

        TreeNode s = searchBST(root,2);

        System.out.println(s);

    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        if(val == root.val) return root;

        return val < root.val?searchBST(root.left,val):searchBST(root.right,val);

    }
}
