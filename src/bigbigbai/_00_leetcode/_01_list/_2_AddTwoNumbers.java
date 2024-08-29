package bigbigbai._00_leetcode._01_list;

public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode newTail = dummyNode;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            newTail.next = new ListNode(sum % 10);
            newTail = newTail.next;
        }

        if (carry > 0) {
            newTail.next = new ListNode(carry);
            newTail = newTail.next;
        }
        newTail.next = null;
        return dummyNode.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode newTail = dummyNode;
        int sum = 0;
        int carry = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            newTail.next = new ListNode(sum);
            newTail = newTail.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            newTail.next = new ListNode(sum);
            newTail = newTail.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            sum = l2.val + carry;
            carry = sum / 10;
            sum = sum % 10;

            newTail.next = new ListNode(sum);
            newTail = newTail.next;
            l2 = l2.next;
        }

        if (carry > 0) {
            newTail.next = new ListNode(carry);
            newTail = newTail.next;
        }
        newTail.next = null;
        return dummyNode.next;
    }
}
