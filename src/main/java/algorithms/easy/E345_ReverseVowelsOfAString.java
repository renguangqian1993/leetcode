package algorithms.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Input: "hello"
 * Output: "holle"
 *
 * Example 2:
 * Input: "leetcode"
 * Output: "leotcede"
 *
 * Note:
 * The vowels does not include the letter "y".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (null == s || s.length() < 1) {
            return "";
        }

        Set<Character> set = new HashSet<Character>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        StringBuilder stringBuilderL = new StringBuilder();
        StringBuilder stringBuilderR = new StringBuilder();
        int indexL = 0;
        int indexR = s.length() - 1;
        while (indexL <= indexR) {
            char charL = s.charAt(indexL);
            char charR = s.charAt(indexR);

            if (indexL == indexR) {
                stringBuilderL.append(charR);
                indexL++;
                continue;
            }

            if (set.contains(charL) && set.contains(charR)) {
                stringBuilderL.append(charR);
                stringBuilderR.append(charL);
                indexL++;
                indexR--;
                continue;
            }

            if (!set.contains(charL)) {
                stringBuilderL.append(charL);
                indexL++;
            }
            if (!set.contains(charR)) {
                stringBuilderR.append(charR);
                indexR--;
            }
        }

        return stringBuilderL.toString() + stringBuilderR.reverse().toString();
    }

    public String reverseVowels2(String s) {
        if (null == s || s.length() < 1) {
            return "";
        }

        Set<Character> set = new HashSet<Character>(){{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
            add('A');
            add('E');
            add('I');
            add('O');
            add('U');
        }};

        StringBuilder stringBuilder = new StringBuilder(s);
        int indexL = 0;
        int indexR = s.length() - 1;
        while (indexL < indexR) {
            char charL = s.charAt(indexL);
            char charR = s.charAt(indexR);

            if (set.contains(charL) && set.contains(charR)) {
                stringBuilder.setCharAt(indexL, charR);
                stringBuilder.setCharAt(indexR, charL);
                indexL++;
                indexR--;
            } else if (!set.contains(charL)) {
                indexL++;
            } else if (!set.contains(charR)) {
                indexR--;
            }

        }

        return stringBuilder.toString();
    }

}
