package algorithms.easy;

import java.math.BigDecimal;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * <p>
 * Note: Do not use any built-in library function such as sqrt.
 * <p>
 * Example 1:
 * Input: 16
 * Output: true
 * <p>
 * Example 2:
 * Input: 14
 * Output: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E367_ValidPerfectSquare {
    public static void main(String[] args) {
        isPerfectSquare(2147483647);
    }

    /**
     * 二分法
     * 时间复杂度O(log(n)),空间复杂度O(1)
     */
    public static boolean isPerfectSquare(int num) {
        int indexL = 0;
        int indexR = num;

        BigDecimal bigVal = new BigDecimal(num);

        while (indexL <= indexR) {
            int mid = (indexL + indexR) / 2;
            BigDecimal square = new BigDecimal(mid).pow(2);
            if (square.compareTo(bigVal) == 0) {
                return true;
            } else if (square.compareTo(bigVal) < 0) {
                indexL = mid + 1;
            } else {
                indexR = mid - 1;
            }
        }

        return false;
    }

    /**
     * 数学归纳法
     * n^2 = 1 + 3 + ... + (2n-1)
     * @param num
     * @return
     */
    public static boolean isPerfectSquare2(int num) {
        int index = 1;
        while (num > 0) {
            num -= index;
            index += 2;
        }

        return num == 0;
    }

    /**
     * 牛顿迭代法，TODO
     * f(X(n+1)) = X(n) - (f(X(n)) / f'(X(n)))
     */
    public static boolean isPerfaceSquare3(int num) {
        if(1 == num) {
            return true;
        }
        int sqrt = num / 2;
        while((double)sqrt * sqrt > num){
            sqrt = (sqrt + num / sqrt) / 2;
        }

        return sqrt * sqrt == num;
    }
}
