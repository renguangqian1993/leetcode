package algorithms.easy;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 * <p>
 * Example 2:
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 * <p>
 * Note that the order of those five elements can be arbitrary.
 * <p>
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 * <p>
 * Confused why the returned value is an integer but your answer is an array?
 * <p>
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E027_RemoveElement {
    /**
     * 参考026题删除重复项的双指针解法，时间复杂度为O(1)，空间复杂度为O(n)
     * 执行用时:1 ms, 在所有 Java 提交中击败了97.56%的用户
     * 内存消耗:35.6 MB, 在所有 Java 提交中击败了84.23%的用户
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (null == nums || nums.length <= 0) {
            return 0;
        }

        int newArrayIndex = -1;

        for (int indexOfNums = 0; indexOfNums < nums.length; indexOfNums++) {
            if (nums[indexOfNums] != val) {
                nums[++newArrayIndex] = nums[indexOfNums];
            }
        }

        return newArrayIndex + 1;
    }

    /**
     * 官方解法，双指针法，但是元素操作次数较上一个方法减少约一半
     * <p>
     * 时间复杂度：O(n)，i 和 n 最多遍历 n 步。在这个方法中，赋值操作的次数等于要删除的元素的数量。因此，如果要移除的元素很少，效率会更高。
     * 空间复杂度：O(1)。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        int len = new E027_RemoveElement().removeElement2(nums, val);
        System.out.println("len:" + len);

        for (int numTmp : nums) {
            System.out.println(numTmp);
        }

    }
}
