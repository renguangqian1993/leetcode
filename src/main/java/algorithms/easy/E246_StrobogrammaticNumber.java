package algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * <p>
 * Example 1:
 * Input:  "69"
 * Output: true
 * <p>
 * Example 2:
 * Input:  "88"
 * Output: true
 * <p>
 * Example 3:
 * Input:  "962"
 * Output: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/strobogrammatic-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E246_StrobogrammaticNumber {
    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了79.75%的用户
     * 内存消耗 :34.3 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public boolean isStrobogrammatic(String num) {
        if (null == num) return false;
        if (num.isEmpty()) return true;

        Map<Character, Character> relation = new HashMap<Character, Character>() {{
            put('0', '0');
            put('1', '1');
            put('8', '8');
            put('6', '9');
            put('9', '6');
        }};

        char[] chars = num.toCharArray();

        for (int index = 0; index <= chars.length / 2; index++) {
            if (!relation.containsKey(chars[index]) || chars[chars.length - 1 - index] != relation.get(chars[index])) {
                return false;
            }
        }

        return true;
    }
}
