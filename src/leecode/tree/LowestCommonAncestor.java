package leecode.tree;

import leecode.tree.TreeNode.TreeNode;

import static leecode.tree.AgodicTree.getTreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

        TreeNode root = getTreeNode();

        TreeNode p = new TreeNode(2);

        TreeNode q = new TreeNode(8);

        TreeNode result = lowestCommonAncestor2(root,p,q);

        System.out.println(result.val);

    }

    /**
     * 非递归写法
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ) return root;
        if(p == null) return q;
        if(q == null) return p;

        while (root != null){
            if(p.val>root.val && q.val > root.val){
                root = root.right;
            }else if(p.val < root.val && q.val < root.val){
                root = root.left;
            }else {
                break;
            }
        }

        return root;
    }


    /**
     * 递归查找，先找到分到左右两边节点的即为最近父节点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        if(null == p) return q;
        if(null == q) return p;

        //如果val的值都比根大，说明在根节点的右边
        if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        //如果val的值都比根小，说明在根节点的左边
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        //返回根节点
        return root;
    }

    /**
     * 递归中序遍历
     * @param root
     */
    private static void ldr(TreeNode root) {
            if(root == null) return;

            ldr(root.left);
            System.out.println(root.val);
            ldr(root.right);
    }


}
