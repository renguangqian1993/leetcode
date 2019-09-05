package algorithms.easy;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E053_MaximumSubarray {
    //TODO 动态规划，分治法
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    /**
     * TODO 分治法
     * 这种分治法有个问题，时间复杂度为O(n*log(n))
     * 分治需要划分到一个组中只有一个节点，然后往上走，每次分组都要扫描组内每个节点
     */
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }

    private int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;
        return Math.max(
                Math.max(maxSubArraySum(nums, left, mid), maxSubArraySum(nums, mid + 1, right)),
                maxCrossingSum(nums, left, mid, right));
    }

    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // 一定会包含 nums[mid] 这个元素
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        // 左半边包含 nums[mid] 元素，最多可以到什么地方
        // 走到最边界，看看最值是什么
        // 计算以 mid 结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        // 右半边不包含 nums[mid] 元素，最多可以到什么地方
        // 计算以 mid+1 开始的最大的子数组的和
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;

    }


    /**
     * 动态规划
     * 执行用时 :2 ms, 在所有 Java 提交中击败了90.86%的用户
     * 内存消耗 :38.9 MB, 在所有 Java 提交中击败了80.30%的用户
     */
    public int maxSubArray3(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        int tmpSum = 0;

        for (int num : nums) {
            if (tmpSum > 0) {
                tmpSum += num;
            } else {
                tmpSum = num;
            }

            maxSum = Math.max(maxSum, tmpSum);
        }

        return maxSum;
    }

}
