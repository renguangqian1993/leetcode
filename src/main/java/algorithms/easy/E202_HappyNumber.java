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
                n = getPowResult(n);

                if (set.contains(n)) {
                    return false;
                } else {
                    set.add(n);
                }
            }
        }

    }

    /**
     * 双指针法，快节点每次走两步，慢节点每次走一步，当两个节点相同时，说明已经出现了循环，判断当前结果是否为1即可
     * 执行用时 :4 ms, 在所有 Java 提交中击败了75.51%的用户
     * 内存消耗 :33.7 MB, 在所有 Java 提交中击败了27.10%的用户
     */
    public static boolean isHappy2(int n) {
        int fastNode = n;
        int slowNode = n;
        while (true) {

            fastNode = getPowResult(fastNode);
            fastNode = getPowResult(fastNode);

            slowNode = getPowResult(slowNode);
            if (slowNode == fastNode) {
                return fastNode == 1;
            }
        }
    }

    private static int getPowResult(int n) {
        int result = 0;
        while (n != 0) {
            result += Math.pow((n % 10), 2);
            n /= 10;
        }
        return result;
    }
}
