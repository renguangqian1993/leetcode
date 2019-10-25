package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E448_FindAllNumbersDisappearedInAnArray {
    /**
     * 抽屉原理，鸽巢理论
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num : nums) {
            nums[Math.abs(num) - 1] = 0 - Math.abs(nums[Math.abs(num) - 1]);
        }

        List<Integer> list = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] > 0) {
                list.add(index + 1);
            }
        }
        return list;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int index = 0; index < nums.length; index++) {
            /**
             * currVal     : nums[index]     是当前下标的值
             * expectIndex : nums[index] - 1 是当前下标值 期望的下表
             * 如果index下标期望的值不存在，那么index nums[index]-1这两个下表将会相同
             */
            while (nums[index] != nums[nums[index] - 1]) {
                swap(nums, index, nums[index] - 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                list.add(index + 1);
            }
        }
        return list;
    }

    private static void swap(int[] nums, int indexL, int indexR) {
        nums[indexL] ^= nums[indexR];
        nums[indexR] ^= nums[indexL];
        nums[indexL] ^= nums[indexR];
    }

    /**
     * TODO 康不懂
     */
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        int len = nums.length;
        int map = 1 << len;

        for (int num : nums) {
            map |= 1 << (num - 1);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (((map >> i) & 1) == 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
