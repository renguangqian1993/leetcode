package algorithms.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E219_ContainsDuplicate_II {
    /**
     * hash法
     * 执行用时 :34 ms, 在所有 Java 提交中击败了25.98%的用户
     * 内存消耗 :51.5 MB, 在所有 Java 提交中击败了19.68%的用户
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int index = 0; index < nums.length; index++) {
            if (set.contains(nums[index])) {
                return true;
            }

            set.add(nums[index]);

            if (set.size() > k) {
                set.remove(nums[index - k]);
            }
        }
        return false;
    }
}
