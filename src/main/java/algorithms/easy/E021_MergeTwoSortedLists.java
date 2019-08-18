package algorithms.easy;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
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
public class E021_MergeTwoSortedLists {
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了90.18%的用户
     * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了87.29%的用户
     * @description 简单粗暴的去遍历两个list，却没有想到使用递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }

        ListNode beforeHead = new ListNode(0);

        ListNode tmpHead = null;
        if (l1.getVal() <= l2.getVal()) {
            tmpHead = l1;
            l1 = l1.getNext();
        } else {
            tmpHead = l2;
            l2 = l2.getNext();
        }
        beforeHead.setNext(tmpHead);

        while (l1 != null && l2 != null) {
            if (l1.getVal() <= l2.getVal()) {
                tmpHead.setNext(l1);
                l1 = l1.getNext();

            } else {
                tmpHead.setNext(l2);
                l2 = l2.getNext();
            }
            tmpHead = tmpHead.getNext();
        }
        if (null != l1) {
            tmpHead.setNext(l1);
        }
        if (null != l2) {
            tmpHead.setNext(l2);
        }

        return beforeHead.getNext();
    }

    /**
     * 官方解法，使用递归
     * 时间复杂度：O(n+m)。 因为每次调用递归都会去掉 l1 或者 l2 的头元素（直到至少有一个链表为空），函数 mergeTwoList 中只会遍历每个元素一次。所以，时间复杂度与合并后的链表长度为线性关系。
     *
     * 空间复杂度：O(n+m)。调用 mergeTwoLists 退出时 l1 和 l2 中每个元素都一定已经被遍历过了，所以 n+m 个栈帧会消耗 O(n+m) 的空间。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        } else if (l1.getVal() <= l2.getVal()) {
            l1.setNext(mergeTwoLists2(l1.getNext(), l2));
            return l1;
        } else {
            l2.setNext(mergeTwoLists2(l2.getNext(), l1));
            return l2;
        }
    }

    /**
     * 官方解法，迭代法，跟我的解法想法一致，但是代码更加简洁
     * 时间复杂度：O(n+m) 。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中， while 循环的次数等于两个链表的总长度。所有其他工作都是常数级别的，所以总的时间复杂度是线性的。
     * <p>
     * 空间复杂度：O(1) 。迭代的过程只会产生几个指针，所以它所需要的空间是常数级别的。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.getVal() <= l2.getVal()) {
                prev.setNext(l1);
                l1 = l1.getNext();
            } else {
                prev.setNext(l2);
                l2 = l2.getNext();
            }
            prev = prev.getNext();
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.setNext(l1 == null ? l2 : l1);

        return prehead.getNext();
    }

    private class ListNode {
        private int val;
        private ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}


