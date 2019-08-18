package algorithms.easy;

import java.util.ArrayDeque;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * <p>
 * Example 1:
 * Input:     1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * Output: true
 * <p>
 * Example 2:
 * Input:     1         1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * Output: false
 * <p>
 * Example 3:
 * Input:     1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * Output: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E100_SameTree {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了82.81%的用户
     * 内存消耗 :35 MB, 在所有 Java 提交中击败了64.92%的用户
     *
     * @param p
     * @param q
     * @return
     *
     * @description 使用递归，判断当前节点数值、左子树、右子树
     *
     * 时间复杂度 : O(N)，其中 N 是树的结点数，因为每个结点都访问一次。
     *
     * 空间复杂度 : 最优情况（完全平衡二叉树）时为 O(log(N))，最坏情况下（完全不平衡二叉树）时为 O(N)，用于维护递归栈。
     *
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) {
            return true;
        } else if (null == p || null == q) {
            //一颗树为null，一个有值
            return false;
        }

        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    /**
     * TODO 官方解法二
     * 方法二：迭代
     * 直觉
     * <p>
     * 从根开始，每次迭代将当前结点从双向队列中弹出。然后，进行方法一中的判断：
     * <p>
     * p 和 q 不是 None,
     * <p>
     * p.val 等于 q.val,
     * <p>
     * 若以上均满足，则压入子结点。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/xiang-tong-de-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param p
     * @param q
     * @return
     */
    public boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;

        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q)) return false;
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)) return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)) return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


