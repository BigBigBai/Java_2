package bigbigbai._00_assignment.assignment1;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/description/
 * @author bigbigbai
 *
 * 思路：
 * fast-slow pointer
 * When fast reaches null, slow is the middle node
 */
public class _876_MiddleLinkedList {
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
