package leecode.tree;

import leecode.tree.TreeNode.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {
    public static boolean isValidBST(TreeNode root) {
        return helper(root, null ,null);

//        return ldr(root);
    }

    /**
     * 递归判断,广度优先，时间复杂度O(N),空间复杂度O(N)
     * @param node
     * @param min
     * @param max
     * @return
     */
    public static boolean helper(TreeNode node ,Integer min, Integer max){
        if(node == null) return true;

        int val = node.val;
        if(min != null && min > val) return false;
        if(max != null && max < val) return false;

        if (! helper(node.right, val, max)) return false;
        if (! helper(node.left, min, val)) return false;

        return true;
    }

    /**
     * 中序遍历,时间复杂度O(N),空间复杂度O(N)
     * @param
     */
    private static boolean ldr(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if(root.val <= inorder) return false;

            inorder = root.val;

            root = root.right;
        }

        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(22);

        TreeNode left11 = new TreeNode(1);
        left1.left = left11;

        root.left = left1;
        root.right = right1;

        System.out.println(isValidBST(root));

    }
}
