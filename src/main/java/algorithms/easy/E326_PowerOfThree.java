package algorithms.easy;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 * Input: 27
 * Output: true
 *
 * Example 2:
 * Input: 0
 * Output: false
 *
 * Example 3:
 * Input: 9
 * Output: true
 *
 * Example 4:
 * Input: 45
 * Output: false
 *
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E326_PowerOfThree {
    /**
     * 暴力解法
     */
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    /**
     * 将数组转换成以3进制的字符串，使用正则判断，todo，官方解法
     * @param n
     * @return
     */
    public boolean isPowerOfThree2(int n) {
        String baseChange = Integer.toString(n, 3);
        return baseChange.matches("^10*$");
    }

    /**
     * maxPow是Integer.MAX_VALUE范围内，最大的3的幂，是否应该通过程序去计算得到而不是写死呢
     * 这种方法，n必须为质数
     */
    public static boolean isPowerOfThree3(int n) {
        int maxPow = (int) Math.pow(3.0D, 19.0D);
        return n > 0 && maxPow % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree3(6));
    }
}
