package algorithms.easy;

import java.util.Objects;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 *
 * 注意：本题和 1038:https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E538_convert_bst_to_greater_tree {
    class Solution {
        public TreeNode convertBST(TreeNode root) {
            sum(root, 0);
            return root;
        }

        private int sum(TreeNode node, int sum) {
            if (Objects.isNull(node)) {
                return sum;
            }

            sum = sum(node.right, sum);

            int currVal = node.val;
            node.val += sum;
            sum += currVal;

            sum = sum(node.left, sum);

            return sum;
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
