package algorithms.easy;

import javafx.util.Pair;

import java.util.LinkedList;
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
     * @description 1.深度优先搜索，利用stack的FIFO特性
     * 执行用时 :11 ms, 在所有 Java 提交中击败了5.08%的用户
     * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了23.09%的用户
     */
    public boolean hasPathSumDepthFirstSearch(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, root.val));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode tmpNode = pair.getKey();
            Integer tmpSum = pair.getValue();
            if (tmpSum == sum && tmpNode.left == null && tmpNode.right == null) {
                return true;
            } else {
                if (null != tmpNode.right) {
                    stack.push(new Pair<>(tmpNode.right, tmpSum + tmpNode.right.val));
                }
                if (null != tmpNode.left) {
                    stack.push(new Pair<>(tmpNode.left, tmpSum + tmpNode.left.val));
                }
            }
        }

        return false;
    }


    /**
     * 官方递归解法，较上边解法，优势：浅显易懂，缺势：需要遍历所有节点
     * 时间复杂度：我们访问每个节点一次，时间复杂度为 O(N)O(N) ，其中 NN 是节点个数。
     * 空间复杂度：最坏情况下，整棵树是非平衡的，例如每个节点都只有一个孩子，递归会调用 NN 次（树的高度），因此栈的空间开销是 O(N)O(N) 。但在最好情况下，树是完全平衡的，高度只有 \log(N)log(N)，因此在这种情况下空间复杂度只有 O(\log(N))O(log(N)) 。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/path-sum/solution/lu-jing-zong-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    /**
     * 官方迭代解法，与第一种我自己解法类似
     * 时间复杂度：和递归方法相同是 O(N)O(N)。
     * 空间复杂度：当树不平衡的最坏情况下是 O(N)O(N) 。在最好情况（树是平衡的）下是 O(\log N)O(logN)。
     */
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<Integer> sum_stack = new LinkedList();
        node_stack.add(root);
        sum_stack.add(sum - root.val);

        TreeNode node;
        int curr_sum;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            curr_sum = sum_stack.pollLast();
            if ((node.right == null) && (node.left == null) && (curr_sum == 0))
                return true;

            if (node.right != null) {
                node_stack.add(node.right);
                sum_stack.add(curr_sum - node.right.val);
            }
            if (node.left != null) {
                node_stack.add(node.left);
                sum_stack.add(curr_sum - node.left.val);
            }
        }
        return false;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
