package algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E205_IsomorphicStrings {
    public static void main(String[] args) {
        isIsomorphic("ab", "aa");
    }

    /**
     * 空间复杂度：O(4n)，维护了两份对应关系
     * 时间复杂度：O(2n)，所有下标均需要遍历一次
     * 执行用时 :41 ms, 在所有 Java 提交中击败了11.34%的用户
     * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了39.81%的用户
     */
    public static boolean isIsomorphic(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }

        Map<Character/*s.charAt(index)*/, Character/*t.charAt(index)*/> charRelationST = new HashMap<>();
        Map<Character/*t.charAt(index)*/, Character/*s.charAt(index)*/> charRelationTS = new HashMap<>();

        for (int index = 0; index < s.length(); index++) {
            char charS = s.charAt(index);
            char charT = t.charAt(index);

            if (!charRelationST.containsKey(charS) && !charRelationTS.containsKey(charT)) {
                charRelationST.put(charS, charT);
                charRelationTS.put(charT, charS);
            } else if (charRelationST.containsKey(charS) && charRelationTS.containsKey(charT)
                    && charT == charRelationST.get(charS) && charS == charRelationTS.get(charT)) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}
