package algorithms.easy;

import javafx.util.Pair;

import java.util.Stack;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E112_PathSum {

    /**
     * @description 1.深度优先搜索，利用stack的FIFO特性，
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumDepthFirstSearch(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, root.val));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            Integer tmpSum = pair.getValue();
            if (tmpSum == sum && node.left == null && node.right == null) {
                return true;
            } else if (tmpSum != sum) {
                if (null != node.right) {
                    stack.push(new Pair<>(node.right, tmpSum + node.right.val));
                }
                if (null != node.left) {
                    stack.push(new Pair<>(node.left, tmpSum + node.left.val));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        E112_PathSum task = new E112_PathSum();
        task.hasPathSumDepthFirstSearch(null, -5);
    }

    /**
     * @description 2.广度优先搜索
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumBreadthFirstSearch(TreeNode root, int sum) {
        return false;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
