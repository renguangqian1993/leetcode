package algorithms.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 *  
 *
 * Example 1:
 *
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 *
 * Example 2:
 *
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 *
 * Example 3:
 *
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 *
 *  
 *
 * Follow up:
 *
 * Can you solve it using O(1) (i.e. constant) memory?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E141_LinkedListCycle {

    /**
     * 暴力法，使用set存储访问过的节点
     * 执行用时 :13 ms, 在所有 Java 提交中击败了20.07%的用户
     * 内存消耗 :41.9 MB, 在所有 Java 提交中击败了11.23%的用户
     */
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head.next != null) {
            if (set.contains(head.next)) {
                return true;
            } else {
                set.add(head.next);
                head = head.next;
            }
        }

        return false;
    }

    /**
     * 双指针法
     * 执行用时 :1 ms, 在所有 Java 提交中击败了94.90%的用户
     * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了48.59%的用户
     */
    public boolean hasCycle2(ListNode head) {
        if (null == head) {
            return false;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;

        while (true) {
            fastNode = fastNode.next;
            if (fastNode == null) {
                break;
            } else {
                fastNode = fastNode.next;
                if (null == fastNode) {
                    break;
                }
            }

            slowNode = slowNode.next;
            if (slowNode == null) {
                break;
            }

            if (fastNode == slowNode) {
                return true;
            }
        }

        return false;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
