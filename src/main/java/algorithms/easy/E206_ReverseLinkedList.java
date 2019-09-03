package algorithms.easy;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E206_ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        reverseList(head);
    }

    /**
     * 使用递归，从后开始逆转
     * 时间复杂度：O(n)，假设 n 是列表的长度，那么时间复杂度为 O(n)。
     * 空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层
     * 执行用时 :1 ms, 在所有 Java 提交中击败了86.22%的用户
     * 内存消耗 :37.2 MB, 在所有 Java 提交中击败了37.27%的用户
     */
    public static ListNode reverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return tail;
    }

    /**
     * 参考官方解法【迭代法】 TODO
     * 时间复杂度O(n)，空间复杂度O(1)
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :35.9 MB, 在所有 Java 提交中击败了56.21%的用户
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode tmpNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmpNode;
        }
        return prev;
    }



    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
