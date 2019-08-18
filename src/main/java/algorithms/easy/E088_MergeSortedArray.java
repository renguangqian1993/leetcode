package algorithms.easy;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * <p>
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E088_MergeSortedArray {

    /**
     * 执行用时 :1 ms, 在所有 Java 提交中击败了96.38%的用户
     * 内存消耗 :36.4 MB, 在所有 Java 提交中击败了74.57%的用户
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @description 因两数组有序，故从后往前遍历插值。时间复杂度为O(m+n)即O(n)，空间复杂度为O(1)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        while (m > 0 || n > 0) {
            if (m > 0 && n > 0) {
                if (nums1[m - 1] > nums2[n - 1]) {
                    nums1[index] = nums1[m - 1];
                    m--;
                } else {
                    nums1[index] = nums2[n - 1];
                    n--;
                }
            } else if (m > 0) {
                nums1[index] = nums1[m - 1];
                m--;
            } else {
                nums1[index] = nums2[n - 1];
                n--;
            }

            index--;
        }
    }
}
