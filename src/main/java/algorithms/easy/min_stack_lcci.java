package algorithms.easy;

import java.util.Stack;

/**
 * 面试题 03.02. 栈的最小值
 *
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。
 * 执行push、pop和min操作的时间复杂度必须为O(1)。
 *
 *
 * 示例：
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class min_stack_lcci {
    private class MinStack {

        //保存数据
        private Stack<Integer> dataStack;
        //保存dataStack栈顶元素对应的最小栈元素
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty()) {
                minStack.push(x);
            } else {
                if (x > minStack.peek()) {
                    minStack.push(minStack.peek());
                } else {
                    minStack.push(x);
                }
            }

        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            if (dataStack.isEmpty()) {
                return -1;
            }
            return dataStack.peek();
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                return Integer.MAX_VALUE;
            }
            return minStack.peek();
        }
    }
}
