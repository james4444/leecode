package leecode.array.twusum;

import leecode.array.twusum.reverseList.ListNode;
import org.w3c.dom.NodeList;

import java.util.List;

import static leecode.array.twusum.reverseList.ListNodeUtils.getNodeList;
import static leecode.array.twusum.reverseList.ListNodeUtils.printNodeList;

public class ReverseListNode {

    public static void main(String[] args) {

        int[] nums = new int[]{5,4,3,2,1};
        ListNode head = getNodeList(nums);
        ListNode newList = reverseList(head);

        printNodeList(newList);
    }

    /**
     * 循环取list中的val
     * 创建空的listnode
     * 以value创建节点
     * listnode.next = 原有节点
     * 时间复杂度为O(N)
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode temp = null;
        while (head != null){
            temp = getNodeList(temp, head.val);
            head = head.next;
        }
        return temp;
    }


}
