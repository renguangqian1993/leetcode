package algorithms.easy;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E203_RemoveLinkedListElements {


    /**
     * 时间复杂度为O(n)，空间复杂度为O(1)
     * 执行用时 :2 ms, 在所有 Java 提交中击败了93.92%的用户
     * 内存消耗 :43.3 MB, 在所有 Java 提交中击败了67.41%的用户
     */
    public ListNode removeElements(ListNode head, int val) {
        while (null != head && head.val == val) {
            head = head.next;
        }

        ListNode tmpNode = head;
        while (tmpNode != null && tmpNode.next != null) {
            if (tmpNode.next.val == val) {
                tmpNode.next = tmpNode.next.next;
            } else {
                tmpNode = tmpNode.next;
            }
        }

        return head;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
