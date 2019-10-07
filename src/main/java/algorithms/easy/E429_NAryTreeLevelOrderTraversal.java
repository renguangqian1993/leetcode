package algorithms.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * We should return its level order traversal:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 *  
 * <p>
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E429_NAryTreeLevelOrderTraversal {
    /**
     * 深度优先
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (null != root) {
            levelOrderDepthFirst(list, Collections.singletonList(root), 0);
        }
        return list;
    }

    public void levelOrderDepthFirst(List<List<Integer>> list, List<Node> childNodes, int depth) {
        if (null == childNodes || childNodes.size() <= 0) {
            return;
        }

        if (list.size() < depth + 1) {
            list.add(depth, new ArrayList<>());
        }
        List<Integer> listOfCurrDepth = list.get(depth);

        for (Node childNode : childNodes) {
            listOfCurrDepth.add(childNode.val);
            levelOrderDepthFirst(list, childNode.children, depth + 1);
        }
    }

    /**
     * 广度优先
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (null != root) {
            levelOrderWidthFirst(list, Collections.singletonList(root), 0);
        }
        return list;
    }

    public void levelOrderWidthFirst(List<List<Integer>> list, List<Node> childNodes, int depth) {
        if (null == childNodes || childNodes.size() <= 0) {
            return;
        }

        if (list.size() < depth + 1) {
            list.add(depth, new ArrayList<>());
        }
        List<Integer> listOfCurrDepth = list.get(depth);
        for (Node childNode : childNodes) {
            listOfCurrDepth.add(childNode.val);
        }

        for (Node childNode : childNodes) {
            levelOrderWidthFirst(list, childNode.children, depth + 1);
        }

    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
