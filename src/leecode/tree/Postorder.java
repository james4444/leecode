package leecode.tree;

import leecode.tree.TreeNode.Node;

import java.util.ArrayList;
import java.util.List;

public class Postorder {
    public static void main(String[] args) {



        Node root = Node.getNode();
        Postorder postorder = new Postorder();
        List<Integer> list = postorder.postorder(root);

        System.out.println(list);
    }

    public List<Integer> postorder(Node root) {

        List<Integer> list = new ArrayList<>();
        if(null == root) return list;

        return helper(root,list);

    }

    private List<Integer> helper(Node root, List<Integer> list) {
        if(root == null) return list;
        if(root.children != null){
            for(Node item : root.children){
                helper(item,list);
            }
        }
        list.add(root.val);
        return list;
    }
}
