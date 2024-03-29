package algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 1410. HTML 实体解析器
 * <p>
 * 「HTML实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
 * <p>
 * HTML 里这些特殊字符和它们对应的字符实体包括：
 * <p>
 * 双引号：字符实体为&quot;，对应的字符是"。
 * 单引号：字符实体为&apos;，对应的字符是'。
 * 与符号：字符实体为&amp;，对应对的字符是&。
 * 大于号：字符实体为&gt;，对应的字符是>。
 * 小于号：字符实体为&lt;，对应的字符是<。
 * 斜线号：字符实体为&frasl;，对应的字符是/。
 * 给你输入字符串text，请你实现一个 HTML实体解析器，返回解析器解析后的结果。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "&amp; is an HTML entity but &ambassador; is not."
 * 输出："& is an HTML entity but &ambassador; is not."
 * 解释：解析器把字符实体 &amp; 用 & 替换
 * <p>
 * 示例2：
 * 输入：text = "and I quote: &quot;...&quot;"
 * 输出："and I quote: \"...\""
 * <p>
 * 示例 3：
 * 输入：text = "Stay home! Practice on Leetcode :)"
 * 输出："Stay home! Practice on Leetcode :)"
 * <p>
 * 示例 4：
 * 输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
 * 输出："x > y && x < y is always false"
 * <p>
 * 示例 5：
 * 输入：text = "leetcode.com&frasl;problemset&frasl;all"
 * 输出："leetcode.com/problemset/all"
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 10^5
 * 字符串可能包含 256 个ASCII 字符中的任意字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/html-entity-parser
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M1410_html_entity_parser {

    private class Solution {
        private Map<String, Character> charMap = new HashMap<String, Character>() {{
            put("&quot;", '"');
            put("&apos;", '\'');
            put("&amp;", '&');
            put("&gt;", '>');
            put("&lt;", '<');
            put("&frasl;", '/');
        }};

        public String entityParser(String text) {
            StringBuilder result = new StringBuilder();

            StringBuilder stack = new StringBuilder();
            for (int index = 0; index < text.length(); index++) {
                char charTmp = text.charAt(index);
                if (stack.length() != 0) {
                    stack.append(charTmp);
                    if (charTmp == ';') {
                        if (charMap.containsKey(stack.toString())) {
                            result.append(charMap.get(stack.toString()));
                        } else {
                            result.append(stack.toString());
                        }
                        stack = new StringBuilder();
                    }
                } else {
                    if (charTmp == '&') {
                        stack.append(charTmp);
                    } else {
                        result.append(charTmp);
                    }
                }
            }

            return result.toString();
        }
    }
}
