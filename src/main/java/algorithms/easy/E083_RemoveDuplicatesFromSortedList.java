package algorithms.easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * <p>
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class E083_RemoveDuplicatesFromSortedList {

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.88%的用户
     * 内存消耗 :37.3 MB, 在所有 Java 提交中击败了49.81%的用户
     * @description 因为有序，所以从前往后遍历一次。时间复杂度为O(n)，空间复杂度为O(1)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmpNode = head;

        while ((null != tmpNode) && (null != tmpNode.next)) {
            if (tmpNode.val == tmpNode.next.val) {
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

        ListNode(int x) {
            val = x;
        }
    }
}

