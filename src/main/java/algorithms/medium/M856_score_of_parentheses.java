package algorithms.medium;

import java.util.Stack;

/**
 * 856. 括号的分数
 *
 * 给定一个平衡括号字符串S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得A + B分，其中 A 和 B 是平衡括号字符串。
 * (A) 得2 * A分，其中 A 是平衡括号字符串。
 *
 *
 * 示例 1：
 * 输入： "()"
 * 输出： 1
 *
 * 示例 2：
 * 输入： "(())"
 * 输出： 2
 *
 * 示例3：
 * 输入： "()()"
 * 输出： 2
 *
 * 示例4：
 * 输入： "(()(()))"
 * 输出： 6
 *
 *
 * 提示：
 *
 * S是平衡括号字符串，且只含有(和)。
 * 2 <= S.length <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/score-of-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M856_score_of_parentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.scoreOfParentheses("(()(()))");
    }
    private static class Solution {
        private Stack<String> stack = new Stack<>();
        public int scoreOfParentheses(String S) {
            for (char c : S.toCharArray()) {
                stack.push(String.valueOf(c));
            }
            while (stack.size() != 1) {
                dealStack();
            }
            return Integer.parseInt(stack.peek());
        }

        private void dealStack() {
            if (stack.size() <= 1) {
                return;
            }

            if (")".equals(stack.peek())) {
                stack.pop();//弹出右括号
                if ("(".equals(stack.peek())) {
                    //场景：()
                    stack.pop();
                    stack.push("1");
                    return;
                }

                if (")".equals(stack.peek())) {
                    //场景：(A)，递归调用，解析A为单个数字
                    dealStack();
                    stack.push(")");
                    return;
                }

                //top是数字
                String top = stack.pop();

                //( score)场景
                if ("(".equals(stack.peek())) {
                    int score = Integer.parseInt(top);
                    stack.pop();
                    stack.push(String.valueOf(2 * score));
                    return;
                }

                //((...) score)场景,
                if (")".equals(stack.peek())) {
                    dealStack();
                    stack.push(top);
                    stack.push(")");
                    return;
                }
                //(score1 score2)场景
                int score1 = Integer.parseInt(top);
                int score2 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(score1 + score2));
                stack.push(")");

            } else if ("(".equals(stack.peek())) {
                //do nothing
            } else {
                String top = stack.pop();
                if (!"(".equals(stack.peek()) && !")".equals(stack.peek())) {
                    int score1 = Integer.parseInt(top);
                    int score2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(score1 + score2));
                    return;
                } else {
                    dealStack();
                    stack.push(top);
                }
            }
        }
    }

}
