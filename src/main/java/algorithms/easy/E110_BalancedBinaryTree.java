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
     * 递归，解答错误
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
        if (null == null) {
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
        TreeNode(int x) { val = x; }
    }

}
