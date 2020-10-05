package algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 739. 每日温度
 *
 * 请根据每日 气温 列表，重新生成一个列表。
 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 *
 * 例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是[1, 30000]。每个气温的值的均为华氏度，都是在[30, 100]范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M739_daily_temperatures {
    //傻瓜式解法，两层for循环
    private class foolSolution {
        public int[] dailyTemperatures(int[] T) {
            int[] result = new int[T.length];
            for (int index = 0; index < T.length; index++) {
                find: for (int fromIndex = index + 1; fromIndex < T.length; fromIndex++) {
                    if (T[index] < T[fromIndex]) {
                        result[index] = fromIndex - index;
                        break find;
                    }
                }
            }

            return result;
        }
    }

    private class SolutionByHash {
        public int[] dailyTemperatures(int[] T) {
            final int MAX_TEMPERATURE = 100;
            int[] result = new int[T.length];

            Map<Integer, List<Integer>> posListMap = new HashMap<>();
            for (int index = T.length - 1; index >= 0; index--) {
                int minIndex = Integer.MAX_VALUE;

                findTemp: for (int temperature = T[index] + 1; temperature <= MAX_TEMPERATURE; temperature++) {
                    if (posListMap.containsKey(temperature)) {
                        List<Integer> posList = posListMap.get(temperature);
                        for (int posIndex = posList.size() - 1; posIndex >= 0; posIndex--) {
                            int pos = posList.get(posIndex);
                            if (pos >= minIndex) {
                                continue findTemp;
                            }
                            if (pos > index) {
                                minIndex = Math.min(minIndex, pos);
                                continue findTemp;
                            }
                        }
                    }
                }
                if (minIndex == Integer.MAX_VALUE) {
                    result[index] = 0;
                } else {
                    result[index] = minIndex - index;
                }


                if (!posListMap.containsKey(T[index])) {
                    posListMap.put(T[index], new ArrayList<>());
                }
                //从后往前遍历，相同温度，日期小的会在后边
                posListMap.get(T[index]).add(index);
            }
            return result;
        }
    }

    private class SolutionByStack {
        public int[] dailyTemperatures(int[] T) {
            int[] result = new int[T.length];

            /**
             * 栈中维护当前没有遇到更高温度的index
             * 所以从栈顶->栈底，温度在上升
             * 每次遍历，只需要pop并比较即可
             */
            Stack<Integer> minTempStack = new Stack<>();
            for (int index = 0; index < T.length; index++) {
                int currTemp = T[index];
                while (!minTempStack.isEmpty() && currTemp > T[minTempStack.peek()]) {
                    int topIndex = minTempStack.pop();
                    result[topIndex] = index - topIndex;
                }
                minTempStack.push(index);
            }

            return result;
        }
    }


}
