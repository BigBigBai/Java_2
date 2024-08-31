package bigbigbai._00_leetcode._01_list.list1;

import bigbigbai._00_leetcode._01_list.ListNode;

public class _876_MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
