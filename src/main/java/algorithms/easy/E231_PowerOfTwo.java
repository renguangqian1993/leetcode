package algorithms.easy;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Example 2:
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 *
 * Example 3:
 * Input: 218
 * Output: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E231_PowerOfTwo {

    /**
     * TODO 位运算
     * 2^n，二进制始终是只有一位为1。2^n - 1，则是其余位为1
     * 执行用时 :2 ms, 在所有 Java 提交中击败了98.27%的用户
     * 内存消耗 :34.3 MB, 在所有 Java 提交中击败了11.82%的用户
     */
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
