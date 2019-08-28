package algorithms.easy;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E136_SingleNumber {
    /**
     * 将数组排序，从下标0开始找出第一个与其后一个元素不相等的元素
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        return 0;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1,3,5,7,9,2,4,6,8,10,-1};

        sort4(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /**
     * 冒泡排序
     */
    private static void sort1(int[] nums) {
        for (int leftIndexOfUnsorted = 0; leftIndexOfUnsorted < nums.length; leftIndexOfUnsorted++) {
            for (int index = nums.length - 1; index > leftIndexOfUnsorted; index--) {
                if (nums[index] < nums[index - 1]) {
                    int tmp = nums[index];
                    nums[index] = nums[index - 1];
                    nums[index - 1] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序
     */
    private static void sort2(int[] nums) {
        for (int leftIndexOfUnsorted = 0; leftIndexOfUnsorted < nums.length - 1; leftIndexOfUnsorted++) {

            int minIndex = leftIndexOfUnsorted;

            for (int index = leftIndexOfUnsorted + 1; index < nums.length; index++) {
                if (nums[minIndex] > nums[index]) {
                    minIndex = index;
                }
            }

            int tmp = nums[leftIndexOfUnsorted];
            nums[leftIndexOfUnsorted] = nums[minIndex];
            nums[minIndex] = tmp;
        }
    }

    /**
     * 插入排序
     */
    private static void sort3(int[] nums) {
        for (int indexL = 0; indexL < nums.length - 1; indexL++) {

            int dataToInsert = nums[indexL + 1];

            for (int indexToInsert = indexL; indexToInsert >= 0; indexToInsert--) {
                if (nums[indexToInsert] > dataToInsert) {
                    nums[indexToInsert + 1] = nums[indexToInsert];
                } else {
                    nums[indexToInsert + 1] = dataToInsert;

                    break;
                }
            }

        }
    }
    /**
     * 希尔排序
     * TODO 不会写！！！
     */
    private static void sort4(int[] nums) {
        int len = nums.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = nums[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && nums[preIndex] > temp) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }
    /**
     * 归并排序
     */
    private static void sort5(int[] nums) {

    }
    private static void sort5_1(int[] nums, int indexL, int indexC, int indexR) {
        if (indexL == indexR) {
            return;
        } else if (indexL + 2 == indexR) {
            if (nums[indexL] > nums[indexR]) {
                int tmp = nums[indexL];
                nums[indexL] = nums[indexR];
                nums[indexR] = tmp;
            }
        }
        int indexLC = (indexL + indexC) / 2;
        sort5_1(nums, indexL, indexLC, indexC);

        int indexRC = (indexR + indexC) / 2;
        sort5_1(nums, indexC + 1, indexRC, indexR);

        

    }

    /**
     * 快速排序
     */
    private static void sort6(int[] nums) {

    }
    /**
     * 堆排序
     */
    private static void sort7(int[] nums) {

    }
    /**
     * 计数排序
     */
    private static void sort8(int[] nums) {

    }
    /**
     * 桶排序
     */
    private static void sort9(int[] nums) {

    }
    /**
     * 基数排序
     */
    private static void sort10(int[] nums) {

    }
}
