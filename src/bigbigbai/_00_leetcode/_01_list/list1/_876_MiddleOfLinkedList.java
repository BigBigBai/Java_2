package bigbigbai._00_leetcode._01_list.list1;

import bigbigbai._00_leetcode._01_list.ListNode;

/**
 * 1. 双指针slow/fast，定在一个起跑线
 * 2. slow走1步，fast走2步
 * 3. fast到终点，slow就在mid点
 */
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
