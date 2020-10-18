package algorithms.medium;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class M019_remove_nth_node_from_end_of_list {

    /**
     * 遍历两次的解法
     *
     * 第一次遍历获取链表长度，要删除的逆序第n个节点即顺序第(size-n+1)个节点
     */
    private static class Solution1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int size = getSize(head);

            //持有head节点
            ListNode headHolder = new ListNode(0, head);

            //target节点的上一个节点
            ListNode preNode = headHolder;

            //要删除顺序第（size-n+1）个节点，则preNode为顺序第（size-n）个节点
            int index = size - n;
            while (index-- > 0) {
                preNode = preNode.next;
            }
            preNode.next = (null == preNode.next) ? null : preNode.next.next;

            return headHolder.next;
        }

        private int getSize(ListNode node) {
            ListNode curr = node;

            int len = 0;
            while (null != curr) {
                len++;
                curr = curr.next;
            }

            return len;
        }
    }

    /**
     * 快慢节点（快节点为当前遍历的节点，慢节点为目标节点的前一个节点）
     * 快节点不停后移，慢节点等待N步
     * 快节点为null时停止
     */
    private static class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //持有head节点
            ListNode headHolder = new ListNode(0, head);

            //target节点的上一个节点
            ListNode preNode = headHolder;
            ListNode curr = headHolder;

            //当前遍历到的节点
            while (curr.next != null) {
                if (n-- <= 0) {
                    preNode = preNode.next;
                }
                curr = curr.next;
            }

            preNode.next = preNode.next.next;

            return headHolder.next;
        }
    }
    private static class ListNode {
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
