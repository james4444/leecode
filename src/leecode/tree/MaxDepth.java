package leecode.tree;

import leecode.tree.TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = TreeNode.getTreeNode();
        System.out.println(maxDepth2(root));
    }

    /**
     * 深度优先，递推公式为f(n-1) + 1
     * @param root
     * @return
     */
    private static int maxDepth2(TreeNode root) {
        if(root == null) return 0;

        int left = maxDepth2(root.left);
        int right = maxDepth2(root.right);

        return 1+max(left,right);


    }

    /**
     * 广度优先，广度即为最大深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        int result = 0;
        if(null == root) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        result++;

        while (!queue.isEmpty()){
            int length = queue.size();

            boolean flag = false;
            for(int i=0; i<length; i++){
                TreeNode treeNode = queue.poll();
                if(null != treeNode.left){
                    queue.offer(treeNode.left);
                    flag = true;
                }
                if(null != treeNode.right){
                    queue.offer(treeNode.right);
                    flag = true;
                }
            }
            if(flag){
                result ++;
            }
        }
        return result;
    }
}
