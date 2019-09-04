package algorithms.easy;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E234_PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        isPalindrome2(head);
    }



    /**
     * 时间复杂度为O(n^2)，空间复杂度为O(1)
     * 执行用时 :1105 ms, 在所有 Java 提交中击败了6.58%的用户
     * 内存消耗 :44.2 MB, 在所有 Java 提交中击败了53.73%的用户
     */
    public static boolean isPalindrome(ListNode head) {
        while (null != head) {
            ListNode tailNode = head;

            ListNode preNodeBeforeTail = tailNode;
            while (tailNode.next != null) {
                preNodeBeforeTail = tailNode;
                tailNode = tailNode.next;
            }

            if (head.val != tailNode.val) {
                return false;
            }

            preNodeBeforeTail.next = null;
            head = head.next;
        }

        return true;
    }

    /**
     * TODO 双指针法找到中间节点，逆转前半部分，顺序遍历前后两个链表
     * 执行用时 :2 ms, 在所有 Java 提交中击败了96.84%的用户
     * 内存消耗 :43.7 MB, 在所有 Java 提交中击败了61.83%的用户
     */
    public static boolean isPalindrome2(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

        }

        ListNode pre = null;
        ListNode next = null;
        while (head != slowNode) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        if (fastNode != null) {
            head = head.next;
        }

        while (head != null) {
            if (head.val != pre.val) {
                return false;
            }

            head = head.next;
            pre = pre.next;
        }

        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
