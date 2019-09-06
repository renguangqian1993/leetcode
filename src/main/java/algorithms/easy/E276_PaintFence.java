package algorithms.easy;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 *
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 *
 * Return the total number of ways you can paint the fence.
 *
 * Note:
 * n and k are non-negative integers.
 *
 * Example:
 *
 * Input: n = 3, k = 2
 * Output: 6
 * Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:
 *
 *             post1  post2  post3
 *  -----      -----  -----  -----
 *    1         c1     c1     c2
 *    2         c1     c2     c1
 *    3         c1     c2     c2
 *    4         c2     c1     c1 
 *    5         c2     c1     c2
 *    6         c2     c2     c1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paint-fence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E276_PaintFence {
    /**
     * TODO，参考别人答案
     * @thought 动态规划解法在于推出当前解与前边解之间的关系表达式
     * 执行用时 :1 ms, 在所有 Java 提交中击败了91.30%的用户
     * 内存消耗 :33.9 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public int numWays(int n, int k) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return k;
        }

        int prevPrev = k;
        int prev = k * k;

        int result = k * k;
        for (int index = 2; index < n; index++) {
            result = prevPrev * (k - 1) + prev * (k - 1);

            prevPrev = prev;
            prev = result;
        }

        return result;
    }
}
