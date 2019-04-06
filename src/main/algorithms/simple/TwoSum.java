package src.main.algorithms.simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 两次hash
     */
    public int[] slution2(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        Map<Integer/*数组元素*/, Set<Integer/*数组元素下标*/>> indexSetByNum = new HashMap<Integer, Set<Integer>>();

        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            Set<Integer> indexSet = indexSetByNum.get(num);

            if (null == indexSet) {
                indexSet = new HashSet<Integer>();
                indexSetByNum.put(num, indexSet);
            }

            indexSet.add(index);
        }

        for (int index = 0; index < nums.length; index++) {
            int numA = nums[index];
            int numB = target - numA;

            if (indexSetByNum.containsKey(numB)) {
                Set<Integer> indexSet = indexSetByNum.get(numB);
                for (int indexB : indexSet) {
                    if (index != indexB) {
                        return new int[]{index, indexB};
                    }
                }
            }
        }

        return null;
    }

    /**
     * 对solution2的一次优化，将两次hash改为一次hash
     */
    public int[] slution3(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return null;
        }

        Map<Integer/*数组元素*/, Set<Integer/*数组元素下标*/>> indexSetByNum = new HashMap<Integer, Set<Integer>>();

        for (int index = 0; index < nums.length; index++) {
            int numA = nums[index];

            int numB = target - numA;

            if (indexSetByNum.containsKey(numB)) {
                Set<Integer> indexSet = indexSetByNum.get(numB);
                for (int indexB : indexSet) {
                    if (index != indexB) {
                        return new int[]{index, indexB};
                    }
                }
            }

            Set<Integer> indexSet = indexSetByNum.get(numA);

            if (null == indexSet) {
                indexSet = new HashSet<Integer>();
                indexSetByNum.put(numA, indexSet);
            }

            indexSet.add(index);
        }


        return null;
    }
}
