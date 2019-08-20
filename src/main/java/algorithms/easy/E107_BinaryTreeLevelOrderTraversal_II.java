package algorithms.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class E107_BinaryTreeLevelOrderTraversal_II {
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了97.82%的用户
     * 内存消耗 :37.4 MB, 在所有 Java 提交中击败了28.29%的用户
     *
     * @description 还是使用递归，最外层创建大list，每一层进行补充，结束之后进行逆转
     *
     * 
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (null == root) {
            return list;
        }

        this.fillUpList(list, root, 0);

        Collections.reverse(list);

        return list;
    }

    private void fillUpList(List<List<Integer>> lists, TreeNode node, int depth) {
        if (null == node) {
            return;
        }

        List<Integer> datasOfThisDepth = Collections.emptyList();
        if (lists.size() < depth + 1) {
            datasOfThisDepth = new ArrayList<>();
            lists.add(datasOfThisDepth);
        } else {
            datasOfThisDepth = lists.get(depth);
        }

        datasOfThisDepth.add(node.val);
        fillUpList(lists, node.left, depth + 1);
        fillUpList(lists, node.right, depth + 1);
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
