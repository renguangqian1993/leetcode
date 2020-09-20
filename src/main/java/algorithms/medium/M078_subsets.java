package algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * 给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M078_subsets {
    class SolutionRecursively {
        List<List<Integer>> lists = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            choice(nums, 0, new ArrayList<>());
            return lists;
        }

        private void choice(int[] nums, int currIndex, List<Integer> list) {
            if (currIndex >= nums.length) {
                lists.add(new ArrayList<>(list));
                return;
            }
            //包含当前节点
            list.add(nums[currIndex]);
            choice(nums, currIndex + 1, list);

            //不包含当前节点
            list.remove(list.size() - 1);
            choice(nums, currIndex + 1, list);
        }
    }

    class SolutionByByte {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            int size = nums.length;
            List<Integer> list = new ArrayList<>();
            for (int mask = 0; mask < (1 << size); mask++) {
                list.clear();
                for (int index = 0; index < size; index++) {
                    if (((1 << index) & mask) != 0) {
                        list.add(nums[index]);
                    }
                }
                lists.add(new ArrayList<>(list));
            }
            return lists;
        }

    }
}
