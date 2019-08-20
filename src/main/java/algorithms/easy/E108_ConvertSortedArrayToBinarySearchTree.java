package algorithms.easy;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class E108_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        new E108_ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums);
    }

    /**
     *
     * 执行用时 :2 ms, 在所有 Java 提交中击败了77.27%的用户
     * 内存消耗 :38.6 MB, 在所有 Java 提交中击败了43.81%的用户
     * @description 使用递归，或者叫做分治？
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return null;
        }

        int rootIndex = (nums.length - 1) / 2;

        TreeNode root = new TreeNode(nums[rootIndex]);

        this.appendChildNodes(root, nums, rootIndex, 0, nums.length - 1);

        return root;
    }

    /**
     *
     * @param node 当前节点
     * @param nums 数组形式全部数据
     * @param currentIndex 当前节点对应数组下标
     * @param leftIndex 当前数据区域左下标
     * @param rightIndex 当前数据区域右下标
     */
    private void appendChildNodes(TreeNode node, int[] nums, int currentIndex, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex && leftIndex == currentIndex) {
            return;
        }

        int rootIndexOfLeftChild = currentIndex - (currentIndex - leftIndex + 1) / 2;

        int rootIndexOfRightChild = currentIndex + (rightIndex - currentIndex + 1) / 2;

        if (rootIndexOfLeftChild != currentIndex) {
            node.left = new TreeNode(nums[rootIndexOfLeftChild]);
            appendChildNodes(node.left, nums, rootIndexOfLeftChild, leftIndex, currentIndex - 1);
        }

        if (rootIndexOfRightChild != currentIndex) {
            node.right = new TreeNode(nums[rootIndexOfRightChild]);
            appendChildNodes(node.right, nums, rootIndexOfRightChild, currentIndex + 1, rightIndex);

        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
