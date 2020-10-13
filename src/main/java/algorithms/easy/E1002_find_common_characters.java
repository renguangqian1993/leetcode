package algorithms.easy;

import java.util.*;

/**
 * 1002. 查找常用字符
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 *
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class E1002_find_common_characters {
    private static class Solution1 {
        public List<String> commonChars(String[] A) {
            List<String> resultList = new ArrayList<>();
            if (null == A || A.length <= 0) {
                return resultList;
            }

            Map<Character, Integer> resultMap = getHash(A[0]);
            for (int index = 1; index < A.length; index++) {
                Map<Character, Integer> tmpMap = getHash(A[index]);

                tmpMap.entrySet().forEach(entry -> {
                    if (resultMap.containsKey(entry.getKey())) {
                        resultMap.put(entry.getKey(), Math.min(entry.getValue(), resultMap.get(entry.getKey())));
                    }
                });

                Set<Character> keys = new HashSet<>(resultMap.keySet());
                keys.forEach(character -> {
                    if (!tmpMap.containsKey(character)) {
                        resultMap.remove(character);
                    }
                });
            }

            resultMap.entrySet().forEach(entry -> {
                for (int count = 0; count < entry.getValue(); count++) {
                    resultList.add(String.valueOf(entry.getKey()));
                }
            });

            return resultList;
        }

        private Map<Character, Integer> getHash(String str) {
            Map<Character, Integer> resultMap = new HashMap<>();
            for (int index = 0; index < str.length(); index++) {
                char c = str.charAt(index);
                int count = resultMap.getOrDefault(c, 0);
                resultMap.put(c, count + 1);
            }

            return resultMap;
        }
    }

    private static class Solution2 {
        public List<String> commonChars(String[] A) {
            List<String> resultList = new ArrayList<>();
            if (null == A || A.length <= 0) {
                return resultList;
            }

            int[] count = new int[26];
            for (int index = 0; index < 26; index++) {
                count[index] = Integer.MAX_VALUE;
            }
            for (int indexOfArray = 0; indexOfArray < A.length; indexOfArray++) {
                int[] countTmp = new int[26];
                for (int indexOfStr = 0; indexOfStr < A[indexOfArray].length(); indexOfStr++) {
                    countTmp[A[indexOfArray].charAt(indexOfStr) - 'a']++;
                }

                for (int index = 0; index < 26; index++) {
                    count[index] = Math.min(count[index], countTmp[index]);
                }
            }

            for (int index = 0; index < count.length; index++) {
                if (count[index] > 0) {
                    for (int countIndex = 0; countIndex < count[index]; countIndex++) {
                        resultList.add(String.valueOf((char) ('a' + index)));
                    }
                }
            }

            return resultList;
        }

    }
}
