package algorithms.easy;

import java.util.Stack;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E067_AddBinary {

    /**
     * 执行用时 :10 ms, 在所有 Java 提交中击败了16.06%的用户
     * 内存消耗 :36.3 MB, 在所有 Java 提交中击败了54.67%的用户
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        char[] charArra = a.toCharArray();
        char[] charArrb = b.toCharArray();

        Stack<Integer> stack = new Stack<>();
        int indexA = charArra.length - 1;
        int indexB = charArrb.length - 1;


        int upperChar = 0;
        while (indexA >= 0 && indexB >= 0) {
            int remain = (upperChar
                    + ('0' == charArra[indexA] ? 0 : 1)
                    + ('0' == charArrb[indexB] ? 0 : 1));

            if (remain == 3) {
                upperChar = 1;
                stack.push(1);
            } else if (remain == 2) {
                upperChar = 1;
                stack.push(0);
            } else if (remain == 1) {
                upperChar = 0;
                stack.push(1);
            } else {
                upperChar = 0;
                stack.push(0);
            }

            indexA--;
            indexB--;
        }

        if (indexA < 0 && indexB < 0 && upperChar == 1) {
            stack.push(1);
        }
        if (indexA >= 0) {
            binaryAddOneChar(stack, charArra, indexA, upperChar);
        }
        if (indexB >= 0) {
            binaryAddOneChar(stack, charArrb, indexB, upperChar);
        }


        StringBuffer stringBuffer = new StringBuffer();

        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
        }

        return stringBuffer.toString();
    }

    private static void binaryAddOneChar(Stack<Integer> stack, char[] array,
                                         int indexR, int charToAdd) {
        while (indexR >= 0) {
            if (charToAdd + ('0' == array[indexR] ? 0 : 1) == 2) {
                charToAdd = 1;
                stack.push(0);
            } else if (charToAdd + ('0' == array[indexR] ? 0 : 1) == 1) {
                charToAdd = 0;
                stack.push(1);
            } else {
                charToAdd = 0;
                stack.push(0);
            }
            indexR--;
        }
        if (charToAdd == 1) {
            stack.push(1);
        }
    }

    /**
     * 执行用时 :5 ms, 在所有 Java 提交中击败了81.99%的用户
     * 内存消耗 :36 MB, 在所有 Java 提交中击败了55.38%的用户
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary2(String a, String b) {
        StringBuffer buf = new StringBuffer();
        int upper = 0;
        for (int indexA = a.length() - 1, indexB = b.length() - 1; indexA >= 0 || indexB >= 0; indexA--, indexB--) {
            int sum = upper + (indexA >= 0 ? a.charAt(indexA) - '0' : 0) + (indexB >= 0 ? b.charAt(indexB) - '0' : 0);
            buf.append(sum % 2);
            upper = sum / 2;
        }
        buf.append(upper > 0 ? upper : "");

        return buf.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        System.out.println(addBinary2(a, b));
    }
}
