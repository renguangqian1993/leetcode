package algorithms.medium;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M024_swap_nodes_in_pairs {

    private class Solution {
        public ListNode swapPairs(ListNode head) {
            if (null == head || null == head.next) {
                return head;
            }

            ListNode newHead = head.next;

            ListNode pre = null;
            while (null != head && null != head.next) {
                ListNode child = head.next.next;
                if (null != pre) {
                    pre.next = head.next;
                }

                pre = head;

                head.next.next = head;
                head.next = child;
                head = head.next;
            }

            return newHead;
        }
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
