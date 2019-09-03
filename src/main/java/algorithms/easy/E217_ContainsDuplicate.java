package algorithms.easy;

import java.util.Arrays;

/**
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 * Input: [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E217_ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3};
        containsDuplicate(nums);
    }

    /**
     * 排序之后，比较相邻元素
     * 时间复杂度：排序 + O(2n)
     * 空间复杂度：O(1)
     * 执行用时 :9 ms, 在所有 Java 提交中击败了89.29%的用户
     * 内存消耗 :48.2 MB, 在所有 Java 提交中击败了80.18%的用户
     */
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index] == nums[index + 1]) {
                return true;
            }
        }

        return false;
    }
}
