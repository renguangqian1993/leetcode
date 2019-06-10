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
public class M003_LongestSubstringWithoutRepeatingCharacters {

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
        List<Set<Character>> substringList = new ArrayList<>();

        for (int index = 0; index < s.length(); index++) {
            char charByIndex = s.charAt(index);

            substringList.add(new HashSet<>());

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


    /**
     * Runtime: 72 ms, faster than 13.74% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 37.5 MB, less than 94.02% of Java online submissions for Longest Substring Without Repeating Characters.
     */
    public int lengthOfLongestSubstring2(String s) {
        int maxLength = 0;

        if (null == s || s.length() == 0) {
            return maxLength;
        }


        for (int index = 0; index < s.length(); index++) {
            Set<Character> characters = new HashSet<>();
            for (int index2 = index; index2 < s.length(); index2++) {
                char charByIndex = s.charAt(index2);

                if (!characters.contains(charByIndex)) {
                    characters.add(charByIndex);
                    if (maxLength <= characters.size()) {
                        maxLength = characters.size();
                    }
                } else {
                    if (maxLength <= characters.size()) {
                        maxLength = characters.size();
                    }
                    break;
                }
            }
        }

        return maxLength;
    }

    /**
     * Runtime: 13 ms, faster than 44.28% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 37.6 MB, less than 91.50% of Java online submissions for Longest Substring Without Repeating Characters.
     * 参考官方解答《滑动窗口》，如果出现了冲突值，遍历窗口列表并删除冲突值及其左侧的元素，之后再向右侧滑动。
     */
    public int lengthOfLongestSubstring3(String s) {
        int maxLength = 0;

        if (null == s || s.length() == 0) {
            return maxLength;
        }

        Set<Character> characters = new HashSet<>();

        for (int indexL = 0, indexR = 0; indexL < s.length() && indexR < s.length();) {
            char charByIndex = s.charAt(indexR);

            if (characters.contains(charByIndex)) {
                characters.remove(s.charAt(indexL++));
            } else {
                characters.add(s.charAt(indexR++));
                maxLength = Math.max(maxLength, characters.size());
            }
        }

        return maxLength;
    }

    /**
     * Runtime: 7 ms, faster than 86.96% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 35.9 MB, less than 99.93% of Java online submissions for Longest Substring Without Repeating Characters.
     * 解法3在移动窗口时，最坏情况下需要判断窗口队列大小的次数。
     * 使用Map存储字符的下标则不需要移除元素，窗口左下标为<当前窗口左下标, 冲突元素下标>最大值。
     */
    public int lengthOfLongestSubstring4(String s) {
        int maxLength = 0;

        if (null == s || s.length() == 0) {
            return maxLength;
        }
        int indexL = -1, indexR = 0;

        Map<Character, Integer> characterMapByIndex = new HashMap<>();

        for (; indexR < s.length(); indexR++) {
            if (characterMapByIndex.containsKey(s.charAt(indexR))) {
                indexL = Math.max(characterMapByIndex.get(s.charAt(indexR)), indexL);
            }
            characterMapByIndex.put(s.charAt(indexR), indexR);
            maxLength = Math.max(maxLength, indexR - indexL);
        }

        return maxLength;
    }
}
