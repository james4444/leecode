package leecode.linked;

import leecode.linked.ListNode.ListNode;
import leecode.linked.ListNode.ListNodeUtils;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        int[] nums = new int[]{6,5,4,3,2,1};
        ListNode head = ListNodeUtils.getNodeList(nums);
        head = reverseKGroup(head,3);
        ListNodeUtils.printNodeList(head);
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null){
            for(int i=0;i<k && end != null ; i++){
                end = end.next;
            }

            if(end == null){
                break;
            }

            ListNode start = pre.next;
            ListNode next = end.next;

            end.next = null;
            pre.next = reverse(start);

            start.next = next;
            pre = start;

            end = pre;

        }
        return dummy.next;

    }

    private static ListNode reverse(ListNode start) {
        ListNode pre = null;
        while (start != null){
            ListNode next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
        return pre;
    }

}