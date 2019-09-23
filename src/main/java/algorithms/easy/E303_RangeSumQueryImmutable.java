package algorithms.easy;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E303_RangeSumQueryImmutable {
    /**
     * 执行用时 :252 ms, 在所有 Java 提交中击败了17.93%的用户
     * 内存消耗 :61.3 MB, 在所有 Java 提交中击败了16.51%的用户
     */
    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
    private class NumArray1 {
        private int[] nums;
        public NumArray1(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            i = Math.max(0, i);
            j = Math.min(nums.length, j + 1);
            for (int index = i; index < j; index ++) {
                sum += nums[index];
            }
            return sum;
        }
    }


    /**
     * 缓存法，官方解法
     */
    private class NumArray {
        private int[] sum;
        public NumArray(int[] nums) {
            sum = new int[nums.length + 1];

            for (int index = 0; index < nums.length; index++) {
                sum[index + 1] = sum[index] + nums[index];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }
}
