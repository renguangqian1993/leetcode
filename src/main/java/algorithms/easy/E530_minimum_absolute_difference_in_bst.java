package algorithms.easy;

/**
 * 530. 二叉搜索树的最小绝对差
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 *
 * 提示：
 *
 * 树中至少有 2 个节点。
 * 本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class E530_minimum_absolute_difference_in_bst {

    /**
     * 划重点：二叉搜索树
     * 所以中序遍历时，节点的值是递增的
     */
    private static class Solution {
        int pre = -1;
        int result = Integer.MAX_VALUE;
        public int getMinimumDifference(TreeNode root) {
            visitNode(root);
            return result;
        }

        private void visitNode(TreeNode node) {
            if (null == node) {
                return;
            }

            visitNode(node.left);

            if (pre == -1) {
                pre = node.val;
            } else {
                result = Math.min(result, node.val - pre);
                pre = node.val;
            }

            visitNode(node.right);
        }
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
