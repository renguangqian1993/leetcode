package algorithms.easy;

import java.util.*;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E637_average_of_levels_in_binary_tree {

    /**
     * 深度优先搜索
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     */
    private List<Double/**sum*/> sumList = new ArrayList<>();
    private List<Integer/**count*/> countList = new ArrayList<>();
    public List<Double> dfs(TreeNode root) {
        List<Double> avgList = new ArrayList<>();
        if (Objects.isNull(root)) {
            return avgList;
        }

        dfsVisitNode(root, 0);
        for (int index = 0; index < sumList.size(); index++) {
            avgList.add(((double) sumList.get(index)) / ((double) countList.get(index)));
        }

        return avgList;
    }
    private void dfsVisitNode(TreeNode node, int level) {
        if (Objects.isNull(node)) {
            return;
        }
        if (level < sumList.size()) {
            sumList.set(level, sumList.get(level) + (double)node.val);
            countList.set(level, countList.get(level) + 1);
        } else {
            sumList.add((double)node.val);
            countList.add(1);
        }

        dfsVisitNode(node.left, level + 1);
        dfsVisitNode(node.right, level + 1);
    }

    /**
     * 深度优先搜索
     */
    public List<Double> bfs(TreeNode root) {
        List<Double> avgList = new ArrayList<>();
        if (Objects.isNull(root)) {
            return avgList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            final int count = queue.size();
            double sum = 0.0d;

            for (int size = count; size > 0; size--) {
                TreeNode node = queue.poll();
                sum += (double) node.val;

                if (!Objects.isNull(node.left)) {
                    queue.add(node.left);
                }
                if (!Objects.isNull(node.right)) {
                    queue.add(node.right);
                }
            }

            avgList.add(sum / (double) count);
        }

        return avgList;
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
