package src.main.algorithms.medium;

import java.util.*;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Runtime: 110 ms, faster than 9.92% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 41 MB, less than 6.70% of Java online submissions for Longest Substring Without Repeating Characters.
     * 好垃圾的实现方式啊，空间与时间。
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        if (null == s || s.length() == 0) {
            return 0;
        }
        List<Set<Character>> substringList = new ArrayList<Set<Character>>();

        for (int index = 0; index < s.length(); index++) {
            char charByIndex = s.charAt(index);

            substringList.add(new HashSet<Character>());

            Iterator<Set<Character>> substringIterator = substringList.iterator();
            while (substringIterator.hasNext()) {
                Set<Character> substringCharSet = substringIterator.next();
                if (substringCharSet.contains(charByIndex)) {
                    substringIterator.remove();
                } else {
                    substringCharSet.add(charByIndex);
                    if (maxLength < substringCharSet.size()) {
                        maxLength = substringCharSet.size();
                    }
                }
            }
        }

        return maxLength;
    }
}
