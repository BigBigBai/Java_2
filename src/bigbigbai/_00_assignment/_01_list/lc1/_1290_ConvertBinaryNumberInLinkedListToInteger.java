package bigbigbai._00_assignment._01_list.lc1;

import bigbigbai._00_assignment.ListNode;

public class _1290_ConvertBinaryNumberInLinkedListToInteger {
    // 模拟
    public int getDecimalValue1(ListNode head) {
        int res = 0;
        while (head != null) {
            res = 2 * res + head.val;

            head = head.next;
        }
        return res;
    }

    // 反转链表
    public int getDecimalValue(ListNode head) {
        ListNode newHead = reverseList(head);

        int res = 0;
        int count = 0;
        while (newHead != null) {
            res += (int) (newHead.val * Math.pow(2, count++));

            newHead = newHead.next;
        }
        return res;
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
