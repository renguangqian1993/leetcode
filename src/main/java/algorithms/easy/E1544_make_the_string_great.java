package algorithms.easy;

import java.util.Stack;

/**
 * 1544. 整理字符串
 *
 * 给你一个由大小写英文字母组成的字符串 s 。
 *
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：
 * 0 <= i <= s.length - 2
 * s[i] 是小写字符，但 s[i + 1] 是相同的大写字符；反之亦然 。
 *
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 *
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 *
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 *
 *
 * 示例 1：
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 *
 * 示例 2：
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 *
 * 示例 3：
 * 输入：s = "s"
 * 输出："s"
 *
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含小写和大写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/make-the-string-great
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E1544_make_the_string_great {

    public static void main(String[] args) {
        System.out.println('A' - 0);
        System.out.println('Z' - 0);
        System.out.println('a' - 0);
        System.out.println('z' - 0);
    }


    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for (char charInput : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(charInput);
            } else {
                char charTop = stack.pop();
                int diff = charTop - charInput;
                if (diff != DIFF && diff != -DIFF) {
                    stack.push(charTop);
                    stack.push(charInput);
                }
            }
        }
        if (!stack.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            while (!stack.isEmpty()) {
                builder.insert(0, stack.pop());
            }
            return builder.toString();
        }

        return "";
    }

    private final int DIFF = 'a' - 'A';

}
