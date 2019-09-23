package algorithms.easy;

import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1.
 *
 * Example 2:
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nested-list-weight-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E339_NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    /**
     * 递归
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :34.3 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        if (null == nestedList || nestedList.size() == 0) {
            return sum;
        }

        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.getInteger() != null) {
                sum += (depth * nestedInteger.getInteger());
            }
            sum += depthSum(nestedInteger.getList(), depth + 1);
        }

        return sum;
    }

    private interface NestedInteger {
//        // Constructor initializes an empty nested list.
//        public NestedInteger();
//
//        // Constructor initializes a single integer.
//        public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
