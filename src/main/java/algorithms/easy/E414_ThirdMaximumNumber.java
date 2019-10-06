package algorithms.easy;

import java.util.TreeSet;

/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * <p>
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 * <p>
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * <p>
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * <p>
 * Both numbers with value 2 are both considered as second maximum.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E414_ThirdMaximumNumber {
    public static void main(String[] args) {
        thirdMax(new int[]{1, 2, -2147483648});
    }

    public static int thirdMax(int[] nums) {
        long maxNum = Long.MIN_VALUE;
        long secondMaxNum = Long.MIN_VALUE;
        long thirdMaxNum = Long.MIN_VALUE;

        for (int num : nums) {
            if (num > maxNum) {
                thirdMaxNum = secondMaxNum;
                secondMaxNum = maxNum;
                maxNum = num;
            } else if (num == maxNum) {
                continue;
            } else if (num > secondMaxNum) {
                thirdMaxNum = secondMaxNum;
                secondMaxNum = num;
            } else if (num == secondMaxNum) {
                continue;
            } else if (num > thirdMaxNum) {
                thirdMaxNum = num;
            }
        }

        return (int) (thirdMaxNum != Long.MIN_VALUE ? thirdMaxNum : maxNum);
    }

    /**
     * todo : treeSet用法
     *
     * @param nums
     * @return
     */
    public static int thirdMax2(int[] nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() > 3) {
                treeSet.remove(treeSet.first());
            }
        }
        return treeSet.size() < 3 ? treeSet.last() : treeSet.first();
    }
}
