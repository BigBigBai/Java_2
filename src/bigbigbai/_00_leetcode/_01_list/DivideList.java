package bigbigbai._00_leetcode._01_list;

public class DivideList {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(24);
        head.next.next = new ListNode(14);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(25);
        head.next.next.next.next.next = new ListNode(33);
        head.next.next.next.next.next.next = new ListNode(16);
        head.next.next.next.next.next.next.next = null;

        ListNode first = divideList(head, 33);
        while (first != null) {
            System.out.print(first.val+" ");
            first = first.next;
        }

    }

    public static ListNode divideList1(ListNode head, int pivot) {
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode equalHead = null;
        ListNode equalTail = null;
        ListNode moreHead = null;
        ListNode moreTail = null;

//        ListNode next = null;

        while (head != null) {
            if (head.val < pivot) {
                //less区域的第一个节点
                if (lessHead == null) {
                    lessHead = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = head;
                }
            } else if (head.val == pivot) {
                //equal区域的第一个节点
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            } else {
                //more区域的第一个节点
                if (moreHead == null) {
                    moreHead = head;
                    moreTail = head;
                } else {
                    moreTail.next = head;
                    moreTail = head;
                }
            }

            head = head.next;
        }

        //less ---> equal
        if (lessTail != null) {
            lessTail.next = equalHead;
//            equalTail = equalTail == null ? lessTail : equalTail;
        }

        //equal ---> more
        if (equalTail != null) {
            equalTail.next = moreHead;
//            moreTail = moreTail == null ? equalTail : moreTail;
        } else {
            //有问题
            lessTail.next = moreHead;
        }

        //more ---> null
        if (moreTail != null) {
            moreTail.next = null;
        }


        if (lessHead == null && equalHead == null) return moreHead;
        else if (lessHead == null) return equalHead;
        else return lessHead;
    }

    public static ListNode divideList(ListNode head, int pivot) {
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode equalHead = null;
        ListNode equalTail = null;
        ListNode moreHead = null;
        ListNode moreTail = null;

        while (head != null) {
            if (head.val < pivot) {
                //less区域的第一个节点
                if (lessHead == null) {
                    lessHead = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = head;
                }
            } else if (head.val == pivot) {
                //equal区域的第一个节点
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            } else {
                //more区域的第一个节点
                if (moreHead == null) {
                    moreHead = head;
                    moreTail = head;
                } else {
                    moreTail.next = head;
                    moreTail = head;
                }
            }

            head = head.next;
        }

        //less ---> equal
        //equal ---> more
        if (lessTail != null && equalTail != null) {
            lessTail.next = equalHead;
            equalTail.next = moreHead;
        } else if (lessTail != null) {
            lessTail.next = moreHead;
        } else if (equalTail != null) {
            equalTail.next = moreHead;
        }

        //more ---> null
        if (moreTail != null) {
            moreTail.next = null;
        }


        if (lessTail != null) return lessHead;
        else if (equalTail != null) return equalHead;
        else return moreHead;
    }
}
