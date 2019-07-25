package algorithms.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E058_LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int indexR = s.length() - 1;
        for (int index = indexR; index >= 0; index--) {
            if (s.charAt(index) != ' ') {
                indexR = index;
                break;
            }
        }

        int indexL = indexR;
        for (int index = indexR; index >= 0; index--) {
            if (s.charAt(index) == ' ') {
                break;
            }
            indexL--;

        }

        return indexR - indexL;
    }

    public static void main(String[] args) {
        String str = " hello world ";

        System.out.println(lengthOfLastWord(str));
    }
}
