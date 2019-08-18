package algorithms.easy;


/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its depth = 3.
 */
public class E104_MaximumDepthOfBinaryTree {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了98.93%的用户
     * 内存消耗 :37 MB, 在所有 Java 提交中击败了54.28%的用户
     *
     * @description 递归。。。
     * <p>
     * 时间复杂度：我们每个结点只访问一次，因此时间复杂度为 O(N)，其中 N 是结点的数量。
     * 空间复杂度：在最糟糕的情况下，树是完全不平衡的，例如每个结点只剩下左子结点，递归将会被调用 N 次（树的高度），因此保持调用栈的存储将是 O(N)。
     * 但在最好的情况下（树是完全平衡的），树的高度将是 log(N)。因此，在这种情况下的空间复杂度将是 O(log(N))。
     */
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int depthOfLeftChild = maxDepth(root.left);
        int depthOfRightChild = maxDepth(root.right);

        return 1 + Math.max(depthOfLeftChild, depthOfRightChild);
    }

    /**
     * TODO 官方解法2
     * 我们还可以在栈的帮助下将上面的递归转换为迭代。
     * <p>
     * 我们的想法是使用 DFS 策略访问每个结点，同时在每次访问时更新最大深度。
     * <p>
     * 所以我们从包含根结点且相应深度为 1 的栈开始。然后我们继续迭代：将当前结点弹出栈并推入子结点。每一步都会更新深度。
     * 时间复杂度：O(N)。
     * 空间复杂度：O(N)。
     *
     * @param root
     * @return
     */
//    public int maxDepth2(TreeNode root) {
//        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//        if (root != null) {
//            stack.add(new Pair(root, 1));
//        }
//
//        int depth = 0;
//        while (!stack.isEmpty()) {
//            Pair<TreeNode, Integer> current = stack.poll();
//            root = current.getKey();
//            int current_depth = current.getValue();
//            if (root != null) {
//                depth = Math.max(depth, current_depth);
//                stack.add(new Pair(root.left, current_depth + 1));
//                stack.add(new Pair(root.right, current_depth + 1));
//            }
//        }
//        return depth;
//    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
