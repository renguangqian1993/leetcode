package algorithms.medium;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *    3
 *   / \
 *  9  20
 *  /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class M103_binary_tree_zigzag_level_order_traversal {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.size();
    }

    //广度优先搜索 + 栈
    private class SolutionByBfsAndStack {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (!Objects.isNull(root)) {
                Stack<TreeNode> stack = new Stack<>();
                Stack<TreeNode> stack2 = new Stack<>();
                stack.push(root);

                List<Integer> list = new ArrayList<>();
                boolean leftFist = false;
                while (!stack.isEmpty()) {

                    TreeNode node = stack.pop();
                    list.add(node.val);
                    if (leftFist) {
                        if (!Objects.isNull(node.right)) {
                            stack2.push(node.right);
                        }
                        if (!Objects.isNull(node.left)) {
                            stack2.push(node.left);
                        }
                    } else {
                        if (!Objects.isNull(node.left)) {
                            stack2.push(node.left);
                        }
                        if (!Objects.isNull(node.right)) {
                            stack2.push(node.right);
                        }
                    }

                    if (stack.isEmpty()) {
                        lists.add(list);
                        list = new ArrayList<>();
                        if (!stack2.isEmpty()) {
                            leftFist = !leftFist;
                            stack = stack2;
                            stack2 = new Stack<>();
                        }
                    }
                }
            }

            return lists;
        }
    }

    //深度优先搜索 + 队列
    private class SolutionByDfsAndQueue {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (!Objects.isNull(root)) {
                dfs(root, lists, 0);
            }

            return lists;
        }
        private void dfs(TreeNode node, List<List<Integer>> lists, int level) {
            if (Objects.isNull(node)) {
                return;
            }
            if (lists.size() <= level) {
                lists.add(new LinkedList<>());
            }
            LinkedList<Integer> list = (LinkedList<Integer>) lists.get(level);

            if ((level & 1) == 1) {
                //左 <- 右
                list.addFirst(node.val);
            } else {
                //左 -> 右
                list.addLast(node.val);
            }
            dfs(node.left, lists, level + 1);
            dfs(node.right, lists, level + 1);
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
