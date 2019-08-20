package algorithms.easy;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its minimum depth = 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E111_MinimumDepthOfBinaryTree {

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.61%的用户
     * 内存消耗 :40.3 MB, 在所有 Java 提交中击败了5.59%的用户
     *
     * @desciption 自上而下，从左向右遍历，找【左孩子与右孩子同时为null】的最浅的节点
     */
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        } else if (null == root.left && null == root.right) {
            return 1;
        }

        int depthOfLeftChild = null == root.left ? Integer.MAX_VALUE : minDepth(root.left);
        int depthOfRightChild = null == root.right ? Integer.MAX_VALUE : minDepth(root.right);

        return 1 + Math.min(depthOfLeftChild, depthOfRightChild);
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
