package algorithms.easy;

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
     * @description 使用递归，判断当前节点数值、左子树、右子树
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


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


