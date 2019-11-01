package algorithms.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *     For number 2 in the first array, the next greater number for it in the second array is 3.
 *     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E496_NextGreaterElementI {
    public static void main(String[] args) {
        nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    }

    //暴力法
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        for (int index1 = 0; index1 < nums1.length; index1++) {
            int greaterNum = -1;

            int index2 = 0;
            for (int num : nums2) {
                if (num == nums1[index1]) {
                    break;
                }
                index2++;
            }

            for (; index2 < nums2.length; index2++) {
                if (nums2[index2] > nums1[index1]) {
                    greaterNum = nums2[index2];
                    break;
                }
            }

            nums1[index1] = greaterNum;
        }
        return nums1;
    }

    //TODO 栈
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num2 : nums2) {
            while (!stack.isEmpty() && stack.peek() < num2) {
                map.put(stack.pop(), num2);
            }
            stack.push(num2);
        }

        for (int index = 0; index < nums1.length; index++) {
            nums1[index] = map.getOrDefault(nums1[index], -1);
        }
        return nums1;
    }
}
