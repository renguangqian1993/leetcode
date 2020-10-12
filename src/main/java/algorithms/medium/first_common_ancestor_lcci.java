package algorithms.medium;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。
 * 不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 *
 * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *     3
 *    / \
 *   5   1
 *  / \ / \
 * 6  2 0  8
 *   / \
 *  7   4
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-common-ancestor-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class first_common_ancestor_lcci {

    /**
     * 参照别人的解法，递归+深度优先搜索
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root)) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (Objects.isNull(leftNode) && Objects.isNull(rightNode)) {
            return null;
        } else if (!Objects.isNull(leftNode) && !Objects.isNull(rightNode)) {
            return root;
        }

        return Objects.isNull(leftNode) ? rightNode : leftNode;
    }

    /**
     * 变量存入set，通过判断set中元素数量【方法进入时】vs【方法出去时】，得出公共祖先
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Set<Integer> set = new HashSet<>();
        set.add(p.val);
        set.add(q.val);

        return search(root, set, 2);
    }

    private TreeNode search(TreeNode node, Set<Integer> set, final int totalCount) {
        if (Objects.isNull(node) || set.size() == 0) {
            return null;
        }

        int countInput = set.size();
        set.remove(node.val);
        TreeNode leftNode = search(node.left, set, totalCount);
        if (!Objects.isNull(leftNode)) {
            return leftNode;
        }

        TreeNode rightNode = search(node.right, set, totalCount);
        if (!Objects.isNull(rightNode)) {
            return rightNode;
        }

        if (countInput == totalCount && set.size() == 0) {
            return node;
        }

        return null;
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
