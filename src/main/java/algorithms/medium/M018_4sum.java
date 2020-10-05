package algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 18. 四数之和
 *
 * 给定一个包含n个整数的数组nums和一个目标值target，
 * 判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M018_4sum {
    private class SolutionByStack {

        private List<List<Integer>> lists = new ArrayList<>();
        private Set<String> duplicateResult = new HashSet<>();
        private final int SIZE = 4;
        public List<List<Integer>> fourSum(int[] nums, int target) {
            visitEachNum(nums, 0, target, new Stack<>());
            return lists;
        }

        private void visitEachNum(int[] nums, int currIndex, int remainder, Stack<Integer> stack) {
            if (currIndex >= nums.length) {
                return;
            }
            if (stack.size() > SIZE) {
                return;
            }

            //1.当前节点入栈
            stack.push(nums[currIndex]);
            remainder -= nums[currIndex];
            if (remainder == 0 && stack.size() == SIZE && stack.peek() == nums[currIndex]) {
                List<Integer> list = copyToList(stack);
                Collections.sort(list);
                StringBuilder buffer = new StringBuilder();
                for (Integer integer : list) {
                    buffer.append(integer).append(",");
                }
                if (duplicateResult.add(buffer.toString())) {
                    lists.add(list);
                }
            }
            visitEachNum(nums, currIndex + 1, remainder, stack);

            //2.当前节点不入栈
            stack.pop();
            remainder += nums[currIndex];
            visitEachNum(nums, currIndex + 1, remainder, stack);
        }

        private List<Integer> copyToList(Stack<Integer> stack) {
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
            for (int index = list.size() - 1; index >= 0; index--) {
                stack.push(list.get(index));
            }

            return list;
        }
    }
}
