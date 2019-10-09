package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <p>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <p>
 * The order of output does not matter.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * Output:
 * [0, 6]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * <p>
 * Input:
 * s: "abab" p: "ab"
 * <p>
 * Output:
 * [0, 1, 2]
 * <p>
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E438_FindAllAnagramsInAString {
    /**
     * 暴力法
     * 时间复杂度为O(m * n)
     * 空间复杂度为O(1)
     * TODO 滑动窗口
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexList = new ArrayList<>();
        if (null == s || s.isEmpty() || null == p || p.isEmpty() || s.length() < p.length()) {
            return indexList;
        }

        for (int index = 0; index < s.length() - p.length(); index++) {
            int[] countMap = new int[26];
            for (char charTmp : p.toCharArray()) {
                countMap[charTmp - 'a']++;
            }

            for (int shortIndex = index; shortIndex < index + p.length(); shortIndex++) {
                countMap[s.charAt(shortIndex) - 'a']--;
            }

            boolean matched = true;
            for (int count : countMap) {
                if (count != 0) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                indexList.add(index);
            }
        }
        return indexList;
    }
}
