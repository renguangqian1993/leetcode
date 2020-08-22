package algorithms.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E354_RussianDollEnvelopes {
    public static void main(String[] args) {
        E354_RussianDollEnvelopes instance = new E354_RussianDollEnvelopes();
        instance.maxEnvelopes(new int[][]{new int[]{4,5},new int[]{4,6},new int[]{6,7},new int[]{2,3},new int[]{1,1}});
//        instance.maxEnvelopes(new int[][]{new int[]{5,4},new int[]{6,4},new int[]{6,7},new int[]{2,3}});
    }

    /**
     * 数组降维+LIS算法
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });

        List<Integer> heightList = Arrays.stream(envelopes).map(array -> array[1]).collect(Collectors.toList());

        return lengthOfLIS(heightList);
    }

    private int lengthOfLIS(List<Integer> heightList) {
        int[] nums = new int[heightList.size()];
        int len = 0;
        for (int height : heightList) {
            int index = Arrays.binarySearch(nums, 0, len, height);
            if (index < 0) {
                index = Math.abs(index + 1);
            }
            nums[index] = height;
            if (index == len) {
                len++;
            }
        }

        return len;
    }
}
