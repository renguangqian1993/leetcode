package algorithms.medium;

import java.util.Stack;

/**
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 *
 *
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class M394_decode_string {

    /**
     * 递归
     */
    private class Solution1 {
        private int globalIndex = 0;
        public String decodeString(String s) {
            if (globalIndex >= s.length()) {
                return "";
            }

            StringBuilder buffer = new StringBuilder();

            if (s.charAt(globalIndex) == '[') {
                globalIndex++;
            }

            int childCount = 0;
            while (globalIndex < s.length()) {
                char c = s.charAt(globalIndex);
                if (isAlphabet(c)) {
                    buffer.append(c);
                    globalIndex++;
                } else if (isNumber(c)) {
                    childCount = 10 * childCount + (c - '0');
                    globalIndex++;
                } else if ('[' == c) {
                    //遇到子串了
                    String childStr = decodeString(s);
                    while ((childCount--) > 0) {
                        buffer.append(childStr);
                    }
                    childCount = 0;
                } else if (']' == c) {
                    //递归进来的，全局Index+1，跳出去
                    globalIndex++;
                    break;
                }
            }

            return buffer.toString();
        }

        private boolean isNumber(char c) {
            return c >= '0' && c <= '9';
        }

        private boolean isAlphabet(char c) {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }
    }

}
