package algorithms.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E122_BestTimeToBuyAndSellStock_II {

    public static void main(String[] args) {
        int[] prices1 = new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{2,1,4,5,2,9,7};
        int[] prices3 = new int[]{1,2,3,4,5};

        System.out.println(maxProfit2(prices1) + "===" + maxProfit(prices1));
        System.out.println(maxProfit2(prices2) + "===" + maxProfit(prices2));
        System.out.println(maxProfit2(prices3) + "===" + maxProfit(prices3));
    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了97.26%的用户
     * 内存消耗 :39 MB, 在所有 Java 提交中击败了25.67%的用户
     * 从左向后遍历，查找到波谷后查找第一个波峰，再查找下一个波谷->波峰。。。
     * 时间复杂度为O(N)，因需要遍历所有节点一次
     * 空间复杂度为O(1)，因存储了3个临时变量
     */
    public static int maxProfit(int[] prices) {
        int totalProfit = 0;
        for (int indexOfMin = 0; indexOfMin < prices.length - 1;) {
            if (prices[indexOfMin] >= prices[indexOfMin + 1]) {
                indexOfMin++;
                continue;
            }

            int tmpMaxProfit = 0;
            int indexOfMax = indexOfMin + 1;
            //此时拿到了波谷下标
            for (; indexOfMax < prices.length; indexOfMax++) {
                if ((prices[indexOfMax] - prices[indexOfMin]) < tmpMaxProfit) {
                    break;
                } else {
                    tmpMaxProfit = (prices[indexOfMax] - prices[indexOfMin]);

                }

            }
            totalProfit += tmpMaxProfit;
            indexOfMin = indexOfMax;
        }

        return totalProfit;
    }

    /**
     * 执行用时 :2 ms, 在所有 Java 提交中击败了97.22%的用户
     * 内存消耗 :38 MB, 在所有 Java 提交中击败了38.15%的用户
     * 参考官方第三种解法
     */
    public static int maxProfit2(int[] prices) {
        int totalProfit = 0;
        for (int index = 1; index < prices.length; index++) {
            if (prices[index] > prices[index - 1]) {
                totalProfit += prices[index] - prices[index - 1];
            }
        }

        return totalProfit;
    }
}
