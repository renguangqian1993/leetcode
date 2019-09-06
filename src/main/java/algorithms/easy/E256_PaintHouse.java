package algorithms.easy;

import java.util.Arrays;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * <p>
 * Note:
 * All costs are positive integers.
 * <p>
 * Example:
 * <p>
 * Input: [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 *              Minimum cost: 2 + 5 + 3 = 10.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/paint-house
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E256_PaintHouse {

    /**
     * TODO，动态规划，需要重做
     * 执行用时 :2 ms, 在所有 Java 提交中击败了91.53%的用户
     * 内存消耗 :37.2 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static int minCost(int[][] costs) {
        if (0 == costs.length) return 0;

        int[] minCosts = new int[]{costs[0][0], costs[0][1], costs[0][2]};
        int[] preMinCosts = new int[]{costs[0][0], costs[0][1], costs[0][2]};


        for (int index = 1; index < costs.length; index++) {
            minCosts[0] = Math.min(preMinCosts[1], preMinCosts[2]) + costs[index][0];
            minCosts[1] = Math.min(preMinCosts[0], preMinCosts[2]) + costs[index][1];
            minCosts[2] = Math.min(preMinCosts[0], preMinCosts[1]) + costs[index][2];

            preMinCosts = Arrays.copyOf(minCosts, minCosts.length);
        }

        return Math.min(minCosts[0], Math.min(minCosts[1], minCosts[2]));
    }

    public static void main(String[] args) {
//        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        int[][] costs = {{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
        minCost(costs);
    }
}
