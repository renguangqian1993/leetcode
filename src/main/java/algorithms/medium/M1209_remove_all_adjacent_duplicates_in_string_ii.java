package algorithms.medium;

import java.util.Stack;

/**
 * 1209. 删除字符串中的所有相邻重复项 II
 *
 * 给你一个字符串s，「k 倍重复项删除操作」将会从 s中选择k个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 *
 * 你需要对s重复进行无限次这样的删除操作，直到无法继续为止。
 *
 * 在执行完所有删除操作后，返回最终得到的字符串。
 *
 * 本题答案保证唯一。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 *
 * 示例 2：
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 *
 * 示例 3：
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s中只含有小写英文字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class M1209_remove_all_adjacent_duplicates_in_string_ii {
    public static void main(String[] args) {
    }

    /**
     * 栈存储每个字符，遍历字符串
     * 数据量很大时超时
     */
    private static class Solution {
        public String removeDuplicates(String s, int k) {
            StringBuilder buffer = new StringBuilder();

            Stack<Character> stack = new Stack<>();
            for (int index = 0; index < s.length(); index++) {
                int count = 1;
                char c = s.charAt(index);
                while (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                    count++;
                }

                if (count < k) {
                    while ((count--) > 0) {
                        stack.push(c);
                    }
                }
            }

            while (!stack.isEmpty()) {
                buffer.insert(0, stack.pop());
            }

            return buffer.toString();
        }
    }
}
