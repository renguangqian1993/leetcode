package algorithms.easy;

import java.util.*;

/**
 * Given a List of words,
 * return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 *
 *  
 *
 *
 *
 *  
 * Example:
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *  
 *
 * Note:
 *
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E500_KeyboardRow {
    private static Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('Q', 1);
        put('W', 1);
        put('E', 1);
        put('R', 1);
        put('T', 1);
        put('Y', 1);
        put('U', 1);
        put('I', 1);
        put('O', 1);
        put('P', 1);
        put('A', 2);
        put('S', 2);
        put('D', 2);
        put('F', 2);
        put('G', 2);
        put('H', 2);
        put('J', 2);
        put('K', 2);
        put('L', 2);
        put('Z', 3);
        put('X', 3);
        put('C', 3);
        put('V', 3);
        put('B', 3);
        put('N', 3);
        put('M', 3);
    }};
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();

        for (String word : words) {
            char[] chars = word.toUpperCase().toCharArray();
            boolean flag = true;
            for (int index = 1; index < chars.length; index++) {
                if (map.get(chars[index]) != map.get(chars[0])) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                list.add(word);
            }
        }

        return list.toArray(new String[0]);
    }
}
