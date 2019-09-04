package algorithms.easy;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 *
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E232_ImplementQueueUsingStacks {
    /**
     * 入栈O(1)，出栈O(n)
     * 执行用时 :82 ms, 在所有 Java 提交中击败了92.38%的用户
     * 内存消耗 :34.9 MB, 在所有 Java 提交中击败了43.88%的用户
     */
    class MyQueue {

        private Stack<Integer> dataStack;
        private Stack<Integer> tmpStack;
        private Integer front;

        /** Initialize your data structure here. */
        public MyQueue() {
            dataStack = new Stack<>();
            tmpStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if (dataStack.isEmpty()) {
                front = x;
            }
            dataStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            Integer result = null;

            while (!dataStack.isEmpty()) {
                tmpStack.push(dataStack.pop());
            }

            result = tmpStack.pop();

            if (tmpStack.isEmpty()) {
                front = null;
            } else {
                front = tmpStack.peek();
            }

            while (!tmpStack.isEmpty()) {
                dataStack.push(tmpStack.pop());
            }

            return result;
        }

        /** Get the front element. */
        public int peek() {
            return front;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return dataStack.isEmpty();
        }
    }

    /**
     * 入栈O(n)，出栈O(1)
     * 执行用时 :83 ms, 在所有 Java 提交中击败了91.34%的用户
     * 内存消耗 :34.7 MB, 在所有 Java 提交中击败了43.88%的用户
     */
//    private class MyQueue {
//
//        private Stack<Integer> dataStack;
//        private Stack<Integer> tmpStack;
//
//        private Integer front;
//
//        /** Initialize your data structure here. */
//        public MyQueue() {
//            dataStack = new Stack<>();
//            tmpStack = new Stack<>();
//        }
//
//        /** Push element x to the back of queue. */
//        public void push(int x) {
//            if (dataStack.isEmpty()) {
//                front = x;
//            }
//
//            while (!dataStack.isEmpty()) {
//                tmpStack.push(dataStack.pop());
//            }
//            dataStack.push(x);
//            while (!tmpStack.isEmpty()) {
//                dataStack.push(tmpStack.pop());
//            }
//        }
//
//        /** Removes the element from in front of queue and returns that element. */
//        public int pop() {
//            int result = dataStack.pop();
//
//            if (!dataStack.isEmpty()) {
//                front = dataStack.peek();
//            } else {
//                front = null;
//            }
//
//            return result;
//        }
//
//        /** Get the front element. */
//        public int peek() {
//            return front;
//        }
//
//        /** Returns whether the queue is empty. */
//        public boolean empty() {
//            return dataStack.isEmpty();
//        }
//    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
