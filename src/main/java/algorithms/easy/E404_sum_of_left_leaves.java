package algorithms.easy;

import java.util.Objects;
import java.util.Stack;

/**
 * 404. 左叶子之和
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E404_sum_of_left_leaves {
    private boolean leafNode(TreeNode node) {
        return !Objects.isNull(node) && Objects.isNull(node.left) && Objects.isNull(node.right);
    }
    //深度优先搜索 + 递归
    class SolutionByDfsAndRecursively {
        public int sumOfLeftLeaves(TreeNode root) {
            if (Objects.isNull(root)) {
                return 0;
            }
            int sum = 0;
            if (leafNode(root.left)) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
            if (!leafNode(root.right)) {
                sum += sumOfLeftLeaves(root.right);
            }
            return sum;
        }
    }

    //广度优先搜索 + 栈操作
    class SolutionByBfsAndStack {
        public int sumOfLeftLeaves(TreeNode root) {
            if (Objects.isNull(root)) {
                return 0;
            }
            int sum = 0;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (!Objects.isNull(node.left)) {
                    if (leafNode(node.left)) {
                        sum += node.left.val;
                    } else {
                        stack.push(node.left);
                    }
                }
                if (!Objects.isNull(node.right)) {
                    if (!leafNode(node.right)) {
                        stack.push(node.left);
                    }
                }
            }

            return sum;
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
