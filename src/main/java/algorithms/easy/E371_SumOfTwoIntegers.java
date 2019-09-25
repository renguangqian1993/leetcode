package algorithms.easy;

/**
 * Calculate the sum of two integers a and b,
 * but you are not allowed to use the operator + and -.
 *
 * Example 1:
 * Input: a = 1, b = 2
 * Output: 3
 *
 * Example 2:
 * Input: a = -2, b = 3
 * Output: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E371_SumOfTwoIntegers {

    public static void main(String[] args) {
        getSum(1, 3);
    }

    public static int getSum(int a, int b) {
        //保留不进位的数据
        int result = a ^ b;
        //进位的数据
        int carry = (a & b) << 1;
        while (carry != 0) {
            int tmpCarry = (result & carry) << 1;
            result ^= carry;
            carry = tmpCarry;
        }

        return result;
    }
}
