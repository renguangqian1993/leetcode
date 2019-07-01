package algorithms.medium;

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
     * 最坏情况是O(n^3)的时间复杂度，所以超时了。
     * 下一步考虑从中心去查找匹配，复杂度是否有所降低？
     */
    public String longestPalindrome(String s) {
        String longestPalindromicStr = "";

        for (int indexL = 0; indexL < s.length(); indexL++) {
            for (int indexR = s.length(); indexR > indexL; indexR--) {
                String tmpStr = s.substring(indexL, indexR);
                if (judgePalindromeStrByRecurrence(tmpStr) && tmpStr.length() > longestPalindromicStr.length()) {
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
    private boolean judgePalindromeStrByRecurrence(String inputStr) {
        if (inputStr.length() == 0 || inputStr.length() == 1) {
            return true;
        }

        if (inputStr.charAt(0) != inputStr.charAt(inputStr.length() - 1)) {
            return false;
        } else if (inputStr.length() == 2) {
            return true;
        }

        return judgePalindromeStrByRecurrence(inputStr.substring(1, inputStr.length() - 1));
    }

    /**
     * 官方解法：中心扩展法
     * 时间复杂度：O(n^2)，由于围绕中心来扩展回文会耗去 O(n)的时间，所以总的复杂度为 O(n^2)
     * 空间复杂度：O(1)。
     * TODO start, end的判断不熟悉
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
