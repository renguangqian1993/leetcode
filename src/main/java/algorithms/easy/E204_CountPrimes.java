package algorithms.easy;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Example:
 *
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-primes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E204_CountPrimes {

    public static void main(String[] args) {
        countPrimes_2(10);
    }

    /**
     * 厄拉多塞筛法
     * 从2开始遍历。默认为质数，而其n倍数不为质数
     * 时间复杂度为O(n)，空间复杂度为O(n)
     * 执行用时 :27 ms, 在所有 Java 提交中击败了83.64%的用户
     * 内存消耗 :36.8 MB, 在所有 Java 提交中击败了30.35%的用户
     */
    public static int countPrimes_2(int n) {
        boolean[] primeFlags = new boolean[n];
        int count = 0;

        for (int index = 2; index < n; index++) {
            if (!primeFlags[index]) {
                count++;
                for (int multiple = 2; multiple * index < n; multiple++) {
                    primeFlags[multiple * index] = true;
                }
            }
        }

        return count;
    }

    public static int countPrimes(int n) {
        int count = 0;
        for (int index = 2; index < n; index++) {
            if (isPrime_1(index)) {
                count++;
            }
        }

        return count;
    }

    /**
     * 暴力法，超出时间限制
     * @param n
     * @return
     */
    private static boolean isPrime_1(int n) {
        boolean isPrime = true;
        for (int index = 2; index < n; index++) {
            if (n % index == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    /**
     * 暴力法，判断是否质数，缩小一半，只需要对其前半部分取余判断，还是会超时
     */
    private static boolean isPrime_2(int n) {
        boolean isPrime = true;
        for (int index = 2; index <= (n+1) / 2; index++) {
            if (n % index == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

}
