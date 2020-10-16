package algorithms.easy;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 *
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *
 *
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *
 * 示例 2：
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A已按非递减顺序排序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class E977_squares_of_a_sorted_array {

    public static void main(String[] args) {
        new Solution2().sortedSquares(new int[]{-4,-1,0,3,10});
    }

    /**
     * 使用jdk内置排序
     */
    private static class Solution1 {
        public int[] sortedSquares(int[] A) {
            int[] res = new int[A.length];
            for (int index = 0; index < A.length; index++) {
                res[index] = A[index] * A[index];
            }

            Arrays.sort(res);
            return res;
        }
    }

    /**
     * 双指针
     * 分别指向了（最大的负数，最小的非负数）
     * 从最小坐标开始填充目标数组
     */
    private static class Solution2 {
        public int[] sortedSquares(int[] A) {
            int[] res = new int[A.length];

            //最大的负数的坐标
            int negative = -1;

            //寻找最大的负数的坐标
            for (int index = 0; index < A.length; index++) {
                if (A[index] < 0) {
                    negative = index;
                } else {
                    break;
                }
            }

            //最小的非负数的坐标
            int positive = negative + 1;

            int index = 0;
            while (negative >= 0 || positive < A.length) {
                if (negative < 0) {
                    //剩余全部为非负数
                    res[index] = A[positive] * A[positive];
                    positive++;
                } else if (positive >= A.length) {
                    //剩余全部为负数
                    res[index] = A[negative] * A[negative];
                    negative--;
                } else if (A[positive] < (-A[negative])) {
                    //非负数绝对值 < 负数绝对值
                    res[index] = A[positive] * A[positive];
                    positive++;
                } else {
                    //非负数绝对值 > 负数绝对值
                    res[index] = A[negative] * A[negative];
                    negative--;
                }
                index++;
            }

            return res;
        }
    }

    /**
     * 双指针
     * 分别指向了原数组的最左节点、最右节点
     * 从最大坐标开始填充目标数组
     */
    private static class Solution3 {
        public int[] sortedSquares(int[] A) {
            int[] res = new int[A.length];

            int leftIndex = 0;
            int rightIndex = A.length - 1;
            int index = A.length - 1;
            while (leftIndex <= rightIndex) {
                if (Math.abs(A[leftIndex]) > Math.abs(A[rightIndex])) {
                    //左边数据绝对值较大
                    res[index] = A[leftIndex] * A[leftIndex];
                    leftIndex++;
                } else {
                    res[index] = A[rightIndex] * A[rightIndex];
                    rightIndex--;
                }
                index--;
            }

            return res;
        }
    }
}
