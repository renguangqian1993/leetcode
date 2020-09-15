package algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 *
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 *
 *
 * 示例：
 *
 *   7
 *  / \
 * 3   15
 *    / \
 *   9   20
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 *
 *
 * 提示：
 *
 * next()和hasNext()操作的时间复杂度是O(1)，并使用O(h) 内存，其中h是树的高度。
 * 你可以假设next()调用总是有效的，也就是说，当调用 next()时，BST 中至少存在一个下一个最小的数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M173_binary_search_tree_iterator {

    class BSTIterator {
        Stack<TreeNode> stack = new Stack<>();
        public BSTIterator(TreeNode root) {
            while (!Objects.isNull(root)) {
                stack.push(root);
                root = root.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            if (stack.isEmpty()) {
                return -1;
            }
            TreeNode currNode = stack.pop();

            if (!Objects.isNull(currNode.right)) {
                //将右子树的左子树保存起来
                stack.push(currNode.right);
                TreeNode node = currNode.right.left;
                while (!Objects.isNull(node)) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return currNode.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
