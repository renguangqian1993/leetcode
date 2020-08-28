package algorithms.medium;

import java.util.Objects;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动k个位置，其中k是非负数。
 * <p>
 * 示例1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 示例2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步:0->1->2->NULL
 * 向右旋转 4 步:2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M61_rotate_list {
    public ListNode rotateRight(ListNode head, int k) {
        if (Objects.isNull(head)) {
            return head;
        }

        //将尾结点与首节点链接在一起，并获取长度
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        tail.next = head;

        //1.k小于len：向右移动k位，可以转换为首节点向后移动(len-k)位
        //2.k大于len：对len取余，然后参考上一步
        k = len - (k % len);
        while ((k--) > 0) {
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;

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
