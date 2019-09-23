package algorithms.easy;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 * Input: 16
 * Output: true
 *
 * Example 2:
 * Input: 5
 * Output: false
 *
 * Follow up: Could you solve it without loops/recursion?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E342_PowerOfFour {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :33.6 MB, 在所有 Java 提交中击败了12.89%的用户
     */
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }

        while (num % 4 == 0) {
            num /= 4;
        }

        return num == 1;
    }

    public boolean isPowerOfFour2(int num) {
        String rebaseVal = Integer.toString(num, 4);
        return rebaseVal.matches("^10*$");
    }

    public static boolean isPowerOfFour3(int num) {
        if(num < 0) {
            return false;
        } else if ((num & (num - 1)) != 0) {
            /**
             * 1:       1
             * 4:     100  3:    011
             * 16:  10000 15:  01111
             * 32: 100000 31: 010000
             * 如果num是4的幂，那么num & (num-1)的结果为0
             */
            return false;
        }
        /**
         * 0101 0101 0101
         * 1的位置即是4的幂，取&操作后必定为其自身值
         */
        return (num & (0x55555555)) == num;
    }

    public static boolean isPowerOfFour4(int num) {

        double check = Math.log(num) / Math.log(4);
        if(check == (int)check)
            return true;
        return false;
    }
}
