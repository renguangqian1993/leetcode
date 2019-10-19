package algorithms.easy;

/**
 * Given an array of characters, compress it in-place.
 * <p>
 * The length after compression must always be smaller than or equal to the original array.
 * <p>
 * Every element of the array should be a character (not int) of length 1.
 * <p>
 * After you are done modifying the input array in-place, return the new length of the array.
 * <p>
 *  
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * <p>
 *  
 * Example 1:
 * <p>
 * Input:
 * ["a","a","b","b","c","c","c"]
 * <p>
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * <p>
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 *  
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["a"]
 * <p>
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * <p>
 * Explanation:
 * Nothing is replaced.
 *  
 * <p>
 * Example 3:
 * <p>
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * <p>
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * <p>
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 *  
 * <p>
 * Note:
 * <p>
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-compression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E443_StringCompression {
    public static void main(String[] args) {
        compress1(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'});
    }

    /**
     * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
     * 内存消耗 :37.9 MB, 在所有 java 提交中击败了76.32%的用户
     *
     * @param chars
     * @return
     */
    public static int compress1(char[] chars) {
        int slowIndex = 0;
        int countOfRepeatChar = 1;

        for (int index = 1; index < chars.length; index++) {
            if (chars[index] != chars[slowIndex] || index == chars.length - 1) {

                if (countOfRepeatChar > 1) {
                    while (countOfRepeatChar >= 10) {
                        chars[++slowIndex] = (char) (countOfRepeatChar / 10 + '0');
                        countOfRepeatChar %= 10;
                    }
                    chars[++slowIndex] = (char) (countOfRepeatChar + '0');
                    countOfRepeatChar = 1;
                }

                chars[++slowIndex] = chars[index];
            } else {
                countOfRepeatChar++;
            }
        }


        return slowIndex + 1;
    }

    /**
     * 参考官方优雅的解法
     *
     * @param chars
     * @return
     */
    public static int compress2(char[] chars) {
        int writeIndex = 0;
        int repeatCharIndex = 0;

        for (int readIndex = 0; readIndex < chars.length; readIndex++) {
            if (readIndex == chars.length - 1 || chars[readIndex] != chars[readIndex + 1]) {
                chars[writeIndex++] = chars[readIndex];

                if (readIndex > repeatCharIndex) {
                    for (char charOfCount : String.valueOf(readIndex - repeatCharIndex + 1).toCharArray()) {
                        chars[writeIndex++] = charOfCount;
                    }
                }

                repeatCharIndex = readIndex + 1;
            }
        }


        return writeIndex;
    }
}
