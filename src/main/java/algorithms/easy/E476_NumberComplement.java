package algorithms.easy;

/**
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 *
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010.
 * So you need to output 2.
 *
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0.
 * So you need to output 0.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E476_NumberComplement {
    public static void main(String[] args) {
        findComplement(2);
    }

    /**
     * 对每一位的数与1进行异或运算得到相反的数，然后左移若干位，与结果进行或运算
     */
    public static int findComplement(int num) {
        int complement = 0;
        int index = 0;
        while (num != 0) {
            complement |= (((num & 1) ^ 1) << index);
            num >>= 1;
            index++;
        }
        return complement;
    }

    /**
     * @idea 对二进制最高位往下全部置1,然后与输入进行异或运算
     */
    public static int findComplement2(int num) {
        int tmpNum = num;
        int index = 0;
        while (tmpNum != 0) {
            index++;
            tmpNum >>= 1;
        }

        return ((int) (Math.pow(2, index) - 1)) ^ num;
    }
}
