package algorithms.easy;

import java.util.*;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * Example 1:
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 *
 * Example 2:
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-iii-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E170_TwoSum_III_DataStructureDesign {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        twoSum.add(0);
        twoSum.find(0);
    }

    /**
     * 执行用时 :298 ms, 在所有 Java 提交中击败了70.53%的用户
     * 内存消耗 :70.2 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    private static class TwoSum {

        private Map<Integer/*value*/, Integer/*count*/> map;

        /** Initialize your data structure here. */
        public TwoSum() {
            map = new HashMap<>();
        }

        /** Add the number to an internal data structure.. */
        public void add(int number) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }

        /** Find if there exists any pair of numbers which sum is equal to the value. */
        public boolean find(int value) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                Integer val1 = entry.getKey();
                Integer count = entry.getValue();

                if ((value - val1) == val1) {
                    if (count > 1) {
                        return true;
                    }
                } else if (map.containsKey(value - val1)) {
                    return true;
                }

            }
            return false;
        }
    }

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
}
