package leecode.linked;

import leecode.linked.ListNode.ListNode;
import leecode.linked.ListNode.ListNodeUtils;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        ListNode head = ListNodeUtils.getNodeList(nums);
        head = ReverseListNode.reverseList(head);
        ListNodeUtils.printNodeList(swapPairs2(head));
    }

    /**
     * 递归写法
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return  next;
    }

    /**
     * 非递归写法
     * 心得：要把引用赋值想象成指针，进行指针的偏移
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head){
        ListNode pre = new ListNode(0);

        pre.next = head;
        ListNode tmp = pre;

        while (null != tmp.next && null != tmp.next.next){
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;

            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start;
        }
        return pre.next;
    }
}
