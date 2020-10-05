package algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
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
    /**
     * 超时了，逻辑没错，栈+递归
     [-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492]
     1682
     */
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
    //TODO
    private class SolutionByLeetCode {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 4) {
                return quadruplets;
            }
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    //当前index与前一位相等，index后移
                    continue;
                }
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    //当前index开始，四位，sum值大于target，break
                    break;
                }
                if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    //当前index开始，四位，sum值小于target，index后移
                    continue;
                }
                for (int j = i + 1; j < length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }
                    int left = j + 1, right = length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            left++;
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return quadruplets;
        }
    }
}
