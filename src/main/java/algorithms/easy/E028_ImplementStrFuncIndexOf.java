package algorithms.easy;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * <p>
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E028_ImplementStrFuncIndexOf {
    /**
     * 执行用时:4 ms, 在所有 Java 提交中击败了43.45%的用户
     * 内存消耗:36.4 MB, 在所有 Java 提交中击败了83.06%的用户
     *
     * @param haystack
     * @param needle
     * @return
     * @description: 时间复杂度为O(n ^ 2), 空间复杂度为O(n ^ 2)
     * @idea: 从左遍历haystack，匹配每一个字符
     */
    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle
                || haystack.length() < needle.length()) {
            return -1;
        } else if (needle.length() == 0) {
            return 0;
        }
        boolean matchedFlag = false;
        for (int indexOfHaystack = 0;
             indexOfHaystack <= haystack.length() - needle.length();
             indexOfHaystack++) {
            matchedFlag = true;
            for (int indexOfNeedle = 0; indexOfNeedle < needle.length(); indexOfNeedle++) {
                if (haystack.charAt(indexOfHaystack + indexOfNeedle) != needle.charAt(indexOfNeedle)) {
                    matchedFlag = false;
                    break;
                }
            }

            if (matchedFlag) {
                return indexOfHaystack;
            }
        }

        return -1;
    }
}
