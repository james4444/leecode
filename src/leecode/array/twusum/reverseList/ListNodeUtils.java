package leecode.array.twusum.reverseList;

public class ListNodeUtils {

    public static ListNode getNodeList(int[] nums){
        ListNode head = null;
        for (int i=0;i<nums.length;i++){
            head = getNodeList(head,nums[i]);
        }
        return  head;
    }


    public static ListNode getNodeList(ListNode listNode,int i){

        ListNode temp = new ListNode(i);
        temp.next = listNode;

        return temp;
    }

    public static void printNodeList(ListNode listNode){
        System.out.println(listNode.val);

        if(null != listNode.next){
            listNode = listNode.next;
            printNodeList(listNode);
        }
    }
}
