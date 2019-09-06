package algorithms.easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E070_ClimbingStairs {

    /**
     * 递归，超时了，因为每一个n，都需要从0算到n
     */
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        } else if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 对第一种方法的改进，存储了计算结果
     * 执行用时 :1 ms, 在所有 Java 提交中击败了59.63%的用户
     * 内存消耗 :34.5 MB, 在所有 Java 提交中击败了45.62%的用户
     */
    private int[] count = null;
    public int climbStairs2(int n) {
        if (count == null) {
            count = new int[n + 1];
        }
        if (n < 0) {
            return 0;
        } else if (n <= 1) {
            count[n + 1] = 1;
            return 1;
        }

        if (n - 1 >= 0) {
            count[n] += (count[n - 1] == 0 ? climbStairs(n - 1) : count[n - 1]);
        }
        if (n - 2 >= 0) {
            count[n] += (count[n - 2] == 0 ? climbStairs(n - 2) : count[n - 2]);
        }

        return count[n];
    }

    /**
     * 动态规划，参考官方，TODO
     *
     * 时间复杂度：O(n)，单循环到 n 。
     * 空间复杂度：O(n)，dp 数组用了 n 的空间。
     */
    public int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int index = 3; index <= n; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }

        return dp[n];
    }

    /**
     * 对解法三的优化，不再存储大量数据，空间复杂度降低到O(1), TODO
     *
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :33.4 MB, 在所有 Java 提交中击败了61.62%的用户
     */
    public int climbStairs4(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;
        int third = first + second;

        for (int index = 3; index <= n; index++) {
            third = first + second;
            first = second;
            second = third;
        }

        return third;
    }

    public static void main(String[] args) {
        climbStairs5(10);
    }

    /**
     * TODO，不会哦
     * @param n
     * @return
     */
    public static int climbStairs5(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    public static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}
