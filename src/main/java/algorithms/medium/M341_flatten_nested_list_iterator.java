package algorithms.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 341. 扁平化嵌套列表迭代器
 *
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用next 直到hasNext 返回 false，next返回的元素的顺序应该是: [1,1,2,1,1]。
 * 示例 2:
 *
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用next直到hasNext 返回 false，next返回的元素的顺序应该是: [1,4,6]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-nested-list-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class M341_flatten_nested_list_iterator {

    /**
     * 深度优先搜索+递归
     * 构造函数中将数据解析为List<Integer>
     * 将hasNext、next转化为对list的判断
     */
    private class SolutionByDfs {
        private class NestedIterator implements Iterator<Integer> {
            private List<Integer> datas = new ArrayList<>();
            private int indexOfData = 0;

            public NestedIterator(List<NestedInteger> nestedList) {
                for (NestedInteger nestedInteger : nestedList) {
                    dfs(nestedInteger);
                }
            }

            private void dfs(NestedInteger nestedInteger) {
                if (nestedInteger.isInteger()) {
                    datas.add(nestedInteger.getInteger());
                } else {
                    nestedInteger.getList().forEach(item -> dfs(item));
                }
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    return datas.get(indexOfData++);
                }
                return null;
            }

            @Override
            public boolean hasNext() {
                return indexOfData < datas.size();
            }
        }
    }

    private class SolutionByStack {
        private class NestedIterator implements Iterator<Integer> {
            private Stack<NestedInteger> stack = new Stack<>();

            public NestedIterator(List<NestedInteger> nestedList) {
                if (null == nestedList) {
                    return;
                }

                for (int index = nestedList.size() - 1; index >= 0; index--) {
                    stack.push(nestedList.get(index));
                }
            }

            @Override
            public Integer next() {
                while (!stack.isEmpty()) {
                    if ((stack.peek()).isInteger()) {
                        return stack.pop().getInteger();
                    }
                    NestedInteger item = stack.pop();
                    for (int index = item.getList().size() - 1; index >= 0; index--) {
                        stack.push(item.getList().get(index));
                    }
                }
                return null;
            }

            @Override
            public boolean hasNext() {
                while (!stack.isEmpty()) {
                    if ((stack.peek()).isInteger()) {
                        return true;
                    }
                    NestedInteger item = stack.pop();
                    for (int index = item.getList().size() - 1; index >= 0; index--) {
                        stack.push(item.getList().get(index));
                    }
                }
                return false;
            }
        }
    }

    private interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
