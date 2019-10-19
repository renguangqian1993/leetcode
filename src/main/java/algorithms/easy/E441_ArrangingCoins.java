package algorithms.easy;

/**
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * <p>
 * Example 2:
 * <p>
 * n = 8
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E441_ArrangingCoins {
    public static void main(String[] args) {
        arrangeCoins(2147483647);
    }

    public static int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        int indexL = 0;
        int indexR = n == Integer.MAX_VALUE ? (Integer.MAX_VALUE / 2) : n;

        while (indexL < indexR) {
            int middle = (indexL + indexR + 1) / 2;
            long sum = getSum(middle);

            if (sum == n) {
                return middle;
            }

            if (sum > n) {
                indexR = middle - 1;
            } else {
                indexL = middle;
            }
        }


        return indexL;

    }

    private static long getSum(long height) {
        return height * (height + 1) / 2;
    }
}
