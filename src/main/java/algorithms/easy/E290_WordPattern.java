package algorithms.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 *
 * Example 4:
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E290_WordPattern {
    /**
     * 哈希表，使用两个hashmap是空间换时间，因map.containsValue是遍历map中所有value
     * 执行用时 :2 ms, 在所有 Java 提交中击败了97.99%的用户
     * 内存消耗 :33.8 MB, 在所有 Java 提交中击败了48.62%的用户
     */
    public boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();
        String[] words = str.split(" ");
        if (chars.length != words.length) {
            return false;
        }

        Map<Character, String> relationCharToWord = new HashMap<>();
        Map<String, Character> relationWordToChar = new HashMap<>();

        for (int index = 0; index < chars.length; index++) {
            char charTmp = chars[index];
            String wordTmp = words[index];

            if (relationCharToWord.containsKey(charTmp) &&
                    (!relationWordToChar.containsKey(wordTmp) || !wordTmp.equals(relationCharToWord.get(charTmp)))) {
                return false;
            } else if (relationWordToChar.containsKey(wordTmp) &&
                    (!relationCharToWord.containsKey(charTmp) || charTmp != (relationWordToChar.get(wordTmp)))){
                return false;
            }
            relationCharToWord.put(chars[index], words[index]);
            relationWordToChar.put(words[index], chars[index]);
        }

        return true;
    }
}
