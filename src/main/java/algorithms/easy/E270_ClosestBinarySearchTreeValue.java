package algorithms.easy;

import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closest-binary-search-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E270_ClosestBinarySearchTreeValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        closestValue(root, 3.428571);
    }

    /**
     * 时间复杂度为O(log(n))
     * 空间复杂度为O(1)，因记录了常数个额外数据
     * 执行用时 :1 ms, 在所有 Java 提交中击败了97.58%的用户
     * 内存消耗 :37 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static int closestValue(TreeNode root, double target) {
        Long minDist = Long.MAX_VALUE;

        int closestVal = 0;

        long longTarget = Math.round(target);
        TreeNode node = root;
        while (node != null) {
            if (longTarget == node.val) {
                closestVal = node.val;
                break;
            } else if (minDist > Math.abs(node.val - longTarget)) {
                closestVal = node.val;
                minDist = Math.abs(node.val - longTarget);
            }

            if (node.val > longTarget) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return closestVal;
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
