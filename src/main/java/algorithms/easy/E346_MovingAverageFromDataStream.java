package algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 *
 * Example:
 *
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/moving-average-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E346_MovingAverageFromDataStream {
    /**
     * Your MovingAverage object will be instantiated and called as such:
     * MovingAverage obj = new MovingAverage(size);
     * double param_1 = obj.next(val);
     */
    /**
     * 执行用时 :98 ms, 在所有 Java 提交中击败了96.22%的用户
     * 内存消耗 :41.5 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    private class MovingAverage {

        List<Integer> list;
        final int capacity;
        int sum = 0;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            list = new ArrayList<>();
            capacity = size;
        }

        public double next(int val) {
            if (list.size() >= capacity) {
                int valToRemove = list.remove(0);
                sum -= valToRemove;
            }
            list.add(val);
            sum += val;

            return (double)sum / (double)list.size();
        }
    }
}
