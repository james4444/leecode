package leecode.array.twusum;

import leecode.array.twusum.reverseList.ListNode;
import leecode.array.twusum.reverseList.ListNodeUtils;

public class SwapPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        ListNode head = ListNodeUtils.getNodeList(nums);
        head = ReverseListNode.reverseList(head);
        ListNodeUtils.printNodeList(head);
    }

    public ListNode swapPairs(ListNode head) {
        return head;
    }
}
