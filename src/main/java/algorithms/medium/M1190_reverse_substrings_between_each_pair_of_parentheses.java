package algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 1190. 反转每对括号间的子串
 *
 * 给出一个字符串s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中不应包含任何括号。
 *
 *
 *
 * 示例 1：
 * 输入：s = "(abcd)"
 * 输出："dcba"
 *
 * 示例 2：
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 *
 * 示例 3：
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 *
 * 示例 4：
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 我们确保所有括号都是成对出现的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class M1190_reverse_substrings_between_each_pair_of_parentheses {

    public static void main(String[] args) {
        Solution2 solution2 =
                new M1190_reverse_substrings_between_each_pair_of_parentheses().new Solution2();

        String[] arr = new String[]{"f(ul)ao(t(y)qbn)()sj", "(abcd)"};
    }

    /**
     * 字符串扫描+栈
     * 空间复杂度：O(N)
     * 时间复杂度：O(MN)，M为括号对数量
     */
    private class Solution1 {

        private int count = 0;
        private Stack<Character> stack = new Stack<>();

        public String reverseParentheses(String s) {
            for (int index = 0; index < s.length(); index++) {
                if ('(' == s.charAt(index)) {
                    count++;
                }
                stack.push(s.charAt(index));
            }

            while (count > 0) {
                reverseStack();
                count--;
            }

            StringBuilder builder = new StringBuilder();
            while (!stack.isEmpty()) {
                builder.insert(0, stack.pop());
            }

            return builder.toString();
        }

        private void reverseStack() {
            Stack<Character> dataBehand = new Stack<>();
            for (int index = 0; index < count; index++) {
                while (stack.peek() != ')') {
                    //非括号入栈
                    dataBehand.push(stack.pop());
                }
                if (index < count - 1) {
                    //右括号入栈
                    dataBehand.push(stack.pop());
                } else {
                    stack.pop();
                }
            }

            List<Character> charsToReverse = new ArrayList<>();
            while (stack.peek() != '(') {
                charsToReverse.add(stack.pop());
            }
            //左括号出栈
            stack.pop();

            for (Character character : charsToReverse) {
                stack.push(character);
            }

            while (!dataBehand.isEmpty()) {
                stack.push(dataBehand.pop());
            }
        }

    }

    /**
     * 实例变量存储char[]
     * 使用Stack记录左括号坐标
     * 遍历字符串，遇到左括号入栈，遇到右括号则（弹出栈首部的左括号下标，操作char[]，交换数据）
     *
     * 空间复杂度：O(N)
     * 时间复杂度：O(MN)，M为括号对数量
     */
    private class Solution2 {

        private char[] chars;

        public String reverseParentheses(String s) {
            StringBuilder builder = new StringBuilder();

            chars = s.toCharArray();

            Stack<Integer> stack = new Stack<>();
            for (int index = 0; index < chars.length; index++) {
                if ('(' == chars[index]) {
                    stack.push(index);
                } else if (')' == chars[index]) {
                    reverseArray(stack.pop(), index);
                }
            }

            for (char charTmp : chars) {
                if ('(' != charTmp && ')' != charTmp) {
                    builder.append(charTmp);
                }
            }

            return builder.toString();
        }

        private void reverseArray(int leftIndex, int rightIndex) {
            while (leftIndex < rightIndex) {
                if (chars[leftIndex] == '(' || chars[leftIndex] == ')') {
                    leftIndex++;
                    continue;
                }
                if (chars[rightIndex] == '(' || chars[rightIndex] == ')') {
                    rightIndex--;
                    continue;
                }
                char charTmp = chars[leftIndex];
                chars[leftIndex] = chars[rightIndex];
                chars[rightIndex] = charTmp;

                leftIndex++;
                rightIndex--;
            }
        }

    }

    /**
     * 不需要交换数组的解法
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     *
     * 参考自：
     * https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/solution/chong-dong-fa-yi-ge-zhi-zhen-de-qi-huan-piao-liu-b/
     */
    private class Solution3 {
        public String reverseParentheses(String s) {
            StringBuilder builder = new StringBuilder();

            Map<Integer, Integer> indexPairMap = new HashMap<>();
            Stack<Integer> indexStack = new Stack<>();
            for (int index = 0; index < s.length(); index++) {
                switch (s.charAt(index)) {
                    case '(': {
                        indexStack.push(index);
                        break;
                    }
                    case ')': {
                        int indexLeft = indexStack.pop();
                        indexPairMap.put(indexLeft, index);
                        indexPairMap.put(index, indexLeft);
                        break;
                    }
                    default:
                        //do nothing
                        break;
                }
            }

            for (int index = 0, step = 1; index < s.length() && index >= 0; index += step) {
                if (indexPairMap.containsKey(index)) {
                    //遇到括号
                    index = indexPairMap.get(index);
                    step = -step;
                } else {
                    builder.append(s.charAt(index));
                }
            }

            return builder.toString();
        }

    }
}
