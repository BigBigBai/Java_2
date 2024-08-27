package bigbigbai._00_leetcode._01_list;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 * @author bigbigbai
 *
 * 思路：
 * 1.通过快慢指针找到单链表中点
 * 2.反转右半部分
 * 3.设定2个指针从两端向中间遍历, 在遍历的过程中只要有一次不想等则return false
 * 4.恢复现场
 */
public class _234_PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        //1.通过快慢指针找到单链表中点，必须都指向head
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //2.反转右半部分
        ListNode newHead = reverseList(slow);

        //3.设定2个指针从两端向中间遍历, 在遍历的过程中只要有一次不相等则return false
        ListNode left = head;
        ListNode right = newHead;

        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        //4.恢复现场
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
