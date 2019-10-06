package algorithms.easy;

/**
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.
 * <p>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p>
 * Note:
 * Assume the length of given string will not exceed 1,010.
 * <p>
 * Example:
 * <p>
 * Input:
 * "abccccdd"
 * <p>
 * Output:
 * 7
 * <p>
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E409_LongestPalindrome {
    public static void main(String[] args) {
        String s = "abccccdd";
        longestPalindrome(s);
    }

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :36.2 MB, 在所有 Java 提交中击败了78.59%的用户
     * A : 65
     * Z : 90
     * a : 97
     * z : 122
     */
    public static int longestPalindrome(String s) {
        int[] countArray = new int[52];
        for (char charTmp : s.toCharArray()) {
            if (charTmp >= 'a') {
                countArray[charTmp - 'a' + 26]++;
            } else {
                countArray[charTmp - 'A']++;
            }
        }

        boolean singleCharFlag = false;
        int count = 0;
        for (int countOfOneChar : countArray) {
            if (!singleCharFlag) {
                singleCharFlag = countOfOneChar % 2 == 1;
            }

            count += countOfOneChar / 2 * 2;
        }

        return count + (singleCharFlag ? 1 : 0);
    }
}
