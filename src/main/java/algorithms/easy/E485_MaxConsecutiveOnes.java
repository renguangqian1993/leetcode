package algorithms.easy;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;

        int tmpCount = 0;
        for (int num : nums) {
            if (num == 1) {
                tmpCount++;
                maxConsecutiveOnes = Math.max(maxConsecutiveOnes, tmpCount);
            } else {
                tmpCount = 0;
            }
        }

        return maxConsecutiveOnes;
    }
}
