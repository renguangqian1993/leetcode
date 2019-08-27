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

    public int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }

        int indexOfMin = 0;
        int indexOfMax = 0;
        int indexOfTmpMin = 0;

        int min = prices[indexOfMin];
        int max = prices[indexOfMax];
        int tmpMin = prices[indexOfTmpMin];


        for (int index = 1; index < prices.length; index++) {
            if (indexOfMax <= indexOfTmpMin) {

            }
            if (prices[index] > max) {
                indexOfMax = index;
                max = prices[indexOfMax];

            } else if (prices[index] < min) {
                indexOfTmpMin = index;
                tmpMin = prices[indexOfTmpMin];
            }
        }

        return 0;
    }
}
