package algorithms.easy;

import java.util.ArrayList;
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
     * 使用递归，超出时间限制了
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (null == root) {
            return list;
        }


        List<List<Integer>> leftList = levelOrderBottom(root.left);
        List<List<Integer>> rightList = levelOrderBottom(root.right);

        int maxDepth = Math.max(leftList.size(), rightList.size());
        for (int index = maxDepth - 1; index >= 0; index++) {
            List<Integer> listOfOneDepth = new ArrayList<>();
            if (leftList.size() > index) {
                listOfOneDepth.addAll(leftList.get(index));
            }
            if (rightList.size() > index) {
                listOfOneDepth.addAll(rightList.get(index));
            }

            list.add(listOfOneDepth);
        }


        list.add(new ArrayList<Integer>() {{
            add(root.val);
        }});

        return list;
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
