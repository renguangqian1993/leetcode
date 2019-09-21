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

    public static void main(String[] args) {
        int[] nums1 = new int[]{9, 10};
        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        double result = findMedianSortedArrays2(nums1, nums2);
        System.out.println(result);
    }

    /**
     * TODO 官方解法
     * 思路：下标初始化为第一个数组的中间位置，然后循环向前向后移动
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays2(int[] A, int[] B) {

        if (A.length > B.length) { // to ensure lengthA<=lengthB
            int[] temp = A;
            A = B;
            B = temp;
        }

        int lengthA = A.length;
        int lengthB = B.length;
        int halfLen = (lengthA + lengthB + 1) / 2;

        int iMin = 0;
        int iMax = lengthA;

        while (iMin <= iMax) {

            int indexOfA = (iMin + iMax) / 2;
            int indexOfB = halfLen - indexOfA;

            if (indexOfA < iMax && B[indexOfB - 1] > A[indexOfA]) {
                iMin = indexOfA + 1; // indexOfA is too small
            } else if (indexOfA > iMin && A[indexOfA - 1] > B[indexOfB]) {
                iMax = indexOfA - 1; // indexOfA is too big
            } else { // indexOfA is perfect
                int maxLeft = 0;
                if (indexOfA == 0) {
                    maxLeft = B[indexOfB - 1];
                } else if (indexOfB == 0) {
                    maxLeft = A[indexOfA - 1];
                } else {
                    maxLeft = Math.max(A[indexOfA - 1], B[indexOfB - 1]);
                }
                if ((lengthA + lengthB) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (indexOfA == lengthA) {
                    minRight = B[indexOfB];
                } else if (indexOfB == lengthB) {
                    minRight = A[indexOfA];
                } else {
                    minRight = Math.min(B[indexOfB], A[indexOfA]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
