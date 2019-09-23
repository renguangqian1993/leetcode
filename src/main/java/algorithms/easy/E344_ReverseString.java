package algorithms.easy;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *  
 *
 * Example 1:
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E344_ReverseString {
    public void reverseString1(char[] s) {
        if (null == s || s.length <= 1) {
            return;
        }
        for (int index = 0; index < s.length / 2; index++) {
            char tmp = s[index];
            s[index] = s[s.length - 1 - index];
            s[s.length - 1 - index] = tmp;
        }
    }

    /**
     * 双指针法
     */
    public void reverseString2(char[] s) {
        if (null == s || s.length <= 1) {
            return;
        }
        int indexL = -1;
        int indexR = s.length;
        while (++indexL < --indexR) {
            char tmp = s[indexL];

            s[indexL] = s[indexR];
            s[indexR] = tmp;
        }
    }

    /**
     * TODO 位运算是短板
     * 三次异或运算交换两个值
     */
    public void reverseString3(char[] s) {
        if (null == s || s.length <= 1) {
            return;
        }
        for (int index = 0; index < s.length / 2; index++) {
            s[index] ^= s[s.length - 1 - index];
            s[s.length - 1 - index] ^= s[index];
            s[index] ^= s[s.length - 1 - index];
        }
    }
}
