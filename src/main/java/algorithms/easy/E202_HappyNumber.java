package algorithms.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E202_HappyNumber {

    public static void main(String[] args) {
        isHappy(19);
    }
    /**
     * 暴力法
     * 执行用时 :6 ms, 在所有 Java 提交中击败了56.63%的用户
     * 内存消耗 :34.4 MB, 在所有 Java 提交中击败了23.82%的用户
     */
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (true) {

            if (1 == n) {
                return true;
            } else {
                int tmpN = 0;
                while (n != 0) {
                    tmpN += Math.pow((n % 10), 2);
                    n /= 10;
                }
                n = tmpN;

                if (set.contains(n)) {
                    return false;
                } else {
                    set.add(n);
                }
            }
        }

    }
}
