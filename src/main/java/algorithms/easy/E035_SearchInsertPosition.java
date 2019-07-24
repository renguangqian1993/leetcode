package algorithms.easy;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * <p>
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E035_SearchInsertPosition {
    /**
     * 执行用时:1 ms, 在所有 Java 提交中击败了90.00%的用户
     * 内存消耗:39.2 MB, 在所有 Java 提交中击败了47.83%的用户
     * @idea 二分查找 + 递归
     */
    public int searchInsert(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        
        return findIndex(nums, 0, nums.length - 1, target);
    }
    
    private int findIndex(int[] nums, int indexL, int indexR, int target) {
        if (nums[indexL] >= target) {
            return indexL;
        } else if (nums[indexR] == target) {
            return indexR;
        } else if (nums[indexR] < target) {
            return indexR + 1;
        }
        
        int indexMid = (indexL + indexR) /2;
        if (nums[indexMid] == target) {
            return indexMid;
        } else if (nums[indexMid] > target) {
            return findIndex(nums, indexL, indexMid - 1, target);
        } else {
            return findIndex(nums, indexMid + 1, indexR, target);
        }
    }
    
    public static void main(String[] args) {
        E035_SearchInsertPosition instance = new E035_SearchInsertPosition();
        
        int[] nums = new int[]{1,3};
        int target = 3;

        System.out.println(instance.searchInsert(nums, target));
    }
}
