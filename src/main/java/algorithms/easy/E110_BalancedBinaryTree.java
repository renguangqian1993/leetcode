package algorithms.easy;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class E110_BalancedBinaryTree {

    /**
     * 使用递归，从底部往上判断平衡
     * 执行用时 :2 ms, 在所有 Java 提交中击败了97.15%的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了54.32%的用户
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }


        return -1 != getDepthIfBalance(root);
    }

    private int getDepthIfBalance(TreeNode node) {
        if (null == node) {
            return 0;
        }

        int depthOfLeftChild = getDepthIfBalance(node.left);
        if (-1 == depthOfLeftChild) {
            return -1;
        }

        int depthOfRightChild = getDepthIfBalance(node.right);
        if (-1 == depthOfRightChild) {
            return -1;
        }

        if (Math.abs(depthOfLeftChild - depthOfRightChild) <= 1) {
            return 1 + Math.max(depthOfLeftChild, depthOfRightChild);
        }

        return -1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

}
