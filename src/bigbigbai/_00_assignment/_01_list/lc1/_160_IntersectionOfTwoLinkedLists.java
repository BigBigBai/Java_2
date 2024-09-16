package bigbigbai._00_assignment._01_list.lc1;

import bigbigbai._00_assignment.ListNode;

public class _160_IntersectionOfTwoLinkedLists {
    // 判断2个无环单链表的相交问题
    // tc: O(m+n)
    // sc: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        int diff = 0;
        while (cur1 != null) {
            diff++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            diff--;
            cur2 = cur2.next;
        }

        // cur1永远是长的链表
        cur1 = diff > 0 ? headA : headB;
        cur2 = diff > 0 ? headB : headA;
        diff = Math.abs(diff);
        while (diff != 0) {
            diff--;
            cur1 = cur1.next;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static void main(String[] args) {
        ListNode h1 = null;
        ListNode h2 = null;
        System.out.println(h1 != h2);
    }
}
