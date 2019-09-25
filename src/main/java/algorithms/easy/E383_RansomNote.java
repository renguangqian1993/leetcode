package algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char charTmp : ransomNote.toCharArray()) {
            int count = 1;
            if (map.containsKey(charTmp)) {
                count += map.get(charTmp);
            }

            map.put(charTmp, count);
        }

        for (char charTmp : magazine.toCharArray()) {
            if (map.isEmpty()) {
                break;
            } else if (map.containsKey(charTmp)) {
                if (map.get(charTmp) == 1) {
                    map.remove(charTmp);
                } else {
                    map.put(charTmp, map.get(charTmp) - 1);
                }
            }
        }

        return map.isEmpty();
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char charTmp : magazine.toCharArray()) {
            count[charTmp - 'a']++;
        }

        for (char charTmp : ransomNote.toCharArray()) {
            if ((--count[charTmp - 'a']) < 0) {
                return false;
            }
        }

        return true;
    }
}
