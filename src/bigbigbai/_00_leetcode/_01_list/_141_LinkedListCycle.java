package bigbigbai._00_leetcode._01_list;

/**
 * https://leetcode.cn/problems/linked-list-cycle/description/
 * @bigbigbai
 * dummy node O(1)
 *
 */
public class _141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }

        return false;
    }
}
