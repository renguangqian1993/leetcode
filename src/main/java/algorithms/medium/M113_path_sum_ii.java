package algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M113_path_sum_ii {
    class SolutionByDfs {
        private List<List<Integer>> lists = new ArrayList<>();
        private List<Integer> list = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            dfs(root, sum);
            return lists;
        }

        private void dfs(TreeNode node, int remain) {
            if (Objects.isNull(node)) {
                return;
            }

            remain -= node.val;
            list.add(node.val);

            if (Objects.isNull(node.left) && Objects.isNull(node.right) && remain == 0) {
                lists.add(new ArrayList<>(list));
            } else {
                dfs(node.left, remain);
                dfs(node.right, remain);
            }
            list.remove(list.size() - 1);
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
