package bigbigbai._00_leetcode._01_list;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/description/
 * @author bigbigbai
 */
public class _203_RemoveLinkedListElements {
    // dummy node 虚拟节点
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        ListNode newTail = dummyNode;

        while (head != null) {
            if (head.val != val) newTail = newTail.next = head;

            head = head.next;
        }

        newTail.next = null;

        return dummyNode.next;
    }


    // 构建新链表
    public ListNode removeElements1(ListNode head, int val) {
        ListNode newHead = null;
        ListNode newTail = null;

        // head 进行遍历
        // newTail 维持新链表的尾端
        // newHead 维持新链表的首端
        while (head != null) {
            if (head.val != val) {
                if (newTail == null) {
                    newHead = head;
                    newTail = head;
                } else {
                    newTail.next = head;
                    newTail = head;
                }
            }

            head = head.next;
        }

        if (newTail != null) newTail.next = null;

        return newHead;
    }


    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        // head/only one node
        while (head != null && head.val == val) head = head.next;
        if (head == null) return null;

        // current/tail
        ListNode first = head;
        while (first.next != null) {
            if (first.next.val == val) first.next = first.next.next;
            else first = first.next;
        }

        return head;
    }
}
