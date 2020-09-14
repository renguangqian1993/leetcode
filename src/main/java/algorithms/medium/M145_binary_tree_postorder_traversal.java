package algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 145. 二叉树的后序遍历
 *
 * 给定一个二叉树，返回它的 后序遍历。
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
 * 输出: [3,2,1]
 * 进阶:递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M145_binary_tree_postorder_traversal {

    class Solution {
        private List<Integer> list = new ArrayList<>();
        public List<Integer> postorderTraversal(TreeNode root) {
            visitNodeRecursively(root);
            return list;
        }

        private void visitNodeRecursively(TreeNode node) {
            if (Objects.isNull(node)) {
                return;
            }

            visitNodeRecursively(node.left);
            visitNodeRecursively(node.right);
            list.add(node.val);
        }
    }

    class SolutionByStack {
        private List<Integer> list = new ArrayList<>();
        public List<Integer> postorderTraversal(TreeNode root) {
            if (!Objects.isNull(root)) {
                Stack<TreeNode> stack = new Stack<>();
                stack.push(root);

                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    TreeNode left = node.left;
                    TreeNode right = node.right;

                    node.left = null;
                    node.right = null;

                    if (Objects.isNull(left) && Objects.isNull(right)) {
                        list.add(node.val);
                        continue;
                    }
                    stack.push(node);
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() { }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
