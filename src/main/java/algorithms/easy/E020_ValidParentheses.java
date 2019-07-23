package algorithms.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * Input: "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * Input: "(]"
 * Output: false
 * <p>
 * Example 4:
 * Input: "([)]"
 * Output: false
 * <p>
 * Example 5:
 * Input: "{[]}"
 * Output: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E020_ValidParentheses {
    /**
     * 执行用时 :3 ms, 在所有 Java 提交中击败了94.34%的用户
     * 内存消耗 :34.8 MB, 在所有 Java 提交中击败了82.49%的用户
     *
     * @param s
     * @return
     * @description: 使用栈存储字符，
     * 最坏情况比较N次，N为字符串长度，堆栈存储N-1个字符，
     * 时间复杂度为O(n)，空间复杂度为O(n)
     */
    public boolean isValid(String s) {
        if (null == s || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char charTmp : chars) {
            if (charTmp == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char charPre = stack.pop();
                    if (charPre != '(') {
                        return false;
                    }
                }
            } else if (charTmp == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char charPre = stack.pop();
                    if (charPre != '{') {
                        return false;
                    }
                }
            } else if (charTmp == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char charPre = stack.pop();
                    if (charPre != '[') {
                        return false;
                    }
                }
            } else {
                stack.push(charTmp);
            }
        }

        return stack.isEmpty();
    }

}
