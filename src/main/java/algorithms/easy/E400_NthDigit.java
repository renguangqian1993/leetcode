package algorithms.easy;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
 *
 * Example 1:
 * Input:
 * 3
 * Output:
 * 3
 *
 * Example 2:
 * Input:
 * 11
 * Output:
 * 0
 *
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E400_NthDigit {

    public static void main(String[] args) {
        for (int index = 1; index <= 200; index++) {
            System.out.println(index + " : " + findNthDigit(index));
        }

    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 32.8 MB
     * , 在所有 Java 提交中击败了
     * 80.00%
     * 的用户
     */
    public static int findNthDigit(int numInput) {
        //当前区间为几位数
        int carry = 1;
        //记录当前区间之前区间位数和
        double sumOfDight = 0;
        while (sumOfDight + Math.pow(10.0D, carry - 1) * 9 * carry < numInput) {

            sumOfDight += Math.pow(10.0D, carry - 1) * 9 * carry;
            carry++;
        }

        int num = (int) (Math.pow(10.0D, carry - 1) + (numInput - sumOfDight - 1) / carry);

        return String.valueOf(num).charAt((int) ((numInput - sumOfDight - 1) % carry)) - '0';
    }


}
