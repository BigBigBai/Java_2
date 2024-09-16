package bigbigbai._00_assignment._01_list.lc1;

import bigbigbai._00_assignment.ListNode;

public class _876_MiddleOfTheLinkedList {
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
