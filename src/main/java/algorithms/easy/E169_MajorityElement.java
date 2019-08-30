package algorithms.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E169_MajorityElement {

    /**
     * 执行用时 :50 ms, 在所有 Java 提交中击败了6.01%的用户
     * 内存消耗 :50.1 MB, 在所有 Java 提交中击败了28.88%的用户
     * 哈希表法，时间复杂度O(n)，空间复杂度O(n)
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
            if (countMap.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    /**
     * 排序法，返回中位数即为众数
     * 执行用时 :4 ms, 在所有 Java 提交中击败了71.28%的用户
     * 内存消耗 :51.5 MB, 在所有 Java 提交中击败了15.76%的用户
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //TODO 其他高端解法还需要学习哦
}
