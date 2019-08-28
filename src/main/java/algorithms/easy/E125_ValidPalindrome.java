package algorithms.easy;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 * Input: "race a car"
 * Output: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E125_ValidPalindrome {

    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        String str3 = "aa";
        String str4 = "abba";
        String str5 = "0P";
        System.out.println(isPalindrome(str1));
        System.out.println(isPalindrome(str2));
        System.out.println(isPalindrome(str3));
        System.out.println(isPalindrome(str4));
        System.out.println(isPalindrome(str5));
    }

    /**
     * 执行用时 :23 ms, 在所有 Java 提交中击败了21.38%的用户
     * 内存消耗 :50.7 MB, 在所有 Java 提交中击败了5.01%的用户
     * 递归
     * 时间复杂度为O(n)，所有的节点遍历了两次
     * 空间复杂度为O(1)
     */
    public static boolean isPalindrome(String s) {
        if (null == s || s.length() <= 1) {
            return true;
        }
        s = s.toLowerCase();

        return isPalindrome(s, 0, s.length() - 1);
    }

    private static boolean isPalindrome(String str, int indexL, int indexR) {
        if (indexL == indexR) {
            return true;
        } else if (!validChar(str.charAt(indexL))) {
            return isPalindrome(str, indexL + 1, indexR);
        } else if (!validChar(str.charAt(indexR))) {
            return isPalindrome(str, indexL, indexR - 1);
        } else if (indexL + 1 == indexR) {
            return (str.charAt(indexL) == str.charAt(indexR));
        }

        return (str.charAt(indexL) == str.charAt(indexR)) && isPalindrome(str, indexL + 1, indexR - 1);
    }

    private static boolean validChar(char charInput) {
        return (charInput >= 'a' && charInput <= 'z') || (charInput >= '0' && charInput <= '9');
    }
}
