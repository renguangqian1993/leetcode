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

    public static void main(String[] args) {
        String str = "aabad";
        String result = new M005_LongestPalindromicSubstring().longestPalindrome2(str);
        System.out.println(result);
    }

    /**
     * 官方解法：中心扩展法
     * 时间复杂度：O(n^2)，由于围绕中心来扩展回文会耗去 O(n)的时间，所以总的复杂度为 O(n^2)
     * 空间复杂度：O(1)。
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        String longestPalindromeStr = "";

        for (int index = 0; index < s.length() - 1; index++) {
            int len1 = expandAroundCenter(s, index, index);
            int len2 = expandAroundCenter(s, index, index + 1);

            if (longestPalindromeStr.length() >= len1 && longestPalindromeStr.length() >= len2) {
                continue;
            }

            int indexL;
            int len = Math.max(len1, len2);
            if (len1 > len2) {
                indexL = index - (len1 / 2);
            } else {
                indexL = index - (len2 / 2 - 1);
            }
            longestPalindromeStr = s.substring(indexL, len);

        }
        return longestPalindromeStr;
    }

    //此方法有问题
    private int expandAroundCenter(String s, int indexL, int indexR) {
        if (s.charAt(indexL) != s.charAt(indexR)) {
            return 0;
        }

        int indexLTmp = indexL;
        int indexRTmp = indexR;

        while (s.charAt(indexLTmp) == s.charAt(indexRTmp) && indexLTmp > 0 && indexRTmp < s.length() - 1) {
            indexLTmp--;
            indexRTmp++;
        }

        return indexRTmp - indexLTmp + 1;
    }

    public String longestPalindrome3(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];

        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                // 区间应该慢慢放大
                // 状态转移方程：如果头尾字符相等并且中间也是回文
                // 在头尾字符相等的前提下，如果收缩以后不构成区间（最多只有 1 个元素），直接返回 True 即可
                // 否则要继续看收缩以后的区间的回文性
                // 重点理解 or 的短路性质在这里的作用
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestPalindrome) {
                        longestPalindrome = r - l + 1;
                        longestPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }

}
