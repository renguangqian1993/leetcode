package algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * <p>
 * Note:
 * <p>
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s.
 * If the number is zero, it is represented by a single zero character '0';
 * otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 26
 * Output:
 * "1a"
 * <p>
 * Example 2:
 * Input:
 * -1
 * Output:
 * "ffffffff"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E405_ConvertANumberToHexadecimal {
    private static Map<Integer, Character> intToHexMap = new HashMap<Integer, Character>() {{
        put(0, '0');
        put(1, '1');
        put(2, '2');
        put(3, '3');
        put(4, '4');
        put(5, '5');
        put(6, '6');
        put(7, '7');
        put(8, '8');
        put(9, '9');
        put(10, 'a');
        put(11, 'b');
        put(12, 'c');
        put(13, 'd');
        put(14, 'e');
        put(15, 'f');
    }};

    /**
     * TODO：>>> 与 >>
     * 执行用时 :1 ms, 在所有 Java 提交中击败了90.19%的用户
     * 内存消耗 :33.8 MB, 在所有 Java 提交中击败了95.00%的用户
     */
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num != 0) {
            stringBuilder.append(intToHexMap.get(num & 15));
            num >>>= 4;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.toString(-1 & 15, 2));
    }
}
