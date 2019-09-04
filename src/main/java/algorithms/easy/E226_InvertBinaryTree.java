package algorithms.easy;

import java.util.Stack;

/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E226_InvertBinaryTree {

    /**
     * 递归，有啥技术含量？？？
     * 时间复杂度O(n)，每个节点遍历了一次
     * 空间复杂度O(n)，因为递归有隐性占用空间
     * 执行用时 :1 ms, 在所有 Java 提交中击败了89.14%的用户
     * 内存消耗 :35 MB, 在所有 Java 提交中击败了38.99%的用户
     */
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    /**
     * 利用堆栈实现
     *
     * 既然树中的每个节点都只被访问/入队一次，时间复杂度就是 O(n)，其中 n 是树中节点的个数。
     *
     * 空间复杂度是 O(n)，即使在最坏的情况下，也就是队列里包含了树中所有的节点。对于一颗完整二叉树来说，叶子节点那一层拥有O(n) 个节点。

     * 执行用时 :2 ms, 在所有 Java 提交中击败了89.14%的用户
     * 内存消耗 :34.4 MB, 在所有 Java 提交中击败了39.07%的用户
     */
    public TreeNode invertTree2(TreeNode root) {
        if (null == root) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();

            stack.push(currNode.left);
            currNode.left = currNode.right;
            currNode.right = stack.pop();

            if (null != currNode.left) {
                stack.push(currNode.left);
            }
            if (null != currNode.right) {
                stack.push(currNode.right);
            }
        }

        return root;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
