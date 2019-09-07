package algorithms.easy;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * Output: ["1->2->5", "1->3"]
 *
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E257_BinaryTreePaths {

    /**
     * 递归。空间复杂度为O(n)，时间复杂度为O(n)
     * 执行用时 :3 ms, 在所有 Java 提交中击败了91.85%的用户
     * 内存消耗 :36.9 MB, 在所有 Java 提交中击败了97.17%的用户
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();

        getPath("", root, pathList);

        return pathList;
    }
    private static void getPath(String prefix, TreeNode node, List<String> pathList) {
        if (null == node) {
            return;
        } if (null == node.left && null == node.right) {
            pathList.add((prefix + "->" + node.val).substring(2));
        } else {
            getPath(prefix + "->" + node.val, node.left, pathList);
            getPath(prefix + "->" + node.val, node.right, pathList);
        }
    }

    /**
     * 时间复杂度为O(n)，空间复杂度为O(n)
     * 执行用时 :7 ms, 在所有 Java 提交中击败了6.79%的用户
     * 内存消耗 :36.7 MB, 在所有 Java 提交中击败了97.17%的用户
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        if (null == root) {
            return pathList;
        }

        Stack<Pair<TreeNode, String>> stack = new Stack<>();
        stack.push(new Pair<>(root, String.valueOf(root.val)));

        while (!stack.isEmpty()) {
            Pair<TreeNode, String> pair = stack.pop();
            TreeNode node = pair.getKey();
            String path = pair.getValue();

            if (null == node.left && null == node.right) {
                pathList.add(path);
            } else {
                path += "->";

                if (null != node.right) {
                    stack.push(new Pair<>(node.right, path + node.right.val));
                }
                if (null != node.left) {
                    stack.push(new Pair<>(node.left, path + node.left.val));
                }
            }
        }

        return pathList;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
