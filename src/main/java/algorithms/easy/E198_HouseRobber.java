package algorithms.easy;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 *
 * Example 2:
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E198_HouseRobber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
        rob(nums);
    }

    /**
     * TODO 官方解法，动态规划
     */
    public static int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
         for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }

    /**
     * TODO 参考官方，需要再来一次哦
     * 执行用时 :1 ms, 在所有 Java 提交中击败了96.04%的用户
     * 内存消耗 :34.2 MB, 在所有 Java 提交中击败了86.99%的用户
     */
    public static int rob2(int[] nums) {
        //sum(n-1) or (sum(n-2)+currNum)
        int currMax = 0;

        //sum(n-1)
        int prevMax = 0;

        for (int num : nums) {
            int tmp = currMax;

            currMax = Math.max(prevMax + num, currMax);

            prevMax = tmp;
        }

        return currMax;
    }
}
