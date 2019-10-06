package algorithms.easy;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E415_AddStrings {
    public static void main(String[] args) {
        addStrings("1", "9");
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        int carry = 0;
        int val1 = 0;
        int val2 = 0;
        int sum;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0) {
                val1 = num1.charAt(index1) - '0';
            } else {
                val1 = 0;
            }
            if (index2 >= 0) {
                val2 = num2.charAt(index2) - '0';
            } else {
                val2 = 0;
            }

            sum = carry + val1 + val2;

            carry = sum / 10;

            stringBuilder.append(sum % 10);

            index1--;
            index2--;
        }
        if (carry != 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }
}
