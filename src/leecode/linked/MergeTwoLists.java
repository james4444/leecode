package leecode.linked;

import leecode.linked.ListNode.ListNode;
import leecode.linked.ListNode.ListNodeUtils;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        int[] num1 = new int[]{4,2,1};
        int[] num2 = new int[]{4,3,1};

        ListNode l1 = ListNodeUtils.getNodeList(num1);
        ListNode l2 = ListNodeUtils.getNodeList(num2);

        ListNode result = mergeTwoLists(l1,l2);
        ListNodeUtils.printNodeList(result);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;

        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ListNode temp = l1.next;
                l1.next = null;
                head.next = l1;
                head = head.next;
                l1 = temp;
            }else{
                ListNode temp = l2.next;
                l2.next = null;
                head.next = l2;
                head=head.next;
                l2 = temp;
            }
        }

        if(l1 != null) head.next = l1;
        if(l2 != null) head.next = l2;
        return result.next;
    }

    public static void mergeNode(){

    }

}
