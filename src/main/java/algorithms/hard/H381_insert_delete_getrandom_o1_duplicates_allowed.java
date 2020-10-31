package algorithms.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 *
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 *
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 *
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 *
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 *
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 *
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class H381_insert_delete_getrandom_o1_duplicates_allowed {
    class RandomizedCollection {
        private Map<Integer/**val*/, Set<Integer/**idx*/>> keyMap;
        private List<Integer> keyList;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            keyMap = new HashMap<>();
            keyList = new ArrayList<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            Set<Integer> idxSet = keyMap.getOrDefault(val, new HashSet<>());
            idxSet.add(keyList.size());//当前下标
            keyMap.put(val, idxSet);

            keyList.add(val);

            return idxSet.size() == 1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!keyMap.containsKey(val)) {
                return false;
            }

            Set<Integer> idxSet = keyMap.get(val);
            int idxToDel = idxSet.stream().findAny().get();
            int lastIdx = keyList.size() - 1;
            int lastVal = keyList.get(lastIdx);

            if (idxToDel != lastIdx && lastVal != val) {
                keyMap.get(lastVal).remove(lastIdx);
                keyMap.get(lastVal).add(idxToDel);
                keyList.set(idxToDel, lastVal);
            } else {
                idxToDel = keyList.size() - 1;
            }

            keyList.remove(lastIdx);
            keyMap.get(val).remove(idxToDel);
            if (keyMap.get(val).size() == 0) {
                keyMap.remove(val);
            }
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int idx = ((int) (Math.random() * keyList.size())) % keyList.size();

            return keyList.get(idx);
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
