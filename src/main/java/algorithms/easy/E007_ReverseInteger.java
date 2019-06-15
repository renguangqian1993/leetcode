package algorithms.easy;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment
 * which could only store integers
 * within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
public class E007_ReverseInteger {

    /**
     * reverse by string
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int result = 0;

        String inputStr = String.valueOf(x);
        if (x < 0) {
            inputStr = inputStr.substring(1);
        }

        StringBuffer resultStr = new StringBuffer();
        for (int index = inputStr.length() - 1; index >= 0; index--) {
            resultStr.append(inputStr.charAt(index));
        }
        if (x < 0) {
            resultStr.insert(0, "-");
        }

        try {
            result = Integer.parseInt(resultStr.toString());
        } catch (NumberFormatException e) {
            result = 0;
        }
        return result;
    }

    public int reverse2(int x) {
        long result = 0;

        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;

            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int) result;
    }
}
