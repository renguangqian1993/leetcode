package algorithms.easy;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 * Input: [3,0,1]
 * Output: 2
 *
 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E268_MissingNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5,7,4,0};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        int res = nums.length;

        for (int index = 0; index < nums.length; index++) {
            res ^= index;
            res ^= nums[index];
        }

        return res;
    }
}
