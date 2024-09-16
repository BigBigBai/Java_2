package bigbigbai._00_assignment._01_list.lc1;

import bigbigbai._00_assignment.ListNode;

public class _21_MergeTwoSortedLists {
    // dummyNode
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode newTail = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newTail.next = list1;
                newTail = newTail.next;
                list1 = list1.next;
            } else {
                newTail.next = list2;
                newTail = newTail.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            newTail.next = list1;
        }

        if (list2 != null) {
            newTail.next = list2;
        }

        return dummyNode.next;
    }
}
