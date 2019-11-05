package leecode.linked;

import leecode.linked.ListNode.ListNode;
import leecode.linked.ListNode.ListNodeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DetectCycle {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,6};
        ListNode head = ListNodeUtils.getNodeList(nums);
        ListNode temp = new ListNode(0);
        head.next = temp;
//        temp.next = head;
        System.out.println(detectCycle(head));
//        ListNodeUtils.printNodeList(head);
    }

    /**
     * 借鉴有环无环的判断，环的第一个节点就是相等的节点，时间复杂度为O(N),空间复杂度为O(N)
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode resultNode = null;
        Set<ListNode> set = new HashSet<>();

        while (head != null){
            if(set.contains(head)){
                return head;
            }else{
                set.add(head);
                head = head.next;
            }

        }
        return resultNode;
    }

    /**
     * 快慢指针法，相等的节点即为环的节点，时间复杂度为O(N),
     * 如果无环，效率高于上一种写法
     */

    public static ListNode detectCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode resultNode = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return slow;
            }

        }
        return resultNode;
    }
}
