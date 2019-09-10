package algorithms.easy;

/**
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example 1:
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 *
 * Example 2:
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 *
 * Example 3:
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 *
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E263_UglyNumber {
    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了85.58%的用户
     * 内存消耗 :34.1 MB, 在所有 Java 提交中击败了12.26%的用户
     */
    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        while (num > 0) {
            if (num == 2 || num == 3 || num == 5) {
                return true;
            } else if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5== 0) {
                num /= 5;
            } else {
                return false;
            }
        }

        return false;
    }
}
