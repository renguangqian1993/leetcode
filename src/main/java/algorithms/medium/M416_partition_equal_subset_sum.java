package algorithms.medium;

/**
 * 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 *
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 *
 * 示例2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class M416_partition_equal_subset_sum {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,
                100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97};

        boolean flag = solution.canPartition(nums);
        System.out.println(flag);
    }
    /**
     * 递归
     * 超时了
     */
    private static class Solution1 {
        private int sum = 0;
        private int targetSum;
        private int[] nums;

        public boolean canPartition(int[] nums) {
            //第一次遍历，计算sum
            for (int num : nums) {
                this.sum += num;
            }
            //sum是奇数，直接false，无法均分
            if ((this.sum & 1) != 0) {
                return false;
            }
            //计算均分
            this.targetSum = sum / 2;
            this.nums = nums;

            return chose(0, 0);
        }

        private boolean chose(int currIndex, int currSum) {
            //全部正整数，所以当当前sum大于目标sum时，直接return
            if (currSum > targetSum) {
                return false;
            }

            //到达数组最后一位
            if (currIndex >= nums.length) {
                if (currSum != targetSum) {
                    return false;
                } else {
                    return true;
                }
            }

            //1.当前节点不计算
            if (currSum == targetSum) {
                return true;
            }

            //递归
            if (chose(currIndex + 1, currSum)) {
                return true;
            }

            //2.当前节点计算
            currSum += nums[currIndex];
            if (currSum == targetSum) {
                return true;
            }

            //递归
            if (chose(currIndex + 1, currSum)) {
                return true;
            }

            return false;
        }
    }
}
