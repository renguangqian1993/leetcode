package algorithms.easy;

/**
 * Implement int sqrt(int x).
 * <p>
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * Input: 4
 * Output: 2
 * <p>
 * Example 2:
 * Input: 8
 * Output: 2
 * <p>
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E069_Sqrt {
    /**
     * 执行用时 :7 ms, 在所有 Java 提交中击败了39.13%的用户
     * 内存消耗 :34.6 MB, 在所有 Java 提交中击败了75.02%的用户
     *
     * @param x
     * @return
     * @description: 使用二分法查找近似值，控制精度为万分之一才通过，转int好傻
     */
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        }

        double indexL = 0D;
        double indexR = x * 2D;

        final double precision = 0.0001D;

        double decimalVal = 0;

        boolean continueFlag = true;
        while (continueFlag) {
            decimalVal = (indexL + indexR) / 2D;
            if (decimalVal * decimalVal > x) {
                indexR = decimalVal;
            } else {
                indexL = decimalVal;
            }

            continueFlag = Math.abs((decimalVal * decimalVal) - x) > precision;
        }

        return (int) decimalVal;
    }


    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }
}
