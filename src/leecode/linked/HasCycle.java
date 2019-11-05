package leecode.linked;


import leecode.linked.ListNode.ListNode;
import leecode.linked.ListNode.ListNodeUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasCycle {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,6};
        ListNode head = ListNodeUtils.getNodeList(nums);
        ListNode temp = new ListNode(0);
        head.next = temp;
//        temp.next = head;
        System.out.println(hasCycle2(head));
//        ListNodeUtils.printNodeList(head);
    }

    /**
     * 将节点放入set中，判断是否有重复节点
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head){
        boolean flag = false;
        Set<ListNode> set = new HashSet<>();

        while (head != null){
            if(set.contains(head)){
                return true;
            }else {
                set.add(head);
                head = head.next;
            }
        }
        return flag;
    }

    /**
     * 使用快慢指针，快指针每次走两步，慢指针每次走一步，判断是否会相遇
     */

    public static boolean hasCycle2(ListNode head){

        boolean flag = false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }

        return flag;
    }
}
