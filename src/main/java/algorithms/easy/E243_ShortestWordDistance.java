package algorithms.easy;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-word-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E243_ShortestWordDistance {

    public static void main(String[] args) {
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        shortestDistance(words, "coding", "practice");
    }

    /**
     * 空间复杂度为O(n)，时间复杂度为O(n)
     * 想多了，不应该存储所有下标的，直接遍历时候去判断即可
     * 执行用时 :5 ms, 在所有 Java 提交中击败了12.62%的用户
     * 内存消耗 :40.1 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static int shortestDistance(String[] words, String word1, String word2) {
        int distance = words.length;

        Map<Integer, Integer> map = new TreeMap<>();

        int index1 = -1;
        int index2 = -1;

        for (int index = 0; index < words.length; index++) {
            if (word1.equals(words[index])) {
                map.put(index, 1);
                index1 = index;

            } else if (word2.equals(words[index])) {

                map.put(index, 2);
                index2 = index;
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer index = entry.getKey();
            Integer flag = entry.getValue();

            if (flag == 1) {
                index1 = index;
            } else {
                index2 = index;
            }

            distance = Math.min(distance, Math.abs(index1 - index2));
        }

        return distance;
    }

    /**
     * 空间复杂度为O(1)，时间复杂度为O(n)
     * 执行用时 :4 ms, 在所有 Java 提交中击败了56.31%的用户
     * 内存消耗 :39.1 MB, 在所有 Java 提交中击败了100.00%的用户
     */
    public static int shortestDistance2(String[] words, String word1, String word2) {
        int distance = words.length;

        int index1 = -1;
        int index2 = -1;

        for (int index = 0; index < words.length; index++) {
            if (word1.equals(words[index])) {
                index1 = index;

            } else if (word2.equals(words[index])) {
                index2 = index;
            }

            if (index1 != -1 && index2 != -1) {
                distance = Math.min(distance, Math.abs(index1 - index2));
            }
        }


        return distance;
    }
}
