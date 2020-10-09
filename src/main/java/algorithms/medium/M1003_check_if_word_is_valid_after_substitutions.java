package algorithms.medium;

import java.util.Stack;

/**
 * 1003. 检查替换后的词是否有效
 *
 * 给定有效字符串"abc"。
 *
 * 对于任何有效的字符串 V，
 * 我们可以将 V 分成两个部分 X 和 Y，
 * 使得 X + Y（X 与 Y 连接）等于 V。（X或 Y 可以为空。）
 * 那么，X + "abc" + Y 也同样是有效的。
 *
 * 例如，如果 S = "abc"，
 * 则有效字符串的示例是："abc"，"aabcbc"，"abcabc"，"abcabcababcc"。
 * 无效字符串的示例是："abccba"，"ab"，"cababc"，"bac"。
 *
 * 如果给定字符串 S 有效，则返回 true；否则，返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入："aabcbc"
 * 输出：true
 * 解释：
 * 从有效字符串 "abc" 开始。
 * 然后我们可以在 "a" 和 "bc" 之间插入另一个 "abc"，产生 "a" + "abc" + "bc"，即 "aabcbc"。
 * 示例 2：
 *
 * 输入："abcabcababcc"
 * 输出：true
 * 解释：
 * "abcabcabc" 是有效的，它可以视作在原串后连续插入 "abc"。
 * 然后我们可以在最后一个字母之前插入 "abc"，产生 "abcabcab" + "abc" + "c"，即 "abcabcababcc"。
 * 示例 3：
 *
 * 输入："abccba"
 * 输出：false
 * 示例 4：
 *
 * 输入："cababc"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S[i] 为'a'、'b'、或'c'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1003_check_if_word_is_valid_after_substitutions {
    private class Solution {
        Stack<Character> stack = new Stack<>();

        public boolean isValid(String s) {
            //倒序入栈
            for (int index = s.length() - 1; index >= 0; index--) {
                stack.push(s.charAt(index));
            }

            dealStack();

            return stack.isEmpty();
        }

        private void dealStack() {
            if (stack.isEmpty() || 'a' != stack.peek()) {
                //第一位不是a，跳出去让上一层处理
                //栈空，直接跳出去
                return;
            }

            //a出栈
            stack.pop();

            //a出栈后为空，a还原并跳出
            if (stack.isEmpty()) {
                stack.push('a');
                return;
            }

            //栈顶不为b，递归处理后边的字符
            if ('b' != stack.peek()) {
                dealStack();
            }

            //栈空，或者后边字符不为b，则不匹配，a重新入栈并返回
            if (stack.isEmpty() || 'b' != stack.peek()) {
                stack.push('a');
                return;
            }

            //b出栈
            stack.pop();
            //栈空，缺少c，a,b入栈并返回
            if (stack.isEmpty()) {
                stack.push('b');
                stack.push('a');
                return;
            }

            //栈顶不为c，递归处理后边字符
            if ('c' != stack.peek()) {
                dealStack();
            }

            //栈空即缺c或栈顶不为c，a,b入栈并返回
            if (stack.isEmpty() || 'c' != stack.peek()) {
                stack.push('b');
                stack.push('a');
                return;
            }

            //c出栈，此时处理完一个字符串
            stack.pop();

            //栈非空，判断后边的字符
            if (!stack.isEmpty()) {
                dealStack();
            }

        }
    }
}
