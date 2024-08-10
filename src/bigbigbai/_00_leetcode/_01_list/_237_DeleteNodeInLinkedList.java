package bigbigbai._00_leetcode._01_list;

/**
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/description/
 *
 * @author bigbigbai
 *
 * You are given the node to be deleted node.
 * You will not be given access to the first node of head.
 *
 * All the values of the linked list are unique,
 * and it is guaranteed that the given node node is not the last node in the linked list.
 *
 */
public class _237_DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {

        ListNode removed = node.next;
        node.next = removed.next;
        node.val = removed.val;

    }
}
