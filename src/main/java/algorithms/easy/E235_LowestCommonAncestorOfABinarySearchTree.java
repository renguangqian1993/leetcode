package algorithms.easy;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *  
 *
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 *  
 *
 * Note:
 *
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E235_LowestCommonAncestorOfABinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        lowestCommonAncestor(root, new TreeNode(1), new TreeNode(4));

    }

    /**
     * 递归，查找包含两个叶子节点的最小节点
     * 执行用时 :11 ms, 在所有 Java 提交中击败了72.21%的用户
     * 内存消耗 :41.2 MB, 在所有 Java 提交中击败了6.49%的用户
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        while (true) {
            if (leafOfTheNode(root.left, p) && leafOfTheNode(root.left, q)) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (leafOfTheNode(root.right, p) && leafOfTheNode(root.right, q)) {
                return lowestCommonAncestor(root.right, p, q);
            }

            break;
        }

        return root;
    }

    private static boolean leafOfTheNode(TreeNode root, TreeNode leaf) {
        if (root == null || leaf == null) {
            return false;
        }

        if (root.val == leaf.val) {
            return true;
        } else if (root.val > leaf.val) {
            return leafOfTheNode(root.left, leaf);
        }

        return leafOfTheNode(root.right, leaf);
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
