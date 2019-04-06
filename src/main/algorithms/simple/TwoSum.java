package src.main.algorithms.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class TwoSum {
    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)O(1)。
     * 最简单粗暴的方式，耗时会较长
     */
    public int[] slution1(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        for (int indexA = 0; indexA < nums.length; indexA++) {
            int numA = nums[indexA];

            for (int indexB = indexA + 1; indexB < nums.length; indexB++) {
                int numB = nums[indexB];
                if (numA + numB == target) {
                    return new int[]{indexA, indexB};
                }
            }
        }

        return null;
    }
}
