package algorithms.easy;

import java.util.*;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 *
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Example:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E167_TwoSum_II_InputArrayIsSorted {

    /**
     * 空间换时间，哈希表法，空间复杂度为O(2n)，时间复杂度为O(n)
     * 执行用时 :28 ms, 在所有 Java 提交中击败了13.66%的用户
     * 内存消耗 :40.2 MB, 在所有 Java 提交中击败了11.46%的用户
     */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer/*value*/, Integer/*count*/> countMap = new HashMap<>();
        Map<Integer/*value*/, Integer/*index*/> sortedMap = new TreeMap<>();
        for (int index = 0; index < numbers.length; index++) {
            if (countMap.containsKey(numbers[index])) {
                countMap.put(numbers[index], countMap.get(numbers[index]) + 1);
            } else {
                countMap.put(numbers[index], 1);
            }

            if (!sortedMap.containsKey(numbers[index])) {
                sortedMap.put(numbers[index], index);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator
                = sortedMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            Integer val1 = entry.getKey();
            Integer index1 = entry.getValue();

            Integer val2 = (target - val1);


            if (sortedMap.containsKey(val2)) {
                if (val1 == val2 && countMap.get(val1) >= 2) {
                    return new int[]{index1 + 1, index1 + 2};
                } else {
                    return new int[]{index1, sortedMap.get(val2)};
                }
            }
        }

        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        Map<Integer/*value*/, List<Integer>/*index*/> sortedMap = new TreeMap<>();

        for (int index = 0; index < numbers.length; index++) {
            if (!sortedMap.containsKey(numbers[index])) {
                sortedMap.put(numbers[index], new ArrayList<>());
            }
            sortedMap.get(numbers[index]).add(index);
        }

        Iterator<Integer> iterator = sortedMap.keySet().iterator();

        while (iterator.hasNext()) {
            Integer val1 = iterator.next();
            if (sortedMap.containsKey(target - val1)) {
                if (val1 == (target - val1) && sortedMap.get(val1).size() >= 2) {
                    return new int[]{sortedMap.get(val1).get(0) + 1, sortedMap.get(val1).get(1) + 1};
                } else {
                    return new int[]{sortedMap.get(val1).get(0) + 1, sortedMap.get(target - val1).get(0) + 1};
                }
            }
        }

        return null;
    }

    /**
     * 双指针法，时间复杂度O(n)，空间复杂度O(1)
     * 执行用时 :2 ms, 在所有 Java 提交中击败了82.23%的用户
     * 内存消耗 :38.5 MB, 在所有 Java 提交中击败了27.45%的用户
     */
    public int[] twoSum3(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (index1 < index2) {
            if (numbers[index1] + numbers[index2] == target) {
                return new int[]{index1 + 1, index2 + 1};
            } else if (numbers[index1] + numbers[index2] > target) {
                index2--;
            } else {
                index1++;
            }
        }

        return null;
    }
}
