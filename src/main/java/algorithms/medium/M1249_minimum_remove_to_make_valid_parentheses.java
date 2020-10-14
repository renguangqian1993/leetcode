package algorithms.medium;

import java.util.Stack;

/**
 * 1249. 移除无效的括号
 *
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 你需要从字符串中删除最少数目的 '(' 或者 ')'（可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 *
 * 请返回任意一个合法字符串。
 *
 * 有效「括号字符串」应当符合以下任意一条要求：
 *
 * 空字符串或只包含小写字母的字符串
 * 可以被写作AB（A连接B）的字符串，其中A和B都是有效「括号字符串」
 * 可以被写作(A)的字符串，其中A是一个有效的「括号字符串」
 *
 *
 * 示例 1：
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 *
 * 示例 2：
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 *
 * 示例 3：
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 *
 * 示例 4：
 * 输入：s = "(a(b(c)d)"
 * 输出："a(b(c)d)"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s[i]可能是'('、')'或英文小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class M1249_minimum_remove_to_make_valid_parentheses {

    public static void main(String[] args) {
        new Solution2().minRemoveToMakeValid("lee(t(c)o)de)");
    }
    /**
     * 扫描字符串，字符入栈
     * 统计左括号数量leftCount，遇到右括号时减一
     * 多余的右括号，直接忽略不入栈
     *
     * 扫描结束后，拼接栈中字符，去掉leftCount个左括号
     */
    private static class Solution1 {
        public String minRemoveToMakeValid(String s) {
            int leftCount = 0;
            Stack<Character> stack = new Stack<>();
            for (int index = 0; index < s.length(); index++) {
                char c = s.charAt(index);

                switch (c) {
                    case '(': {
                        leftCount++;
                        stack.push(c);
                        break;
                    }
                    case ')': {
                        if (leftCount > 0) {
                            leftCount--;
                            stack.push(c);
                        }
                        break;
                    }
                    default: {
                        stack.push(c);
                        break;
                    }
                }
            }
            if (stack.isEmpty()) {
                return "";
            }
            char[] chars = new char[stack.size() - leftCount];
            int index = chars.length - 1;
            while (!stack.isEmpty()) {
                if ('(' == stack.peek() && (leftCount > 0)) {
                    stack.pop();
                    leftCount--;
                    continue;
                }

                chars[index--] = stack.pop();
            }

            return new String(chars);
        }
    }

    /**
     * 使用单调栈 存储非法字符下标
     * 第一次扫描字符串时从左到右，将非法坐标入栈
     * 第二次扫描（组装结果）时从右到左，跳过非法坐标并弹出
     */
    private static class Solution2 {
        public String minRemoveToMakeValid(String s) {

            Stack<Integer> indexToRemove = new Stack<>();
            for (int index = 0; index < s.length(); index++) {

                switch (s.charAt(index)) {
                    case '(': {
                        indexToRemove.push(index);
                        break;
                    }
                    case ')': {
                        if (indexToRemove.isEmpty()) {
                            //单独出现的右括号
                            indexToRemove.push(index);
                        } else if ('(' == s.charAt(indexToRemove.peek())) {
                            //弹出成对出现的左括号
                            indexToRemove.pop();
                        } else {
                            //单独出现的右括号
                            indexToRemove.push(index);
                        }
                        break;
                    }
                    default: {
                        //do nothing
                        break;
                    }
                }
            }

            StringBuilder builder = new StringBuilder();
            for (int index = s.length() - 1; index >= 0; index--) {
                if (!indexToRemove.isEmpty() && index == indexToRemove.peek()) {
                    indexToRemove.pop();
                    continue;
                }

                builder.insert(0, s.charAt(index));
            }
            return builder.toString();
        }
    }
}
