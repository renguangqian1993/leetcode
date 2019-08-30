package algorithms.easy;

import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *  
 *
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E155_MinStack {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> 返回 0.
        System.out.println(minStack.getMin());   //--> 返回 -2.

    }


    private static class MinStack {

        //为了瞬时拿到最小值
        private Map<Integer/*value*/, Integer/*count*/> sortedMap;
        //堆栈
        private Stack<Integer> stack;

        /** initialize your data structure here. */
        public MinStack() {
            sortedMap = new TreeMap<>();
            stack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (sortedMap.containsKey(x)) {
                sortedMap.put(x, (sortedMap.get(x) + 1));
            } else {
                sortedMap.put(x, 1);
            }
        }

        public void pop() {
            Integer top = stack.pop();
            if (null != top) {
                if (sortedMap.get(top) == 1) {
                    sortedMap.remove(top);
                } else {
                    sortedMap.put(top, (sortedMap.get(top) - 1));
                }
            }
        }

        public int top() {
            Integer top = stack.pop();
            if (null != top) {
                stack.push(top);
                return top;
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }

        public int getMin() {

            Iterator<Map.Entry<Integer, Integer>> iterator = sortedMap.entrySet().iterator();
            if (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                int minVal = entry.getKey();
                return minVal;
            }
            throw new RuntimeException("栈中元素为空，此操作非法");
        }

        /**
         * Your MinStack object will be instantiated and called as such:
         * MinStack obj = new MinStack();
         * obj.push(x);
         * obj.pop();
         * int param_3 = obj.top();
         * int param_4 = obj.getMin();
         */
    }

}
