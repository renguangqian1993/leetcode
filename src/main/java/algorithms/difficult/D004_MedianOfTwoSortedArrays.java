package algorithms.difficult;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * <p>
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class D004_MedianOfTwoSortedArrays {

    /**
     * 暴力解法，将两数组合并，拿中位数
     * 但是题意要求时间复杂度O(log(m+n))，应该考虑二分法
     * 执行用时 :3 ms, 在所有 Java 提交中击败了99.81%的用户
     * 内存消耗 :46.5 MB, 在所有 Java 提交中击败了95.89%的用户
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sumArray = new int[nums1.length + nums2.length];
        int indexOfNum1 = 0;
        int indexOfNum2 = 0;
        for (int index = 0; index < sumArray.length; index++) {
            if (indexOfNum1 >= nums1.length) {
                sumArray[index] = nums2[indexOfNum2++];
            } else if (indexOfNum2 >= nums2.length) {
                sumArray[index] = nums1[indexOfNum1++];
            } else if (nums1[indexOfNum1] <= nums2[indexOfNum2]) {
                sumArray[index] = nums1[indexOfNum1++];
            } else {
                sumArray[index] = nums2[indexOfNum2++];
            }
        }

        if (sumArray.length % 2 == 1) {
            return sumArray[(sumArray.length + 1) / 2 - 1];
        }

        int indexL = sumArray.length / 2 - 1;
        int indexR = sumArray.length / 2;


        return (sumArray[indexL] + sumArray[indexR]) / 2.0D;
    }

}
