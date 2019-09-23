package algorithms.easy;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 *
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E349_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        intersection(new int[]{1,2,2,1}, new int[]{2,2});
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> commonList = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (int tmp : nums1) {
            set.add(tmp);
        }

        for (int tmp : nums2) {
            if (set.contains(tmp)) {
                commonList.add(tmp);
                set.remove(tmp);
            }
        }

        return commonList.stream().mapToInt(i -> i).toArray();
    }
}
