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

    /**
     * 使用栈存储每个字符
     * 遍历字符串，循环判断栈顶字符是否与当前字符相同，相同则出栈。数量达到阈值则丢弃掉，未达到阈值则重新入栈
     * 数据量很大时超时
     */
    private static class Solution1 {
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

    /**
     * 使用栈存储每一个重复的字符出现的次数，使用StringBuilder存储已遍历的字符
     * 遍历字符串，当前字符与上一个字符相同时，判断栈顶元素（上一个字符的重复次数），数量达到阈值则delete掉，未达到阈值则栈顶元素值+1
     * 避免了 Solution1 使用栈存储字符时做的很多无用功
     */
    private static class Solution2 {
        public String removeDuplicates(String s, int k) {
            StringBuilder buffer = new StringBuilder();

            Stack<Integer> stack = new Stack<>();
            for (int index = 0; index < s.length(); index++) {
                char c = s.charAt(index);
                if (buffer.length() == 0 || buffer.charAt(buffer.length() - 1) != c) {
                    //缓存为空 || 缓存尾部元素与当前元素不同
                    buffer.append(c);
                    stack.push(1);
                    continue;
                }

                //缓存尾部元素与当前元素相同
                if (stack.peek() + 1 >= k) {
                    //达到数量阈值
                    buffer.delete(buffer.length() - stack.pop(), buffer.length());
                } else {
                    //未达到数量阈值
                    buffer.append(c);
                    stack.push(stack.pop() + 1);
                }
            }

            return buffer.toString();
        }
    }

    /**
     * 使用栈存储【字符,重复次数】，避免 Solution2 对StringBuilder的删除操作，空间换时间
     */
    private static class Solution3 {
        public String removeDuplicates(String s, int k) {
            StringBuilder buffer = new StringBuilder();

            Stack<Pair> stack = new Stack<>();
            for (int index = 0; index < s.length(); index++) {
                char c = s.charAt(index);
                if (stack.isEmpty() || stack.peek().c != c) {
                    //栈为空 || 上一个字符与当前字符不同
                    stack.push(new Pair(c, 1));
                } else if (stack.peek().count + 1 >= k) {
                    //上一个字符与当前字符相同，且数量达到阈值
                    stack.pop();
                } else {
                    //上一个字符与当前字符相同，且数量未达到阈值
                    stack.peek().count++;
                }
            }

            while (!stack.isEmpty()) {
                Pair pair = stack.pop();
                while ((pair.count--) > 0) {
                    buffer.append(pair.c);
                }
            }

            return buffer.reverse().toString();
        }

        private static class Pair {
            char c;
            int count;

            public Pair(char c, int count) {
                this.c = c;
                this.count = count;
            }
        }
    }

    /**
     * 参考官方解答，快慢指针+栈
     *
     * 慢指针记录准备写入有效字符的下标（即慢指针之前的字符就是要返回的数据），快指针记录当前正在读取的下标，栈记录每个有效字符重复的次数
     *
     */
    private static class Solution4 {
        public String removeDuplicates(String s, int k) {
            char[] chars = s.toCharArray();

            Stack<Integer> countStack = new Stack<>();
            int slow = 0;
            int fast = 0;

            while (fast < s.length()) {
                //将当前遍历到的字符写入慢指针位置
                chars[slow] = chars[fast];

                if (slow == 0 || chars[slow - 1] != chars[fast]) {
                    //当前没有有效数据 || 最后一位有效字符与当前字符不同
                    countStack.push(1);
                } else if (countStack.peek() + 1 >= k) {
                    //最后一位有效字符重复次数达到阈值，出栈、慢指针后退
                    countStack.pop();
                    slow -= k;
                } else {
                    //重复次数+1
                    countStack.push(countStack.pop() + 1);
                }

                //快慢指针均需要前进
                slow++;
                fast++;
            }

            return new String(chars, 0, slow);
        }

    }

}
