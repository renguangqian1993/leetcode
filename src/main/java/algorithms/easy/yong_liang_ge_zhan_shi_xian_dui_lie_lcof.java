package algorithms.easy;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 *
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 提示：
 * 1 <= values <= 10000
 * 最多会对appendTail、deleteHead 进行10000次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class yong_liang_ge_zhan_shi_xian_dui_lie_lcof {
    private class CQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        /**
         * stack1中存放数据，stack2只做临时存储用
         */
        public int deleteHead1() {
            int result = -1;
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                result = stack2.pop();
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            return result;
        }

        /**
         * 参考官方
         * stack2用作存储head->head.next->head.next.next...
         * stack1用于正常存储
         * deleteHead时，先判断stack2，直接pop。如果stack2为空，将stack1中数据导入stack2
         * @return
         */
        public int deleteHead2() {
            int result = -1;
            if (!stack1.isEmpty() || !stack2.isEmpty()) {
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                if (!stack2.isEmpty()) {
                    result = stack2.pop();
                }
            }
            return result;
        }
    }
}
