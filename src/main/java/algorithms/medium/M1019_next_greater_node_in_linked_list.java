package algorithms.medium;

/**
 * 1019. 链表中的下一个更大节点
 *
 * 给出一个以头节点head作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：
 * 对于node_i，
 * 如果其next_larger(node_i)是node_j.val，那么就有j > i且node_j.val > node_i.val，而j是可能的选项中最小的那个。
 * 如果不存在这样的j，那么下一个更大值为0。
 *
 * 返回整数答案数组answer，其中answer[i] = next_larger(node_{i+1})。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为2，第二个节点值为 1，第三个节点值为5 。
 *
 *
 *
 * 示例 1：
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 *
 * 示例 2：
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 *
 * 示例 3：
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *
 *
 * 提示：
 *
 * 对于链表中的每个节点，1 <= node.val<= 10^9
 * 给定列表的长度在 [0, 10000]范围内
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-node-in-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1019_next_greater_node_in_linked_list {
    private class Solution {
        public int[] nextLargerNodes(ListNode head) {
            return null;
        }
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
