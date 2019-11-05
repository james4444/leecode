package leecode.linked;

import leecode.linked.ListNode.ListNode;

import static leecode.linked.ListNode.ListNodeUtils.getNodeList;
import static leecode.linked.ListNode.ListNodeUtils.printNodeList;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
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
