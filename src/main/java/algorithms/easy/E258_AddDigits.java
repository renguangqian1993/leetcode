package algorithms.easy;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E258_AddDigits {
    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了98.25%的用户
     * 内存消耗 :34.5 MB, 在所有 Java 提交中击败了11.84%的用户
     */
    public int addDigits(int num) {
        int result = num;
        while (num >= 10) {
            result = 0;
            while (num > 0) {
                result += num % 10;
                num /= 10;
            }

            num = result;
        }

        return result;
    }
}
