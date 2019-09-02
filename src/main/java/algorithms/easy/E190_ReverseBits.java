package algorithms.easy;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 *  
 *
 * Example 1:
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 *
 * Example 2:
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001.
 *  
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 *  
 *
 * Follow up:
 *
 * If this function is called many times, how would you optimize it?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E190_ReverseBits {

    //TODO 需要回顾一下位操作相关知识
    // you need treat n as an unsigned value

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了98.79%的用户
     * 内存消耗 :30 MB, 在所有 Java 提交中击败了5.27%的用户
     */
    public int reverseBits(int n) {

        int result = 0;
        for (int offset = 0; offset <= 31; offset++) {
            //offset位移到最右端
            int low = (n >> offset);
            //将最低位之外的其他位置零
            low &= 1;
            //数据位倒置
            low = (low << (31 - offset));
            //结果为0000,取或即可
            result |= low;
        }
        return result;
    }


}
