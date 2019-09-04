package algorithms.easy;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Given linked list -- head = [4,5,1,9]
 *
 *
 * Example 1:
 * Input: head = [4,5,1,9], node = 5
 * Output: [4,1,9]
 * Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
 *
 * Example 2:
 * Input: head = [4,5,1,9], node = 1
 * Output: [4,5,9]
 * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
 *  
 *
 * Note:
 *
 * The linked list will have at least two elements.
 * All of the nodes' values will be unique.
 * The given node will not be the tail and it will always be a valid node of the linked list.
 * Do not return anything from your function.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E237_DeleteNodeInALinkedList {

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了77.97%的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了32.48%的用户
     */
    public void deleteNode(ListNode node) {
        while (true) {
            node.val = node.next.val;
            if (node.next.next != null) {
                node = node.next;
            } else {
                node.next = null;
                break;
            }
        }

    }

    /**
     * 官方O(1)复杂度的解法-_-
     */
    public void deleteNode2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
