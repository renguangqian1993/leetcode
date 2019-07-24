package algorithms.easy;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * <p>
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
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
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E026_RemoveDuplicatesFromSortedArray {

    /**
     * 执行用时 : 81 ms, 在所有 Java 提交中击败了8.48%的用户
     * 内存消耗 : 43.7 MB, 在所有 Java 提交中击败了75.05%的用户
     *
     * @param nums
     * @return
     * @description: 指定O(1)空间复杂度，故使用时间换空间，时间复杂度为O(n^2)
     */
    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length < 1) {
            return 0;
        }

        int newLen = nums.length;

        for (int index = 1; index < newLen; ) {
            if (nums[index] == nums[index - 1]) {
                for (int indexToModi = index; indexToModi < newLen - 1; indexToModi++) {
                    nums[indexToModi] = nums[indexToModi + 1];
                }
                newLen--;
            } else {
                index++;
            }
        }

        return newLen;
    }

    /**
     * 参考官方双指针解法
     * 时间复杂度：O(n)，‘新数组’与‘老数组’全部需要遍历一次，最坏情况下为2n次
     * 空间复杂度：O(1)。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (null == nums || nums.length < 1) {
            return 0;
        }

        int indexOfNewArray = 0;

        for (int indexOfRawArray = 1; indexOfRawArray < nums.length; indexOfRawArray++) {
            if (nums[indexOfNewArray] != nums[indexOfRawArray]) {
                indexOfNewArray++;
                nums[indexOfNewArray] = nums[indexOfRawArray];
            }
        }

        return indexOfNewArray + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int newLen = new E026_RemoveDuplicatesFromSortedArray().removeDuplicates2(nums);
        for (int tmp : nums) {
            System.out.println(tmp);

        }
        System.out.println("len:" + newLen);
    }
}
