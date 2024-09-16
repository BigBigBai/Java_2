package bigbigbai._00_assignment._01_list.lc1;

import bigbigbai._00_assignment.ListNode;

public class _203_RemoveLinkedListElements {
    // 构建新链表
    public ListNode removeElements1(ListNode head, int val) {
        ListNode newHead = null;
        ListNode newTail = null;

        while (head != null) {
            if (head.val != val) {
                if (newHead == null) {
                    newHead = head;
                    newTail = head;
                } else {
                    newTail.next = head;
                    newTail = newTail.next;
                }
            }
            head = head.next;
        }

        if (newTail != null) {
            newTail.next = null;
        }

        return newHead;
    }

    // dummyNode
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        ListNode newTail = dummyNode;

        while (head != null) {
            if (head.val != val) {
                newTail.next = head;
                newTail = newTail.next;
            }
            head = head.next;
        }
        newTail.next = null;

        return dummyNode.next;
    }
}
