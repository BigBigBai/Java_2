package bigbigbai._00_leetcode._01_list;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 * @author bigbigbai
 *
 */
public class _206_ReverseLinkedList {

    // iteration
    public ListNode reverseList2(ListNode head) {
//        if (head == null || head.next == null) return head;

        // 头插
        ListNode newHead = null;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }

        return newHead;
    }

    // recursion
    public ListNode reverseList1(ListNode head) {
        // 归
        if (head == null || head.next == null) return head;

        // 递
        ListNode newHead = reverseList1(head.next);
        // 4
        head.next.next = head;
        head.next = null;

        return newHead;
    }


}
