package bigbigbai._00_assignment._01_list.lc1;

import bigbigbai._00_assignment.ListNode;

public class _206_ReverseLinkedList {
    // 递归
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // 非递归：头插
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;

            head = tmp;
        }

        return newHead;
    }
}
