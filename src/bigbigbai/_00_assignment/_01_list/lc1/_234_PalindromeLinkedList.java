package bigbigbai._00_assignment._01_list.lc1;

import bigbigbai._00_assignment.ListNode;

/**
 * 1.拿到中点
 * 2.从中点处反转链表
 * 3.左右对比
 * 4.反转回来（optional）
 */
public class _234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // 1.拿到中点
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2.从中点处反转链表
        ListNode newHead = reverseList(slow);

        // 3.左右对比
        ListNode left = head;
        ListNode right = newHead;
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        // 4.反转回来
        reverseList(newHead);

        return true;
    }

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
