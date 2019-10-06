package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 * For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p>
 * Example:
 * <p>
 * n = 15,
 * <p>
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fizz-buzz
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E412_FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(3);
    }

    public static List<String> fizzBuzz(int n) {
        /**
         * 0: 普通数字
         * 3: 3的倍数
         * 5: 5的倍数
         * 8: 15的倍数
         */
        int[] map = new int[n];
        for (int index = 3; index <= n; index += 3) {
            map[index - 1] += 3;
        }
        for (int index = 5; index <= n; index += 5) {
            map[index - 1] += 5;
        }

        List<String> list = new ArrayList<>(n);
        for (int index = 0; index < n; index++) {
            if (map[index] == 0) {
                list.add(String.valueOf(index + 1));
            } else if (map[index] == 3) {
                list.add("Fizz");
            } else if (map[index] == 5) {
                list.add("Buzz");
            } else if (map[index] == 8) {
                list.add("FizzBuzz");
            }
        }
        return list;
    }
}
