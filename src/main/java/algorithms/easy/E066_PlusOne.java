package algorithms.easy;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E066_PlusOne {

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了97.67%的用户
     * 内存消耗 :36.1 MB, 在所有 Java 提交中击败了36.69%的用户
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int index = digits.length - 1; index >= 0; index--) {
            if (digits[index] < 9) {
                digits[index] += 1;
                return digits;
            } else {
                digits[index] = 0;
            }
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9};

        int[] digits2 = plusOne(digits);

        for (int tmp : digits2) {
            System.out.println(tmp);
        }
    }

}
