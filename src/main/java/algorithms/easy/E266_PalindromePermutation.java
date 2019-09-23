package algorithms.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * Example 1:
 * Input: "code"
 * Output: false
 *
 * Example 2:
 * Input: "aab"
 * Output: true
 *
 * Example 3:
 * Input: "carerac"
 * Output: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E266_PalindromePermutation {
    public static void main(String[] args) {
        String str = "as";
        canPermutePalindrome(str);
    }

    /**
     * 哈希表法
     * 时间复杂度为O(n)，因每一个位置都需要遍历一次，最坏情况下需要遍历两次
     * 空间复杂度为O(1）,因存储了有限个<Character,Integer>对
     * 执行用时 :2 ms, 在所有 Java 提交中击败了70.21%的用户
     * 内存消耗 :33.8 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static boolean canPermutePalindrome(String s) {

        Map<Character, Integer> hash = new HashMap<>();

        for (char charTmp : s.toCharArray()) {
            if (hash.containsKey(charTmp)) {
                hash.put(charTmp, hash.get(charTmp) + 1);
            } else {
                hash.put(charTmp, 1);
            }
        }

        int count = 0;

        for (int countOfChar : hash.values()) {
            if (countOfChar % 2 == 1) {
                count++;
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}
