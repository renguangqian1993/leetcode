package algorithms.easy;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 *
 * Example 2:
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 *
 * Note: Your solution should be in logarithmic time complexity.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E172_FactorialTrailingZeroes {


    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.68%的用户
     * 内存消耗 :34.3 MB, 在所有 Java 提交中击败了79.72%的用户
     */
    public int trailingZeroes(int n) {
        int result = 0;
        while (n > 0) {
            result += (n / 5);
            n /= 5;
        }

        return result;
    }
}
