package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 * Input: "III"
 * Output: 3
 *
 * Example 2:
 * Input: "IV"
 * Output: 4
 *
 * Example 3:
 * Input: "IX"
 * Output: 9
 *
 * Example 4:
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 5:
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class E013_RomanToInteger {

    /**
     * Runtime: 3 ms, faster than 100.00% of Java online submissions for Roman to Integer.
     * Memory Usage: 36.3 MB, less than 99.94% of Java online submissions for Roman to Integer.
     * switch-case解决-_-
     * 但是有没有可能我写错了，比如有IIV代表8的情况?现在只认为有IV这种
     */
    public int romanToInt(String s) {
        int result = 0;
        if (null == s || "".equals(s.trim())) {
            return result;
        }

        char[] chars = s.toCharArray();
        for (int index = 0; index < chars.length;) {
            switch (chars[index]) {
                case 'I' :
                    if (index < chars.length - 1) {
                        if ('V' == chars[index + 1]) {
                            result = result + 4;
                            index += 2;
                        } else if ('X' == chars[index + 1]) {
                            result = result + 9;
                            index += 2;
                        } else {
                            result = result + 1;
                            index++;
                        }
                    } else {
                        result = result + 1;
                        index++;
                    }
                    break;
                case 'X':
                    if (index < chars.length - 1) {
                        if ('L' == chars[index + 1]) {
                            result = result + 40;
                            index += 2;
                        } else if ('C' == chars[index + 1]) {
                            result = result + 90;
                            index += 2;
                        } else {
                            result = result + 10;
                            index++;
                        }
                    } else {
                        result = result + 10;
                        index++;
                    }
                    break;
                case 'C':
                    if (index < chars.length - 1) {
                        if ('D' == chars[index + 1]) {
                            result = result + 400;
                            index += 2;
                        } else if ('M' == chars[index + 1]) {
                            result = result + 900;
                            index += 2;
                        } else {
                            result = result + 100;
                            index++;
                        }
                    } else {
                        result = result + 100;
                        index++;
                    }
                    break;
                case 'V':
                    result = result + 5;
                    index++;
                    break;
                case 'L':
                    result = result + 50;
                    index++;
                    break;
                case 'D':
                    result = result + 500;
                    index++;
                    break;
                case 'M':
                    result = result + 1000;
                    index++;
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        new E013_RomanToInteger().romanToInt("III");
    }
}
