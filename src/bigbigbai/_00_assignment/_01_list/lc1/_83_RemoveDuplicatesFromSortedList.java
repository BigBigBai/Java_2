package bigbigbai._00_assignment._01_list.lc1;

import bigbigbai._00_assignment.ListNode;

public class _83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode first = head;

        while (first != null && first.next != null) {
            if (first.val == first.next.val) {
                first.next = first.next.next;
            } else {
                first = first.next;
            }
        }

        return head;
    }
}
