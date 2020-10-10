package algorithms.medium;

import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M503_next_greater_element_ii {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.nextGreaterElements(new int[]{5,4,3,2,1});
    }

    /**
     * 双层for循环
     * 时间复杂度O(N^2)
     * 空间复杂度O(1)
     */
    private static class Solution1 {
        public int[] nextGreaterElements(int[] nums) {
            int[] result = new int[nums.length];
            for (int index = 0; index < nums.length; index++) {
                int targetIndex = index + 1;
                while (true) {
                    if (targetIndex == nums.length) {
                        targetIndex = 0;
                    }
                    if (targetIndex == index) {
                        result[index] = -1;
                        break;
                    }
                    if (nums[targetIndex] > nums[index]) {
                        result[index] = nums[targetIndex];
                        break;
                    }

                    targetIndex++;
                }
            }

            return result;
        }
    }

    /**
     * 栈
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    private static class Solution2 {
        public int[] nextGreaterElements(int[] nums) {
            int[] result = new int[nums.length];
            //存储index
            //nums[index]：大->小
            Stack<Integer> stack = new Stack<>();

            //第一次遍历，查找index后的更大的值
            for (int index = 0; index < nums.length; index++) {
                while (!stack.isEmpty()) {
                    if (nums[index] > nums[stack.peek()]) {
                        result[stack.pop()] = nums[index];
                    } else {
                        break;
                    }
                }

                stack.push(index);
                result[index] = -1;
            }

            //第二次遍历，查找index前的更大的值
            for (int index = 0; index < nums.length; index++) {
                if (stack.isEmpty()) {
                    break;
                }
                while (!stack.isEmpty()) {
                    if (nums[index] > nums[stack.peek()]) {
                        result[stack.pop()] = nums[index];
                    } else {
                        break;
                    }
                }
            }

            return result;
        }
    }
}
