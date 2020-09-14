package algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序遍历。
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
 * 输出: [1,3,2]
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M094_binary_tree_inorder_traversal {
    class Solution {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if (!Objects.isNull(root)) {
                visitNodeRecursively(root);
            }
            return list;
        }

        private void visitNodeRecursively(TreeNode node) {
            if (Objects.isNull(node)) {
                return;
            }
            visitNodeRecursively(node.left);
            list.add(node.val);
            visitNodeRecursively(node.right);
        }
    }

    class Solution2 {
        List<Integer> list = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if (!Objects.isNull(root)) {
                Stack<TreeNode> stack = new Stack<>();
                stack.push(root);
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    TreeNode right = node.right;
                    TreeNode left = node.left;

                    node.left = null;
                    node.right = null;
                    if (Objects.isNull(left) && Objects.isNull(right)) {
                        list.add(node.val);
                        continue;
                    }
                    if (!Objects.isNull(right)) {
                        stack.push(right);
                    }
                    stack.push(node);
                    if (!Objects.isNull(left)) {
                        stack.push(left);
                    }
                }
            }
            return list;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
