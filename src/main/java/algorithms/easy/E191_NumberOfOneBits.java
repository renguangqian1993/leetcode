package algorithms.easy;

/**
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 *  
 *
 * Example 1:
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 *
 * Example 2:
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 *
 * Example 3:
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *  
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the input represents the signed integer -3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-1-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E191_NumberOfOneBits {

    /**
     * 执行用时 :4 ms, 在所有 Java 提交中击败了57.45%的用户
     * 内存消耗 :34.1 MB, 在所有 Java 提交中击败了16.41%的用户
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int countOfOne = 0;

        for (int offset = 0; offset < 32; offset++) {
            int low = (n >> offset);
            low &= 1;

            if (low == 1) {
                countOfOne++;
            }
        }
        return countOfOne;
    }

    /**
     * 官方解法二
     * TODO 需要理解为啥直接减去十进制的一
     * answer: 与(n-1)进行与操作，每次只会消除最低位的1
     */
    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

}
