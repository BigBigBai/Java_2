package bigbigbai._00_leetcode._01_list;

import org.junit.Test;

/**
 *
 */
public class GetFirstInsertionNode {
    public static void main(String[] args) {

    }

    @Test
    public void test3() {
        // 虫型结构
        // 1->2->3->4->5->6->7->4...
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = head1.next.next.next;

        // 0->9->8->6->7->4...
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; //8->6
        System.out.println(getFirstInsertionNode(head1, head2).val);
    }

    @Test
    public void test2() {
        // Y型+圈
        // 1->2->3->4->5->6->7->4...
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = head1.next.next.next;

        // 0->9->8->2...
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; //8->2
        System.out.println(getFirstInsertionNode(head1, head2).val);
    }

    @Test
    public void test1() {
        // Y型结构
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; //8->6

        System.out.println(getFirstInsertionNode(head1, head2).val);
    }

    public static Node getFirstInsertionNode(Node head1, Node head2) {
        Node cycleNode1 = getCycleNode(head1);
        Node cycleNode2 = getCycleNode(head2);

        if (cycleNode1 == null && cycleNode2 == null) {
            return getNoCycleInsertionNode(head1, head2);
        } else if (cycleNode1 == null) {
            return null;
        } else if (cycleNode2 == null) {
            return null;
        } else {
            return getCycleInsertionNode(head1, cycleNode1, head2, cycleNode2);
        }
    }

    public static Node getCycleInsertionNode(Node head1, Node cycleNode1, Node head2, Node cycleNode2) {
        Node cur1 = null;
        Node cur2 = null;

        //2
        if (cycleNode1 == cycleNode2) {
            cur1 = head1;
            cur2 = head2;

            int diff = 0;
            while (cur1 != cycleNode1) {
                diff++;
                cur1 = cur1.next;
            }
            while (cur2 != cycleNode1) {
                diff--;
                cur2 = cur2.next;
            }

            //cur1永远是长的链表，cur2永远是短的链表
            cur1 = diff > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;

            diff = Math.abs(diff);
            //让较长的单链表的指针先跑完difference长度，再让2个指针一起跑，相遇的位置就是相交点
            while (diff != 0) {
                cur1 = cur1.next;
                diff--;
            }

            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {//1or3
            cur1 = cycleNode1.next;

            while (cur1 != cycleNode1) {
                if (cur1 == cycleNode2) return cycleNode1;//3
                cur1 = cur1.next;
            }

            return null;
        }

    }

    public static Node getNoCycleInsertionNode(Node head1, Node head2) {
        Node cur1 = head1;
        Node cur2 = head2;
        int diff = 0;
        while (cur1 != null) {
            diff++;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            diff--;
            cur2 = cur2.next;
        }

        //cur1永远是长的链表，cur2永远是短的链表
        cur1 = diff > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;

        diff = Math.abs(diff);

        //让较长的单链表的指针先跑完difference长度，再让2个指针一起跑，相遇的位置就是相交点
        while (diff != 0) {
            cur1 = cur1.next;
            diff--;
        }

        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }

    public static Node getCycleNode(Node head) {
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;

        }

        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    public static class Node {
        public int val;
        public Node next;

        public Node(int data) {
            this.val = data;
        }
    }
}
