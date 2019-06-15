package algorithms.medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class M002_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode currNode = dummyHead;

        int carry = 0;

        while (null != node1 || null != node2) {
            int val1 = null == node1 ? 0 : node1.val;
            int val2 = null == node2 ? 0 : node2.val;

            int currVal = carry + val1 + val2;

            currNode.next = new ListNode(currVal % 10);

            currNode = currNode.next;

            carry = currVal / 10;

            node1 = null == node1 || null == node1.next ? null : node1.next;
            node2 = null == node2 || null == node2.next ? null : node2.next;
        }
        if (carry > 0) {
            currNode.next = new ListNode(carry);
        }


        return dummyHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }


    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }
}
