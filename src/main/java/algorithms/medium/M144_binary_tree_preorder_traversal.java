package algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 *
 * 给定一个二叉树，返回它的前序遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M144_binary_tree_preorder_traversal {


    private class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            visitNodeRecursively(root);
            return list;
        }

        private void visitNodeRecursively(TreeNode node) {
            if (Objects.isNull(node)) {
                return;
            }
            list.add(node.val);
            visitNodeRecursively(node.left);
            visitNodeRecursively(node.right);
        }
    }

    private class SolutionByStack {
        List<Integer> list = new ArrayList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
            if (!Objects.isNull(root)) {
                Stack<TreeNode> stack = new Stack();
                stack.push(root);
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    TreeNode left = node.left;
                    TreeNode right = node.right;

                    list.add(node.val);
                    if (!Objects.isNull(right)) {
                        stack.push(right);
                    }
                    if (!Objects.isNull(left)) {
                        stack.push(left);
                    }
                }
            }
            return list;
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
