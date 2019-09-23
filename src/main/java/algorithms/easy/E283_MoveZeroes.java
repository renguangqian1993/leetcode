package algorithms.easy;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E283_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};

        moveZeroes(nums);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗 :37.8 MB, 在所有 Java 提交中击败了95.38%的用户
     */
    public static void moveZeroes(int[] nums) {
        int countOfZero = 0;

        for (int index = 0; index < nums.length; index++) {
            nums[index - countOfZero] = nums[index];
            countOfZero += (0 == nums[index] ? 1 : 0);
        }

        for (int index = nums.length - countOfZero; index < nums.length; index++) {
            nums[index] = 0;
        }
    }
}
