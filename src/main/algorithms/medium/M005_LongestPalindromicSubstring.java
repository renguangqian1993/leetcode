package src.main.algorithms.medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class M005_LongestPalindromicSubstring {

    /**
     * 使用穷举+递归。
     * 由字符串最左最右两边一直往中间缩小。
     * 最坏情况是O(n^2)的时间复杂度，所以超时了
     */
    public String longestPalindrome(String s) {
        String longestPalindromicStr = "";

        for (int indexL = 0; indexL < s.length(); indexL++) {
            for (int indexR = s.length(); indexR > indexL; indexR--) {
                String tmpStr = s.substring(indexL, indexR);
                if (judgePalindromeStr(tmpStr) && tmpStr.length() > longestPalindromicStr.length()) {
                    longestPalindromicStr = tmpStr;

                    if (longestPalindromicStr.length() >= (s.length() - indexL)) {
                        return longestPalindromicStr;
                    }
                }


            }
        }
        return longestPalindromicStr;
    }

    /**
     * 判断输入字符串是否是回文字符串，使用递归
     */
    private boolean judgePalindromeStr(String inputStr) {
        if (inputStr.length() == 0 || inputStr.length() == 1) {
            return true;
        }

        if (inputStr.charAt(0) != inputStr.charAt(inputStr.length() - 1)) {
            return false;
        } else if (inputStr.length() == 2) {
            return true;
        }

        return judgePalindromeStr(inputStr.substring(1, inputStr.length() - 1));
    }

    public static void main(String[] args) {
        M005_LongestPalindromicSubstring model = new M005_LongestPalindromicSubstring();
        String str = "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
        System.out.println(model.longestPalindrome(str));
    }
}
