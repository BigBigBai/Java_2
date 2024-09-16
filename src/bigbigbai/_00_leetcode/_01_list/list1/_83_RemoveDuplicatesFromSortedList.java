package bigbigbai._00_leetcode._01_list.list1;

import bigbigbai._00_leetcode._01_list.ListNode;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 * @author bigbigbai
 *
 * 1.跳过重复节点，first.next = first.next.next
 * 2.继续看下一个节点是否还是重复
 *   重复：继续跳过
 *   不重复：移动first指针
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
