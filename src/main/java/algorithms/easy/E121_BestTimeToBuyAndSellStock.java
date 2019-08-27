package algorithms.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * <p>
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
//        int[] prices = new int[]{7,1,5,3,6,4};
        int[] prices = new int[]{3,3,5,0,0,3,1,4};

        System.out.println(maxProfit(prices));
    }

    /**
     * 暴力法
     * 双重循环，外层为最大值，里层为最小值，里层下标为0到外层下标
     * 时间复杂度O(n^2)，空间复杂度O(1)
     * 执行用时 :586 ms, 在所有 Java 提交中击败了5.01%的用户
     * 内存消耗 :39.6 MB, 在所有 Java 提交中击败了23.92%的用户
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int indexOfMax = 0; indexOfMax < prices.length; indexOfMax++) {
            for (int indexOfMin = 0; indexOfMin < indexOfMax; indexOfMin++) {
                if (prices[indexOfMax] - prices[indexOfMin] >= maxProfit) {
                    maxProfit = prices[indexOfMax] - prices[indexOfMin];
                }
            }
        }

        return maxProfit;
    }

    /**
     * 遍历一次法
     * 保存两个变量：最大差值、波谷
     * 每次得到一个新元素，判断是否波谷；如果不是波谷，判断其与波谷的差值
     * 执行用时 :2 ms, 在所有 Java 提交中击败了98.30%的用户
     * 内存消耗 :38.1 MB, 在所有 Java 提交中击败了55.23%的用户
     */
    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int index = 0; index < prices.length; index++) {
            if (prices[index] < minPrice) {
                minPrice = prices[index];
            } else if (prices[index] - minPrice > maxProfit) {
                maxProfit = prices[index] - minPrice;
            }
        }

        return maxProfit;
    }
}
