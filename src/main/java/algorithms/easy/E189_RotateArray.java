package algorithms.easy;

import java.util.Stack;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E189_RotateArray {
    /**
     * 暴力法，O(n * k)时间复杂度，O(1)空间复杂度
     * 执行用时 :115 ms, 在所有 Java 提交中击败了33.34%的用户
     * 内存消耗 :39.8 MB, 在所有 Java 提交中击败了20.95%的用户
     */
    public void rotate(int[] nums, int k) {
        for (int countIndex = 0; countIndex < k; countIndex ++) {
            int tmp = nums[nums.length - 1];
            for (int index = nums.length - 1; index > 0; index--) {
                nums[index] = nums[index - 1];
            }
            nums[0] = tmp;
        }
    }

    /**
     * 使用临时数组，空间复杂度为O(n)，时间复杂度为O(n)
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.39%的用户
     * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了24.85%的用户
     */
    public static void rotate2(int[] nums, int k) {
        int[] newArray = new int[nums.length];

        k = k % nums.length;

        for (int index = 0; index < k; index++) {
            newArray[index] = nums[nums.length - k + index];
        }

        for (int index = k; index < nums.length; index++) {
            newArray[index] = nums[index - k];
        }

        System.arraycopy(newArray, 0, nums, 0, nums.length);
    }

    /**
     * 该数组可以看作是环形，该解法与第一种解法的区别是，该解法最多轮转nums.length-1次
     * 执行用时 :148 ms, 在所有 Java 提交中击败了13.42%的用户
     * 内存消耗 :39.9 MB, 在所有 Java 提交中击败了20.95%的用户
     */
    public static void rotate3(int[] nums, int k) {
        for (int count = 1; count <= k % nums.length; count++) {
            int tmp = nums[nums.length - 1];

            for (int index = nums.length - 1; index > 0; index--) {
                nums[index] = nums[index - 1];
            }
            nums[0] = tmp;
        }
    }

    /**
     * 使用堆栈存放需要前移的元素，然后将前边元素后移，然后将堆栈元素放入
     * 时间复杂度：O(n)，需要遍历所有元素一次 + 前移元素一次
     * 空间复杂度：O(k)
     * 执行用时 :7 ms, 在所有 Java 提交中击败了36.39%的用户
     * 内存消耗 :40 MB, 在所有 Java 提交中击败了20.91%的用户
     */
    public static void rotate4(int[] nums, int k) {
        k = k % nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int index = nums.length - 1; index >= nums.length - k; index--) {
            stack.push(nums[index]);
        }

        for (int index = nums.length - 1 - k; index >= 0; index--) {
            nums[index + k] = nums[index];
        }

        for (int index = 0; index < k; index++) {
            nums[index] = stack.pop();
        }
    }

    /**
     * 官方解法【使用环状替换】
     */
    public static void rotate5(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};

        rotate6(nums, 2);
    }

    /**
     * 参考官方【使用环状替换】法
     * 时间复杂度为O(n)，因每个节点只遍历了一次
     * 空间复杂度为O(1)，因存储了固定的额外数据
     * 执行用时 :1 ms, 在所有 Java 提交中击败了99.39%的用户
     * 内存消耗 :39.2 MB, 在所有 Java 提交中击败了24.85%的用户
     */
    public static void rotate6(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        int count = 0;

        //这一层for循环是因为，有可能(startIndex + n * k) % nums.length == startIndex，
        // 即按照偏移量偏移形成环，完成一圈替换后需要重新开始一个‘环’
        for (int startIndex = 0; count < nums.length; startIndex++) {
            int currentIndex = startIndex;

            int preVal = nums[currentIndex];

            do {
                currentIndex = (currentIndex + k) % nums.length;
                int tmpVal = nums[currentIndex];

                nums[currentIndex] = preVal;
                preVal = tmpVal;

                count++;
            } while (currentIndex != startIndex);
        }

    }
}
