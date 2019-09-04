package algorithms.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E242_ValidAnagram {

    /**
     * 空间复杂度O(1)，时间复杂度O(n)
     * 执行用时 :56 ms, 在所有 Java 提交中击败了16.77%的用户
     * 内存消耗 :44 MB, 在所有 Java 提交中击败了11.38%的用户
     */
    public boolean isAnagram(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char oneChar : s.toCharArray()) {
            if (map.containsKey(oneChar)) {
                map.put(oneChar, map.get(oneChar) + 1);
            } else {
                map.put(oneChar, 1);
            }
        }

        for (char oneChar : t.toCharArray()) {
            if (!map.containsKey(oneChar)) {
                return false;
            } else if (map.get(oneChar) > 1) {
                map.put(oneChar, map.get(oneChar) - 1);
            } else {
                map.remove(oneChar);
            }
        }

        return map.isEmpty();
    }


    /**
     * 执行用时 :13 ms, 在所有 Java 提交中击败了41.55%的用户
     * 内存消耗 :41.2 MB, 在所有 Java 提交中击败了36.02%的用户
     */
    public boolean isAnagram2(String s, String t) {
        if (null == s || null == t || s.length() != t.length()) {
            return false;
        }

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);

        return Arrays.equals(charS, charT);
    }
}
