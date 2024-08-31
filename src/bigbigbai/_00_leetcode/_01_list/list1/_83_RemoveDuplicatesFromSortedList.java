package bigbigbai._00_leetcode._01_list.list1;

import bigbigbai._00_leetcode._01_list.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 * @author bigbigbai
 */
public class _83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode first = head;

        while (first.next != null) {
            if (first.val == first.next.val)
                first.next = first.next.next;
            else
                first = first.next;
        }

        return head;
    }

}
